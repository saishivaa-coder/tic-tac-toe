import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    // ─── UC5: Validate the move ───────────────────────────────────────────────
    public static boolean isValidMove(char[][] board, int row, int col) {

        // Check 1: Boundary — row and col must both be within 0–2
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move! Slot out of bounds.");
            return false;
        }

        // Check 2: Availability — cell must still be empty ('-')
        if (board[row][col] != '-') {
            System.out.println("Invalid move! Slot " + (row * 3 + col + 1) + " is already taken.");
            return false;
        }

        return true; // Move is safe to place
    }

    // ─── UC4: Convert slot to row/column ─────────────────────────────────────
    public static int[] getRowCol(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // ─── UC3: Get player input ────────────────────────────────────────────────
    public static int getPlayerInput(String currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + currentPlayer + ", enter a slot number (1-9): ");
        return scanner.nextInt();
    }

    // ─── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // ── UC1: Board initialisation ─────────────────────────────────────────
        char[][] board = new char[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                board[row][col] = '-';

        System.out.println("Tic-Tac-Toe Board:");
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++)
                System.out.print(board[row][col] + " | ");
            System.out.println();
            System.out.println("-------------");
        }

        // ── UC2: Toss & symbol assignment ─────────────────────────────────────
        String player1Symbol, player2Symbol, currentPlayer;
        Random random = new Random();
        int toss = random.nextInt(2);

        if (toss == 0) {
            player1Symbol = "X";  player2Symbol = "O";  currentPlayer = "Player 1";
        } else {
            player1Symbol = "O";  player2Symbol = "X";  currentPlayer = "Player 2";
        }

        System.out.println("\n=== Toss Result ===");
        System.out.println(currentPlayer + " wins the toss and goes first!");
        System.out.println("Player 1 → " + player1Symbol + "  |  Player 2 → " + player2Symbol);

        // ── UC3 + UC4: Get input & convert ────────────────────────────────────
        int slot = getPlayerInput(currentPlayer);
        int[] position = getRowCol(slot);
        int row = position[0];
        int col = position[1];

        // ── UC5: Validate the move ────────────────────────────────────────────
        if (isValidMove(board, row, col)) {
            System.out.println("\nMove accepted! board[" + row + "][" + col + "] is free.");
        } else {
            System.out.println("\nMove rejected. Please try again.");
        }
    }
}
