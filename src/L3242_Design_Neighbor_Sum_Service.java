import java.util.HashMap;

/*
    3 <= n == grid.length == grid[0].length <= 10
    0 <= grid[i][j] <= n^2 - 1
    All grid[i][j] are distinct.
    value in adjacentSum and diagonalSum will be in the range [0, n^2 - 1].
    At most 2 * n^2 calls will be made to adjacentSum and diagonalSum.

 */

/*
    每个值都不一样
    需要记录每个值对应的坐标
 */
class NeighborSum {

    HashMap<Integer, int[]> map = new HashMap<>();
    int n = 0;
    int[][] gridData;
    int[][] adjacentDirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] diagonalDirs = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public NeighborSum(int[][] grid) {

        n = grid.length;
        gridData = grid;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = grid[i][j];
                map.put(value, new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {

        int[] curCoordinate = map.get(value);
        int x = curCoordinate[0];
        int y = curCoordinate[1];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int tempX = x + adjacentDirs[i][0];
            int tempY = y + adjacentDirs[i][1];
            if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
                sum += gridData[tempX][tempY];
            }
        }

        return sum;
    }

    public int diagonalSum(int value) {
        int[] curCoordinate = map.get(value);
        int x = curCoordinate[0];
        int y = curCoordinate[1];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int tempX = x + diagonalDirs[i][0];
            int tempY = y + diagonalDirs[i][1];
            if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
                sum += gridData[tempX][tempY];
            }
        }

        return sum;
    }
}

/*
    提前算好
 */
class neighborSumEfficient {

    int[] adjacent, diagonal;
    int n;

    public neighborSumEfficient(int[][] grid) {
        n = grid.length;
        adjacent = new int[n * n];
        diagonal = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = j > 0 ? grid[i][j - 1] : 0, right = j < n - 1 ? grid[i][j + 1] : 0;
                int top = i > 0 ? grid[i - 1][j] : 0, bottom = i < n - 1 ? grid[i + 1][j] : 0;
                adjacent[grid[i][j]] = left + right + top + bottom;
                int tl = (i > 0 && j > 0) ? grid[i - 1][j - 1] : 0, tr = (i > 0 && j < n - 1) ? grid[i - 1][j + 1] : 0;
                int bl = (i < n - 1 && j > 0) ? grid[i + 1][j - 1] : 0, br = (i < n - 1 && j < n - 1) ? grid[i + 1][j + 1] : 0;
                diagonal[grid[i][j]] = tl + tr + bl + br;
            }
        }
    }

    public int adjacentSum(int value) {
        return adjacent[value];
    }

    public int diagonalSum(int value) {
        return diagonal[value];
    }
}

public class L3242_Design_Neighbor_Sum_Service {

    public static void main(String[] args) {

        long sysDate1 = System.currentTimeMillis();

        int[][] grid = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

        NeighborSum obj = new NeighborSum(grid);
        System.out.println(obj.adjacentSum(1));
        System.out.println(obj.adjacentSum(4));
        System.out.println(obj.diagonalSum(4));
        System.out.println(obj.diagonalSum(8));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}