package TTT;

/* import java.util.Scanner; */

/**
 * Represents the Tic-Tac-Toe game logic for the terminal application.
 */
public class TTT {
    char[][] board;
    char currentPlayer;

    /**
     * Constructs a new Tic-Tac-Toe game and initializes the board.
     */
    public TTT() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    /**
     * Initializes the game board with empty spaces.
     */
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Prints the game board to the console.
     */
    public void printBoard() {
        System.out.println("Current Player: " + currentPlayer);
        System.out.println("▁▁▁▁▁▁");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔");
    }

    /**
     * Attempts to make a move on the game board at the specified row and column.
     *
     * @param row The row index (0-2).
     * @param col The column index (0-2).
     * @return {@code true} True if the move was successful, false otherwise.
     */
    boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    /**
     * Checks if the current player has won the game.
     *
     * @return True if the current player has won, false otherwise.
     */
    boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Row win
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Column win
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Diagonal win
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Diagonal win
        }

        else {
            return false;
        }
    }

    /**
     * Checks if the game board is full.
     *
     * @return True if the board is full, false otherwise.
     */
    boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }



}