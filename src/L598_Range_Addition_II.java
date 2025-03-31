import java.util.*;

public class L598_Range_Addition_II {

    /*

    You are given an m x n matrix M initialized with all 0's and an array of operations ops,
    where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

    Count and return the number of maximum integers in the matrix after performing all the operations.



    Example 1:


    Input: m = 3, n = 3, ops = [[2,2],[3,3]]
    Output: 4
    Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.

    Example 2:

    Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
    Output: 4


    Example 3:

    Input: m = 3, n = 3, ops = []
    Output: 9


    Constraints:

    1 <= m, n <= 4 * 10^4
    0 <= ops.length <= 10^4
    ops[i].length == 2
    1 <= ai <= m
    1 <= bi <= n

     */
    public int maxCount(int m, int n, int[][] ops) {

        // 寻找操作序列中最小的行和列，即为最终结果区域。因为最大值一定是在最左上角，所以只需要找到最小的行和列即可。
        if (ops.length == 0)
            return m * n;

        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        for (int[] op : ops) {
            minRow = Math.min(op[0], minRow);
            minCol = Math.min(op[1], minCol);
        }

        return minRow * minCol;
    }

    public static void main(String[] args) {

        L598_Range_Addition_II s = new L598_Range_Addition_II();

        long sysDate1 = System.currentTimeMillis();

        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};

        int res = s.maxCount(m, n, ops);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}