import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1380_Lucky_Numbers_in_a_Matrix {


    /*
     the minimum element in its row
        and maximum in its column

        All elements in the matrix are distinct.

     */
    public List<Integer> luckyNumbers(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[] rowMin = new int[row];
        for (int i = 0; i < row; i++) {
            rowMin[i] = 100001;
        }
        int[] colMax = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rowMin[i] = Math.min(matrix[i][j], rowMin[i]);
                colMax[j] = Math.max(matrix[i][j], colMax[j]);
            }
        }

        Arrays.sort(colMax);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            if (binarySearch(colMax, rowMin[i]) != -1) {
                res.add(rowMin[i]);
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }


    public List<Integer> luckyNumbers2(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            int minCol = minColInRow(matrix, row);
            int value = matrix[row][minCol];
            if (checkIfMaxInCol(matrix, minCol, value)) {
                result.add(value);
            }
        }

        return result;
    }

    private int minColInRow(int[][] matrix, int row) {
        int minIndex = 0, min = matrix[row][minIndex];
        for (int col = 1; col < matrix[row].length; col++) {
            if (matrix[row][col] < min) {
                min = matrix[row][col];
                minIndex = col;
            }
        }
        return minIndex;
    }

    private boolean checkIfMaxInCol(int[][] matrix, int col, int value) {
        for (int[] ints : matrix) {
            if (ints[col] > value)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

        L1380_Lucky_Numbers_in_a_Matrix s = new L1380_Lucky_Numbers_in_a_Matrix();
        long sysDate1 = System.currentTimeMillis();

        //        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        //        int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        int[][] matrix = {{56216}, {63251}, {75772}, {1945}, {27014}};

        List<Integer> res = s.luckyNumbers(matrix);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}