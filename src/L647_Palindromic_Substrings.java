public class L647_Palindromic_Substrings {

    /**
     * Given a string, your task is to count how many
     * palindromic substrings in this string.
     * <p>
     * The substrings with different start indexes
     * or end indexes are counted as different substrings even they consist of same characters.
     * <p>
     * Example 1:
     * <p>
     * Input: "abc"
     * Output: 3
     * Explanation: Three palindromic strings: "a", "b", "c".
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: "aaa"
     * Output: 6
     * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     */

    public int countSubstrings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        int[][] palindromicStatus = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() && i + j < s.length(); j++) {
                if (i == 0) {
                    palindromicStatus[j][j + i] = 1;
                    count++;
                } else if ((s.charAt(j) == s.charAt(j + i) && i == 1) ||
                        (s.charAt(j) == s.charAt(j + i) && palindromicStatus[j + 1][i + j - 1] == 1)) {
                    palindromicStatus[j][j + i] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    public int countSubstrings3(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]))
                    dp[i][j] = true;
                if (dp[i][j]) res++;
            }
        }
        return res;
    }

    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extendPalin(s, i, i);
            count += extendPalin(s, i, i + 1);
        }
        return count;
    }

    public int extendPalin(String s, int left, int right) {
        int count = 0;
        for (; left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right); left--, right++) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        L647_Palindromic_Substrings s = new L647_Palindromic_Substrings();
        long sysDate1 = System.currentTimeMillis();

        String ss = "aaaaa";

        int res = s.countSubstrings(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}