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
    public boolean checkDraw() {
        boolean noEmptyCells = true; // Boolean flag
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    noEmptyCells = false;
                    break;
                }
            }
            if (!noEmptyCells) break;
        }
        return noEmptyCells;
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
        game.updateBoard(0, 1, 'O');
        game.updateBoard(0, 2, 'X');
        game.updateBoard(1, 0, 'X');
        game.updateBoard(1, 1, 'O');
        game.updateBoard(1, 2, 'X');
        game.updateBoard(2, 0, 'O');
        game.updateBoard(2, 1, 'X');
        game.updateBoard(2, 2, 'O');

        game.displayBoard();

        if (game.checkDraw()) {
            System.out.println("It's a draw! No moves remain.");
        } else {
            System.out.println("Moves still possible.");
        }
    }
}
