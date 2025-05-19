public class L1572_Matrix_Diagonal_Sum {


    /*
    Given a square matrix mat, return the sum of the matrix diagonals.

    Only include the sum of all the elements on the primary diagonal
        and all the elements on the secondary diagonal that are not part of the primary diagonal.



    Example 1:
    Input: mat = [[1,2,3],
                  [4,5,6],
                  [7,8,9]]
    Output: 25
    Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
    Notice that element mat[1][1] = 5 is counted only once.

    Example 2:

    Input: mat = [[1,1,1,1],
                  [1,1,1,1],
                  [1,1,1,1],
                  [1,1,1,1]]
    Output: 8

    Example 3:

    Input: mat = [[5]]
    Output: 5


    Constraints:

    n == mat.length == mat[i].length
    1 <= n <= 100
    1 <= mat[i][j] <= 100

     */
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        // 方法一：动态判断
//        for (int i = 0; i < n; i++) {
//            sum += mat[i][i]; // primary diagonal
//            if (i != n - 1 - i) {
//                // secondary diagonal, excluding the elements on the primary diagonal
//                sum += mat[i][n - 1 - i];
//            }
//        }

        // 方法二：直接计算，排除中间的元素
        for (int i = 0; i < n; i++) {
            sum += mat[i][i]; // primary diagonal
            sum += mat[i][n - 1 - i]; // secondary diagonal
        }
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }

    public static void main(String[] args) {

        L1572_Matrix_Diagonal_Sum s =
                new L1572_Matrix_Diagonal_Sum();
        long sysDate1 = System.currentTimeMillis();

//        int[][] mat = new int[][] {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

        int[][] mat = new int[][] {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int res = s.diagonalSum(mat);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}