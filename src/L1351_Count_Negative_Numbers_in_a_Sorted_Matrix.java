public class L1351_Count_Negative_Numbers_in_a_Sorted_Matrix {

    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m ; i++) {
            int [] row = grid[i];
            int curCount = findNegative(row, n);
            count += curCount;
        }

        return count;
    }

    int findNegative(int [] row, int n) {
        int l = 0; int r = n-1;
        while (l < r) {
            int cur = row[ (l+r) / 2];
            if (cur >= 0) {
                l = (l+r) / 2 + 1;
            }
            else {
                r = (l+r) / 2;
            }
        }

        if (row[r] < 0) {
            return n - r;
        }
        return n - r - 1;
    }

    public static void main(String[] args) {

        L1351_Count_Negative_Numbers_in_a_Sorted_Matrix s = new L1351_Count_Negative_Numbers_in_a_Sorted_Matrix();
        long sysDate1 = System.currentTimeMillis();

        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
//        int[][] grid = {{3,2},{2,0}};
//        int [][] grid = {{4,3,3,1,1},{1,0,0,-1,-1},{-2,-2,-2,-2,-3},{-2,-2,-2,-3,-3},{-3,-3,-3,-3,-3}};
        int res = s.countNegatives(grid);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}