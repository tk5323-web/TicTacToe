public class TicTacToe {
    private char[][] board;
    public TicTacToe(int size) {
        board = new char[size][size];
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
    public boolean checkWin(char symbol) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != symbol) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }
        for (int j = 0; j < size; j++) {
            boolean colWin = true;
            for (int i = 0; i < size; i++) {
                if (board[i][j] != symbol) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }
        boolean diag1Win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                diag1Win = false;
                break;
            }
        }
        if (diag1Win) return true;
        boolean diag2Win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != symbol) {
                diag2Win = false;
                break;
            }
        }
        if (diag2Win) return true;

        return false;
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
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);

        game.updateBoard(0, 0, 'X');
        game.updateBoard(1, 1, 'X');
        game.updateBoard(2, 2, 'X');

        game.displayBoard();

        if (game.checkWin('X')) {
            System.out.println("Player X wins!");
        } else {
            System.out.println("No winner yet.");
        }
    }
}
