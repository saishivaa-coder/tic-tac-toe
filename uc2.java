import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {

        // Game state variables
        String player1Symbol, player2Symbol;
        String currentPlayer;

        // Step 1: Perform random toss (0 = Player 1 starts, 1 = Player 2 starts)
        Random random = new Random();
        int toss = random.nextInt(2); // Generates 0 or 1

        // Step 2: Conditional logic — assign symbols based on toss result
        if (toss == 0) {
            player1Symbol = "X";
            player2Symbol = "O";
            currentPlayer  = "Player 1";
        } else {
            player1Symbol = "O";
            player2Symbol = "X";
            currentPlayer  = "Player 2";
        }

        // Step 3: Display the toss result and assignments
        System.out.println("=== Toss Result ===");
        System.out.println(currentPlayer + " wins the toss and goes first!");
        System.out.println();
        System.out.println("=== Symbol Assignment ===");
        System.out.println("Player 1  →  " + player1Symbol);
        System.out.println("Player 2  →  " + player2Symbol);
        System.out.println();
        System.out.println("Current Player: " + currentPlayer);
    }
}
