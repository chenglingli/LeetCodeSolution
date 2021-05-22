public class L878_Nth_Magical_Number {

    /**
     * A positive integer is magical if it is divisible by either A or B.
     * <p>
     * Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: N = 1, A = 2, B = 3
     * Output: 2
     * <p>
     * Example 2:
     * <p>
     * Input: N = 4, A = 2, B = 3
     * Output: 6
     * <p>
     * Example 3:
     * <p>
     * Input: N = 5, A = 2, B = 4
     * Output: 10
     * <p>
     * <p>
     * Example 4:
     * <p>
     * Input: N = 3, A = 6, B = 4
     * Output: 8
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= N <= 10^9
     * 2 <= A <= 40000
     * 2 <= B <= 40000
     */

    public int nthMagicalNumber(int N, int A, int B) {
        long lcm = A * B / gcd(A, B);
        long left = 2, right = (long) Math.pow(10, 14), M = (long) Math.pow(10, 9) + 7;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid / A + mid / B - mid / lcm < N) left = mid + 1;
            else right = mid;
        }

        return (int) (right % M);
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

        L878_Nth_Magical_Number s = new L878_Nth_Magical_Number();
        long sysDate1 = System.currentTimeMillis();

        int res = s.nthMagicalNumber(8, 10, 5);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}