public class L486_Predict_the_Winner {

    /**
     Given an array of scores that are non-negative integers.
     Player 1 picks one of the numbers from either end of the array
     followed by the player 2 and then player 1 and so on.
     Each time a player picks a number, that number will not be available
     for the next player. This continues until all the scores have been chosen.
     The player with the maximum score wins.

     Given an array of scores, predict whether player 1 is the winner.
     You can assume each player plays to maximize his score.

     Example 1:
     Input: [1, 5, 2]
     Output: False
     Explanation: Initially, player 1 can choose between 1 and 2.
     If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5.
     If player 2 chooses 5, then player 1 will be left with 1 (or 2).
     So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
     Hence, player 1 will never be the winner and you need to return False.

     Example 2:
     Input: [1, 5, 233, 7]
     Output: True
     Explanation: Player 1 first chooses 1.
     Then player 2 have to choose between 5 and 7.
     No matter which number player 2 choose, player 1 can choose 233.
     Finally, player 1 has more score (234)
     than player 2 (12), so you need to return True representing
     player1 can win.

     Note:
     1 <= length of the array <= 20.
     Any scores in the given array are non-negative integers
     and will not exceed 10,000,000.
     If the scores of both players are equal,
     then player 1 is still the winner.
     */


    /*
     * 使用动态规划的思路
     * f(i,j) 表示在i到j的区间（前后包含），如果某个人先拿能拿到的最大value
     *
     * 因为如果使用纯value，则需要计算任意sum(i,j)，
     * 然后使用sum - f 得到另一个人得到的value
     *
     *  所以这里使用变种，f(i,j)表示某人先拿能拿到的最大value 差值，即A-B
     *  这样就可以方便递归
     *
     */
    public boolean PredictTheWinner(int[] nums) {
        return findAns(nums, 0, nums.length-1) >= 0;
    }

    public int findAns(int[] nums, int i, int j) {
        if (i == j) return nums[i];
        else {
            int first = nums[i] - findAns(nums, i+1, j);
            int last = nums[j] - findAns(nums, i, j-1);
            return Math.max(first, last);
        }
    }

    public static void main(String[] args) {

        L486_Predict_the_Winner s = new L486_Predict_the_Winner();
        long sysDate1 = System.currentTimeMillis();

        int [] nums = {1, 5, 233, 7};
        boolean res = s.PredictTheWinner(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}