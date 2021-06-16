public class L198_House_Robber {

    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only
     * constraint stopping you from robbing each of them is that adjacent
     * houses have security system connected and it will automatically
     * contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount
     * of money of each house, determine the maximum amount of money
     * you can rob tonight without alerting the police.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1)
     * and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * <p>
     * Example 2:
     * <p>
     * Input: [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2),
     * rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     */

    /**
     * dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
     */

    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] f = new int[nums.length];
        int[] curMax = new int[nums.length];
        f[0] = nums[0];
        curMax[0] = f[0];
        f[1] = nums[1];
        curMax[1] = Integer.max(f[0], f[1]);

        for (int i = 2; i < nums.length; i++) {
            f[i] = curMax[i - 2] + nums[i];
            curMax[i] = Integer.max(f[i], curMax[i - 1]);
        }

        return curMax[nums.length - 1];
    }


    public static void main(String[] args) {

        L198_House_Robber s = new L198_House_Robber();
        long sysDate1 = System.currentTimeMillis();

        int[] cost = {2, 7, 9, 3, 1};

        int res = s.rob(cost);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}