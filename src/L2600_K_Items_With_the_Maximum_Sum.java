public class L2600_K_Items_With_the_Maximum_Sum {


    /*

    There is a bag that consists of items, each item has a number 1, 0, or -1 written on it.

    You are given four non-negative integers numOnes, numZeros, numNegOnes, and k.

    The bag initially contains:

    numOnes items with 1s written on them.
    numZeroes items with 0s written on them.
    numNegOnes items with -1s written on them.
    We want to pick exactly k items among the available items.
    Return the maximum possible sum of numbers written on the items.



    Example 1:

    Input: numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
    Output: 2
    Explanation: We have a bag of items with numbers written on them {1, 1, 1, 0, 0}.
    We take 2 items with 1 written on them and get a sum in a total of 2.
    It can be proven that 2 is the maximum possible sum.

    Example 2:

    Input: numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4
    Output: 3
    Explanation: We have a bag of items with numbers written on them {1, 1, 1, 0, 0}.
    We take 3 items with 1 written on them, and 1 item with 0 written on it, and get a sum in a total of 3.
    It can be proven that 3 is the maximum possible sum.


    Constraints:
    0 <= numOnes, numZeros, numNegOnes <= 50
    0 <= k <= numOnes + numZeros + numNegOnes

     */
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;

        if (k <= numOnes) {
            ans = k;
        } else {
            ans += numOnes;
            k -= numOnes;

            if (k <= numZeros) {
                return ans;
            } else {
                k -= numZeros;
                ans -= k;
            }
        }

        return ans;
    }

    public int kItemsWithMaximumSum2(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= (numOnes + numZeros)) {
            return Math.min(k, numOnes);
        } else {
            int r = k - (numOnes + numZeros);
            return numOnes - r;
        }
    }

    public static void main(String[] args) {

        L2600_K_Items_With_the_Maximum_Sum s = new L2600_K_Items_With_the_Maximum_Sum();
        long sysDate1 = System.currentTimeMillis();

        int numOnes = 3;
        int numZeros = 2;
        int numNegOnes = 6;
        int k = 7;
        int res = s.kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}