public class L097_Interleaving_String {

    /*
    0 <= s1.length, s2.length <= 100
    0 <= s3.length <= 200
    s1, s2, and s3 consist of lowercase English letters.

    dp[i][j] 代表 s1 的前 i 个字符和 s2 的前 j 个字符是否可以交错组成 s3 的前 i+j 个字符
    dp[0][0] = true

    递推方程：
    dp[i][j] = (dp[i - 1][j] == 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
            || (dp[i][j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ? 1 : 0;

     */
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if (m + n != l) {
            return false;
        }

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] == 1 && s1.charAt(i - 1) == s3.charAt(i - 1) ? 1 : 0;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(j - 1) ? 1 : 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] == 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ? 1 : 0;
            }
        }

        return dp[m][n] == 1;
    }


    /*
    一维数组进行DP

    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
     || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));

     */
    public boolean isInterleave2(String s1, String s2, String s3) {

        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l)
            return false;

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <= n; ++j) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; ++i) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; ++j) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[n];
    }


    /*
     递归方式
     */
    public boolean isInterleave3(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l)
            return false;

        int[] memo = new int[101 * 101];

        return helper(0, 0, 0, memo, l, s1, s2, s3);
    }

    private boolean helper(
            int i, int j, int k,
            int[] memo, int l,
            String s1, String s2, String s3) {
        if (k == l) {
            return true;
        }

        if (memo[i * 101 + j] != 0) {
            return memo[i * 101 + j] == 1;
        }

        boolean ans = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = helper(i + 1, j, k + 1, memo, l, s1, s2, s3);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = ans || helper(i, j + 1, k + 1, memo, l, s1, s2, s3);
        }

        memo[i * 101 + j] = ans ? 1 : -1;

        return ans;
    }


    public boolean isInterleave4(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length())
            return false;

        return recursion(
                s1, s2, s3, 0, 0, 0,
                new boolean[s1.length() + 1][s2.length() + 1]);

    }

    /*
    递归
     */
    private boolean recursion(String s1, String s2, String s3, int i, int j, int k, boolean[][] visited) {
        if (k == s3.length()) return true;
        if (visited[i][j]) return false;

        boolean valid =
                i < s1.length() && s1.charAt(i) == s3.charAt(k)
                    && recursion(s1, s2, s3, i + 1, j, k + 1, visited)
                ||
                j < s2.length() && s2.charAt(j) == s3.charAt(k)
                        && recursion(s1, s2, s3, i, j + 1, k + 1, visited);

        if (!valid)
            visited[i][j] = true;

        return valid;
    }

    public static void main(String[] args) {

        L097_Interleaving_String s = new L097_Interleaving_String();

        long sysDate1 = System.currentTimeMillis();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        boolean res = s.isInterleave3(s1, s2, s3);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}