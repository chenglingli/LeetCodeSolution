public class L2133_Check_if_Every_Row_and_Column_Contains_All_Numbers {

    /*
    n == matrix.length == matrix[i].length
    1 <= n <= 100
    1 <= matrix[i][j] <= n

    An n x n matrix is valid
        if every row and every column contains
            all the integers from 1 to n (inclusive).

    Given an n x n integer matrix,
        return true if the matrix is valid.
            Otherwise, return false.
     */
    public boolean checkValid(int[][] matrix) {

        int n = matrix.length;
        int[][] line = new int[n][n];
        int[][] column = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                line[i][matrix[i][j] - 1] = 1;
                column[j][matrix[i][j] - 1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (line[i][j] == 0) {
                    return false;
                }
                if (column[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkValid2(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            if (!checkRow(matrix[i]))
                return false;
            if (!checkColumn(matrix, i))
                return false;
        }

        return true;
    }

    boolean checkRow(int[] row) {

        int[] count = new int[row.length + 1];
        for (int i : row) {
            count[i]++;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) return false;
        }
        return true;
    }

    boolean checkColumn(int[][] matrix, int column) {

        int[] count = new int[matrix.length + 1];
        for (int[] ints : matrix) {
            count[ints[column]]++;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        L2133_Check_if_Every_Row_and_Column_Contains_All_Numbers s =
                new L2133_Check_if_Every_Row_and_Column_Contains_All_Numbers();
        long sysDate1 = System.currentTimeMillis();

        int[][] nums = {{1, 1, 3}, {3, 1, 2}, {2, 3, 1}};
        // matrix = [[1,2,3],[3,1,2],[2,3,1]]
        // matrix = [[1,1,1],[1,2,3],[1,2,3]]
        boolean res = s.checkValid(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}