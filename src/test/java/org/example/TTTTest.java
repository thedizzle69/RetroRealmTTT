package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class TTTTest {

    TTT game;
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        game = new TTT();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testInitializeBoard() {
        game.initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', game.board[i][j], "Board should be initialized with spaces");
            }
        }
    }

    @Test
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


    // Negative test cases can be difficult for these methods since they are quite simple.
    // But we can still test if the board prints incorrectly after a bad modification.

    @Test
    void testPrintBoardAfterIncorrectModification() {
        game.board[0][0] = 'X'; // Incorrectly setting without using a game method.
        game.printBoard();
        String expectedOutput = "Current Player: X\n" +
                "▁▁▁▁▁▁\n" +
                "|X| | |\n" +
                "| | | |\n" +
                "| | | |\n" +
                "▔▔▔▔";
        assertFalse(outputStreamCaptor.toString().trim().equals(expectedOutput));
    }

    @Test
    public void testCheckWinHorizontal() {
        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X
        assertTrue(game.checkWin()); // X wins horizontally
    }

    @Test
    public void testCheckWinVertical() {
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 1); // O
        game.makeMove(2, 0); // X
        assertTrue(game.checkWin()); // X wins vertically
    }

    @Test
    public void testCheckWinDiagonal() {
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 1); // X
        game.makeMove(0, 2); // O
        game.makeMove(2, 2); // X
        assertTrue(game.checkWin()); // X wins diagonally
    }

}
