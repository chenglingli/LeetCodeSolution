public class L115_Distinct_Subsequences {

    /*

        f[i, j] 表示 t 前 i 字符串可以由 s 的 j 字符串组成的最多个数.
        t的长度是m，s的长度是n
        结果是 ： s[m, n]

        f[i, j] = f[i, j - 1] + f[i - 1, j - 1]  if t[i] == s[j]
        f[i, j] = f[i, j - 1]  if t[i] != s[j]

        Input: s = "babgbag", t = "bag"
        Output: 5

        Input: s = "rabbbit", t = "rabbit"
        Output: 3

        1 <= s.length, t.length <= 1000
        s and t consist of English letters.

        自底向上写法
        打表法
        Tabulation

     */
    public int numDistinct(String s, String t) {

        int m = t.length();
        int n = s.length();

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {
                dp[0][j] = 1;

                if (j < i) {
                    continue;
                }

                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }



    /*
    递归写法，带有备忘录
    自顶向下

   Memoization
     */

    private Integer[][] map;
    private String s;
    private String t;

    public int numDistinct2(String s, String t) {
        map = new Integer[s.length() + 1][t.length() + 1];
        this.s = s;
        this.t = t;
        return dp(s.length(), t.length());
    }

    private int dp(int i, int j) {

        if (j == 0) {
            return 1;
        }
        if (i < j) {
            return 0;
        }

        if (map[i][j] != null) {
            return map[i][j];
        }

        if (s.charAt(i - 1) != t.charAt(j - 1)) {
            map[i][j] = dp(i - 1, j);
        } else {
            map[i][j] = dp(i - 1, j - 1) + dp(i - 1, j);
        }
        return map[i][j];
    }

    public static void main(String[] args) {

        L115_Distinct_Subsequences s = new L115_Distinct_Subsequences();

        long sysDate1 = System.currentTimeMillis();
        //        String s1 = "babgbag";
        //        String s2 = "bag";

        String s1 = "rabbbit";
        String s2 = "rabbit";

        int res = s.numDistinct(s1, s2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}