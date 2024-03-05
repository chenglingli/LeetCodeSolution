import java.util.Arrays;

public class L377_Combination_Sum_IV {


    /*
    1 <= nums.length <= 200
    1 <= nums[i] <= 1000
    All the elements of nums are unique.
    1 <= target <= 1000

    f[i] 表示和为 i 的方案数
    f[i] = f[i - nums[0]] + f[i - nums[1]] + ... + f[i - nums[n-1]]
    f[0] = 1
     */
    public int combinationSum4(int[] nums, int target) {
        int[] mem = new int[target + 1];
        Arrays.fill(mem, -1);
        mem[0] = 1;

        return f(nums, target, mem);
    }

    private int f(int[] nums, int target, int[] mem) {

        if (mem[target] != -1) {
            return mem[target];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += f(nums, target - nums[i], mem);
            }
        }

        mem[target] = res;
        return res;
    }

    /*

    dp[i] 表示 i 用 数组组成的方式
    dp[i] = dp[i - nums[0]] + dp[i - nums[1]] + ... + dp[i - nums[n-1]]
    dp[i] = sum(dp[i - nums[j]]) (0 <= j < n)

     */
    public int combinationSum43(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < nums.length ; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }


    public int combinationSum44(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return help(nums, target, dp);
    }

    public int help(int[] nums, int target, int[] dp) {

        int n = nums.length;
        if (target == 0)
            return 1;
        int ans = 0;

        if (dp[target] != -1)
            return dp[target];

        for (int i = 0; i < n; i++) {
            if (nums[i] <= target) {
                ans += help(nums, target - nums[i], dp);
            }
        }
        dp[target] = ans;
        return dp[target];
    }

    public static void main(String[] args) {

        L377_Combination_Sum_IV s = new L377_Combination_Sum_IV();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3};
        int target = 4;
        int res = s.combinationSum4(nums, target);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}