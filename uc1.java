public class TicTacToe {
    public static void main(String[] args) {

        // Step 1: Declare a 3x3 2D character array
        char[][] board = new char[3][3];

        // Step 2: Initialize all cells with '-'
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }

        // Step 3: Print the board
        System.out.println("Tic-Tac-Toe Board:");
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
