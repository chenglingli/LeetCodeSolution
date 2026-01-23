public class L3726_Remove_Zeros_in_Decimal_Representation {

    /*
    You are given a positive integer n.

    Return the integer obtained by removing all zeros from the decimal representation of n.



    Example 1:

    Input: n = 1020030

    Output: 123

    Explanation:

    After removing all zeros from 1020030, we get 123.

    Example 2:

    Input: n = 1

    Output: 1

    Explanation:

    1 has no zero in its decimal representation. Therefore, the answer is 1.



    Constraints:

    1 <= n <= 10^15

     */
    public long removeZeros(long n) {
        long res = 0;

        while (n > 0) {
            int x = (int) (n % 10);
            if (x != 0) {
                res = res * 10 + x;
            }
            n /= 10;
        }

        long res2 = 0;
        while (res > 0) {
            res2 = res2 * 10 + (int) (res % 10);
            res /= 10;
        }

        return res2;
    }

    public static void main(String[] args) {

        L3726_Remove_Zeros_in_Decimal_Representation s = new L3726_Remove_Zeros_in_Decimal_Representation();
        long sysDate1 = System.currentTimeMillis();

        long n = 1020030;

        long res = s.removeZeros(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}