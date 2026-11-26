import java.util.Arrays;

public class L3567_Minimum_Absolute_Difference_in_Sliding_Submatrix {

    /*
    You are given an m x n integer matrix grid and an integer k.

    For every contiguous k x k submatrix of grid,
        compute the minimum absolute difference between any two distinct values within that submatrix.

    Return a 2D array ans of size (m - k + 1) x (n - k + 1),
        where ans[i][j] is the minimum absolute difference in the submatrix whose top-left corner is (i, j) in grid.

    Note: If all elements in the submatrix have the same value, the answer will be 0.

    A submatrix (x1, y1, x2, y2) is a matrix that is formed by choosing all cells matrix[x][y] where x1 <= x <= x2 and y1 <= y <= y2.


    Example 1:

    Input: grid = [[1,8],[3,-2]], k = 2

    Output: [[2]]

    Explanation:

    There is only one possible k x k submatrix: [[1, 8], [3, -2]].
    Distinct values in the submatrix are [1, 8, 3, -2].
    The minimum absolute difference in the submatrix is |1 - 3| = 2. Thus, the answer is [[2]].

    Example 2:
    Input: grid = [[3,-1]], k = 1
    Output: [[0,0]]
    Explanation:
    Both k x k submatrix has only one distinct element.
    Thus, the answer is [[0, 0]].

    Example 3:
    Input: grid = [[1,-2,3],[2,3,5]], k = 2
    Output: [[1,2]]

    Explanation:
    There are two possible k × k submatrix:
    Starting at (0, 0): [[1, -2], [2, 3]].
    Distinct values in the submatrix are [1, -2, 2, 3].
    The minimum absolute difference in the submatrix is |1 - 2| = 1.
    Starting at (0, 1): [[-2, 3], [3, 5]].
    Distinct values in the submatrix are [-2, 3, 5].
    The minimum absolute difference in the submatrix is |3 - 5| = 2.
    Thus, the answer is [[1, 2]].


    Constraints:
    1 <= m == grid.length <= 30
    1 <= n == grid[i].length <= 30
    -105 <= grid[i][j] <= 10^5
    1 <= k <= min(m, n)
     */
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k + 1];

        for (int i = 0; i < m - k + 1; ++i) {
            for (int j = 0; j < n - k + 1; ++j) {
                res[i][j] = minAbsDiff2(grid, k, i, j);
            }
        }

        return res;
    }

    private int minAbsDiff2(int[][] grid, int k, int i, int j) {
        if (k == 1) {
            return 0;
        }
        int[] arr = new int[k * k];

        for (int x = 0; x < k; ++x) {
            for (int y = 0; y < k; ++y) {
                arr[x * k + y] = grid[i + x][j + y];
            }
        }

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int x = 1; x < k * k; ++x) {
            if (arr[x] == arr[x - 1]) {
                continue;
            }
            minDiff = Math.min(minDiff, arr[x] - arr[x - 1]);
        }

        if (minDiff == Integer.MAX_VALUE) {
            return 0;
        }

        return minDiff;
    }

    public int[][] minAbsDiff2(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int row = m - k + 1;
        int col = n - k + 1;
        int[][] ans = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int[] vals = new int[k * k];
                int idx = 0;
                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        vals[idx++] = grid[r][c];
                    }
                }

                Arrays.sort(vals);
                int minDiff = Integer.MAX_VALUE;
                for (int x = 1; x < vals.length; x++) {
                    if (vals[x] != vals[x - 1]) {
                        minDiff = Math.min(minDiff, vals[x] - vals[x - 1]);
                    }
                }
                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }

        return ans;

    }

    public static void main(String[] args) {

        L3567_Minimum_Absolute_Difference_in_Sliding_Submatrix s = new L3567_Minimum_Absolute_Difference_in_Sliding_Submatrix();
        long sysDate1 = System.currentTimeMillis();


        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int k = 5;

        int[][] res = s.minAbsDiff(grid, k);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}