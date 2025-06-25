public class L2544_Alternating_Digit_Sum {

    /*
    You are given a positive integer n. Each digit of n has a sign according to the following rules:

    The most significant digit is assigned a positive sign.
    Each other digit has an opposite sign to its adjacent digits.
    Return the sum of all digits with their corresponding sign.



    Example 1:

    Input: n = 521
    Output: 4
    Explanation: (+5) + (-2) + (+1) = 4.

    Example 2:
    Input: n = 111
    Output: 1
    Explanation: (+1) + (-1) + (+1) = 1.

    Example 3:
    Input: n = 886996
    Output: 0
    Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.

    Constraints:
    1 <= n <= 10^9

     */
    public int alternateDigitSum(int n) {
        int sum = 0;
        int x = n;
        int count = 1;

        while (x > 0) {
            int digit = x % 10;
            if (count % 2 == 1) {
                sum += digit;
            }
            else {
                sum -= digit;
            }

            x /= 10;
            count++;
        }

        if (count % 2 == 1) {
            sum *= -1;
        }

        return sum;
    }

    public static void main(String[] args) {

        L2544_Alternating_Digit_Sum s = new L2544_Alternating_Digit_Sum();
        long sysDate1 = System.currentTimeMillis();

        int num = 521;
        int res = s.alternateDigitSum(num);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}