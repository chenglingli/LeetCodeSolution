import java.util.HashMap;
import java.util.Map;


public class L309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    /*
    动态规划

     */

    private int maxProfit(int currentDay, int prevBuyDay, int[] prices, Map<Integer, Integer> cache) {

        if (currentDay >= prices.length)
            return 0;

        int cacheKey = currentDay * prices.length + prevBuyDay;
        if (cache.containsKey(cacheKey))
            return cache.get(cacheKey);

        int maxProfit = 0;

        if (prevBuyDay == -1) {
            int buyNow = maxProfit(currentDay + 1, currentDay, prices, cache);
            int notBuyNow = maxProfit(currentDay + 1, -1, prices, cache);
            maxProfit = Math.max(buyNow, notBuyNow);
        } else if (prices[prevBuyDay] < prices[currentDay]) {
            int sellNow = (prices[currentDay] - prices[prevBuyDay]) + maxProfit(currentDay + 2, -1, prices, cache);
            int notBuyNow = maxProfit(currentDay + 1, prevBuyDay, prices, cache);
            maxProfit = Math.max(sellNow, notBuyNow);
        }

        cache.put(cacheKey, maxProfit);

        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        return maxProfit(0, -1, prices, new HashMap<>());
    }


    /*
    动态规划

     */
    public int maxProfit2(int[] prices) {

        int hold = Integer.MIN_VALUE;
        int sold = Integer.MIN_VALUE;

        int reset = 0;

        for (int price : prices) {
            int preSold = sold;

            sold = hold + price;
            hold = Math.max(hold, reset - price);
            reset = Math.max(reset, preSold);
        }

        return Math.max(sold, reset);
    }

    /*


        buy[i]  = max(rest[i-1]-price, buy[i-1])
        sell[i] = max(buy[i-1]+price, sell[i-1])
        rest[i] = max(sell[i-1], buy[i-1], rest[i-1])

     */
    public int maxProfit3(int[] prices) {

        int n = prices.length;

        if (n < 2)
            return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = prices[0];
        buy[1] = Math.min(prices[0], prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - buy[1]);

        //
        for (int i = 2; i < n; i++) {
            buy[i] = Math.min(buy[i - 1], prices[i] - sell[i - 2]);
            sell[i] = Math.max(sell[i - 1], prices[i] - buy[i]);
        }

        return sell[n - 1];
    }

    /*

        Logic

        We will focus on current day i, what kind of day it is? 3 cases:

        buy day
        coolDown day
        sell day

        We will discuss each one of them

        If it is a buy day,
            then we cannot make any profit at current day,
            so the max profit is the max profit we have made previously,
            i.e. yesterday, M[i] = M[i - 1]

        If It is a coolDown day,
            then same as above, we cannot make profit at current day =>M[i] = M[i - 1](1)

        If It is a sell day,
            then which day is the buy day? The buy day could be any days before day i(exclusive, i.e. 0 to i - 1).
            Let's denote it as j, then the profit we get = + previous day's profit + nums[i] - nums[j].
            The problem becomes what is the previous days' profit?
            To figure it out, ask yourself what about the day j - 1?

        3.1. j - 1 cannot be a buy day.
            Since you cannot have 2 continuous days(j - 1 and j) as the buy day,
            you must sell the stock before you buy again as required.
        3.2. j - 1 cannot be a sell day as well,
            because if it is, day j must be a coolDown day.
        3.3. Thus, day j - 1 must be a coolDown day.
            If it is a coolDown day, then the max profit we can get at day j - 1 is M[j - 2]

        Above all, M[i] = Math.max(M[j - 2] + nums[i] - nums[j])
            for j = 0 to i - 1 (2)

        With (1) and (2), we know that:
        M[i] = max(M[i - 1], Math.max(M[j - 2] + nums[i] - nums[j])
            for j = 0 to i - 1)


       M[i] 表示第i天获得的最大收益。

       我们专注于考虑i天的操作：
       sell
       buy
       coolDown

       如果是buy：
        M[i] = M[i-1]
       如果是coolDown：
        M[i] = M[i-1]
       如果是sell：
        我们得到的收益 =  之前天的收益 + nums[i] - nums[j]

        那 之前天的收益 是多少呢？
        那就要看j-1天做了啥。j-1天不可能是buy（不能连续买），也不可能是sell（因为如果这样，第j天必须是coolDown），只能是coolDown
        所以 之前天的收益 == M[j-2]

        所以
        M[i] = max(M[i-1], M[j-2] + prices[i] - prices[j])
        j是buy的天数，j < i

       时间复杂度是：O(n^2)
       空间复杂度是：O(n)

     */
    public int maxProfit4(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        int n = prices.length;
        int[] M = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                M[0] = 0;
            } else if (i == 1) {
                M[1] = Math.max(prices[1] - prices[0], 0);
            } else {
                M[i] = M[i - 1];

                // linear scan
                for (int j = 0; j < i; j++) {
                    int prev = j >= 2 ? M[j - 2] : 0;
                    M[i] = Math.max(M[i], prev + prices[i] - prices[j]);
                }
            }
        }

        return M[n - 1];
    }

    /*
    优化4

    我们注意到:
    M[i] = max(M[i - 1], Math.max(M[j - 2] + nums[i] - nums[j])
        for j = 0 to i - 1) (3)

    这里的M[j - 2] + nums[i] - nums[j]是一个变化的值，
    maxDiff = max(maxDiff, M[j - 2] - nums[j])
    我们可以用一个变量maxDiff来保存它的最大值，这样(3)就可以变成 M[i] = max(M[i - 1], maxDiff + nums[i]) (4)

     */
    public int maxProfit5(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        int n = prices.length;
        int[] M = new int[n];
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                M[0] = 0;
                // 因为i-2不存在，M[i - 2] == 0
                maxDiff = Math.max(maxDiff, -prices[i]);
            } else if (i == 1) {
                M[1] = Math.max(prices[1] - prices[0], 0);
                // 因为i-2不存在，M[i - 2] == 0
                maxDiff = Math.max(maxDiff, -prices[i]);
            } else {
                M[i] = Math.max(M[i - 1], maxDiff + prices[i]);
                maxDiff = Math.max(maxDiff, M[i - 2] - prices[i]);
            }
        }

        return M[n - 1];
    }


    public static void main(String[] args) {


        L309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown s = new L309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
        long sysDate1 = System.currentTimeMillis();

        int[] prices = {1, 2, 3, 0, 2};
        int res = s.maxProfit(prices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}