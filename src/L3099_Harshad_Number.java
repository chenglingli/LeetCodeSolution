public class L3099_Harshad_Number {

    /*

    An integer divisible by the sum of its digits is said to be a Harshad number.
    You are given an integer x. Return the sum of the digits of x if x is a Harshad number, otherwise, return -1.



    Example 1:

    Input: x = 18

    Output: 9

    Explanation:

    The sum of digits of x is 9. 18 is divisible by 9. So 18 is a Harshad number and the answer is 9.

    Example 2:

    Input: x = 23

    Output: -1

    Explanation:

    The sum of digits of x is 5. 23 is not divisible by 5. So 23 is not a Harshad number and the answer is -1.



    Constraints:

    1 <= x <= 100

     */
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int orgX = x;

        while (orgX > 0) {
            sum += orgX % 10;
            orgX /= 10;
        }

        return x % sum == 0 ? sum : -1;
    }

    public static void main(String[] args) {

        L3099_Harshad_Number s = new L3099_Harshad_Number();
        long sysDate1 = System.currentTimeMillis();

        int x = 18;

        int res = s.sumOfTheDigitsOfHarshadNumber(x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}