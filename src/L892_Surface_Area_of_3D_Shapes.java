public class L892_Surface_Area_of_3D_Shapes {

    public int surfaceArea(int[][] grid) {
        int res = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int cur = grid[i][j];
                if (cur == 0) {
                    continue;
                }

                res = res + 2 + cur * 4;

                if (j + 1 < n) {
                    int rightVal = grid[i][j + 1];
                    int minVal = Math.min(cur, rightVal);
                    res -= minVal * 2;
                }

                if (i + 1 < n) {
                    int downVal = grid[i + 1][j];
                    int minVal = Math.min(cur, downVal);
                    res -= minVal * 2;
                }
            }
        }

        return res;
    }

    public int surfaceArea2(int[][] grid) {

        int area = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                area += getArea(grid, i, j);
            }
        }

        return area;
    }

    private int getArea(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) return 0;
        int n = grid.length;

        int val = grid[x][y];
        int area = 0;

        // top
        if (x - 1 < 0) {
            area += val;
        } else if (val > grid[x - 1][y]) {
            area += val - grid[x - 1][y];
        }

        // bot
        if (x + 1 >= n) {
            area += val;
        } else if (val > grid[x + 1][y]) {
            area += val - grid[x + 1][y];
        }

        // left
        if (y - 1 >= 0) {
            if (val > grid[x][y - 1]) {
                area += val - grid[x][y - 1];
            }
        } else {
            area += val;
        }

        // right
        if (y + 1 >= n) {
            area += val;
        } else if (val > grid[x][y + 1]) {
            area += val - grid[x][y + 1];
        }

        // front & back
        area += 2;
        return area;
    }

    public static void main(String[] args) {

        L892_Surface_Area_of_3D_Shapes s = new L892_Surface_Area_of_3D_Shapes();

        long sysDate1 = System.currentTimeMillis();

        int[][] nums = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        //        int[][] nums = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        int res = s.surfaceArea(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}