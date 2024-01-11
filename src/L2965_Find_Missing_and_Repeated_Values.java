import java.util.Arrays;

public class L2965_Find_Missing_and_Repeated_Values {

    /*
    2 <= n == grid.length == grid[i].length <= 50
    1 <= grid[i][j] <= n * n
    For all x that 1 <= x <= n * n
        there is exactly one x that is not equal to any of the grid members.
    For all x that 1 <= x <= n * n
        there is exactly one x that is equal to exactly two of the grid members.
    For all x that 1 <= x <= n * n
        except two of them
            there is exactly one pair of i, j that 0 <= i, j <= n - 1 and grid[i][j] == x.
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] res = new int[2];
        int[] count = new int[n * n + 1];

        for (int[] row : grid) {
            for (int num : row) {
                count[num]++;
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (count[i] == 0) {
                res[1] = i;
            } else if (count[i] == 2) {
                res[0] = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2965_Find_Missing_and_Repeated_Values s = new L2965_Find_Missing_and_Repeated_Values();
        long sysDate1 = System.currentTimeMillis();

        int[][] grid = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        int[] res = s.findMissingAndRepeatedValues(grid);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}