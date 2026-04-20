package org.example;

public class TicTacToe {

    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move: Out of bounds!");
            return false;
        }
        if (board[row][col] != '-') {
            System.out.println("Invalid move: Cell already occupied!");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'-', '-', '-'},
                {'-', 'X', '-'},
                {'-', '-', '-'}
        };
        int row = 1, col = 1;
        System.out.println("Move at (1,1): " + isValidMove(board, row, col));

        row = 2; col = 2;
        System.out.println("Move at (2,2): " + isValidMove(board, row, col));

        row = 3; col = 0;
        System.out.println("Move at (3,0): " + isValidMove(board, row, col));
    }
}
