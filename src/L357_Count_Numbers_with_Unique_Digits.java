public class L357_Count_Numbers_with_Unique_Digits {

    /**
     * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
     * <p>
     * Example:
     * <p>
     * Input: 2
     * Output: 91
     * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
     * excluding 11,22,33,44,55,66,77,88,99
     */

    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) return 1;
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            res += count(i);
        }
        return res;
    }

    int count(int k) {
        if (k < 1) return 0;
        if (k == 1) return 10;
        int res = 1;
        for (int i = 9; i >= (11 - k); --i) {
            res *= i;
        }
        return res * 9;
    }

    public static void main(String[] args) {

        L357_Count_Numbers_with_Unique_Digits s = new L357_Count_Numbers_with_Unique_Digits();
        long sysDate1 = System.currentTimeMillis();

        int res = s.countNumbersWithUniqueDigits(2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}