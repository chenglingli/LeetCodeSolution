public class L188_Best_Time_to_Buy_and_Sell_Stock_IV {

    /*


    动态规划
    dp[i][j] 表示 i 次交易，到第 j 天的最大利润

    如果只能只有一只股票：
        f(i) 表示 i 次交易，到第 i 天的最大利润
        f(i) = max (f(i-1), f(i-1) + p(i) - p(i-1))

    初始化
    dp[0][j] = 0, 没法执行交易，利润为 0
    dp[i][0] = 0, 第 0 天，无法卖出，利润为 0

    动态转移方程
    dp[i][j] = max(
                dp[i][j-1],
                prices[j] - prices[x] + dp[i-1][x])
        表示要么第j天啥事没发生，要么第j天卖出，第x天买入的股票
        x = 0 ~ j-1

    按照上述，正常时间复杂度是：O(k*n^2)，n是prices的长度，k是交易次数

    但是可以优化，时间复杂度是：O(k*n)
    优化的方法是，max(dp[i-1][k] + price[j] - price[k]) k from 0 to j-1,
        不需要每次重新计算

    我们可以维护一个最大值（maxDiff）, maxDiff = Math.max(maxDiff, dp[i-1][j] - price[j]);
    maxDiff 初始化为 Integer.MIN_VALUE;

    dp[i][j] = Math.max(dp[i][j-1], price[j] + maxDiff);

     */
    public int maxProfit(int k, int[] prices) {

        // 变量定义
        if (prices.length <= 1)
            return 0;

        int n = prices.length;
        int[][] dp = new int[k + 1][n];

        // 初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
        }

        // 结算
        for (int i = 1; i <= k; i++) {
            int maxdiff = Integer.MIN_VALUE;
            //maxdiff is maximum difference of dp[i-1][k] - prices[k] before and include j-2;

            for (int j = 1; j < n; j++) {
                maxdiff = Math.max(maxdiff, dp[i - 1][j - 1] - prices[j - 1]);

                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxdiff);
            }
        }
        return dp[k][n - 1];
    }

    /*
    优化后的动态规划方法
    O(k*n)
     */
    public int maxProfit2(int k, int[] prices) {

        int n = prices.length;
        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;

            for (int d = 1; d < n; d++) {
                max = Math.max(max, dp[t - 1][d - 1] - prices[d - 1]);
                dp[t][d] = Math.max(max + prices[d], dp[t][d - 1]);
            }
        }

        return dp[k][n - 1];
    }

    /*
    原始的动态规划方法，没有优化前
    O(k*n^2)
     */
    public int maxProfit3(int k, int[] prices) {

        int n = prices.length;
        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {

            for (int d = 1; d < n; d++) {
                int max = Integer.MIN_VALUE;
                for (int x = 0; x < d; x++) {
                    max = Math.max(max, dp[t - 1][x] - prices[x] + prices[d]);
                }
                dp[t][d] = Math.max(max, dp[t][d - 1]);
            }
        }

        return dp[k][n - 1];
    }


    public static void main(String[] args) {

        L188_Best_Time_to_Buy_and_Sell_Stock_IV s = new L188_Best_Time_to_Buy_and_Sell_Stock_IV();

        long sysDate1 = System.currentTimeMillis();


        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int res = s.maxProfit3(k, prices);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}