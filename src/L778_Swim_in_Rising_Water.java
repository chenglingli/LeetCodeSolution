import java.util.Stack;

public class L778_Swim_in_Rising_Water {

    /**
     *
     On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

     Now rain starts to fall. At time t,
     the depth of the water everywhere is t.
     You can swim from a square to another 4-directionally adjacent square
     if and only if the elevation of both squares individually are at most t.
     You can swim infinite distance in zero time. Of course,
     you must stay within the boundaries of the grid during your swim.

     You start at the top left square (0, 0).
     What is the least time until you can reach the bottom right square (N-1, N-1)?

     Example 1:

     Input: [[0,2],[1,3]]
     Output: 3
     Explanation:
     At time 0, you are in grid location (0, 0).
     You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

     You cannot reach point (1, 1) until time 3.
     When the depth of water is 3, we can swim anywhere inside the grid.
     Example 2:

     Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
     Output: 16
     Explanation:
     0  1  2  3  4
     24 23 22 21  5
     12 13 14 15 16
     11 17 18 19 20
     10  9  8  7  6

     The final route is marked in bold.
     We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
     Note:

     2 <= N <= 50.
     grid[i][j] is a permutation of [0, ..., N*N - 1].

     */


    /**
     * 我们也可以使用DP+DFS来做，这里使用一个二维dp数组，
     * 其中 dp[i][j] 表示到达 (i, j) 位置所需要的最低水面高度，均初始化为整型数最大值，
     * 我们的递归函数函数需要知道当前的位置 (x, y)，还有当前的水高cur，
     * 同时传入grid数组和需要不停更新的dp数组，如果当前位置越界了，
     * 或者是当前水高和 grid[x][y] 中的较大值大于等于 dp[x][y] 了，
     * 直接跳过，因为此时的dp值更小，不需要被更新了。否则 dp[x][y] 更新为较大值，
     * 然后对周围四个位置调用递归函数继续更新dp数组，最终返回右下位置的dp值即可
     */

    int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][51];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        helper(grid, 0, 0, grid[0][0], dp);
        return dp[n - 1][n - 1];
    }

    void helper(int[][] grid, int x, int y, int cur, int[][] dp) {
        int n = grid.length;
        if (x < 0 || x >= n || y < 0 || y >= n || Integer.max(cur, grid[x][y]) >= dp[x][y])
            return;
        dp[x][y] = Integer.max(cur, grid[x][y]);
        for (int[] dir : dirs) {
            helper(grid, x + dir[0], y + dir[1], dp[x][y], dp);
        }
    }


    public int swimInWater2(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!helper2(grid, mid))
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private boolean helper2(int[][] grid, int mid) {
        int n = grid.length;
        int[] visited = new int[(n + 1) * (n + 1)];

        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        while (!stack.empty()) {
            int i = stack.peek() / n, j = stack.peek() % n;
            stack.pop();
            if (i == n - 1 && j == n - 1)
                return true;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= n || y < 0 || y >= n || visited[x * n + y] == 1 || grid[x][y] > mid)
                    continue;
                stack.push(x * n + y);
                visited[x * n + y] = 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        L778_Swim_in_Rising_Water s = new L778_Swim_in_Rising_Water();
        long sysDate1 = System.currentTimeMillis();

        int[][] nums = {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        int res = s.swimInWater2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}