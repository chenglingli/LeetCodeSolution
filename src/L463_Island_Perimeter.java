public class L463_Island_Perimeter {


    /*

    给定一个 row x col 的网格表示地图，其中 grid[i][j] = 1 表示陆地，grid[i][j] = 0 表示水域。
    网格单元格在水平方向和垂直方向上相连（不是对角线方向）。网格完全被水域包围，
    并且只有一个岛屿（即一个或多个相连的陆地单元格）。
    岛屿内没有“湖泊”，即岛屿内部的水域不与岛屿周围的水域相连。
    一个单元格是一个边长为1的正方形。网格是矩形的，宽度和高度都不超过100。

    确定岛屿的周长。

    示例 1:


    输入: grid = [
        [0,1,0,0],
        [1,1,1,0],
        [0,1,0,0],
        [1,1,0,0]]
    输出: 16
    解释: 图像中的黄色条纹表示周长，共有16条。

    示例 2:

    输入: grid = [[1]]
    输出: 4

    示例 3:

    输入: grid = [[1,0]]
    输出: 4


    约束条件:

    row == grid.length
    col == grid[i].length
    1 <= row, col <= 100
    grid[i][j] 是 0 或 1。
    网格中只有一个岛屿。

     */
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;

        // 遍历网格中的每个单元格
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 如果当前单元格是陆地
                if (grid[i][j] == 1) {
                    // 初始假设当前陆地单元格的周长贡献为4（上、下、左、右各1）
                    ans += 4;

                    // 检查上方是否有相邻的陆地单元格，如果有，则周长减少1
                    if (i > 0 && grid[i - 1][j] == 1) {
                        ans--;
                    }

                    // 检查左方是否有相邻的陆地单元格，如果有，则周长减少1
                    if (j > 0 && grid[i][j - 1] == 1) {
                        ans--;
                    }

                    // 检查下方是否有相邻的陆地单元格，如果有，则周长减少1
                    if (i < row - 1 && grid[i + 1][j] == 1) {
                        ans--;
                    }

                    // 检查右方是否有相邻的陆地单元格，如果有，则周长减少1
                    if (j < col - 1 && grid[i][j + 1] == 1) {
                        ans--;
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        L463_Island_Perimeter s = new L463_Island_Perimeter();

        long sysDate1 = System.currentTimeMillis();

        int[][] grid = new int[][]{
            {0,1,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {1,1,0,0}
        };
        int res = s.islandPerimeter(grid);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}