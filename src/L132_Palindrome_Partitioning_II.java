
public class L132_Palindrome_Partitioning_II {

    /**
     * 整体的思路是一维DP。DP[i]表示长度为i的prefix：s[0: i-1]的min cut数量。
     DP[i] = min (DP[j] + 1) ，对所有 0<=j<i，且s[j: i-1]为palindrome。
     和I同样的技巧，用DP先计算存储一个palindrome判断矩阵isPal[i][j]，便于后面一维DP计算中能迅速判断s[j: i-1]是否为palindrome。
     */
    public int minCut(String s) {
        int len = s.length();

        boolean dp[][] = new boolean[len][len];
        int cut[] = new int[len];

        for (int j = 0; j < len; j++) {
            cut[j] = j; //set maximum # of cut

            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (i > 0) {
                        // if need to cut, add 1 to the previous cut[i-1]
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    } else {
                        // if [0...j] is palindrome, no need to cut
                        cut[j] = 0;
                    }
                }
            }
        }

        return cut[len - 1];
    }

    public static void main(String[] args) {

        L132_Palindrome_Partitioning_II s = new L132_Palindrome_Partitioning_II();

        long sysDate1 = System.currentTimeMillis();
        int res = s.minCut("aaccda");

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}