// ─── UC7: Computer makes a random valid move ──────────────────────────────
public static void computerMove(char[][] board, String computerSymbol) {

    System.out.println("\nComputer is thinking...");

    Random random = new Random();
    int row, col;

    // Loop until a valid (empty) cell is found
    do {
        int slot   = random.nextInt(9) + 1;  // Generates slot 1–9
        int[] pos  = getRowCol(slot);         // UC4: convert to indices
        row        = pos[0];
        col        = pos[1];
    } while (!isValidMove(board, row, col));  // UC5: repeat if cell is taken

    // UC6: Place the symbol on the confirmed valid cell
    placeSymbol(board, row, col, computerSymbol);
}
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    // ─── UC7: Computer move ───────────────────────────────────────────────────
    public static void computerMove(char[][] board, String computerSymbol) {
        System.out.println("\nComputer is thinking...");
        Random random = new Random();
        int row, col;
        do {
            int slot  = random.nextInt(9) + 1;
            int[] pos = getRowCol(slot);
            row       = pos[0];
            col       = pos[1];
        } while (!isValidMove(board, row, col));
        placeSymbol(board, row, col, computerSymbol);
    }

    // ─── UC6: Place symbol ────────────────────────────────────────────────────
    public static void placeSymbol(char[][] board, int row, int col, String symbol) {
        board[row][col] = symbol.charAt(0);
        System.out.println("Symbol '" + symbol + "' placed at board[" + row + "][" + col + "]");
    }

    // ─── UC5: Validate move ───────────────────────────────────────────────────
    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;                    // Silent — computer never prints errors
        }
        if (board[row][col] != '-') {
            return false;
        }
        return true;
    }

    // ─── UC4: Slot → row/col ─────────────────────────────────────────────────
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

    // ─── Print board ──────────────────────────────────────────────────────────
    public static void printBoard(char[][] board) {
        System.out.println("\n-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++)
                System.out.print(board[row][col] + " | ");
            System.out.println();
            System.out.println("-------------");
        }
    }

    // ─── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // ── UC1: Board initialisation ─────────────────────────────────────────
        char[][] board = new char[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                board[row][col] = '-';

        printBoard(board);

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

        // ── UC3 + UC4 + UC5 + UC6: Human move ────────────────────────────────
        int slot, row, col;
        do {
            slot = getPlayerInput(currentPlayer);
            int[] pos = getRowCol(slot);
            row = pos[0];
            col = pos[1];
        } while (!isValidMove(board, row, col));

        String humanSymbol    = currentPlayer.equals("Player 1") ? player1Symbol : player2Symbol;
        String computerSymbol = currentPlayer.equals("Player 1") ? player2Symbol : player1Symbol;

        placeSymbol(board, row, col, humanSymbol);
        printBoard(board);

        // ── UC7: Computer move ────────────────────────────────────────────────
        computerMove(board, computerSymbol);
        printBoard(board);
    }
}
