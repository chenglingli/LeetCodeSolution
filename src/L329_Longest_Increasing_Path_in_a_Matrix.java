import struct.ListNode;

public class L329_Longest_Increasing_Path_in_a_Matrix {

    /*

    Given an m x n integers matrix, return the length of the longest increasing path in matrix.

    From each cell, you can either move in four directions: left, right, up, or down.
    You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).



    Example 1:

    Input: matrix =[[9,9,4],
                    [6,6,8],
                    [2,1,1]]
    Output: 4
    Explanation: The longest increasing path is [1, 2, 6, 9].


    Example 2:

    Input: matrix = [   [3,4,5],
                        [3,2,6],
                        [2,2,1]]
    Output: 4
    Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

    Example 3:

    Input: matrix = [[1]]
    Output: 1


    Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 200
    0 <= matrix[i][j] <= 2^31 - 1

     */
    public int longestIncreasingPath(int[][] matrix) {

        // 初始化
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];

        // 初始化memo数组，-1表示未访问过
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        // 遍历矩阵，对每个节点进行dfs搜索，并记录最长路径的长度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] == -1)
                    dfs(matrix, i, j, memo);
            }
        }

        // 遍历memo数组，找到最大值即为最长路径的长度
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, memo[i][j]);
            }
        }

        // 返回最长路径的长度
        return max;
    }


    private int dfs(int[][] matrix, int i, int j, int[][] memo) {

        // 如果memo[i][j]不为-1，则说明已经访问过该节点，直接返回其值
        if (memo[i][j] != -1)
            return memo[i][j];

        // 初始化最大路径长度为1，表示当前节点本身
        int m = matrix.length, n = matrix[0].length;
        int max = 1;

        // 遍历四个方向，找到最大的路径长度
        for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, x, y, memo) + 1);
            }
        }

        // 更新memo[i][j]的值，并返回其值
        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {

        L329_Longest_Increasing_Path_in_a_Matrix s = new L329_Longest_Increasing_Path_in_a_Matrix();

        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        int x = s.longestIncreasingPath(matrix);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}