public class L2923_Find_Champion_I {

    /*

    n == grid.length
    n == grid[i].length
    2 <= n <= 100
    grid[i][j] is either 0 or 1.
    For all i grid[i][i] is 0.

    For all i, j that i != j, grid[i][j] != grid[j][i].
    The input is generated such that
        if team a is stronger than team b and team b is stronger than team c,
        then team a is stronger than team c.
    */
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int[] team = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    team[j]++;
                } else {
                    team[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (team[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public int findChampion2(int[][] grid) {
        final int n = grid.length;
        int strongest = 0;

        for (int i = 1; i < n; i++) {
            if (grid[strongest][i] == 0) {
                strongest = i;
            }
        }

        return strongest;
    }

    public static void main(String[] args) {

        L2923_Find_Champion_I s = new L2923_Find_Champion_I();
        long sysDate1 = System.currentTimeMillis();

        int[][] grid = {{0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
        int res = s.findChampion(grid);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}