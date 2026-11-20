import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1072_Flip_Columns_For_Maximum_Number_of_Equal_Rows {

    /*

    You are given an m x n binary matrix matrix.

    You can choose any number of columns in the matrix and flip every cell in that column
        (i.e., Change the value of the cell from 0 to 1 or vice versa).

    Return the maximum number of rows that have all values equal after some number of flips.



    Example 1:
    Input: matrix = [[0,1],[1,1]]
    Output: 1
    Explanation: After flipping no values, 1 row has all values equal.

    Example 2:
    Input: matrix = [[0,1],[1,0]]
    Output: 2
    Explanation: After flipping values in the first column, both rows have equal values.

    Example 3:
    Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
    Output: 2
    Explanation: After flipping values in the first two columns, the last two rows have equal values.


    Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 300
    matrix[i][j] is either 0 or 1.

     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        /*
        题意：一个二进制数字矩阵，可以任意翻动某一列，已达到最多的行数字一样

        思路：
        遍历每一行，判断首位，如果为0则不动，如果为1则取反

        然后看，有多少行是一样的，取最大值即可
         */

        Map<String, Integer> map = new HashMap<>();

        for (int[] ints : matrix) {
            StringBuilder sb = new StringBuilder();
            if (ints[0] == 1) {
                for (int i = 0; i < ints.length; i++) {
                    sb.append(ints[i] ^ 1);
                }
            } else {
                for (int anInt : ints) {
                    sb.append(anInt);
                }
            }
            map.put(sb
                    .toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(value, max);
        }

        return max;

    }

    public int maxEqualRowsAfterFlips2(int[][] matrix) {

        // Approach Using Bit Manipulation
        int rows = matrix.length;
        int cols = matrix[0].length;

        Map<Integer, Integer> mp = new HashMap<>();
        int maxRows = Integer.MIN_VALUE;

        for (int r = 0; r < rows; ++r) {
            if (matrix[r][0] == 1) {
                for (int c = 0; c < cols; ++c) {
                    matrix[r][c] ^= 1;
                }
            }

            // Use Arrays.hashCode() to get the hashcode of the row
            // and store the count of rows having same hashcode
            int cnt = mp.merge(Arrays.hashCode(matrix[r]), 1, Integer::sum);

            // Update maxRows
            maxRows = Math.max(maxRows, cnt);
        }

        return maxRows;
    }

    public static void main(String[] args) {

        L1072_Flip_Columns_For_Maximum_Number_of_Equal_Rows s = new L1072_Flip_Columns_For_Maximum_Number_of_Equal_Rows();

        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = new int[][]{
                {0, 1},
                {1, 0}
        };

        int res = s.maxEqualRowsAfterFlips(matrix);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}