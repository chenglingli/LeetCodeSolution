import java.util.Arrays;

public class L4052_Cyclically_Shift_Rows_and_Columns {

    /*
        You are given an integer n, a 2D integer array grid of size n x n, and two integer arrays rowShift and colShift, each of length n, where:

    rowShift[i] represents the number of positions to cyclically shift the ith row of grid to the left.
    colShift[j] represents the number of positions to cyclically shift the jth column of grid upward.

    First, cyclically shift each row according to rowShift, then cyclically shift each column of the resulting grid according to colShift.

    Return the resulting grid after performing all the shifts.

    A cyclic left shift of a row by k positions moves the element at column j to column (j - k + n) % n. All other rows remain unchanged.
    A cyclic upward shift of a column by k positions moves the element at row i to row (i - k + n) % n. All other columns remain unchanged.



    Example 1:

    Input: n = 2, grid = [[1,2],[3,4]], rowShift = [1,0], colShift = [0,1]

    Output: [[2,4],[3,1]]

    Explanation:

    The grid changes as follows:



    Example 2:

    Input: n = 3, grid = [[1,2,3],[4,5,6],[7,8,9]], rowShift = [1,2,0], colShift = [2,2,1]

    Output: [[7,8,5],[2,3,9],[6,4,1]]

    Explanation:

    The grid changes as follows:





    Constraints:

    1 <= n == grid.length == grid[i].length <= 10
    1 <= grid[i][j] <= 100
    rowShift.length == colShift.length == n
    0 <= rowShift[i], colShift[i] < n

     */
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        int[][] res1 = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res1[i][j] = grid[i][(j + rowShift[i] + n) % n];
            }
        }

        int [][] res2 = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res2[i][j] = res1[(i + colShift[j] + n) % n][j];
            }
        }

        return res2;
    }

    public static void main(String[] args) {

        L4052_Cyclically_Shift_Rows_and_Columns s = new L4052_Cyclically_Shift_Rows_and_Columns();
        long sysDate1 = System.currentTimeMillis();

        int n = 3;
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] rowShift = {1, 2, 0};
        int[] colShift = {2, 2, 1};

        int[][] res = s.cyclicShift(n, grid, rowShift, colShift);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}