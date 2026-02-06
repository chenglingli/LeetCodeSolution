import java.util.Arrays;

public class L3643_Flip_Square_Submatrix_Vertically {

    /*

    You are given an m x n integer matrix grid, and three integers x, y, and k.

    The integers x and y represent the row and column indices of the top-left corner of a square submatrix and the integer k represents the size (side length) of the square submatrix.

    Your task is to flip the submatrix by reversing the order of its rows vertically.

    Return the updated matrix.



    Example 1:


    Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], x = 1, y = 0, k = 3

    Output: [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]

    Explanation:

    The diagram above shows the grid before and after the transformation.

    Example 2:

    Input: grid = [[3,4,2,3],[2,3,4,2]], x = 0, y = 2, k = 2

    Output: [[3,4,4,2],[2,3,2,3]]

    Explanation:

    The diagram above shows the grid before and after the transformation.



    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    1 <= grid[i][j] <= 100
    0 <= x < m
    0 <= y < n
    1 <= k <= min(m - x, n - y)
     */
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for (int i = 0; i < k / 2; i++) {

            int top = x + i;
            int bottom = x + k - 1 - i;

            for (int col = 0; col < k; col++) {
                int temp = grid[top][y + col];
                grid[top][y + col] = grid[bottom][y + col];
                grid[bottom][y + col] = temp;
            }
        }
        return grid;
    }

    public static void main(String[] args) {

        L3643_Flip_Square_Submatrix_Vertically s = new L3643_Flip_Square_Submatrix_Vertically();
        long sysDate1 = System.currentTimeMillis();

        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int x = 1;
        int y = 0;
        int k = 3;

        int[][]  res = s.reverseSubmatrix(grid, x, y, k);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}