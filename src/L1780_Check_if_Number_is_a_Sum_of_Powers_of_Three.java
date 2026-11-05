public class L1780_Check_if_Number_is_a_Sum_of_Powers_of_Three {

    /*

    Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

    An integer y is a power of three if there exists an integer x such that y == 3^x.



    Example 1:

    Input: n = 12
    Output: true
    Explanation: 12 = 3^1 + 3^2
    Example 2:

    Input: n = 91
    Output: true
    Explanation: 91 = 3^0 + 3^2 + 3^4
    Example 3:

    Input: n = 21
    Output: false


    Constraints:

    1 <= n <= 10^7

     */
    public boolean checkPowersOfThree(int n) {
        /*
        题意：
        判断一个整数，是否可以由3的幂的和组成

         */

        int x = n;

        while (x > 0) {

            if (x % 3 == 0) {
                x /= 3;
            }
            else if (x % 3 == 1) {
                x -= 1;
            }
            else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L1780_Check_if_Number_is_a_Sum_of_Powers_of_Three s = new L1780_Check_if_Number_is_a_Sum_of_Powers_of_Three();
        long sysDate1 = System.currentTimeMillis();

        int n = 21;
        boolean res = s.checkPowersOfThree(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}