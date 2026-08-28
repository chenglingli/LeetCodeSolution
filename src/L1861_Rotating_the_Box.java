import java.util.Arrays;


public class L1861_Rotating_the_Box {

    /**
     * You are given an m x n matrix of characters boxGrid representing a side-view of a box. Each cell of the box is one of the following:
     * <p>
     * A stone '#'
     * A stationary obstacle '*'
     * Empty '.'
     * <p>
     * The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity.
     * Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box.
     * Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
     * <p>
     * It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the bottom of the box.
     * <p>
     * Return an n x m matrix representing the box after the rotation described above.
     *
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * <p>
     * Input: boxGrid = [["#",".","#"]]
     * Output: [["."],
     * ["#"],
     * ["#"]]
     * Example 2:
     * <p>
     * <p>
     * <p>
     * Input: boxGrid = [["#",".","*","."],
     * ["#","#","*","."]]
     * Output: [["#","."],
     * ["#","#"],
     * ["*","*"],
     * [".","."]]
     * Example 3:
     * <p>
     * <p>
     * <p>
     * Input: boxGrid = [["#","#","*",".","*","."],
     * ["#","#","#","*",".","."],
     * ["#","#","#",".","#","."]]
     * Output: [[".","#","#"],
     * [".","#","#"],
     * ["#","#","*"],
     * ["#","*","."],
     * ["#",".","*"],
     * ["#",".","."]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == boxGrid.length
     * n == boxGrid[i].length
     * 1 <= m, n <= 500
     * boxGrid[i][j] is either '#', '*', or '.'.
     */

    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] rotated = new char[n][m];

        // 顺时针 90°：原 m×n -> 新 n×m，原 (i,j) 映射到 (j, m-1-i)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        // 每列从下往上处理：石头 '#'' 下沉到 obstacles/stones/bottom
        for (int col = 0; col < m; col++) {
            int empty = n - 1;
            for (int row = n - 1; row >= 0; row--) {
                if (rotated[row][col] == '*') {
                    empty = row - 1;
                } else if (rotated[row][col] == '#') {
                    rotated[row][col] = '.';
                    rotated[empty][col] = '#';
                    empty--;
                }
            }
        }

        return rotated;
    }


    public char[][] rotateTheBox2(char[][] boxGrid) {
        char[][] rotated = new char[boxGrid[0].length][boxGrid.length];
        int row = boxGrid.length - 1;

        for (char[] chars : boxGrid) {
            solveColumn(row--, chars, rotated);
        }

        return rotated;
    }

    private void solveColumn(int i, char[] column, char[][] rotated) {

        int lastobj = column.length;

        for (int j = column.length - 1; j >= 0; j--) {
            rotated[j][i] = '.';
            if (column[j] == '*') {
                rotated[j][i] = '*';
                lastobj = j;
                continue;
            }
            if (column[j] == '.') {
                continue;
            }
            if (column[j] == '#') {
                rotated[--lastobj][i] = '#';
            }
        }

    }

    public static void main(String[] args) {

        L1861_Rotating_the_Box s = new L1861_Rotating_the_Box();
        long sysDate1 = System.currentTimeMillis();

        char[][] boxGrid1 = {{'#', '.', '#'}};
        char[][] expected1 = {{'.'}, {'#'}, {'#'}};
        assertDeepEquals(expected1, s.rotateTheBox(boxGrid1), "example 1");

        char[][] boxGrid2 = {
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        };
        char[][] expected2 = {
                {'#', '.'},
                {'#', '#'},
                {'*', '*'},
                {'.', '.'}
        };
        assertDeepEquals(expected2, s.rotateTheBox(boxGrid2), "example 2");

        char[][] boxGrid3 = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };
        char[][] expected3 = {
                {'.', '#', '#'},
                {'.', '#', '#'},
                {'#', '#', '*'},
                {'#', '*', '.'},
                {'#', '.', '*'},
                {'#', '.', '.'}
        };
        assertDeepEquals(expected3, s.rotateTheBox(boxGrid3), "example 3");

        System.out.println("All tests passed.");

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }

    private static void assertDeepEquals(char[][] expected, char[][] actual, String name) {
        if (!Arrays.deepEquals(expected, actual)) {
            throw new AssertionError(name + " failed\nexpected: "
                    + Arrays.deepToString(expected) + "\nactual:   "
                    + Arrays.deepToString(actual));
        }
        System.out.println(name + " ok: " + Arrays.deepToString(actual));
    }
}
