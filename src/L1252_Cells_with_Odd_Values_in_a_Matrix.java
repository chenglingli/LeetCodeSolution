public class L1252_Cells_with_Odd_Values_in_a_Matrix {

    /*

    There is an m x n matrix that is initialized to all 0's.
    There is also a 2D array indices
        where each indices[i] = [ri, ci] represents a 0-indexed location
        to perform some increment operations on the matrix.

    For each location indices[i], do both of the following:

    Increment all the cells on row ri.
    Increment all the cells on column ci.
    Given m, n, and indices,
    return the number of odd-valued cells in the matrix
        after applying the increment to all locations in indices.


    Example 1:
    Input: m = 2, n = 3, indices = [[0,1],[1,1]]
    Output: 6
    Explanation: Initial matrix = [[0,0,0],[0,0,0]].
    After applying first increment it becomes [[1,2,1],[0,1,0]].
    The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.

    Example 2:
    Input: m = 2, n = 2, indices = [[1,1],[0,0]]
    Output: 0
    Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.

    Constraints:
    1 <= m, n <= 50
    1 <= indices.length <= 100
    0 <= ri < m
    0 <= ci < n

    Follow up:
        Could you solve this
            in O(n + m + indices.length) time
            with only O(n + m) extra space?

     */
    public int oddCells(int m, int n, int[][] indices) {

        int[][] matrix = new int[m][n];
        for (int[] index : indices) {
            for (int i = 0; i < m; i++) {
                matrix[i][index[1]]++;
            }
            for (int j = 0; j < n; j++) {
                matrix[index[0]][j]++;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    /*

    首先，定义了两个数组row和col，分别用于记录每一行和每一列被操作的次数（即对应单元格值被加1的次数）。
    数组的长度分别为m和n，与矩阵的行数和列数相对应。

    接着，遍历indices数组。对于每个idx元素（表示一个位置），
        将idx[0]对应的行在row数组中的计数加1，将idx[1]对应的列在col数组中的计数加1。
    这样，row和col数组就记录了每一行和每一列分别被操作了多少次。

    然后，定义了两个变量oddRows和oddCols，用于记录行和列中操作次数为奇数的数量。
    通过遍历row和col数组，统计出操作次数为奇数的行和列的数量。

    最后，根据统计出的奇数行数和奇数列数，计算出最终矩阵中值为奇数的单元格数量。
    逻辑是：奇数行与偶数列相交的位置，以及偶数行与奇数列相交的位置，其单元格值会为奇数。
    因此，奇数单元格的数量等于奇数行数乘以偶数列数（n - oddCols） 加上
        偶数行数乘以奇数列数（m - oddRows乘以oddCols）。

     */
    public int oddCells2(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];

        for (int[] idx : indices) {
            row[idx[0]]++;
            col[idx[1]]++;
        }

        int oddRows = 0;
        int oddCols = 0;

        for (int r : row) if (r % 2 == 1) oddRows++;
        for (int c : col) if (c % 2 == 1) oddCols++;

        return oddRows * (n - oddCols) + (m - oddRows) * oddCols;
    }

    public static void main(String[] args) {

        L1252_Cells_with_Odd_Values_in_a_Matrix s = new L1252_Cells_with_Odd_Values_in_a_Matrix();
        long sysDate1 = System.currentTimeMillis();

        int m = 2;
        int n = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        int res = s.oddCells(m, n, indices);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}