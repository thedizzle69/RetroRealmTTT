package TTT;

import java.util.Scanner;

public class Arrows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Normal mode");
            System.out.println("2. Arrow key mode");
            System.out.println("3. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    playNormalMode();
                    break;
                case 2:
                    playArrowKeyMode();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        System.out.println("Exiting the game. Thank you for playing!");
    }

    private static void playNormalMode() {
        TTT game = new TTT();
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            playGame(game, scanner);

            System.out.println("Do you want to play again? (y/n): ");
            char response = scanner.next().charAt(0);

            playAgain = (response == 'y' || response == 'Y');
        }

        System.out.println("Exiting Normal mode.");
    }

    private static void playArrowKeyMode() {
        TTT game = new TTT();
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            playArrowKeyGame(game, scanner);

            System.out.println("Do you want to play again? (y/n): ");
            char response = scanner.next().charAt(0);

            playAgain = (response == 'y' || response == 'Y');
        }

        System.out.println("Exiting Arrow Key mode.");
    }

    private static void playGame(TTT game, Scanner scanner) {
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

    private static void playArrowKeyGame(TTT game, Scanner scanner) {
        int row = 0;
        int col = 0;

        while (true) {
            game.printBoard();

            try {
                System.out.print("Use arrow keys to scroll, Enter to make a move: ");

                // Arrow key mode logic here
                char input = scanner.next().charAt(0);

                switch (input) {
                    case 'w':
                        row = (row - 1 + 3) % 3; // Move up
                        break;
                    case 's':
                        row = (row + 1) % 3; // Move down
                        break;
                    case 'a':
                        col = (col - 1 + 3) % 3; // Move left
                        break;
                    case 'd':
                        col = (col + 1) % 3; // Move right
                        break;
                    case '\n':
                        // Enter key pressed, make a move
                        if (game.makeMove(row, col)) {
                            if (game.checkWin()) {
                                game.printBoard();
                                System.out.println("Player " + game.currentPlayer + " wins!");
                                return;
                            } else if (game.isBoardFull()) {
                                game.printBoard();
                                System.out.println("It's a tie! The board is full.");
                                return;
                            } else {
                                game.currentPlayer = (game.currentPlayer == 'X') ? 'O' : 'X';
                            }
                        } else {
                            System.out.println("Invalid move. Try again.");
                        }
                        break;
                    default:
                        System.out.println("Invalid input. Use arrow keys (w, a, s, d) and Enter.");
                        break;
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid key.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            }
        }
    }
}
