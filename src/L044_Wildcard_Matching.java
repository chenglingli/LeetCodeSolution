public class L044_Wildcard_Matching {


    /*
     *
     * 动态规划
     * dp[i][j] 表示 字符串 s 的前 i 个字符和模式 p 的前 j 个字符是否能匹配
     *
     * 如果s[i] == p[j] 或者 p[j] == '?'
     *      dp[i][j] = dp[i-1][j-1]
     *
     * 如果p[j] = '*'
     *      dp[i][j] = dp[i][j-1]   （不用*）
     *      或
     *      dp[i][j] = dp[i-1][j]   （使用*）
     * 初始化
     *  dp[0][0]=True，即当字符串 s 和模式 p 均为空时，匹配成功；
     *  dp[i][0]=False，即空模式无法匹配非空字符串；
     *  dp[0][j] 需要分情况讨论：因为星号才能匹配空字符串，所以只有当模式 p 的前 j 个字符均为星号时，dp[0][j] 才为真。
     *
     */

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = false;
            }
        }

        dp[0][0] = true;
        for (int j = 1; j < n + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }


        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

            }
        }

        return dp[m][n];
    }

    public boolean isMatch2(String s, String p) {

        int m = s.length();
        int n = p.length();

        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 1;
        for (int j = 1; j < n + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = 1;
            } else {
                break;
            }
        }


        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] >= 1 ? 1 : 0;
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

            }
        }

        return dp[m][n] == 1;
    }

    public static void main(String[] args) {

        L044_Wildcard_Matching s = new L044_Wildcard_Matching();
        long sysDate1 = System.currentTimeMillis();

        String s1 = "aba";
        String s2 = "ab?";
        boolean res = s.isMatch(s1, s2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}