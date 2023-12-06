package TTT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TTT game = new TTT();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.printBoard();

            int row = 0;
            int col = 0;
            try {
                System.out.print("row (0-2): ");
                row = scanner.nextInt();

                System.out.print("column (0-2): ");
                col = scanner.nextInt();

                // Your logic for handling user input here

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            }

            if (game.makeMove(row, col)) {
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a tie! The board is full.");
                    break;
                } else {
                    game.currentPlayer = (game.currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}