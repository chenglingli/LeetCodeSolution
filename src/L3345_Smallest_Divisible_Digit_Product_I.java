import java.util.Arrays;
import java.util.List;

public class L3345_Smallest_Divisible_Digit_Product_I {

    /*
    You are given two integers n and t.
    Return the smallest number greater than or equal to n such that the product of its digits is divisible by t.

    Example 1:

    Input: n = 10, t = 2

    Output: 10

    Explanation:

    The digit product of 10 is 0, which is divisible by 2,
    making it the smallest number greater than or equal to 10 that satisfies the condition.

    Example 2:

    Input: n = 15, t = 3

    Output: 16

    Explanation:

    The digit product of 16 is 6, which is divisible by 3,
    making it the smallest number greater than or equal to 15 that satisfies the condition.


    Constraints:

    1 <= n <= 100
    1 <= t <= 10
     */

    public int smallestNumber(int n, int t) {
        int res = n;

        while (true) {

            int product = 1;
            for (int i = res; i > 0; i /= 10) {
                product *= i % 10;
            }

            if (product % t == 0) {
                break;
            }

            res++;
        }

        return res;
    }

    public static void main(String[] args) {

        L3345_Smallest_Divisible_Digit_Product_I s = new L3345_Smallest_Divisible_Digit_Product_I();
        long sysDate1 = System.currentTimeMillis();

        int n = 15;
        int k = 3;

        int res = s.smallestNumber(n, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}