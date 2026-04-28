public class L3908_Valid_Digit_Number {

    /*

    You are given an integer n and a digit x.

    A number is considered valid if:

    It contains at least one occurrence of digit x, and
    It does not start with digit x.
    Return true if n is valid, otherwise return false.



    Example 1:

    Input: n = 101, x = 0

    Output: true

    Explanation:

    The number contains digit 0 at index 1. It does not start with 0, so it satisfies both conditions. Thus, the answer is true


    Example 2:

    Input: n = 232, x = 2

    Output: false

    Explanation:

    The number starts with 2, which violates the condition. Thus, the answer is false.


    Example 3:

    Input: n = 5, x = 1

    Output: false

    Explanation:

    The number does not contain digit 1. Thus, the answer is false.


    Constraints:

    0 <= n <= 10^5
    0 <= x <= 9

     */
    public boolean validDigit(int n, int x) {
        int num = n;
        boolean flag = false;

        while (num > 9) {
            if (num % 10 == x) {
                flag = true;
            }
            num /= 10;
        }

        if (num == x) {
            return false;
        }

        if (flag) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L3908_Valid_Digit_Number s = new L3908_Valid_Digit_Number();
        long sysDate1 = System.currentTimeMillis();

        int n = 101;
        int x = 0;

        boolean res = s.validDigit(n, x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}