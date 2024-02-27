public class L416_Partition_Equal_Subset_Sum {

    /*
    f[i, j] 表示前i个数字能否凑成j
    f[i, j] = f[i-1, j] || f[i-1, j-nums[i]]

    f[i, 0] = true
    f[0, j] = false

    返回f[n, sum]
     */

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int n = nums.length;

        for (int x : nums) {
            if (x == sum) {
                return true;
            }
            if (x > sum) {
                return false;
            }
        }

        int[][] f = new int[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                if (j == 0) {
                    f[i][j] = 1;
                    continue;
                }

                if (j >= nums[i - 1]) {
                    f[i][j] = (f[i - 1][j - nums[i - 1]] + f[i - 1][j]) >= 1 ? 1 : 0;
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }

        return f[n][sum] == 1;
    }


    public boolean canPartition3(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        int subSetSum = sum / 2;
        int n = nums.length;

        // 记录状态
        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];

        return dfs(nums, n - 1, subSetSum, memo);
    }

    public boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {

        // Base Cases
        if (subSetSum == 0)
            return true;

        if (n == 0 || subSetSum < 0)
            return false;

        // 是否已经计算过
        if (memo[n][subSetSum] != null)
            return memo[n][subSetSum];

        /*
        f[i, j] = f[i-1, j] || f[i-1, j-nums[i]]
        f[i, 0] = true
        f[0, j] = false
        if j < 0 " false
         */
        boolean result =
                dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                        dfs(nums, n - 1, subSetSum, memo);

        // 存储结果
        memo[n][subSetSum] = result;

        return result;
    }

    public static void main(String[] args) {

        L416_Partition_Equal_Subset_Sum s = new L416_Partition_Equal_Subset_Sum();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {1, 5, 11, 5};
        //                 int[] nums = {1, 2, 3, 5};
        int[] nums = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97};
        boolean res = s.canPartition2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}