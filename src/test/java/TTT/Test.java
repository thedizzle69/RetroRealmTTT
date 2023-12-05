package TTT;

import org.junit.jupiter.api.BeforeEach;

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

}
