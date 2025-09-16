import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3370_Smallest_Number_With_All_Set_Bits {

    /*
    You are given a positive number n.

    Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits



    Example 1:
    Input: n = 5
    Output: 7
    Explanation:
    The binary representation of 7 is "111".

    Example 2:
    Input: n = 10
    Output: 15

    Explanation:
    The binary representation of 15 is "1111".

    Example 3:
    Input: n = 3
    Output: 3
    Explanation:
    The binary representation of 3 is "11".



    Constraints:

    1 <= n <= 1000
     */
    public int smallestNumber(int n) {

        if (n <= 1) {
            return 1;
        } else if (n <= (int) Math.pow(2, 2) - 1) {
            return (int) Math.pow(2, 2) - 1;
        } else if (n <= (int) Math.pow(2, 3) - 1) {
            return (int) Math.pow(2, 3) - 1;
        } else if (n <= (int) Math.pow(2, 4) - 1) {
            return (int) Math.pow(2, 4) - 1;
        } else if (n <= (int) Math.pow(2, 5) - 1) {
            return (int) Math.pow(2, 5) - 1;
        } else if (n <= (int) Math.pow(2, 6) - 1) {
            return (int) Math.pow(2, 6) - 1;
        } else if (n <= (int) Math.pow(2, 7) - 1) {
            return (int) Math.pow(2, 7) - 1;
        } else if (n <= (int) Math.pow(2, 8) - 1) {
            return (int) Math.pow(2, 8) - 1;
        } else if (n <= (int) Math.pow(2, 9) - 1) {
            return (int) Math.pow(2, 9) - 1;
        } else if (n <= (int) Math.pow(2, 10) - 1) {
            return (int) Math.pow(2, 10) - 1;
        } else if (n <= (int) Math.pow(2, 11) - 1) {
            return (int) Math.pow(2, 11) - 1;
        }

        return -1;
    }

    public int smallestNumber2(int n) {
        int t = 2;

        while (t <= n)
            t *= 2;

        return t - 1;
    }

    public int smallestNumber3(int n) {

        /* 计算出从左边看第一个1在哪

        32位的整数，00000000000000000000000000011000，Integer.numberOfLeadingZeros(n)得到27
        32-27 == 5
         */

        int s = 32 - Integer.numberOfLeadingZeros(n);
        int res = (1 << s) - 1;
        return res;
    }


    public static void main(String[] args) {

        L3370_Smallest_Number_With_All_Set_Bits s = new L3370_Smallest_Number_With_All_Set_Bits();
        long sysDate1 = System.currentTimeMillis();


        int n = 10;
        int res = s.smallestNumber(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}