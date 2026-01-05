public class L3536_Maximum_Product_of_Two_Digits {

    /*
    You are given a positive integer n.

    Return the maximum product of any two digits in n.

    Note: You may use the same digit twice if it appears more than once in n.


    Example 1:

    Input: n = 31

    Output: 3

    Explanation:

    The digits of n are [3, 1].
    The possible products of any two digits are: 3 * 1 = 3.
    The maximum product is 3.
    Example 2:

    Input: n = 22

    Output: 4

    Explanation:

    The digits of n are [2, 2].
    The possible products of any two digits are: 2 * 2 = 4.
    The maximum product is 4.
    Example 3:

    Input: n = 124

    Output: 8

    Explanation:

    The digits of n are [1, 2, 4].
    The possible products of any two digits are: 1 * 2 = 2, 1 * 4 = 4, 2 * 4 = 8.
    The maximum product is 8.


    Constraints:

    10 <= n <= 10^9
     */
    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }
            n /= 10;
        }
        return max1 * max2;
    }

    public static void main(String[] args) {

        L3536_Maximum_Product_of_Two_Digits s = new L3536_Maximum_Product_of_Two_Digits();
        long sysDate1 = System.currentTimeMillis();

        int n = 124;

        int res = s.maxProduct(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}