public class L121_Best_Time_to_Buy_and_Sell_Stock {

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


    public static void main(String[] args) {

        L121_Best_Time_to_Buy_and_Sell_Stock s = new L121_Best_Time_to_Buy_and_Sell_Stock();

        long sysDate1 = System.currentTimeMillis();

        int[] prices = {7};

        int res = s.maxProfit(prices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}