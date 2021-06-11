public class L122_Best_Time_to_Buy_and_Sell_Stock_II {

    /**
     * f(i) = max (f(i-1), f(i-1) + p(i) - p(i-1))
     */

    public int maxProfit(int[] prices) {

        int len = prices.length;
        int[] p = new int[len];
        p[0] = 0;
        for (int i = 1; i < len; i++) {
            p[i] = Math.max(prices[i] - prices[i - 1] + p[i - 1], p[i - 1]);
        }
        return p[len - 1];
    }

    public static void main(String[] args) {

        L122_Best_Time_to_Buy_and_Sell_Stock_II s = new L122_Best_Time_to_Buy_and_Sell_Stock_II();

        long sysDate1 = System.currentTimeMillis();
        int[] prices = {7, 1, 5, 3, 6, 4};

        int res = s.maxProfit(prices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }

}