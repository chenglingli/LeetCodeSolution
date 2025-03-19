import java.util.Arrays;

public class L566_Reshape_the_Matrix {

    /**
     * In MATLAB, there is a handy function called reshape
     * which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
     * <p>
     * You are given an m x n matrix mat
     * and two integers r and c representing the number of rows
     * and the number of columns of the wanted reshaped matrix.
     * <p>
     * The reshaped matrix should be filled with all the elements of the original matrix
     * in the same row-traversing order as they were.
     * <p>
     * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix;
     * Otherwise, output the original matrix.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: mat = [[1,2],[3,4]], r = 1, c = 4
     * Output: [[1,2,3,4]]
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: mat = [[1,2],[3,4]], r = 2, c = 4
     * Output: [[1,2],[3,4]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 100
     * -1000 <= mat[i][j] <= 1000
     * 1 <= r, c <= 300
     */

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        // 如果原始矩阵的元素总数不等于新矩阵的元素总数，则无法进行重塑操作，直接返回原始矩阵
        if (m * n != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        int row = 0;
        int col = 0;

        // 遍历原始矩阵，将元素按行遍历顺序填入新矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[row][col] = mat[i][j];

                // 当当前列数等于新矩阵的列数减1时，说明当前行已经填满，需要换行
                if (col == c - 1) {
                    row++;
                    col = 0;
                } else {
                    col++;
                }
            }
        }

        return res;
    }

    public int[][] matrixReshape2(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;
        if ((m * n) != (r * c)) {
            return mat;
        }

        int[][] res = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L566_Reshape_the_Matrix s = new L566_Reshape_the_Matrix();
        long sysDate1 = System.currentTimeMillis();

        int[][] mat = new int[][]{{1, 2}, {3, 4}};
        int r = 4;
        int c = 1;
        int[][] res = s.matrixReshape2(mat, r, c);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}