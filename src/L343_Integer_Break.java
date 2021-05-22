public class L343_Integer_Break {

    /**
     * Given a positive integer n, break it into the sum of at
     * least two positive integers and maximize the product of those integers.
     * Return the maximum product you can get.
     * <p>
     * Example 1:
     * <p>
     * Input: 2
     * Output: 1
     * Explanation: 2 = 1 + 1, 1 × 1 = 1.
     * Example 2:
     * <p>
     * Input: 10
     * Output: 36
     * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
     * Note: You may assume that n is not less than 2 and not larger than 58.
     */

    int[] maxValue = new int[60];

    public int integerBreak(int n) {

        maxValue[1] = 1;
        maxValue[2] = 1;
        maxValue[3] = 2;
        maxValue[4] = 4;

        if (maxValue[n] != 0) {
            return maxValue[n];
        }

        int ans = -1;

        for (int i = 2; i <= n / 2; i++) {
            int temp1 = i * integerBreak(n - i);
            int temp2 = i * (n - i);
            ans = Integer.max(temp1, ans);
            ans = Integer.max(temp2, ans);
        }

        maxValue[n] = ans;
        return ans;
    }

    public int integerBreak3(int n) {
        if (n == 2 || n == 3) return n - 1;
        if (n == 4) return 4;
        n -= 5;
        return (int) Math.pow(3, (n / 3 + 1)) * (n % 3 + 2);
    }

    public int integerBreak2(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {

        L343_Integer_Break s = new L343_Integer_Break();
        long sysDate1 = System.currentTimeMillis();

        int res = s.integerBreak2(58);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}