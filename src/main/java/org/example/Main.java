package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        TTT game = new TTT();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.printBoard();

            System.out.print("row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("column (0-2): ");
            int col = scanner.nextInt();
        }
    }
}

