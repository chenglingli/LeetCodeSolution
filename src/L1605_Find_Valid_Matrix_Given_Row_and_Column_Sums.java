import java.util.Arrays;

public class L1605_Find_Valid_Matrix_Given_Row_and_Column_Sums {

    /**
     * You are given two arrays rowSum and colSum of non-negative integers
     * where rowSum[i] is the sum of the elements in the ith row and colSum[j] is the sum of the elements of the jth column of a 2D matrix.
     * <p>
     * In other words, you do not know the elements of the matrix, but you do know the sums of each row and column.
     * <p>
     * Find any matrix of non-negative integers of size rowSum.length x colSum.length that satisfies the rowSum and colSum requirements.
     * <p>
     * Return a 2D array representing any matrix that fulfills the requirements.
     * <p>
     * It's guaranteed that at least one matrix that fulfills the requirements exists.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: rowSum = [3,8], colSum = [4,7]
     * Output: [[3,0],
     * [1,7]]
     * Explanation:
     * 0th row: 3 + 0 = 3 == rowSum[0]
     * 1st row: 1 + 7 = 8 == rowSum[1]
     * 0th column: 3 + 1 = 4 == colSum[0]
     * 1st column: 0 + 7 = 7 == colSum[1]
     * The row and column sums match, and all matrix elements are non-negative.
     * Another possible matrix is: [[1,2],
     * [3,5]]
     * <p>
     * <p>
     * Example 2:
     * Input: rowSum = [5,7,10], colSum = [8,6,8]
     * Output: [[0,5,0],
     * [6,1,0],
     * [2,0,8]]
     * <p>
     * Constraints:
     * 1 <= rowSum.length, colSum.length <= 500
     * 0 <= rowSum[i], colSum[i] <= 10^8
     * sum(rowSum) == sum(colSum)
     */

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        int r = rowSum.length;
        int c = colSum.length;

        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }

        return res;
    }

    public int[][] restoreMatrix2(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int[][] matrix = new int[m][n];

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            // 对于i行j列的值，取当前行和列的和的最小值作为该单元格的值
            int value = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = value;

            // 更新剩余的行和列的和
            rowSum[i] -= value;
            colSum[j] -= value;

            // 如果当前行已经填满，移动到下一行。该行的其他值都为0，因此无需再处理该列
            if (rowSum[i] == 0) {
                i++;
            }

            // 如果当前列已经填满，移动到下一列。该列的其他值都为0，因此无需再处理该行
            if (colSum[j] == 0) {
                j++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        L1605_Find_Valid_Matrix_Given_Row_and_Column_Sums s = new L1605_Find_Valid_Matrix_Given_Row_and_Column_Sums();
        long sysDate1 = System.currentTimeMillis();

        int[] rowSum = new int[]{5, 7, 10};
        int[] colSum = new int[]{8, 6, 8};
        int[][] res = s.restoreMatrix2(rowSum, colSum);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}