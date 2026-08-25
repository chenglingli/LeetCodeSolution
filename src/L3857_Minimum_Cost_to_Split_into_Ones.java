public class L3857_Minimum_Cost_to_Split_into_Ones {

    /*
     * You are given an integer n.
     * 
     * In one operation, you may split an integer x into two positive integers a and
     * b such that a + b = x.
     * 
     * The cost of this operation is a * b.
     * 
     * Return an integer denoting the minimum total cost required to split the
     * integer n into n ones.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: n = 3
     * 
     * Output: 3
     * 
     * Explanation:
     * 
     * One optimal set of operations is:
     * 
     * x a b a + b a * b Cost
     * 3 1 2 3 2 2
     * 2 1 1 2 1 1
     * Thus, the minimum total cost is 2 + 1 = 3.
     * 
     * Example 2:
     * 
     * Input: n = 4
     * 
     * Output: 6
     * 
     * Explanation:
     * 
     * One optimal set of operations is:
     * 
     * x a b a + b a * b Cost
     * 4 2 2 4 4 4
     * 2 1 1 2 1 1
     * 2 1 1 2 1 1
     * Thus, the minimum total cost is 4 + 1 + 1 = 6.
     * 
     * 
     * 
     * Constraints:
     * 
     * 1 <= n <= 500
     * 
     */
    public int minCost(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j] + j * (i - j));
            }
        }

        return dp[n];
    }

    /*
    把 n 想成 n 个带编号的 1，事情会清楚很多。

    例如 n = 4，四个 1 分别叫 A、B、C、D。一开始它们在同一堆里，目标是每个人单独一堆。

    每次把一堆拆成大小为 a、b 的两堆，代价是 a * b。这个数的含义是：

    左边每个 1，都要和右边每个 1「告别」一次，每次告别记 1 分。

    任意两个 1，一开始在一起，最后各自独立。它们恰好会在某一次切开时被分到两边，而且只会分开这一次。所以每一对 1 对总代价的贡献永远是 1，跟中间怎么切无关。

    */
    public int minCost2(int n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {

        L3857_Minimum_Cost_to_Split_into_Ones s = new L3857_Minimum_Cost_to_Split_into_Ones();
        long sysDate1 = System.currentTimeMillis();

        int n = 4;

        int res = s.minCost(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}