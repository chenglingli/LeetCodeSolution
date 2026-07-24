import java.util.Arrays;

public class L885_Spiral_Matrix_III {

    /*

    You start at the cell (rStart, cStart) of an rows x cols grid facing east.
    The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

    You will walk in a clockwise spiral shape to visit every position in this grid.
    Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

    Return an array of coordinates representing the positions of the grid in the order you visited them.



    Example 1:
    Input: rows = 1, cols = 4, rStart = 0, cStart = 0
    Output: [[0,0],[0,1],[0,2],[0,3]]

    Example 2:
    Input: rows = 5, cols = 6, rStart = 1, cStart = 4
    Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]


    Constraints:

    1 <= rows, cols <= 100
    0 <= rStart < rows
    0 <= cStart < cols

     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] res = new int[rows * cols][2];
        res[0] = new int[]{rStart, cStart};
        int index = 1;
        int step = 1;
        // east, south, west, north
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (index < rows * cols) {
            for (int d = 0; d < 4; d++) {

                // step: 1,1 then 2,2 then 3,3 ... — increase after every two directions
                for (int i = 0; i < step; i++) {
                    rStart += dirs[d][0];
                    cStart += dirs[d][1];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        res[index++] = new int[]{rStart, cStart};
                        if (index == rows * cols) {
                            return res;
                        }
                    }
                }

                // step: 1,1 then 2,2 then 3,3 ... — increase after every two directions
                if (d % 2 == 1) {
                    step++;
                }
            }
        }

        return res;
    }


    public int[][] spiralMatrixIII2(int rows, int cols, int rStart, int cStart) {

        int[][] ans = new int[rows * cols][2];
        int index = 0;

        int r = rStart;
        int c = cStart;

        ans[index][0] = r;
        ans[index][1] = c;
        index++;

        int steps = 1;

        while (index < rows * cols) {

            for (int i = 0; i < steps; i++) {
                c++;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans[index][0] = r;
                    ans[index][1] = c;
                    index++;
                }
            }

            for (int i = 0; i < steps; i++) {
                r++;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans[index][0] = r;
                    ans[index][1] = c;
                    index++;
                }
            }

            steps++;

            for (int i = 0; i < steps; i++) {
                c--;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans[index][0] = r;
                    ans[index][1] = c;
                    index++;
                }
            }

            for (int i = 0; i < steps; i++) {
                r--;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans[index][0] = r;
                    ans[index][1] = c;
                    index++;
                }
            }

            steps++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L885_Spiral_Matrix_III s = new L885_Spiral_Matrix_III();
        long sysDate1 = System.currentTimeMillis();

        int rows = 5;
        int cols = 6;
        int rStart = 1;
        int cStart = 4;
        int[][] res = s.spiralMatrixIII(rows, cols, rStart, cStart);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}