public class L3622_Check_Divisibility_by_Digit_Sum_and_Product {

    /*

    You are given a positive integer n. Determine whether n is divisible by the sum of the following two values:

    The digit sum of n (the sum of its digits).

    The digit product of n (the product of its digits).

    Return true if n is divisible by this sum; otherwise, return false.



    Example 1:

    Input: n = 99

    Output: true

    Explanation:

    Since 99 is divisible by the sum (9 + 9 = 18) plus product (9 * 9 = 81) of its digits (total 99), the output is true.

    Example 2:

    Input: n = 23

    Output: false

    Explanation:

    Since 23 is not divisible by the sum (2 + 3 = 5) plus product (2 * 3 = 6) of its digits (total 11), the output is false.



    Constraints:

    1 <= n <= 106
     */
    public boolean checkDivisibility(int n) {

        int copyN = n;
        int sum = 0;
        int product = 1;

        while (n > 0) {
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }

        return (sum + product) == 0 || copyN % (sum + product) == 0;
    }

    public static void main(String[] args) {

        L3622_Check_Divisibility_by_Digit_Sum_and_Product s = new L3622_Check_Divisibility_by_Digit_Sum_and_Product();
        long sysDate1 = System.currentTimeMillis();

        int n = 99;

        boolean res = s.checkDivisibility(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}