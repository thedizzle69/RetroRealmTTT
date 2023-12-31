package TTT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class TestTTT {

    TTT game;
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        game = new TTT();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @org.junit.jupiter.api.Test
    void testInitializeBoard() {
        game.initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', game.board[i][j], "Board should be initialized with spaces");
            }
        }
    }

    @org.junit.jupiter.api.Test
    void testPrintBoard() {
        game.printBoard();
        System.out.flush();  // Ensure that the output stream is flushed

        String lineSeparator = System.lineSeparator();
        String expectedOutput = "Current Player: X" + lineSeparator +
                "▁▁▁▁▁▁" + lineSeparator +
                "| | | |" + lineSeparator +
                "| | | |" + lineSeparator +
                "| | | |" + lineSeparator +
                "▔▔▔▔";

        String actualOutput = outputStreamCaptor.toString().trim();

        // Debug: print both expected and actual outputs to the console
        System.out.println("Expected output:\n" + expectedOutput);
        System.out.println("Actual output:\n" + actualOutput);

        assertEquals(expectedOutput, actualOutput, "The printed board does not match the expected output.");
    }

    @org.junit.jupiter.api.Test
    void testMakeMove() {
        assertTrue(game.makeMove(0, 0), "Should successfully make a move");
        assertEquals('X', game.board[0][0], "The cell should be marked with X");

        assertFalse(game.makeMove(0, 0), "Should not allow marking an already marked cell");
        assertFalse(game.makeMove(3, 3), "Should not allow marking outside the board");
    }




    @org.junit.jupiter.api.Test
    void testIsBoardFull() {
        // Test for not full board
        game.initializeBoard();
        assertFalse(game.isBoardFull(), "Board should not be full initially");

        // Fill the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.board[i][j] = 'X'; // or 'O'
            }
        }

        assertTrue(game.isBoardFull(), "Board should be full");
    }

    @Test
    void testRowWin() {
        for (char player : new char[]{'X', 'O'}) {
            for (int row = 0; row < 3; row++) {
                game.currentPlayer = player;
                game.initializeBoard();
                for (int col = 0; col < 3; col++) {
                    game.board[row][col] = player;
                }
                assertTrue(game.checkWin(), "Player " + player + " should win with row " + row);
            }
        }
    }

    @Test
    void testColumnWin() {
        for (char player : new char[]{'X', 'O'}) {
            for (int col = 0; col < 3; col++) {
                game.currentPlayer = player;
                game.initializeBoard();
                for (int row = 0; row < 3; row++) {
                    game.board[row][col] = player;
                }
                assertTrue(game.checkWin(), "Player " + player + " should win with column " + col);
            }
        }
    }

    @Test
    void testDiagonalWin() {
        for (char player : new char[]{'X', 'O'}) {
            game.currentPlayer = player;
            game.initializeBoard();

            // Check first diagonal
            for (int i = 0; i < 3; i++) {
                game.board[i][i] = player;
            }
            assertTrue(game.checkWin(), "Player " + player + " should win with first diagonal");

            // Check second diagonal
            game.initializeBoard();
            for (int i = 0; i < 3; i++) {
                game.board[i][2 - i] = player;
            }
            assertTrue(game.checkWin(), "Player " + player + " should win with second diagonal");
        }
    }

    @Test
    void testNoWin() {
        game.currentPlayer = 'X';
        game.initializeBoard();

        // Set up a board with no win
        game.board[0][0] = 'X';
        game.board[1][1] = 'X';
        game.board[0][1] = 'O';
        game.board[1][0] = 'O';

        assertFalse(game.checkWin(), "There should be no win");
    }
}


    // Negative test cases can be difficult for these methods since they are quite simple.
    // But we can still test if the board prints incorrectly after a bad modification.

    /*@org.junit.jupiter.api.Test
     void testPrintBoardAfterIncorrectModification() {
        game.board[0][0] = 'X'; // Incorrectly setting without using a game method.
        game.printBoard();

        String actualOutput = outputStreamCaptor.toString().trim();

        // Check if the output contains an indication of incorrect modification
        assertTrue(actualOutput.contains("Error") || actualOutput.contains("Invalid modification"),
                "The board should print an error message for incorrect modification.");
    }*/


