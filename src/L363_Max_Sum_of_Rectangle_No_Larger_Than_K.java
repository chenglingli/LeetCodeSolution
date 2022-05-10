public class L363_Max_Sum_of_Rectangle_No_Larger_Than_K {


    public int maxSumSubmatrix(int[][] matrix, int k) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, res = Integer.MIN_VALUE;

        int[][] sum = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int t = matrix[i][j];
                if (i > 0) t += sum[i - 1][j];
                if (j > 0) t += sum[i][j - 1];
                if (i > 0 && j > 0) t -= sum[i - 1][j - 1];
                sum[i][j] = t;
                for (int r = 0; r <= i; ++r) {
                    for (int c = 0; c <= j; ++c) {
                        int d = sum[i][j];
                        if (r > 0) d -= sum[r - 1][j];
                        if (c > 0) d -= sum[i][c - 1];
                        if (r > 0 && c > 0) d += sum[r - 1][c - 1];
                        if (d <= k)
                            res = Integer.max(res, d);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        L363_Max_Sum_of_Rectangle_No_Larger_Than_K s = new L363_Max_Sum_of_Rectangle_No_Larger_Than_K();

        long sysDate1 = System.currentTimeMillis();

        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int res2 = s.maxSumSubmatrix(matrix, 2);
        System.out.println(res2);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}