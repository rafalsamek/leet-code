package easy;

/**
 * 1025. Divisor Game
 * Easy
 * Topics
 * Companies
 * Hint
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 *
 * Choosing any x with 0 < x < n and n % x == 0.
 * Replacing the number n on the chalkboard with n - x.
 * Also, if a player cannot make a move, they lose the game.
 *
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 *
 * Input: n = 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 */
public class DivisorGame {
    int n;
    String currentPlayer = "Alice";

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        checkConstraints(n);
        DivisorGame devisorGame = new DivisorGame(n);
        while (devisorGame.makeTurn());

        System.out.println(!"Alice".equals(devisorGame.currentPlayer));
    }

    private static void checkConstraints(int n) {
        //1 <= n <= 1000
        if (n < 1) {
            throw new IllegalArgumentException("n is less than 1");
        }
        if (n > 1000) {
            throw new IllegalArgumentException("n is greater than 1000");
        }
    }

    private boolean makeTurn() {
         // * Choosing any x with 0 < x < n and n % x == 0.
        if (n == 1) {
            return false;
        }
        int x = this.n - 1;
        while (this.n % x != 0 && x > 0) {
            x--;
        }
        // * Replacing the number n on the chalkboard with n - x.
        this.n = n -x;
        this.currentPlayer = "Alice".equals(this.currentPlayer) ? "Bob" : "Alice";

        return true;
    }

    public DivisorGame(int n) {
        this.n = n;
    }
}
