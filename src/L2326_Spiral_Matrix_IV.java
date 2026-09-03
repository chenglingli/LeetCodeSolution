import struct.ListNode;

import java.util.Arrays;

public class L2326_Spiral_Matrix_IV {

    /*
    You are given two integers m and n, which represent the dimensions of a matrix.

    You are also given the head of a linked list of integers.

    Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise),
    starting from the top-left of the matrix.

    If there are remaining empty spaces, fill them with -1.

    Return the generated matrix.



    Example 1:
    Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
    Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
    Explanation: The diagram above shows how the values are printed in the matrix.
    Note that the remaining spaces in the matrix are filled with -1.

    Example 2:
    Input: m = 1, n = 4, head = [0,1,2]
    Output: [[0,1,2,-1]]
    Explanation: The diagram above shows how the values are printed from left to right in the matrix.
    The last space in the matrix is set to -1.


    Constraints:
    1 <= m, n <= 10^5
    1 <= m * n <= 10^5
    The number of nodes in the list is in the range [1, m * n].
    0 <= Node.val <= 1000

     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] res = new int[m][n];
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int dirIdx = 0;

        while (head != null) {
            res[x][y] = head.val;

            int nextX = x + dirs[dirIdx][0];
            int nextY = y + dirs[dirIdx][1];

            // 检查下一个位置是否越界或已被填充
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || res[nextX][nextY] != -1) {
                dirIdx = (dirIdx + 1) % 4;
            }

            x += dirs[dirIdx][0];
            y += dirs[dirIdx][1];

            head = head.next;
        }

        return res;
    }

    public int[][] spiralMatrix2(int rows, int columns, ListNode head) {

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int [columns];
            Arrays.fill(matrix[i], -1);
        }

        int topRow = 0, bottomRow = rows - 1, leftColumn = 0, rightColumn = columns - 1;
        while (head != null) {

            for (int col = leftColumn; col <= rightColumn && head != null; col++) {
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;


            for (int row = topRow; row <= bottomRow && head != null; row++) {
                matrix[row][rightColumn] = head.val;
                head = head.next;
            }
            rightColumn--;


            for (int col = rightColumn; col >= leftColumn && head != null; col--) {
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;


            for (int row = bottomRow; row >= topRow && head != null; row--) {
                matrix[row][leftColumn] = head.val;
                head = head.next;
            }
            leftColumn++;
        }

        return matrix;
    }

    public static void main(String[] args) {

        L2326_Spiral_Matrix_IV s =
                new L2326_Spiral_Matrix_IV();
        long sysDate1 = System.currentTimeMillis();

        int m = 3;
        int n = 5;
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

        int[][] res = s.spiralMatrix(m, n, head);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}