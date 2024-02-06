public class L074_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int col = searchCol(matrix, target);
        if (col == -1) {
            return false;
        }

        int row = searchRow(matrix[col], target);
        return row != -1;
    }

    int searchCol(int[][] matrix, int target) {
        int m = matrix.length;
        if (matrix[0][0] > target) return -1;
        if (matrix[m - 1][0] < target) return m - 1;

        int l = 0, r = m - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (matrix[mid][0] > target) r = mid - 1;
            else l = mid;
        }
        if (matrix[l][0] <= target) return l;
        return -1;
    }

    int searchRow(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[r] == target) return r;
        else return -1;
    }

    public static void main(String[] args) {

        L074_Search_a_2D_Matrix s = new L074_Search_a_2D_Matrix();

        long sysDate1 = System.currentTimeMillis();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean res = s.searchMatrix(matrix, 3);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        
        System.out.print(sysDate2 - sysDate1);
    }
}