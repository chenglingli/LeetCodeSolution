import java.util.Arrays;

public class L3963_Create_Grid_With_Exactly_One_Path {

    /*

    You are given two integers m and n, representing the number of rows and columns of a grid.

    Construct any m x n grid consisting only of the characters '.' and '#', where:

    '.' represents a free cell.
    '#' represents an obstacle cell.

    A valid path is a sequence of free cells that:
    Starts at the top-left cell (0, 0).
    Ends at the bottom-right cell (m - 1, n - 1).

    Moves only:
    Right, from (i, j) to (i, j + 1), or
    Down, from (i, j) to (i + 1, j).
    Return any grid such that there is exactly one valid path from the top-left cell to the bottom-right cell.

    Example 1:
    Input: m = 2, n = 3
    Output: ["..#","#.."]
    Explanation:
    The only valid path is: (0,0) → (0,1) → (1,1) → (1,2)

    Example 2:
    Input: m = 3, n = 3
    Output: ["..#","#..","##."]
    Explanation:
    The only valid path is: (0,0) → (0,1) → (1,1) → (1,2) → (2,2)

    Example 3:
    Input: m = 1, n = 4
    Output: ["...."]
    Explanation:
    The only valid path is: (0,0) → (0,1) → (0,2) → (0,3)

    Constraints:

    1 <= m, n <= 25
     */
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];

        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n - 1; j++) {
                if (i == 0) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sb.append(".");

            res[i] = sb.toString();
        }

        return res;
    }

    public String[] createGrid2(int m, int n) {
        String[] res = new String[m];

        char[] str = new char[n];
        Arrays.fill(str, '.');
        res[0] = new String(str);

        Arrays.fill(str, 0, n - 1, '#');
        String other = new String(str);
        for (int i = 1; i < m; ++i) {
            res[i] = other;
        }

        return res;
    }

    public static void main(String[] args) {

        L3963_Create_Grid_With_Exactly_One_Path s = new L3963_Create_Grid_With_Exactly_One_Path();
        long sysDate1 = System.currentTimeMillis();

        int m = 2;
        int n = 3;
        String[] res = s.createGrid(m, n);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}