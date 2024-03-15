import java.util.ArrayList;
import java.util.List;

public class L073_Set_Matrix_Zeroes {

    /*
    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -231 <= matrix[i][j] <= 231 - 1
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> recordRow = new ArrayList<>();
        List<Integer> recordColumn = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    recordRow.add(i);
                    recordColumn.add(j);
                }
            }
        }

        for (int i = 0; i < recordRow.size(); i++) {
            for (int j = 0; j < n; j++) {
                matrix[recordRow.get(i)][j] = 0;
            }
        }

        for (int j = 0; j < recordColumn.size(); j++) {
            for (int i = 0; i < m; i++) {
                matrix[i][recordColumn.get(j)] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // mark ith index of row wih 1:
                    row[i] = 1;

                    // mark jth index of col wih 1:
                    col[j] = 1;
                }
            }
        }

        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        L073_Set_Matrix_Zeroes s = new L073_Set_Matrix_Zeroes();

        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 1, 1}
        };
        s.setZeroes(matrix);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}