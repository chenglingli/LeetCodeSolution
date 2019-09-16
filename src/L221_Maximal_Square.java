public class L221_Maximal_Square {

    /**

     Given a 2D binary matrix filled with 0's and 1's,
     find the largest square containing only 1's and return its area.

     Example:

     Input:

     1 0 1 0 0
     1 0 1 1 1
     1 1 1 1 1
     1 0 0 1 0

     Output: 4

     */


    public int maximalSquare(char[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length,n = matrix[0].length;
        int [][] dp = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Integer.min(
                            Integer.min(
                                    dp[i - 1][j - 1],
                                    dp[i - 1][j]
                            ),
                            dp[i][j - 1])
                            + 1;
                }
                res = Integer.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    public static void main(String[] args) {

        L221_Maximal_Square s = new L221_Maximal_Square();
        long sysDate1 = System.currentTimeMillis();

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        int res = s.maximalSquare(matrix);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}