import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    // ─── UC3: Get player input ───────────────────────────────────────────────
    public static int getPlayerInput(String currentPlayer) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + currentPlayer + ", enter a slot number (1-9): ");
        int slot = scanner.nextInt();

        return slot;
    }

    // ─── Main ────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // ── UC1: Board initialisation ────────────────────────────────────────
        char[][] board = new char[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                board[row][col] = '-';

        // Print board
        System.out.println("Tic-Tac-Toe Board:");
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++)
                System.out.print(board[row][col] + " | ");
            System.out.println();
            System.out.println("-------------");
        }

        // ── UC2: Toss & symbol assignment ────────────────────────────────────
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

        // ── UC3: Get player input ─────────────────────────────────────────────
        int slot = getPlayerInput(currentPlayer);
        System.out.println("\n" + currentPlayer + " selected slot: " + slot);
    }
}
