public class L240_Search_a_2D_Matrix_II {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0 ; i < m; i++ ) {
            if (matrix[i][0] > target || matrix[i][n-1] < target) {
                continue;
            }

            if (binarySearch(matrix, target, i)) {
                return true;
            }
        }

        return false;
    }

    boolean binarySearch(int[][] matrix, int target, int line) {

        int l = 0; int r = matrix[line].length-1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[line][mid] == target) {
                return true;
            }
            else if (target > matrix[line][mid]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j])
                return true;
            else if (target < matrix[i][j])
                j--;
            else
                i++;
        }
        return false;
    }


    public static void main(String[] args) {

        L240_Search_a_2D_Matrix_II s = new L240_Search_a_2D_Matrix_II();

        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = {{1,4,7,11,15},{3,5,8,12,19},{5,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        // int[][] matrix = {{1}};
        int target = 2;

        boolean res = s.searchMatrix(matrix, target);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}