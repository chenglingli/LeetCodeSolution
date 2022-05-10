public class L746_Min_Cost_Climbing_Stairs {

    /**
     * On a staircase, the i-th step has some non-negative
     * cost cost[i] assigned (0 indexed).
     * <p>
     * Once you pay the cost, you can either climb one or two steps.
     * You need to find minimum cost to reach the top of the floor, and you
     * can either start from the step with index 0, or the step with index 1.
     * <p>
     * Example 1:
     * Input: cost = [10, 15, 20]
     * Output: 15
     * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     * <p>
     * Example 2:
     * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * Output: 6
     * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
     * <p>
     * Note:
     * cost will have a length in the range [2, 1000].
     * Every cost[i] will be an integer in the range [0, 999].
     */


    public int minCostClimbingStairs(int[] cost) {

        int[] f = new int[cost.length + 1];

        f[0] = 0;
        f[1] = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            f[i] = Integer.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[cost.length];
    }

    public static void main(String[] args) {

        L746_Min_Cost_Climbing_Stairs s = new L746_Min_Cost_Climbing_Stairs();
        long sysDate1 = System.currentTimeMillis();

        int[] cost = {10, 15, 20};

        int res = s.minCostClimbingStairs(cost);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}