import java.util.Arrays;

public class L1727_Largest_Submatrix_With_Rearrangements {


    /*
    You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.

    Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.



    Example 1:
    Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
    Output: 4
    Explanation: You can rearrange the columns as shown above.
    The largest submatrix of 1s, in bold, has an area of 4.

    Example 2:
    Input: matrix = [[1,0,1,0,1]]
    Output: 3
    Explanation: You can rearrange the columns as shown above.
    The largest submatrix of 1s, in bold, has an area of 3.

    Example 3:
    Input: matrix = [[1,1,0],[1,0,1]]
    Output: 2
    Explanation: Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.


    Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m * n <= 10^5
    matrix[i][j] is either 0 or 1.
     */
    public int largestSubmatrix(int[][] matrix) {

        /*
        题意：
        给定一个0和1的矩阵，你可以重新排列矩阵的列，返回最大的全1子矩阵的面积。

        时间复杂度：O(m * n * log(n))
        空间复杂度：O(m * n)

         */

        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        int[][] heights = new int[m][n];

        for (int i = 0; i < m; i++) {

            // 计算当前行每列的高度
            // 每列高度等于上一行高度 + 1，如果当前元素为1
            // 否则为0
            int[] heightsTemp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        heights[i][j] = heights[i - 1][j] + 1;
                    } else {
                        heights[i][j] = 0;
                    }
                }
                heightsTemp[j] = heights[i][j];
            }

            // 排序
            Arrays.sort(heightsTemp);

            for (int j = n - 1; j >= 0; j--) {
                if (heightsTemp[j] > 0) {
                    maxArea = Math.max(heightsTemp[j] * (n - j), maxArea);
                }
            }
        }

        return maxArea;
    }

    /*  

    时间复杂度：O(m * n * log(n))
    空间复杂度：O(m * n)

    相比较1，少去了：
    1，复制到heightsTemp数组
    */
    public int largestSubmatrix2(int[][] matrix) {

        // 初始化高度矩阵
        int m = matrix.length, n = matrix[0].length, res = 0;

        // 计算每一行向上的高度，并更新到矩阵中
        // 更新后结果是：matrix[i][j] 表示第i行，第j列向上的高度
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        // 计算每一行最大的子矩阵面积
        for (int i = 0; i < m; i++) {
            // 对每一行进行排序，假设当前是第i行，那么就是把这行所有列高度拿出来排序
            Arrays.sort(matrix[i]);
            // 计算每一行最大的子矩阵面积
            for (int j = 0; j < n; j++) {
                res = Math.max(res, matrix[i][j] * (n - j));
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L1727_Largest_Submatrix_With_Rearrangements s = new L1727_Largest_Submatrix_With_Rearrangements();
        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 1}
        };
        int res = s.largestSubmatrix(matrix);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}