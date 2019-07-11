public class L062_Unique_Paths {

    public int uniquePaths(int m, int n) {

        if (m <= 1 || n <= 1) {
            return 1;
        }

        int mapCount[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j<= n ; j++) {
                if (i == 1 || j == 1) {
                    mapCount[i][j] = 1;
                }
                else {
                    mapCount[i][j] = mapCount[i][j-1] + mapCount[i-1][j];
                }
            }
        }

        return mapCount[m][n];
    }

    public static void main(String[] args) {

        L062_Unique_Paths s = new L062_Unique_Paths();

        long sysDate1 = System.currentTimeMillis();


        int x = s.uniquePaths(7, 3);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}