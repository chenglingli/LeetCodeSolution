public class L121_Best_Time_to_Buy_and_Sell_Stock {

    /**
     * 题目
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed
     * because you must buy before you sell.
     *
     */


    /**
     *
     * 解法1，
     * 从尾部找，找到当前最大值数组，max[i]表示，倒过来看到下标i时候的最大值。
     * 其实下标i时候卖的话可以获得的最大卖价。
     * 然后遍历数组，max[i] - num[i] 就知道可以获得的最大收益了。
     *
     */
    public int maxProfit(int[] prices) {

        // 从尾部计算最大售出价
        int[] max = new int[prices.length];
        int curMax = -1;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > curMax) {
                max[i] = prices[i];
                curMax = max[i];
            } else {
                max[i] = curMax;
            }
        }

        int curRes = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = max[i] - prices[i];
            if (temp > curRes) {
                curRes = temp;
            }
        }
        return curRes;
    }

    /**
     *
     * 解法2
     *
     * minBuyPrice 记录到目前为止的最小price
     * max记录到目前i为止可以获得的最大收益
     *
     */
    public int maxProfit2(int[] prices) {

        int max = 0;
        if (prices.length == 0)
            return 0;
        int minBuyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minBuyPrice)
                minBuyPrice = prices[i];
            else
                max = Math.max(max, prices[i] - minBuyPrice);
        }
        return max;
    }




    public static void main(String[] args) {

        L121_Best_Time_to_Buy_and_Sell_Stock s = new L121_Best_Time_to_Buy_and_Sell_Stock();

        long sysDate1 = System.currentTimeMillis();

        int[] prices = {7,1,5,3,6,4};

        int res = s.maxProfit2(prices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}