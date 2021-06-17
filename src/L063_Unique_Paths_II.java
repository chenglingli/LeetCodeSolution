public class L063_Unique_Paths_II {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int mapCount[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    mapCount[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    mapCount[i][j] = 1;
                } else if (i == 0 && j != 0) {
                    mapCount[i][j] = mapCount[i][j - 1];
                } else if (i != 0 && j == 0) {
                    mapCount[i][j] = mapCount[i - 1][j];
                } else {
                    mapCount[i][j] = mapCount[i][j - 1] + mapCount[i - 1][j];
                }
            }
        }

        return mapCount[m - 1][n - 1];
    }

    public static void main(String[] args) {

        L063_Unique_Paths_II s = new L063_Unique_Paths_II();

        long sysDate1 = System.currentTimeMillis();

        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        int x = s.uniquePathsWithObstacles(obstacleGrid);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}