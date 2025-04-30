import java.util.Arrays;

public class L883_Projection_Area_of_3D_Shapes {

    /*

    You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.

    Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).

    We view the projection of these cubes onto the xy, yz, and zx planes.

    A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane.
        We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

    Return the total area of all three projections.



    Example 1:


    Input: grid = [[1,2],[3,4]]
    Output: 17
    Explanation: Here are the three projections ("shadows") of the shape made with each axis-aligned plane.


    Example 2:

    Input: grid = [[2]]
    Output: 5


    Example 3:

    Input: grid = [[1,0],[0,2]]
    Output: 8


    Constraints:

    n == grid.length == grid[i].length
    1 <= n <= 50
    0 <= grid[i][j] <= 50


     */
    public int projectionArea(int[][] grid) {

        int res = 0;

        // x 投影最大值sum
        for (int[] xList : grid) {
            res += Arrays.stream(xList).max().getAsInt();
        }

        // y 投影最大值sum
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int[] xList : grid) {
                max = Math.max(max, xList[i]);
            }
            res += max;
        }

        // z 投影总面积(其实就是不为0的个数)
        for (int[] xList : grid) {
            res += Arrays.stream(xList).filter(a -> a != 0).count();
        }

        return res;
    }


    public int projectionArea2(int[][] grid) {
        int N = grid.length;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            int bestRow = 0;  // largest of grid[i][j]
            int bestCol = 0;  // largest of grid[j][i]
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0) ans++;  // top shadow
                bestRow = Math.max(bestRow, grid[i][j]);
                bestCol = Math.max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;
        }

        return ans;
    }

    public static void main(String[] args) {

        L883_Projection_Area_of_3D_Shapes s = new L883_Projection_Area_of_3D_Shapes();
        long sysDate1 = System.currentTimeMillis();

        int[][] grid = new int[][]{
                {1, 2},
                {3, 4}
        };
        int res = s.projectionArea(grid);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}