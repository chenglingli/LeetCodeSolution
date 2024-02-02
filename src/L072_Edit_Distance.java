import java.util.Arrays;

public class L072_Edit_Distance {

    /*
    0 <= word1.length, word2.length <= 500
    word1 and word2 consist of lowercase English letters.

    Insert a character
    Delete a character
    Replace a character


    f[i][j] 表示 word1[0..i] 和 word2[0..j] 的最小编辑距离

    如果 word1[i] == word2[j]，那么 f[i][j] = f[i-1][j-1]
    否则 f[i][j] = min(f[i-1][j], f[i][j-1], f[i-1][j-1]) + 1

    f[0][0] = 0;
    f[0][1] = 1;
    f[1][0] = 1;
    f[1][1] = 1;


    打表写法：自底向上
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length(), n = word2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        int[][] f = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            f[i][0] = i;
            for (int j = 1; j <= n; j++) {
                f[0][j] = j;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                }
            }
        }

        return f[m][n];
    }


    /*
    递归写法：自顶向下
     */
    public int helper(int n, int m, String w1, String w2, int[][] dp) {

        if (m < 0) {
            return n + 1;
        }

        if (n < 0) {
            return m + 1;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (w1.charAt(n) == w2.charAt(m)) {

            // match found
            return dp[n][m] = helper(n - 1, m - 1, w1, w2, dp);

        } else {

            // replace
            int replace = 1 + helper(n - 1, m - 1, w1, w2, dp);

            // not take
            int notTake = Math.min(
                    1 + helper(n - 1, m, w1, w2, dp),
                    1 + helper(n, m - 1, w1, w2, dp));

            return dp[n][m] = Math.min(replace, notTake);
        }
    }

    public int minDistance2(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int res = 0;

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        res = helper(n - 1, m - 1, word1, word2, dp);
        return res;
    }

    public static void main(String[] args) {

        L072_Edit_Distance s = new L072_Edit_Distance();

        long sysDate1 = System.currentTimeMillis();
        //        String word1 = "intention";
        //        String word2 = "execution";
        //        String word1 = "horse";
        //        String word2 = "ros";

        String word1 = "";
        String word2 = "a";
        int res = s.minDistance(word1, word2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}