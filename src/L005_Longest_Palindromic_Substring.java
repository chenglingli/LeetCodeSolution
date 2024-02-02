public class L005_Longest_Palindromic_Substring {

    /**
     * 动态规划
     * dp[i, j]  1表示从i到j是否是回文[i, j]
     *
     * 那么，
     * dp[i, j] == 1, 如果 j == i
     * dp[i, j] == 1, 如果 j > i + 2 && dp[i+1, j-1]==1 && s.charAt[i] == s.charAt[j]
     * dp[i, j] == 1, 如果 j = i + 2 && s.charAt[i] == s.charAt[j]
     * dp 过程中记录最大duration对应的 left 和 right
     *
     */

    public String longestPalindrome(String s) {

        String res = "";
        if (s == null || s.length() == 0) {
            return res;
        }

        int[][] dp = new int[s.length()][s.length()];
        int max = 0;
        int right = 0, left = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 2 || dp[j + 1][i - 1] == 1) {
                        dp[j][i] = 1;
                    }
                }

                if (dp[j][i] == 1 && max < i - j + 1) {
                    max = i - j + 1;
                    right = i;
                    left = j;
                }
            }
            dp[i][i] = 1;
        }

        res = s.substring(left, right + 1);

        return res;
    }

    public String longestPalindrome2(String s) {

        String res = "";
        if (s == null || s.length() == 0) {
            return res;
        }

        int[][] dp = new int[s.length()][s.length()];
        int max = 0;
        int right = 0, left = 0;

        for (int j = 0; j < s.length(); j++) {

            // i==j
            dp[j][j] = 1;

            for (int i = 0; i < j; i++) {

                // i+1==j
                if (i == j - 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                    }
                }
                // i+1<j
                else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }

                // 记录当前最长串
                if (dp[i][j] == 1 && max < j - i + 1) {
                    max = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }

        res = s.substring(left, right + 1);

        return res;
    }

    public static void main(String[] args) {

        L005_Longest_Palindromic_Substring s = new L005_Longest_Palindromic_Substring();

        long sysDate1 = System.currentTimeMillis();

        String input = "cbbd";

        String res = s.longestPalindrome(input);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}