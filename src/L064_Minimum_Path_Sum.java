public class L064_Minimum_Path_Sum {


    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int mapCount[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    mapCount[i][j] = grid[i][j];
                } else if (i == 0 && j != 0) {
                    mapCount[i][j] = grid[i][j] + mapCount[i][j - 1];
                } else if (i != 0 && j == 0) {
                    mapCount[i][j] = grid[i][j] + mapCount[i - 1][j];
                } else {
                    mapCount[i][j] = grid[i][j] + Integer.min(mapCount[i][j - 1], mapCount[i - 1][j]);
                }
            }
        }

        return mapCount[m - 1][n - 1];
    }

    public static void main(String[] args) {

        L064_Minimum_Path_Sum s = new L064_Minimum_Path_Sum();

        long sysDate1 = System.currentTimeMillis();

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int x = s.minPathSum(grid);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}