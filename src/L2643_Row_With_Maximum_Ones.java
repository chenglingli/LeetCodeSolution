import java.util.Arrays;

public class L2643_Row_With_Maximum_Ones {

    /*

    Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones,
    and the number of ones in that row.

    In case there are multiple rows that have the maximum count of ones,
    the row with the smallest row number should be selected.

    Return an array containing the index of the row, and the number of ones in it.



    Example 1:

    Input: mat = [[0,1],[1,0]]
    Output: [0,1]
    Explanation: Both rows have the same number of 1's. So we return the index of the smaller row, 0,
    and the maximum count of ones (1). So, the answer is [0,1].

    Example 2:
    Input: mat = [[0,0,0],[0,1,1]]
    Output: [1,2]
    Explanation: The row indexed 1 has the maximum count of ones (2). So we return its index, 1,
    and the count. So, the answer is [1,2].

    Example 3:
    Input: mat = [[0,0],[1,1],[0,0]]
    Output: [1,2]
    Explanation: The row indexed 1 has the maximum count of ones (2). So the answer is [1,2].


    Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 100
    mat[i][j] is either 0 or 1.

     */
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];

        int maxCount = 0;
        int minRow = 0;

        for (int i = 0; i < mat.length; i++) {
            int countOnes = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    countOnes++;
                }
            }
            if (maxCount < countOnes) {
                minRow = i;
                maxCount = countOnes;
            }
        }

        res[0] = minRow;
        res[1] = maxCount;

        return res;
    }

    public int[] rowAndMaximumOnes2(int[][] mat) {
        int row = 0;
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            int currSum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                currSum += mat[i][j];
            }
            if (currSum > sum) {
                sum = currSum;
                row = i;
            }
        }
        return new int[]{row, sum};
    }

    public static void main(String[] args) {

        L2643_Row_With_Maximum_Ones s = new L2643_Row_With_Maximum_Ones();
        long sysDate1 = System.currentTimeMillis();
        int[][] mat = {{0, 1}, {1, 0}};
        int[] res = s.rowAndMaximumOnes(mat);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}