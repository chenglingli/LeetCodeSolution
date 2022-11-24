public class L279_Perfect_Squares {


    // 动态规划 ，存储
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        return solve(n, dp);
    }

    int solve(int n, int[] dp) {

        if (n == 0) {
            return 0;
        }

        if (dp[n] > 0) {
            return dp[n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + solve(n - i * i, dp));
        }

        return dp[n] = min;
    }


    protected boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    public int numSquares2(int n) {


        // 拉格朗日 四平方定理
        // 任何数字都可以由4个平方数和构成，某个平方数可以为0

        // Adrien Marie Legendre 三平方定理
        // 可以表示为3个平方数的特殊条件
        // n不能表示为 4^k * (8*m+7)  <-> n = a^2 + b^2 + c^2 （abc可以为0）


        /*
        结合以上

        如果一个n可以表示为 xxxxx，则其必然是4个平方数和 -> 4
        否则 判断其是否是平方数 -> 1
        否则 判断其是否是两个平方数和 -> 2
        否则 3

         */


        // four-square and three-square theorems.
        while (n % 4 == 0)
            n /= 4;

        if (n % 8 == 7)
            return 4;

        if (this.isSquare(n))
            return 1;
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i))
                return 2;
        }

        // bottom case of three-square theorem.
        return 3;
    }

    public static void main(String[] args) {

        L279_Perfect_Squares s = new L279_Perfect_Squares();

        long sysDate1 = System.currentTimeMillis();
        int res = s.numSquares(62);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}