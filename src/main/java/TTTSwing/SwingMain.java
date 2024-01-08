package TTTSwing;

import javax.swing.*;
import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

/**
 * The main class for the Tic-Tac-Toe Swing GUI application.
 */
public class SwingMain {

    private JFrame frame;
    private JButton[][] buttons;
    private TTTSwing game;

    /**
     * The main method to launch the Swing GUI.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingMain window = new SwingMain();
        window.frame.setVisible(true);
    }


    /**
     * Constructs the SwingMain object and initializes the GUI components.
     */
    public SwingMain() {
        initialize();
    }


    /**
     * Initializes the Swing GUI components.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 300);
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

    /**
     * Creates a JButton for the specified row and column and sets up its properties.
     *
     * @param row The row index.
     * @param col The column index.
     * @return The configured JButton.
     */
    private JButton createButton(final int row, final int col) {
        JButton button = new JButton();
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 40));

        // Replace anonymous ActionListener with lambda expression
        button.addActionListener(e -> makeMove(row, col));

        return button;
    }

    /**
     * Handles a player's move when a button is clicked.
     *
     * @param row The row index of the clicked button.
     * @param col The column index of the clicked button.
     */
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

    /**
     * Updates the text on a button after a valid move.
     *
     * @param row The row index of the button.
     * @param col The column index of the button.
     */
    private void updateButton(int row, int col) {
        buttons[row][col].setText(Character.toString(game.getBoard()[row][col]));
    }

    /**
     * Resets the game board and clears the button texts.
     */
    private void resetGame() {
        game.initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }
}
