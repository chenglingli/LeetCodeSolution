import java.util.Arrays;

public class L2595_Number_of_Even_and_Odd_Bits {

    /*
    You are given a positive integer n.

    Let even denote the number of even indices in the binary representation of n with value 1.

    Let odd denote the number of odd indices in the binary representation of n with value 1.

    Note that bits are indexed from right to left in the binary representation of a number.

    Return the array [even, odd].



    Example 1:

    Input: n = 50

    Output: [1,2]

    Explanation:
    The binary representation of 50 is 110010.
    It contains 1 on indices 1, 4, and 5.


    Example 2:

    Input: n = 2
    Output: [0,1]

    Explanation:
    The binary representation of 2 is 10.
    It contains 1 only on index 1.



    Constraints:

    1 <= n <= 1000
     */
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];

        for (int i = 0; i < 32; ++i) {
            if ((n & (1 << i)) != 0) {
                ans[i % 2]++;
            }
        }

        return ans;
    }

    public int[] evenOddBit2(int n) {
        int[] ans = new int[2];

        int x = n;

        int index = 0;
        while (x > 0) {
            int cur = x % 2;
            if (cur == 1) {
                ans[index % 2]++;
            }
            x = x / 2;
            index++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L2595_Number_of_Even_and_Odd_Bits s = new L2595_Number_of_Even_and_Odd_Bits();
        long sysDate1 = System.currentTimeMillis();

        int n = 50;
        int[] ans = s.evenOddBit2(n);
        System.out.println(Arrays.toString(ans));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}