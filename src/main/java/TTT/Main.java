package TTT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TTT game = new TTT();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.printBoard();

            try {
                System.out.print("row (0-2): ");
                int row = scanner.nextInt();

                System.out.print("column (0-2): ");
                int col = scanner.nextInt();

                // Your logic for handling user input here

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            }
        }
    }
}
