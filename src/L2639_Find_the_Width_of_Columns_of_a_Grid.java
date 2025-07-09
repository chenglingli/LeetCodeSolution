import java.util.Arrays;

public class L2639_Find_the_Width_of_Columns_of_a_Grid {

    /*

    You are given a 0-indexed m x n integer matrix grid. The width of a column is the maximum length of its integers.

    For example, if grid = [[-10], [3], [12]], the width of the only column is 3 since -10 is of length 3.
    Return an integer array ans of size n where ans[i] is the width of the ith column.

    The length of an integer x with len digits is equal to len if x is non-negative, and len + 1 otherwise.



    Example 1:

    Input: grid = [[1],[22],[333]]
    Output: [3]
    Explanation: In the 0th column, 333 is of length 3.

    Example 2:
    Input: grid = [[-15,1,3],[15,7,12],[5,6,-2]]
    Output: [3,1,2]
    Explanation:
    In the 0th column, only -15 is of length 3.
    In the 1st column, all integers are of length 1.
    In the 2nd column, both 12 and -2 are of length 2.


    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -10^9 <= grid[r][c] <= 10^9

     */
    public int[] findColumnWidth(int[][] grid) {

        // m, n 分别为行数和列数
        int m = grid.length;
        int n = grid[0].length;
        int [] ans = new int[n];

        // 找出每列的最大长度
        for (int j = 0; j < n; j++) {
            // 每列的最大长度初始化为1，因为至少有一个数字
            ans[j] = 1;
            for (int i = 0; i < m; i++) {
                // 当前数字的长度
                int len = length(grid[i][j]);
                if (len > ans[j]) {
                    ans[j] = len;
                }
            }
        }

        // 返回结果
        return ans;
    }

    private int length(int num) {
        int len = 0;
        if (num < 0) {
            len++;
            num = -num;
        }

        while (num > 0) {
            len++;
            num /= 10;
        }

        return len;
    }

    public static void main(String[] args) {

        L2639_Find_the_Width_of_Columns_of_a_Grid s = new L2639_Find_the_Width_of_Columns_of_a_Grid();
        long sysDate1 = System.currentTimeMillis();
        int[][] grid = {{-15, 1, 3}, {15, 7, 12}, {5, 6, -2}};
        int[] res = s.findColumnWidth(grid);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}