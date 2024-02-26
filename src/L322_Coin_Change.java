import java.util.Arrays;

public class L322_Coin_Change {

    /*

    f[i, j] 表示前i个硬币凑成j元钱所需的最少硬币数量
    f[i, j] = min(f[i-1, j], f[i, j-coins[i]] + 1)

    Tabulation

     */
    public int coinChange2(int[] coins, int amount) {

        int m = coins.length;
        int n = amount;
        int[][] f = new int[m + 1][n + 1];

        // 初始化
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        // 状态迁移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i - 1]) {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - coins[i - 1]] + 1);
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }

        // 返回结果
        return f[m][n] == Integer.MAX_VALUE - 1 ? -1 : f[m][n];
    }


    /*
    f[i, j] 表示前i个硬币凑成j元钱所需的最少硬币数量
    f[i, j] = min(f[i-1, j], f[i, j-coins[i]] + 1)
     */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = -1;
        }

        int ans = calc(amount, coins, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    private int calc(int amount, int[] coins, int[] dp) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = calc(amount - coins[i], coins, dp);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        dp[amount] = minCoins;

        return minCoins;
    }


    int[] map;

    public int coinChange3(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        Arrays.sort(coins);
        map = new int[amount + 1];

        for (int coin : coins) {
            if (coin <= amount)
                map[coin] = 1;
        }

        return findCoinChange(coins, amount);
    }

    private int findCoinChange(int[] coins, int amount) {

        // 记忆的已有结果
        if (map[amount] != 0)
            return map[amount];

        int temp;
        int min = -1;

        for (int i = coins.length - 1; i >= 0; --i) {
            if (min != -1 && coins[i] * min < amount)
                break;

            if (amount > coins[i]) {
                temp = 1 + findCoinChange(coins, amount - coins[i]);
                if (temp != 0)
                    min = min == -1 ? temp : Math.min(temp, min);
            }
        }

        // 更新记忆
        map[amount] = min;

        return min;
    }

    public static void main(String[] args) {


        L322_Coin_Change s = new L322_Coin_Change();
        long sysDate1 = System.currentTimeMillis();

        int amount = 100;
        int[] coins = {1, 2, 5};
        int res = s.coinChange(coins, amount);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}