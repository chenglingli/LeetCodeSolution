import java.util.Arrays;

public class L2022_Convert_1D_Array_Into_2D_Array {


    /*

    You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n.
    You are tasked with creating a 2-dimensional (2D) array with
        m rows and n columns using all the elements from original.

    The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array,
    the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array,
        and so on.

    Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.



    Example 1:
    Input: original = [1,2,3,4], m = 2, n = 2
    Output: [[1,2],[3,4]]
    Explanation: The constructed 2D array should contain 2 rows and 2 columns.
    The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
    The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.

    Example 2:
    Input: original = [1,2,3], m = 1, n = 3
    Output: [[1,2,3]]
    Explanation: The constructed 2D array should contain 1 row and 3 columns.
    Put all three elements in original into the first row of the constructed 2D array.

    Example 3:
    Input: original = [1,2], m = 1, n = 1
    Output: []
    Explanation: There are 2 elements in original.
    It is impossible to fit 2 elements in a 1x1 2D array, so return an empty 2D array.


    Constraints:

    1 <= original.length <= 5 * 10^4
    1 <= original[i] <= 10^5
    1 <= m, n <= 4 * 10^4

     */

    // 5ms
    public int[][] construct2DArray(int[] original, int m, int n) {

        // 判断长度是否符合要求
        int len = original.length;
        if (len != m * n) {
            return new int[0][0];
        }

        // 构造二维数组
        int[][] res = new int[m][n];
        for (int i = 0; i < len; i++) {
            res[i / n][i % n] = original[i];
        }

        // 返回结果
        return res;
    }

    // 2ms
    // 更快，原因是使用了Arrays.copyOfRange方法，该方法可以快速复制数组的一部分。
    // 这种方法减少了循环次数，提高了效率。
    public int[][] construct2DArray2(int[] original, int m, int n) {

        if (m * n != original.length) {
            return new int[0][0];
        }

        int[][] result = new int[m][];
        for (int i = 0; i < m; i++) {
            result[i] = Arrays.copyOfRange(original, i * n, i * n + n);
        }

        return result;
    }

    public static void main(String[] args) {

        L2022_Convert_1D_Array_Into_2D_Array s = new L2022_Convert_1D_Array_Into_2D_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] original = {1, 2, 3, 4};
        int m = 2;
        int n = 2;
        int[][] res = s.construct2DArray(original, m, n);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}