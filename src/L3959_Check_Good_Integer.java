public class L3959_Check_Good_Integer {

    /*

    You are given a positive integer n.

    Let digitSum be the sum of the digits of n, and let squareSum be the sum of the squares of the digits of n.

    An integer is called good if squareSum - digitSum >= 50.

    Return true if n is good. Otherwise, return false.



    Example 1:

    Input: n = 1000

    Output: false

    Explanation:

    The digits of 1000 are 1, 0, 0, and 0.
    The digitSum is 1 + 0 + 0 + 0 = 1.
    The squareSum is 12 + 02 + 02 + 02 = 1.
    The squareSum - digitSum is 1 - 1 = 0. As 0 is not greater than or equal to 50, the output is false.
    Example 2:

    Input: n = 19

    Output: true

    Explanation:

    The digits of 19 are 1 and 9.
    The digitSum is 1 + 9 = 10.
    The squareSum is 12 + 92 = 1 + 81 = 82.
    The squareSum - digitSum is 82 - 10 = 72. As 72 is greater than or equal to 50, the output is true.


    Constraints:

    1 <= n <= 10^9

     */
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int squareSum = 0;

        while (n > 0) {
            digitSum += n % 10;
            squareSum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return squareSum - digitSum >= 50;
    }

    public static void main(String[] args) {

        L3959_Check_Good_Integer s = new L3959_Check_Good_Integer();
        long sysDate1 = System.currentTimeMillis();

        int n = 19;
        boolean res = s.checkGoodInteger(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}