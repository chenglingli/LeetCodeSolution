

// Best Time to Buy and Sell Stock III

public class maxProfit3 {

    public int maxProfit3(int[] prices) {

        if (prices.length <= 1) return 0;
        int m = 2;
        int n = prices.length;
        int[][] dp = new int[m+1][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            int maxdiff = Integer.MIN_VALUE; //maxdiff is maximum difference of dp[i-1][k] - prices[k] before and include j-2;
            for (int j = 1; j < n; j++) {
                maxdiff = Math.max(maxdiff, dp[i-1][j-1] - prices[j-1]);
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxdiff);
            }
        }
        return dp[m][n-1];
    }

    public int maxProfit2(int[] prices) {

        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }


    public static void main(String[] args) {

        maxProfit3 s = new maxProfit3();

        long sysDate1 = System.currentTimeMillis();
        int [] prices = {7,1,5,3,6,4};

        int res = s.maxProfit2(prices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}