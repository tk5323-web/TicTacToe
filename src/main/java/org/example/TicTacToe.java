import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private Random random;
    public TicTacToe(int size) {
        board = new char[size][size];
        random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public boolean updateBoard(int row, int col, char symbol) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            if (board[row][col] == ' ') {
                board[row][col] = symbol;
                return true;
            }
        }
        return false;
    }
    public void computerMove(char symbol) {
        boolean validMove = false;
        while (!validMove) {
            int slot = random.nextInt(9) + 1;
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;
            validMove = updateBoard(row, col, symbol);
        }
        System.out.println("Computer placed " + symbol);
    }
    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                if (j < board.length - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("---------");
            }
        }
    }
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);

        game.displayBoard();
        System.out.println("Computer's turn:");
        game.computerMove('O');
        game.displayBoard();
    }
}
