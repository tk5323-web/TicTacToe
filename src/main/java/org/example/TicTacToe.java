import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private Random random;
    private char currentPlayer;

    public TicTacToe(int size) {
        board = new char[size][size];
        random = new Random();
        currentPlayer = 'X';
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
            int slot = random.nextInt(9) + 1; // 1–9
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;
            validMove = updateBoard(row, col, symbol);
        }
        System.out.println("Computer placed " + symbol);
    }
    public boolean checkWin(char symbol) {
        for (int i = 0; i < board.length; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }
    public boolean checkDraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                if (j < board.length - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < board.length - 1) System.out.println("---------");
        }
    }
    public void playGame() {
        boolean gameOver = false;
        while (!gameOver) {
            displayBoard();
            if (currentPlayer == 'X') {
                updateBoard(0, 0, 'X');
                System.out.println("Human placed X");
            } else {
                computerMove('O');
            }
            if (checkWin(currentPlayer)) {
                displayBoard();
                System.out.println(currentPlayer + " wins!");
                gameOver = true;
            } else if (checkDraw()) {
                displayBoard();
                System.out.println("It's a draw!");
                gameOver = true;
            } else {

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);
        game.playGame();
    }
}
