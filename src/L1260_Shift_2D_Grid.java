import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L1260_Shift_2D_Grid {

    /*

    Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

    In one shift operation:

    Element at grid[i][j] moves to grid[i][j + 1].
    Element at grid[i][n - 1] moves to grid[i + 1][0].
    Element at grid[m - 1][n - 1] moves to grid[0][0].
    Return the 2D grid after applying shift operation k times.



    Example 1:


    Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
    Output: [[9,1,2],[3,4,5],[6,7,8]]
    Example 2:


    Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
    Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
    Example 3:

    Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
    Output: [[1,2,3],[4,5,6],[7,8,9]]


    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m <= 50
    1 <= n <= 50
    -1000 <= grid[i][j] <= 1000
    0 <= k <= 100

     */

    /*

    思路：
    1. 将二维数组转换为一维列表
    2. 将列表旋转k次
    3. 将旋转后的列表转换回二维数组

     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int[] line : grid) {
            for (int j = 0; j < n; j++) {
                list.add(line[j]);
            }
        }

        Collections.rotate(list, k);
        for (int i = 0; i < m; i++) {
            res.add(new ArrayList<>(list.subList(i * n, (i + 1) * n)));
        }
        return res;
    }

    /*
    思路：
    1. 创建一个新的二维数组，大小为原数组大小
    2. 遍历原数组，将元素按照规则放入新数组，对于特定某个元素 grid[i][j]，旋转k次后，应该位于新数组的 grid[r][c]
        r = (i + (j + k) / n) % m，意思是 第j列 + k次，然后除以宽度，得到新的行，加上原来行数，再模，得到新的行
        c = (j + k) % n，意思是 第j列 + k次，然后模宽度，得到新的列

        譬如 m = 3, n = 2, k = 3，那就是3行2列
        假设一个元素位置是 2，1，就是第3行第2列。
        新的行 = (2 + (1 + 3) / 2）% 3 = 1
        新的列 = (1 + 3) % 2 = 0


    3. 返回新数组
     */
    public List<List<Integer>> shiftGrid2(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Integer[][] shift = new Integer[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = (i + (j + k) / n) % m;
                int c = (j + k) % n;
                shift[r][c] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            res.add(Arrays.asList(shift[i]));
        }

        return res;
    }

    public static void main(String[] args) {

        L1260_Shift_2D_Grid s = new L1260_Shift_2D_Grid();
        long sysDate1 = System.currentTimeMillis();

        int k = 2;
        int[][] grid = {{0, 1}, {2, 3}};
        List<List<Integer>> res = s.shiftGrid(grid, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}