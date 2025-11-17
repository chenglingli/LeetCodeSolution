public class L3127_Make_a_Square_with_the_Same_Color {

    /*

    You are given a 2D matrix grid of size 3 x 3 consisting only of characters 'B' and 'W'.
    Character 'W' represents the white color, and character 'B' represents the black color.

    Your task is to change the color of at most one cell so that the matrix has a 2 x 2 square where all cells are of the same color.

    Return true if it is possible to create a 2 x 2 square of the same color, otherwise, return false.



    Example 1:

    Input: grid = [["B","W","B"],["B","W","W"],["B","W","B"]]

    Output: true

    Explanation:

    It can be done by changing the color of the grid[0][2].

    Example 2:

    Input: grid = [["B","W","B"],["W","B","W"],["B","W","B"]]

    Output: false

    Explanation:

    It cannot be done by changing at most one cell.

    Example 3:

    Input: grid = [["B","W","B"],["B","W","W"],["B","W","W"]]

    Output: true

    Explanation:

    The grid already contains a 2 x 2 square of the same color.



    Constraints:

    grid.length == 3
    grid[i].length == 3
    grid[i][j] is either 'W' or 'B'.

     */
    public boolean canMakeSquare(char[][] grid) {

        int len = grid.length;
        for (int i = 0 ; i < len - 1; i++) {
            for (int j = 0; j < len - 1; j++) {

                int countW = 0;
                int countB = 0;
                for (int m = i; m < i + 2; m++) {
                    for (int n = j; n < j+2; n++) {
                        if (grid[m][n] == 'W') {
                            countW++;
                        }
                        if (grid[m][n] == 'B') {
                            countB++;
                        }
                    }
                }

                if (countW >= 3 || countB >= 3) {
                    return true;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {

        L3127_Make_a_Square_with_the_Same_Color s = new L3127_Make_a_Square_with_the_Same_Color();
        long sysDate1 = System.currentTimeMillis();

//        char[][] grid = {
//                {'B', 'W', 'B'},
//                {'B', 'W', 'W'},
//                {'B', 'W', 'B'}
//        };

        char[][] grid = {
                {'B', 'W', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'B'}
        };

        boolean res = s.canMakeSquare(grid);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}