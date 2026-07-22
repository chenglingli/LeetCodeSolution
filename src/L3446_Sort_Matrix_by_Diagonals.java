import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L3446_Sort_Matrix_by_Diagonals {

    /*
    You are given an n x n square matrix of integers grid. Return the matrix such that:

    The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
    The diagonals in the top-right triangle are sorted in non-decreasing order.


    Example 1:

    Input: grid = [[1,7,3],[9,8,2],[4,5,6]]

    Output: [[8,2,3],[9,6,7],[4,5,1]]

    Explanation:



    The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:

    [1, 8, 6] becomes [8, 6, 1].
    [9, 5] and [4] remain unchanged.
    The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:

    [7, 2] becomes [2, 7].
    [3] remains unchanged.
    Example 2:

    Input: grid = [[0,1],[1,2]]

    Output: [[2,1],[1,0]]

    Explanation:



    The diagonals with a black arrow must be non-increasing, so [0, 2] is changed to [2, 0]. The other diagonals are already in the correct order.

    Example 3:

    Input: grid = [[1]]

    Output: [[1]]

    Explanation:

    Diagonals with exactly one element are already in order, so no changes are needed.



    Constraints:

    grid.length == grid[i].length == n
    1 <= n <= 10
    -10^5 <= grid[i][j] <= 10^5
     */

    public int[][] sortMatrix(int[][] grid) {
        // 按照对角线排序，左下部分倒序排序(包括中线)，右上部分升序排序
        // 同一条对角线满足 i - j 恒定：
        //   i - j >= 0 → 左下（含主对角）→ 降序
        //   i - j < 0  → 右上           → 升序
        int n = grid.length;

        // 左下三角（含主对角）：从 (0,0), (1,0), ..., (n-1,0) 出发
        for (int startRow = 0; startRow < n; startRow++) {
            sortDiagonal(grid, startRow, 0, false);
        }
        // 右上三角：从 (0,1), (0,2), ..., (0,n-1) 出发
        for (int startCol = 1; startCol < n; startCol++) {
            sortDiagonal(grid, 0, startCol, true);
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int r, int c, boolean ascending) {

        int n = grid.length;
        List<Integer> vals = new ArrayList<>();

        int i = r, j = c;
        while (i < n && j < n) {
            vals.add(grid[i][j]);
            i++;
            j++;
        }

        if (ascending) {
            Collections.sort(vals);
        } else {
            vals.sort(Collections.reverseOrder());
        }

        i = r;
        j = c;
        int idx = 0;
        while (i < n && j < n) {
            grid[i][j] = vals.get(idx++);
            i++;
            j++;
        }
    }

    public int[][] sortMatrix2(int[][] grid) {

        int n = grid.length;

        // bottom-left triangle: non-increasing order.
        for (int i = 0; i < n; i++) {
            for (int extra = 0; i + extra < n; extra++) {
                for (int j = extra + 1; i + j < n; j++) {
                    if (grid[i + j][j] >= grid[i + extra][extra]) {
                        swap(grid, i + extra, extra, i + j, j);
                    }
                }
            }
        }

        // top-right triangle: non-decreasing order.
        for (int j = 1; j < n; j++) {
            for (int extra = 0; j + extra < n; extra++) {
                for (int i = extra + 1; i + j < n; i++) {
                    if (grid[i][i + j] <= grid[extra][extra + j]) {
                        swap(grid, extra, extra + j, i, i + j);
                    }
                }
            }
        }
        
        return grid;
    }

    private void swap(int[][] grid, int r1, int c1, int r2, int c2) {
        int temp = grid[r2][c2];
        grid[r2][c2] = grid[r1][c1];
        grid[r1][c1] = temp;
    }

    public static void main(String[] args) {

        L3446_Sort_Matrix_by_Diagonals s = new L3446_Sort_Matrix_by_Diagonals();
        long sysDate1 = System.currentTimeMillis();

        int[][] grid = new int[][]{
                {1, 7, 3},
                {9, 8, 2},
                {4, 5, 6}
        };
        int[][] res = s.sortMatrix(grid);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}