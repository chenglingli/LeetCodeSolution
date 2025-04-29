import java.util.Arrays;

public class L867_Transpose_Matrix {


    /*
    Given a 2D integer array matrix, return the transpose of matrix.

    The transpose of a matrix is the matrix flipped over its main diagonal,
    switching the matrix's row and column indices.



    Example 1:

    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[1,4,7],[2,5,8],[3,6,9]]
    Example 2:

    Input: matrix = [[1,2,3],[4,5,6]]
    Output: [[1,4],[2,5],[3,6]]


    Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 1000
    1 <= m * n <= 10^5
    -10^9 <= matrix[i][j] <= 10^9


     */
    public int[][] transpose(int[][] matrix) {

        int[][] res = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        L867_Transpose_Matrix s = new L867_Transpose_Matrix();
        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] res = s.transpose(matrix);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}