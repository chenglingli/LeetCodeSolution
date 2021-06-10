public class MaxProfit {

    public int maxProfit2(int[] prices) {

        int max = 0;
        if (prices.length == 0)
            return 0;
        int minbuyprice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minbuyprice)
                minbuyprice = prices[i];
            else
                //   max = Math.max(prices[i]-minbuyprice,max);
                max = max > prices[i] - minbuyprice ? max : prices[i] - minbuyprice;
        }
        return max;

    }

    public static void main(String[] args) {

        MaxProfit s = new MaxProfit();

        long sysDate1 = System.currentTimeMillis();
        int[] prices = {7};

        int res = s.maxProfit2(prices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }

}