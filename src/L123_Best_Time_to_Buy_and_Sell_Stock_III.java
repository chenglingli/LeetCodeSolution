// Best Time to Buy and Sell Stock III

/**
 * DP int [m+1][n] m is the number of transactions, n is the number of days = prices.length;
 * dp[i][j] means maximum total profit gained when complete i transactions (0 means no transaction)
 * at day j (can only buy at day 0)
 * <p>
 * initialization:
 * dp[0][j] = 0, since if there is no transaction, no profit
 * dp[i][0] = 0, since it is at day[0], you can only buy, not sell, so no profit will be make.
 * final: return dp[m][n-1]
 * <p>
 * update:
 * dp[i][j] = max (dp[i][j-1], max(dp[i-1][k] + price[j] - price[k]) k from 0 to j-1;)
 * either at day j, no new transaction, or a transaction happened by sell the stock bought at day[k];
 * <p>
 * <p>
 * one trick to reduce time complexity from O(mn^2) to O(mn);
 * max(dp[i-1][k] + price[j] - price[k]) k from 0 to j-1, does not need to be compute from scratch every time
 * we can keep a maximum value (maxdiff) of part dp[i-1][k] - price[k] (k = 0 ~ j-1), and when j move to j + 1;
 * the maxdiff = Math.max(maxdiff, dp[i-1][j] - price[j]); maxdiff is initialized to be Integer.MIN_VALUE;
 * <p>
 * detailed instruction: https://www.youtube.com/watch?v=oDhu5uGq_ic&feature=youtu.be
 */

public class L123_Best_Time_to_Buy_and_Sell_Stock_III {

    public int maxProfit(int[] prices) {

        // 变量定义
        if (prices.length <= 1) return 0;
        int m = 2;
        int n = prices.length;
        int[][] dp = new int[m + 1][n];

        // 初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        // 结算
        for (int i = 1; i <= m; i++) {
            int maxdiff = Integer.MIN_VALUE;
            //maxdiff is maximum difference of dp[i-1][k] - prices[k] before and include j-2;

            for (int j = 1; j < n; j++) {
                maxdiff = Math.max(maxdiff, dp[i - 1][j - 1] - prices[j - 1]);

                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxdiff);
            }
        }
        return dp[m][n - 1];
    }

    public static void main(String[] args) {

        L123_Best_Time_to_Buy_and_Sell_Stock_III s = new L123_Best_Time_to_Buy_and_Sell_Stock_III();

        long sysDate1 = System.currentTimeMillis();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        int res = s.maxProfit(prices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}