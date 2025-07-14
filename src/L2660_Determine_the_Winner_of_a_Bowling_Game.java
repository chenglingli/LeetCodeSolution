public class L2660_Determine_the_Winner_of_a_Bowling_Game {

    /*

    You are given two 0-indexed integer arrays player1 and player2,
    representing the number of pins that player 1 and player 2 hit in a bowling game, respectively.

    The bowling game consists of n turns, and the number of pins in each turn is exactly 10.

    Assume a player hits xi pins in the ith turn. The value of the ith turn for the player is:

    2xi if the player hits 10 pins in either (i - 1)th or (i - 2)th turn.

    Otherwise, it is xi.
    The score of the player is the sum of the values of their n turns.

    Return

    1 if the score of player 1 is more than the score of player 2,
    2 if the score of player 2 is more than the score of player 1, and
    0 in case of a draw.


    Example 1:

    Input: player1 = [5,10,3,2], player2 = [6,5,7,3]

    Output: 1

    Explanation:

    The score of player 1 is 5 + 10 + 2*3 + 2*2 = 25.

    The score of player 2 is 6 + 5 + 7 + 3 = 21.

    Example 2:

    Input: player1 = [3,5,7,6], player2 = [8,10,10,2]

    Output: 2

    Explanation:

    The score of player 1 is 3 + 5 + 7 + 6 = 21.

    The score of player 2 is 8 + 10 + 2*10 + 2*2 = 42.

    Example 3:

    Input: player1 = [2,3], player2 = [4,1]

    Output: 0

    Explanation:

    The score of player1 is 2 + 3 = 5.

    The score of player2 is 4 + 1 = 5.

    Example 4:

    Input: player1 = [1,1,1,10,10,10,10], player2 = [10,10,10,10,1,1,1]

    Output: 2

    Explanation:

    The score of player1 is 1 + 1 + 1 + 10 + 2*10 + 2*10 + 2*10 = 73.

    The score of player2 is 10 + 2*10 + 2*10 + 2*10 + 2*1 + 2*1 + 1 = 75.



    Constraints:

    n == player1.length == player2.length
    1 <= n <= 1000
    0 <= player1[i], player2[i] <= 10

     */
    public int isWinner(int[] player1, int[] player2) {
        int score1 = countScore(player1);
        int score2 = countScore(player2);

        if (score1 > score2) {
            return 1;
        } else if (score1 < score2) {
            return 2;
        } else {
            return 0;
        }
    }

    private int countScore(int[] player) {
        int score = 0;
        int d = 0;

        for (int x : player) {
            if (d > 0) {
                score += x * 2;
                d--;
            }
            else {
                score += x;
            }

            if (x == 10) {
                d = 2;
            }
        }

        return score;
    }

    public static void main(String[] args) {

        L2660_Determine_the_Winner_of_a_Bowling_Game s = new L2660_Determine_the_Winner_of_a_Bowling_Game();
        long sysDate1 = System.currentTimeMillis();

        //        int[] player1 = {5, 10, 3, 2};
        //        int[] player2 = {6, 5, 7, 3};

        int[] player1 = {0, 4, 7, 2, 0};
        int[] player2 = {2, 3, 3, 0, 1};
        int res = s.isWinner(player1, player2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}