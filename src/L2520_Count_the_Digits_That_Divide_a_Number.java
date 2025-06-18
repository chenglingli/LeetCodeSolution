public class L2520_Count_the_Digits_That_Divide_a_Number {

    /*
     Given an integer num, return the number of digits in num that divide num.
    An integer val divides nums if nums % val == 0.


    Example 1:
    Input: num = 7
    Output: 1
    Explanation: 7 divides itself, hence the answer is 1.

    Example 2:
    Input: num = 121
    Output: 2
    Explanation: 121 is divisible by 1, but not 2. Since 1 occurs twice as a digit, we return 2.

    Example 3:
    Input: num = 1248
    Output: 4
    Explanation: 1248 is divisible by all of its digits, hence the answer is 4.

    Constraints:
    1 <= num <= 10^9
    num does not contain 0 as one of its digits.

     */
    public int countDigits(int num) {
        int ans = 0;

        int n = num;

        while (n > 0) {
            int temp = n % 10;

            if (temp != 0 && num % temp == 0) {
                ans++;
            }
            n = n / 10;
        }

        return ans;
    }

    public static void main(String[] args) {

        L2520_Count_the_Digits_That_Divide_a_Number s = new L2520_Count_the_Digits_That_Divide_a_Number();
        long sysDate1 = System.currentTimeMillis();

        int num = 1048;
        int res = s.countDigits(num);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}