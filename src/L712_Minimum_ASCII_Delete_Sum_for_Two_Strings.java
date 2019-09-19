import java.util.Arrays;

public class L712_Minimum_ASCII_Delete_Sum_for_Two_Strings {

    /**

     Given two strings s1, s2, find the lowest ASCII sum of deleted
     characters to make two strings equal.

     Example 1:
     Input: s1 = "sea", s2 = "eat"
     Output: 231
     Explanation: Deleting "s" from "sea" adds the ASCII
     value of "s" (115) to the sum.
     Deleting "t" from "eat" adds 116 to the sum.
     At the end, both strings are equal, and 115 + 116 = 231
     is the minimum sum possible to achieve this.

     Example 2:
     Input: s1 = "delete", s2 = "leet"
     Output: 403
     Explanation: Deleting "dee" from "delete" to turn the string into "let",
     adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from
     "leet" adds 101[e] to the sum.
     At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
     If instead we turned both strings into "lee" or "eet", we
     would get answers of 433 or 417, which are higher.
     Note:

     0 < s1.length, s2.length <= 1000.
     All elements of each string will have an ASCII value in [97, 122].

     */

    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int [][]dp = new int[m+1][n+1];

        for (int i = 1 ; i <= n; i++)
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);

        for (int i = 1 ; i <= m; i++)
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = s1.charAt(i-1) == s2.charAt(j-1) ? dp[i-1][j-1] :
                        Integer.min(dp[i-1][j] + s1.charAt(i-1),dp[i][j-1] + s2.charAt(j-1));

        return dp[m][n];
    }

    public int minimumDeleteSum2(String s1, String s2) {

        int len = s1.length();
        int total = 0;
        int[][] pos = new int[26][0];

        char[] ss1 = s1.toCharArray();
        for (int i = 0; i < len; i++) {
            total += (int)ss1[i];
            int index = ss1[i] - 'a';
            int[] a = pos[index];
            pos[index] = Arrays.copyOf(a, a.length + 1);
            pos[index][a.length] = i;
        }

        int[] dp = new int[len];
        for (int i = 0; i < s2.length(); i++) {
            int ch = (int)s2.charAt(i);
            total += ch;
            int[] ps = pos[ch - 'a'];
            for (int j = ps.length - 1; j >= 0; j--) {
                int p = ps[j];
                int v = ch + (p > 0 ? dp[p - 1] : 0);
                while (p < len && v > dp[p]) {
                    dp[p] = v;
                    p += 1;
                }
            }
        }

        return total - (dp[len - 1] << 1);
    }

    public static void main(String[] args) {

        L712_Minimum_ASCII_Delete_Sum_for_Two_Strings s = new L712_Minimum_ASCII_Delete_Sum_for_Two_Strings();
        long sysDate1 = System.currentTimeMillis();

        String s1 = "delete";
        String s2 = "leet";

        int res = s.minimumDeleteSum(s1, s2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}