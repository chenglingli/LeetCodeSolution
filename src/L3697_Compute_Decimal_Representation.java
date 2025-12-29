import java.util.*;

public class L3697_Compute_Decimal_Representation {

    /*
    You are given a positive integer n.

    A positive integer is a base-10 component if it is the product of a single digit from 1 to 9 and a non-negative power of 10.
    For example, 500, 30, and 7 are base-10 components, while 537, 102, and 11 are not.

    Express n as a sum of only base-10 components, using the fewest base-10 components possible.

    Return an array containing these base-10 components in descending order.



    Example 1:

    Input: n = 537

    Output: [500,30,7]

    Explanation:

    We can express 537 as 500 + 30 + 7. It is impossible to express 537 as a sum using fewer than 3 base-10 components.

    Example 2:

    Input: n = 102

    Output: [100,2]

    Explanation:

    We can express 102 as 100 + 2. 102 is not a base-10 component, which means 2 base-10 components are needed.

    Example 3:

    Input: n = 6

    Output: [6]

    Explanation:

    6 is a base-10 component.



    Constraints:

    1 <= n <= 10^9
     */
    public int[] decimalRepresentation(int n) {
        List<Integer> resList = new ArrayList<>();
        int tempN = n;

        int p = 0;
        while (tempN > 0) {
            int digit = tempN % 10;
            if (digit != 0) {
                resList.add((int)(Math.pow(10, p) * digit));
            }
            p++;
            tempN /= 10;
        }

        int l = resList.size();
        int[] res = new int[l];
        for (int i = 0; i < l; i++) {
            res[l - i - 1] = resList.get(i);
        }

        return res;
    }


    public static void main(String[] args) {

        L3697_Compute_Decimal_Representation s = new L3697_Compute_Decimal_Representation();
        long sysDate1 = System.currentTimeMillis();

        int n = 5037;

        int[] res = s.decimalRepresentation(n);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}