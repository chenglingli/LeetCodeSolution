public class L213_House_Robber_II {


    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Integer.max(nums[0], nums[1]);
        if (n == 3) return Integer.max(Integer.max(nums[0], nums[1]), nums[2]);


        int[] f = new int[nums.length];
        int[] curMax1 = new int[nums.length];
        int[] curMax2 = new int[nums.length];


        //偷第一家
        f[0] = f[1] = nums[0];
        curMax1[0] = f[0];
        curMax1[1] = f[0];
        f[2] = nums[0] + nums[2];
        curMax1[2] = f[2];
        for (int i = 3; i < n - 1; i++) {
            f[i] = Integer.max(f[i - 2] + nums[i], f[i - 1]);
            curMax1[i] = Integer.max(f[i], curMax1[i - 1]);
        }

        //不偷第一家
        f[0] = 0;
        f[1] = nums[1];
        curMax2[1] = f[1];
        f[2] = Integer.max(nums[1], nums[2]);
        curMax2[2] = Integer.max(curMax2[1], f[2]);
        for (int i = 3; i < n; i++) {
            f[i] = Integer.max(f[i - 2] + nums[i], f[i - 1]);
            curMax2[i] = Integer.max(f[i], curMax2[i - 1]);
        }

        return Integer.max(curMax2[n - 1], curMax1[n - 2]);
    }


    public static void main(String[] args) {

        L213_House_Robber_II s = new L213_House_Robber_II();
        long sysDate1 = System.currentTimeMillis();

        int[] cost = {1, 2, 3, 1};

        int res = s.rob(cost);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}