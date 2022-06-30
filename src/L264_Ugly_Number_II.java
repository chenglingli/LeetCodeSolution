public class L264_Ugly_Number_II {


    public int nthUglyNumber(int n) {

        if (n == 1)
            return 1; // base case

        int t2 = 0, t3 = 0, t5 = 0; //pointers for 2, 3, 5

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[t2] * 2, Math.min(dp[t3] * 3, dp[t5] * 5));
            if (dp[i] == dp[t2] * 2) t2++;
            if (dp[i] == dp[t3] * 3) t3++;
            if (dp[i] == dp[t5] * 5) t5++;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        L264_Ugly_Number_II s = new L264_Ugly_Number_II();
        long sysDate1 = System.currentTimeMillis();

        int res = s.nthUglyNumber(496);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}