package TTTSwing;

/* import java.util.Scanner; */

/**
 * Represents the Tic-Tac-Toe game logic for the Swing GUI application.
 */
public class TTTSwing {
    char[][] board;
    char currentPlayer;

    /*
    private int currentRow;
    private int currentCol;

     */

    public TTTSwing() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /*public void printBoard() {
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

     */
    boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }
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

    //everything from here on is new and just made for swing

    /**
     * Gets the current state of the game board.
     *
     * @return The 2D array representing the game board.
     */
    public char[][] getBoard() {
        return board;
    }


    /**
     * Gets the current player ('X' or 'O').
     *
     * @return The current player.
     */
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    /*
    public void moveCursor(int rowChange, int colChange) {
        int newRow = Math.floorMod(currentRow + rowChange, 3);
        int newCol = Math.floorMod(currentCol + colChange, 3);
        currentRow = newRow;
        currentCol = newCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }


     */

}