public class L861_Score_After_Flipping_Matrix {

    /*

    You are given an m x n binary matrix grid.

    A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

    Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

    Return the highest possible score after making any number of moves (including zero moves).


    Example 1:
    Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]

    Output: 39
    Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

    Example 2:
    Input: grid = [[0]]
    Output: 1


    Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 20
    grid[i][j] is either 0 or 1.

     */
    public int matrixScore(int[][] grid) {

        /*

        题意：
        给定一个矩阵，里面全是1或者0
        你可以选择任意一行或者一列，然后将这一行或这列的所有数字翻转，翻转意思是1变成0，0变成1

        期望达到
        按照每行二进制表示，加起来和最大

        思路：
        1. 先将每一行第一个数字翻转，保证每行的最高位是1
        2. 然后将每一列的1的数量少于一半的，翻转这一列
        3. 然后将每一行二进制加起来

         */

        int m = grid.length;
        int n = grid[0].length;

        // 将每一行第一个数字翻转，保证每行的最高位是1
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = grid[i][j] ^ 1;
                }
            }
        }

        // 将每一列的1的数量少于一半的，翻转这一列
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int[] ints : grid) {
                if (ints[j] == 1) {
                    count++;
                }
            }
            if (count * 2 <= m) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = grid[i][j] ^ 1;
                }
            }
        }

        // 将每一行二进制加起来
        int res = 0;
        for (int[] ints : grid) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += ints[j] << (n - 1 - j);
            }
            res += sum;
        }

        return res;
    }

    public int matrixScore2(int[][] grid) {

        /*

        题意：
        给定一个矩阵，里面全是1或者0
        你可以选择任意一行或者一列，然后将这一行或这列的所有数字翻转，翻转意思是1变成0，0变成1

        期望达到
        按照每行二进制表示，加起来和最大

        思路：
        1. 先将每一行第一个数字翻转，保证每行的最高位是1
        2. 然后将每一列的1的数量少于一半的，翻转这一列
        3. 然后将每一行二进制加起来

         */

        int m = grid.length;
        int n = grid[0].length;

        // 将每一行第一个数字翻转，保证每行的最高位是1
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = grid[i][j] ^ 1;
                }
            }
        }

        // 将每一列的1的数量少于一半的，翻转这一列
        int res = 0;
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int[] ints : grid) {
                if (ints[j] == 1) {
                    count++;
                }
            }

            // 将每一行二进制加起来
            int countOne = Math.max(count, m - count);
            res += countOne * (1 << (n - 1 - j));
        }

        return res;
    }


    public int matrixScore3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Make the first element of every row 1
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }

        int score = 0;

        // Step 2: Maximize the number of 1s in each column
        for (int j = 0; j < n; j++) {
            int ones = 0;

            for (int[] ints : grid) {
                if (ints[j] == 1) {
                    ones++;
                }
            }

            // Choose the better of the current column or its flipped version
            int maxOnes = Math.max(ones, m - ones);

            // Step 3: Calculate the column's contribution to the score
            score += maxOnes * (1 << (n - 1 - j));
        }

        return score;
    }

    public static void main(String[] args) {

        L861_Score_After_Flipping_Matrix s = new L861_Score_After_Flipping_Matrix();
        long sysDate1 = System.currentTimeMillis();

        int[][] grid = new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };
        int res = s.matrixScore2(grid);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}