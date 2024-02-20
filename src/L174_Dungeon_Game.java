import java.util.Arrays;

public class L174_Dungeon_Game {

    /*
    递归解法

    Memoization !

    倒着来计算，从右下角开始，到达右下角需要的最小体力，然后递归计算左上角，最后返回左上角的值


    dp[i][j] 表示到达i，j需要的最小体力
    dp[i][j] = min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]
    dp[i][j] <= 0, dp[i][j] = 1


     */
    public int calculateMinimumHP(int[][] d) {
        return rec(0, 0, d, new Integer[d.length][d[0].length]);
    }

    int rec(int i, int j, int[][] d, Integer[][] dp) {

        if (i >= d.length || j >= d[0].length) {
            return (int) 1e9;
        }

        if (i == d.length - 1 && j == d[0].length - 1) {
            return d[i][j] >= 0 ? 1 : -d[i][j] + 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int min = Math.min(rec(i + 1, j, d, dp), rec(i, j + 1, d, dp)) - d[i][j];
        dp[i][j] = min <= 0 ? 1 : min;

        return dp[i][j];
    }

    /*

    递归解法2
    从左上角开始，到达右下角需要的最小体力，然后递归计算右下角，最后返回右下角的值

    dp[i][j] 表示到达i，j需要的最小体力
    dp[i][j] = min(dp[i-1][j], dp[i][j-1]) - dungeon[i][j]
    dp[i][j] <= 0, dp[i][j] = 1

     */
    public int calculateMinimumHP2(int[][] dun) {

        int n = dun.length, m = dun[0].length, dp[][] = new int[n + 1][m + 1];
        Arrays.fill(dp[n], Integer.MAX_VALUE);

        dp[n][m - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {

            dp[i][m] = Integer.MAX_VALUE;
            if (i == n - 1)
                dp[i][m] = 1;

            for (int j = m - 1; j >= 0; j--) {
                int val = Math.min(dp[i + 1][j], dp[i][j + 1]) - dun[i][j];
                dp[i][j] = Math.max(1, val);
            }
        }

        return dp[0][0];
    }


    /*


    动态规划

    tabulation !

     */
    public int calculateMinimumHP4(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        if (dungeon[m - 1][n - 1] >= 0) {
            dp[m - 1][n - 1] = 1;
        } else {
            dp[m - 1][n - 1] = 1 - dungeon[m - 1][n - 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = c(dungeon[i][n - 1], dp[i + 1][n - 1]);
        }

        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = c(dungeon[m - 1][j], dp[m - 1][j + 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(
                        c(dungeon[i][j], dp[i + 1][j]),
                        c(dungeon[i][j], dp[i][j + 1]));
            }
        }

        return dp[0][0];
    }

    private int c(int value, int preResult) {
        if (value == 0)
            return preResult;

        if (value > 0) {
            if (value >= preResult)
                return 1;
            return preResult - value;
        }

        return preResult - value;
    }


    /*

     */
    public int calculateMinimumHP3(int[][] D) {

        int n = D.length - 1, m = D[0].length - 1;

        for (int i = n - 1; i > -1; i--)
            if (D[i + 1][m] < 0)
                D[i][m] += D[i + 1][m];

        for (int j = m - 1; j > -1; j--)
            if (D[n][j + 1] < 0)
                D[n][j] += D[n][j + 1];

        for (int i = n - 1; i > -1; i--) {
            for (int j = m - 1; j > -1; j--) {
                if (D[i + 1][j] < 0 && D[i][j + 1] < 0)
                    D[i][j] += Math.max(D[i + 1][j], D[i][j + 1]);
            }
        }

        return 1 + Math.max(0, -D[0][0]);
    }


    public static void main(String[] args) {

        L174_Dungeon_Game s = new L174_Dungeon_Game();

        long sysDate1 = System.currentTimeMillis();

        // int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        // int[][] dungeon = {{2, 0, -1}};
        int[][] dungeon = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};

        int res = s.calculateMinimumHP4(dungeon);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}