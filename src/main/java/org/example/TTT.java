package org.example;

import java.util.Scanner;

public class TTT {
        char[][] board;
        char currentPlayer;

        public TTT() {
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

    boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    }

