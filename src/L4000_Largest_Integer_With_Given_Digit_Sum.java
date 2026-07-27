import java.util.ArrayList;
import java.util.List;

public class L4000_Largest_Integer_With_Given_Digit_Sum {

    /*
    You are given two non-negative integers n and s.

    Return the largest integer that has at most n digits and whose sum of digits is s. If no such integer exists, return -1.



    Example 1:

    Input: n = 2, s = 9

    Output: 90

    Explanation:

    The largest integer with at most 2 digits that has a sum of digits of 9 is 90.

    Example 2:

    Input: n = 2, s = 19

    Output: -1

    Explanation:

    There is no integer with at most 2 digits that has a sum of digits of 19, so the answer is -1.

    Example 3:

    Input: n = 5, s = 0

    Output: 0

    Explanation:

    The only non-negative integer whose digits sum to 0 is 0.



    Constraints:

    1 <= n <= 5
    0 <= s <= 100
     */

    public int largestInteger(int n, int s) {
        if (s == 0) {
            return 0;
        }

        List<Integer> resList = new ArrayList<>();
        while (s > 0 && n > 0) {
            int digit = Math.min(9, s);
            resList.add(digit);

            s -= digit;
            n--;
        }

        if (s == 0 && n > 0) {
            while (n > 0) {
                resList.add(0);
                n--;
            }
        }
        else if (s > 0 && n == 0) {
            return -1;
        }

        int res = 0;
        int len = resList.size();
        for (int i = 0; i < resList.size(); i++) {
            res += resList.get(i) * (int)(Math.pow(10, len - i - 1));
        }

        return res;
    }

    public static void main(String[] args) {

        L4000_Largest_Integer_With_Given_Digit_Sum s = new L4000_Largest_Integer_With_Given_Digit_Sum();
        long sysDate1 = System.currentTimeMillis();

        int n = 2;
        int ss = 9;
        int res = s.largestInteger(n, ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}