public class L3754_Concatenate_Non_Zero_Digits_and_Multiply_by_Sum_I {

    /*
    You are given an integer n.

    Form a new integer x by concatenating all the non-zero digits of n in their original order. If there are no non-zero digits, x = 0.

    Let sum be the sum of digits in x.

    Return an integer representing the value of x * sum.



    Example 1:

    Input: n = 10203004

    Output: 12340

    Explanation:

    The non-zero digits are 1, 2, 3, and 4. Thus, x = 1234.
    The sum of digits is sum = 1 + 2 + 3 + 4 = 10.
    Therefore, the answer is x * sum = 1234 * 10 = 12340.
    Example 2:

    Input: n = 1000

    Output: 1

    Explanation:

    The non-zero digit is 1, so x = 1 and sum = 1.
    Therefore, the answer is x * sum = 1 * 1 = 1.


    Constraints:

    0 <= n <= 109

     */
    public long sumAndMultiply(int n) {
        long res = 0;
        int pow = 0;
        int sum = 0;
        int nCopy = n;

        while (nCopy > 0) {
            int digit = nCopy % 10;
            if (digit != 0) {
                res += digit * (long)(Math.pow(10, pow));
                sum += digit;
                pow ++;
            }

            nCopy /= 10;
        }

        return res * sum;
    }

    public static void main(String[] args) {

        L3754_Concatenate_Non_Zero_Digits_and_Multiply_by_Sum_I s = new L3754_Concatenate_Non_Zero_Digits_and_Multiply_by_Sum_I();
        long sysDate1 = System.currentTimeMillis();

        int n = 10203004;
        long res = s.sumAndMultiply(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}