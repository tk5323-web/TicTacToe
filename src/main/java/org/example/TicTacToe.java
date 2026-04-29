public class TicTacToe {
    private char[][] board;
    public TicTacToe(int size) {
        board = new char[size][size];
        // Fill board with empty spaces
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
            } else {
                System.out.println("Cell already occupied!");
                return false;
            }
        } else {
            System.out.println("Invalid move! Out of bounds.");
            return false;
        }
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
        System.out.println("Player X moves:");
        game.updateBoard(0, 0, 'X');
        game.displayBoard();

        System.out.println("Player O moves:");
        game.updateBoard(1, 1, 'O');
        game.displayBoard();

        System.out.println("Invalid move attempt:");
        game.updateBoard(0, 0, 'O');
    }
}
