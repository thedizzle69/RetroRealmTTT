package TTTSwing;

import javax.swing.*;
import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

public class SwingMain {

    private JFrame frame;
    private JButton[][] buttons;
    private TTTSwing game;

    public static void main(String[] args) {
        SwingMain window = new SwingMain();
        window.frame.setVisible(true);
    }

    public SwingMain() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(3, 3));

        game = new TTTSwing();
        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = createButton(i, j);
                frame.getContentPane().add(buttons[i][j]);
            }
        }
    }

    // warning because of ActionListener. Let's try another way

    /*
    private JButton createButton(final int row, final int col) {
        JButton button = new JButton();
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 40));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeMove(row, col);
            }
        });
        return button;
    }

    */

    private JButton createButton(final int row, final int col) {
        JButton button = new JButton();
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 40));

        // Replace anonymous ActionListener with lambda expression
        button.addActionListener(e -> makeMove(row, col));

        return button;
    }

    private void makeMove(int row, int col) {
        if (game.makeMove(row, col)) {
            updateButton(row, col);
            if (game.checkWin()) {
                JOptionPane.showMessageDialog(frame, "Player " + game.getCurrentPlayer() + " wins!");
                resetGame();
            } else if (game.isBoardFull()) {
                JOptionPane.showMessageDialog(frame, "It's a tie! The board is full.");
                resetGame();
            } else {
                game.currentPlayer = (game.currentPlayer == 'X') ? 'O' : 'X';
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid move. Try again.");
        }
    }

    private void updateButton(int row, int col) {
        buttons[row][col].setText(Character.toString(game.getBoard()[row][col]));
    }

    private void resetGame() {
        game.initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }
}
