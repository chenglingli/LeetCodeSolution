import java.util.Arrays;

public class L1475_Final_Prices_With_a_Special_Discount_in_a_Shop {

    /*

    There is a special discount for items in the shop.
    If you buy the ith item, then you will receive a discount equivalent to prices[j]
        where j is the minimum index such that j > i and prices[j] <= prices[i].

    Otherwise, you will not receive any discount at all.

    Input: prices = [8,4,6,2,3]
    Output: [4,2,4,2,3]

    Explanation:
    For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4,
    therefore, the final price you will pay is 8 - 4 = 4.
    For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2,
    therefore, the final price you will pay is 4 - 2 = 2.
    For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2,
    therefore, the final price you will pay is 6 - 2 = 4.
    For items 3 and 4 you will not receive any discount at all.


     */

    public int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] res = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int discount = findDiscount(prices, i);
            res[i] = prices[i] - discount;
        }

        res[n - 1] = prices[n - 1];

        return res;
    }

    private int findDiscount(int[] prices, int x) {
        int i = x + 1;
        int n = prices.length;

        while (i < n && prices[i] > prices[x]) {
            i++;
        }

        if (i == n) {
            return 0;
        }
        return prices[i];
    }

    public static void main(String[] args) {

        L1475_Final_Prices_With_a_Special_Discount_in_a_Shop s = new L1475_Final_Prices_With_a_Special_Discount_in_a_Shop();
        long sysDate1 = System.currentTimeMillis();

        int[] prices = {8, 4, 6, 2, 3};
        int[] res = s.finalPrices(prices);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}