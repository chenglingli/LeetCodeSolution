import java.util.Arrays;

public class L085_Maximal_Rectangle {

    /*
    rows == matrix.length
    cols == matrix[i].length
    1 <= row, cols <= 200
    matrix[i][j] is '0' or '1'.

    将多维数组转化为一维数组：
    f[i, j] 表示以i和j为 行坐标，列坐标
    f[0,  j] 最长1
    f[1,  j] 第1行最长1，第1+0行最长2
    f[2,  j] 第2行最长1，第2+1行最长2，第2+1+0行最长3
    f[3,  j] 第3行最长1，第3+2行最长2，第3+2+1行最长3，第3+2+1+0行最长4

    第1步骤：转化数组为数字数组
    第2步：计算累计数组    cumu[k,i] 为 累积第k行往上，i为行个数
    第3步：计算一维数组值为k的最大长度
    第4步：计算最大面积

     */
    public int maximalRectangle(char[][] matrix) {

        // 行
        int m = matrix.length;
        // 列
        int n = matrix[0].length;

        // 转化为数字数组
        int[][] matrixInt = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrixInt[i][j] = matrix[i][j] - '0';

        int ans = 0;

        for (int k = 0; k < m; k++) {
            for (int count = 1; count <= k + 1; count++) {
                int[] list = cumulate(matrixInt, k, count);
                int curValue = maxValue(list, count) * count;
                ans = Math.max(ans, curValue);
            }
        }

        return ans;
    }

    /*
    累积 从第k行往上，count为行个数
    得到一维数组
     */
    private int[] cumulate(int[][] matrixInt, int k, int count) {

        int n = matrixInt[0].length;
        int[] list = new int[n];

        for (int j = 0; j < n; j++) {
            for (int i = k; i >= k - count + 1; i--) {
                if (matrixInt[i][j] == 1) {
                    list[j]++;
                } else {
                    break;
                }
            }
        }

        return list;
    }

    /*
    计算一维数组值为k的最大长度
     */
    private int maxValue(int[] list, int k) {
        int maxLen = 0;
        for (int i = 0; i < list.length; i++) {
            int len = 0;
            for (int j = i; j < list.length; j++) {
                if (list[j] == k) {
                    len++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }


    /*
    优化

    左边界 leftBoundaries 的定义： 从0到该j位置， 第一个1的位置。
    右边界 rightBoundaries 的定义： 从j 到该行末尾，第一个0的位置


    类似于042雨水承接那题用类似办法
    1. 用一个一维数组记录每一行的高度
    2. 用一个一维数组记录每一行的左边界（从左向右，第一个1）
    3. 用一个一维数组记录每一行的右边界（从右想做，第一个0）
    4. 用一个函数计算最大面积 = （右边界 - 左边界） *高度


    为什么可以这么计算：
        因为leftBoundaries 和 rightBoundaries 包含了历史信息
        例如：第一行的leftBoundaries[3] = 2，表示第一行的第3列的左边界是第一行的第2列
        第二行的leftBoundaries[3] = 3，表示第二行的第3列的左边界是第二行的第3列

        这里面不断取得最大值。

     */
    public int maximalRectangle2(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int[] leftBoundaries = new int[n];
        int[] rightBoundaries = new int[n];
        Arrays.fill(rightBoundaries, n);

        int maxRectangle = 0;

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n;

            updateHeightsAndLeftBoundaries(matrix[i], heights, leftBoundaries, left);

            updateRightBoundaries(matrix[i], rightBoundaries, right);

            maxRectangle = calculateMaxRectangle(heights, leftBoundaries, rightBoundaries, maxRectangle);
        }

        return maxRectangle;
    }

    private void updateHeightsAndLeftBoundaries(char[] row, int[] heights, int[] leftBoundaries, int left) {
        for (int j = 0; j < heights.length; j++) {
            if (row[j] == '1') {
                heights[j]++;
                leftBoundaries[j] = Math.max(leftBoundaries[j], left);
            } else {
                heights[j] = 0;
                leftBoundaries[j] = 0;
                left = j + 1;
            }
        }
    }

    private void updateRightBoundaries(char[] row, int[] rightBoundaries, int right) {
        for (int j = rightBoundaries.length - 1; j >= 0; j--) {
            if (row[j] == '1') {
                rightBoundaries[j] = Math.min(rightBoundaries[j], right);
            } else {
                rightBoundaries[j] = right;
                right = j;
            }
        }
    }

    private int calculateMaxRectangle(int[] heights, int[] leftBoundaries, int[] rightBoundaries, int maxRectangle) {
        for (int j = 0; j < heights.length; j++) {
            int width = rightBoundaries[j] - leftBoundaries[j];
            int area = heights[j] * width;
            maxRectangle = Math.max(maxRectangle, area);
        }
        return maxRectangle;
    }

    public static void main(String[] args) {

        L085_Maximal_Rectangle s = new L085_Maximal_Rectangle();

        long sysDate1 = System.currentTimeMillis();

        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        int res = s.maximalRectangle2(matrix);

        System.out.println(res);

        //        int[] list = {0, 1, 2, 1, 1, 0, 2, 2, 2, 0, 0};
        //        System.out.println(s.maxValue(list, 2));

        //        int[][] matrixInt =
        //                {{1, 0, 1, 0, 0},
        //                {1, 0, 1, 1, 1},
        //                {1, 1, 1, 1, 1},
        //                {1, 0, 0, 1, 0}};
        //        int k = 3;
        //        int count = 4;
        //        int [] list2 = s.cumulate( matrixInt, k, count);
        //        System.out.println(Arrays.toString(list2));


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}