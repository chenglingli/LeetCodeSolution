public class L1277_Count_Square_Submatrices_with_All_Ones {

    /*

    Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

    Example 1:

    Input: matrix =
    [
      [0,1,1,1],
      [1,1,1,1],
      [0,1,1,1]
    ]
    Output: 15

    Explanation:
    There are 10 squares of side 1.
    There are 4 squares of side 2.
    There is  1 square of side 3.
    Total number of squares = 10 + 4 + 1 = 15.

    Example 2:
    Input: matrix =
    [
      [1,0,1],
      [1,1,0],
      [1,1,0]
    ]
    Output: 7
    Explanation:
    There are 6 squares of side 1.
    There is 1 square of side 2.
    Total number of squares = 6 + 1 = 7.


    Constraints:
    1 <= arr.length <= 300
    1 <= arr[0].length <= 300
    0 <= arr[i][j] <= 1

     */
    public int countSquares(int[][] matrix) {
        // dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
        // dp[i][j] 表示 以 (i, j) 为右下角、且全是 1 的最大正方形边长

        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += dp[i][j];
            }
        }

        return res;
    }

    public int countSquares2(int[][] matrix) {

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    continue;
                matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]));
            }
        }
        int res = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res += matrix[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L1277_Count_Square_Submatrices_with_All_Ones s = new L1277_Count_Square_Submatrices_with_All_Ones();
        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int res = s.countSquares(matrix);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}