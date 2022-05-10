public class L010_Regular_Expression_Matching {

    /*
     * 这个问题也可以用动态规划的思路来解决。我们定义状态 dp[i][j] 为子串 s[0,i) 和 p[0,j) 是否匹配，
     * 能匹配为真，反之为假，然后状态转移方程则可以分为以下三种情况：
     *
     * 1, 如果 p[j-1] != ‘*’ && (s[i-1] == p[j-1] || p[j-1] == ‘.’) ，
     * 说明当前两个字符可以匹配且没有遇到 '*'，
     * 那么此时 dp[i][j] = dp[i-1][j-1]，也即若 s[0,i-1) 和 p[0,j-1) 匹配，则 s[0,i) 和 p[0,j) 也能匹配；
     *
     * 2, 如果 p[j-1] == ‘*’ ，说明当前字符为 '*'，并且我们用其匹配零个字符，
     * 那么 dp[i][j] = dp[i][j-2]，也即若 s[0,i) 和 p[0,j-2) 匹配，则跳过 p[j-1]，p[j-2] 两个元素后
     *     s[0,i) 和 p[0,j) 也能匹配；
     *
     * i = 1, j = 3
     * s[0, 1) 和 p[0, 1) 匹配， p[2] == '*'
     * s[0, 1) 和 p[0, 3) 匹配
     * s = "x"
     * p = "x2*"
     *
     *
     *
     *
     * 3, 如果 p[j-1] == ‘*’ ，说明当前字符为 '*'，并且我们用其匹配至少一个字符，
     * 而且还需满足 s[i-1] == p[j-2] || p[j-2] == ‘.’，
     * 那么 dp[i][j] = dp[i-1][j]，也即若 s[0,i-1) 和 p[0,j) 匹配，
     * 那么我们用这个 '*' 来匹配 s[i-1] 后， s[0,i) 和 p[0,j) 也就能匹配。
     * 至少一次是说这里 '*' 已经被用了一次，而前面 s[0,i-1) 和 p[0,j) 的匹配也有可能会用到。
     *
     * i = 2, j = 3
     * s[0, 1) 和 p[0, 1) 匹配， p[2] == '*'
     * s[0, 1) 和 p[0, 3) 匹配
     * s = "x2"
     * p = "x2*"
     *
     *
     * 其中 2 和 3 只需满足一个即可匹配
     */

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[j][i] = false;
            }
        }
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (p.charAt(j - 1) == '*') {

                    boolean repeat_zero = false;
                    boolean repeat_one_more = false;

                    repeat_zero = dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        repeat_one_more = dp[i - 1][j];
                    }

                    dp[i][j] = repeat_zero || repeat_one_more;

                } else {

                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }

                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        L010_Regular_Expression_Matching s = new L010_Regular_Expression_Matching();

        long sysDate1 = System.currentTimeMillis();

        String ss = "acb";
        String p = "ab*";

        boolean res = s.isMatch(ss, p);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}