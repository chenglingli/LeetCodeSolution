import java.util.Arrays;
import java.util.HashMap;

public class L2500_Delete_Greatest_Value_in_Each_Row {

    /*
    You are given an m x n matrix grid consisting of positive integers.

    Perform the following operation until grid becomes empty:

    Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
    Add the maximum of deleted elements to the answer.
    Note that the number of columns decreases by one after each operation.

    Return the answer after performing the operations described above.


    Example 1:
    Input: grid = [[1,2,4],[3,3,1]]
    Output: 8
    Explanation: The diagram above shows the removed values in each step.
    - In the first operation, we remove 4 from the first row and 3 from the second row (notice that,
        there are two cells with value 3 and we can remove any of them). We add 4 to the answer.
    - In the second operation, we remove 2 from the first row and 3 from the second row. We add 3 to the answer.
    - In the third operation, we remove 1 from the first row and 1 from the second row. We add 1 to the answer.
    The final answer = 4 + 3 + 1 = 8.


    Example 2:
    Input: grid = [[10]]
    Output: 10
    Explanation: The diagram above shows the removed values in each step.
    - In the first operation, we remove 10 from the first row. We add 10 to the answer.
    The final answer = 10.


    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    1 <= grid[i][j] <= 100
     */
    public int deleteGreatestValue(int[][] grid) {

        // 遍历每一行，找出最大值，记录下列索引，然后标记为0，然后继续遍历下一行
        // 用一个变量记录多行之间的最大值，然后累加到结果中

        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int temp = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < m; i++) {
                int tempIndex = -1;
                int tempMax = 0;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > tempMax) {
                        tempMax = grid[i][j];
                        tempIndex = j;
                    }
                }
                temp = Math.max(temp, tempMax);
                grid[i][tempIndex] = 0;
            }
            ans += temp;
            temp = 0;
        }

        return ans;
    }

    /*

    每行先排序，然后每列取最大值加起来
    排序使用 arrays.sort

    时间复杂度：O(m * nlogn)

     */
    public int deleteGreatestValue2(int[][] grid) {

        int ans = 0;
        int n = grid[0].length;

        for (int[] ints : grid) {
            Arrays.sort(ints);
        }

        for (int i = 0; i < n; i++) {
            int maxVal = 0;
            for (int[] ints : grid) {
                maxVal = Math.max(maxVal, ints[i]);
            }
            ans += maxVal;
        }

        return ans;
    }

    /*

    先每行排序，然后每列取最大值加起来

    排序方式：计数排序

    时间复杂度：
        O(maxVal * m + n * m)

     */
    public int deleteGreatestValue3(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        // 每行排序
        for (int i = 0; i < m; i++) {

            // 统计每个元素的出现次数
            int[] count = new int[101]; // 1 to 100
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }

            // 按照倒序，将每个元素放到正确的位置上
            int index = 0;
            for (int val = 100; val >= 1; val--) {
                while (count[val] > 0) {
                    grid[i][index++] = val;
                    count[val]--;
                }
            }
        }

        // 每列取最大值(每行遍历的的最大值就是当前列的元素)
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int[] ints : grid) {
                max = Math.max(max, ints[j]);
            }
            ans += max;
        }

        return ans;
    }

    public static void main(String[] args) {

        L2500_Delete_Greatest_Value_in_Each_Row s = new L2500_Delete_Greatest_Value_in_Each_Row();
        long sysDate1 = System.currentTimeMillis();

        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        int res = s.deleteGreatestValue3(grid);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}