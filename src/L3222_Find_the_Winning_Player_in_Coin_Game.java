public class L3222_Find_the_Winning_Player_in_Coin_Game {

    /*
    You are given two positive integers x and y, denoting the number of coins with values 75 and 10 respectively.

    Alice and Bob are playing a game. Each turn, starting with Alice,
    the player must pick up coins with a total value 115.
    If the player is unable to do so, they lose the game.

    Return the name of the player who wins the game if both players play optimally.


    115 = 75 + 10 + 10 + 10 + 10

    Example 1:

        Input: x = 2, y = 7

        Output: "Alice"

        Explanation:

        The game ends in a single turn:

        Alice picks 1 coin with a value of 75 and 4 coins with a value of 10.

    Example 2:

        Input: x = 4, y = 11

        Output: "Bob"

        Explanation:

        The game ends in 2 turns:

        Alice picks 1 coin with a value of 75 and 4 coins with a value of 10.
        Bob picks 1 coin with a value of 75 and 4 coins with a value of 10.


    Constraints:
    1 <= x, y <= 100

     */
    public String losingPlayer(int x, int y) {

        int tenCount = y / 4;

        int winner = -1;

        if (x % 2 != 0) {
            if (tenCount > x) {
                winner = 1;
            } else {
                if (tenCount % 2 != 0) {
                    winner = 1;
                } else {
                    winner = 2;
                }
            }
        } else {
            if (tenCount > x) {
                winner = 2;
            } else {
                if (tenCount % 2 != 0) {
                    winner = 1;
                } else {
                    winner = 2;
                }
            }
        }

        return winner == 1 ? "Alice" : "Bob";
    }

    public String losingPlayer2(int x, int y) {

        int turns = Math.min(x, y / 4);

        return turns % 2 == 1 ? "Alice" : "Bob";
    }

    public static void main(String[] args) {

        L3222_Find_the_Winning_Player_in_Coin_Game s = new L3222_Find_the_Winning_Player_in_Coin_Game();
        long sysDate1 = System.currentTimeMillis();

        int x = 4;
        int y = 11;
        String res = s.losingPlayer(x, y);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}