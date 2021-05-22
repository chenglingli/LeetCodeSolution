public class LongestPalindrome {

    /**
     * 动态规划
     * dp[i, j] = 1                                   if i == j
     *            = s[i] == s[j]                        if j = i + 1
     *            = s[i] == s[j] && dp[i + 1][j - 1]    if j > i + 1 
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

    public static void main(String[] args) {

        LongestPalindrome s = new LongestPalindrome();

        long sysDate1 = System.currentTimeMillis();

        String input = "babad";

        String res = s.longestPalindrome(input);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}