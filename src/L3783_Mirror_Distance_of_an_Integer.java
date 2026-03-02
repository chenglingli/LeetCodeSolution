public class L3783_Mirror_Distance_of_an_Integer {

    /*
    You are given an integer n.

    Define its mirror distance as: abs(n - reverse(n)) where reverse(n) is the integer formed by reversing the digits of n.

    Return an integer denoting the mirror distance of n.

    abs(x) denotes the absolute value of x.



    Example 1:

    Input: n = 25

    Output: 27

    Explanation:

    reverse(25) = 52.
    Thus, the answer is abs(25 - 52) = 27.
    Example 2:

    Input: n = 10

    Output: 9

    Explanation:

    reverse(10) = 01 which is 1.
    Thus, the answer is abs(10 - 1) = 9.
    Example 3:

    Input: n = 7

    Output: 0

    Explanation:

    reverse(7) = 7.
    Thus, the answer is abs(7 - 7) = 0.


    Constraints:

    1 <= n <= 10^9

     */
    public int mirrorDistance(int n) {
        if (n <= 9) {
            return 0;
        }
        int x = reverse(n);
        return Math.abs(n - x);
    }

    private int reverse(int n) {

        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }

        return res;
    }

    public static void main(String[] args) {

        L3783_Mirror_Distance_of_an_Integer s = new L3783_Mirror_Distance_of_an_Integer();
        long sysDate1 = System.currentTimeMillis();

        int n = 25;
        int res = s.mirrorDistance(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}