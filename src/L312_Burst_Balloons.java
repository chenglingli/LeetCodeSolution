public class L312_Burst_Balloons {

    /*
    n == nums.length
    1 <= n <= 300
    0 <= nums[i] <= 100

    动态规划
    1. 状态定义
        dp[i][j] 表示戳破i到j之间的所有气球，获得的最大金币数
    2. 状态转移方程

        假设号码是 1 1,2,3,4 1 (左右各加一个1)
        假设我们最后一个戳破的气球是3，此时其他气球都戳破了
        f值 = f(1, 2) + f(4) + 1 * 3 * 1

    3. 初始状态
        dp[i][i+1] = 0
    4. 返回值
        dp[0][n+1]
    5. 空间优化
        一维数组
    6. 注意
        为了方便计算，我们在nums数组的两端加上两个1
    7. 时间复杂度
        O(n^3)
    8. 空间复杂度
        O(n^2)

     */
    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        int[][] dpValue = new int[n + 2][n + 2];
        int ans = maxCoinsCalc(newNums, 0, n + 1, dpValue);

        return ans;
    }

    private int maxCoinsCalc(int[] nums, int i, int j, int[][] dpValue) {

        if (i == j - 1) {
            return 0;
        }

        // 记忆化返回
        if (dpValue[i][j] != 0) {
            return dpValue[i][j];
        }

        int ans = 0;

        for (int k = i + 1; k < j; k++) {
            int left = maxCoinsCalc(nums, i, k, dpValue);
            int right = maxCoinsCalc(nums, k, j, dpValue);
            int curValue = nums[i] * nums[k] * nums[j] + left + right;
            ans = Math.max(ans, curValue);
        }

        // 记录值
        dpValue[i][j] = ans;

        return ans;
    }

    /*
    maxCoins4的优化
     */
    public int maxCoins2(int[] nums) {

        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        int[][] dpValue = new int[n + 2][n + 2];

        for (int i = n; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                int ij = newNums[i] * newNums[j];

                int tempAns = 0;

                for (int k = i + 1; k < j; k++) {
                    tempAns = Math.max(tempAns, ij * newNums[k] + dpValue[i][k] + dpValue[k][j]);
                }
                dpValue[i][j] = tempAns;
            }
        }

        return dpValue[0][n + 1];
    }

    /*
    打表方式
    Tabulation
     */
    public int maxCoins4(int[] nums) {

        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        int[][] dpValue = new int[n + 2][n + 2];

        for (int i = n; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int left = dpValue[i][k];
                    int right = dpValue[k][j];
                    int curValue = newNums[i] * newNums[k] * newNums[j] + left + right;
                    dpValue[i][j] = Math.max(dpValue[i][j], curValue);
                }
            }
        }

        return dpValue[0][n + 1];
    }

    public int maxCoins3(int[] nums) {

        int n = nums.length;
        int[] newnums = new int[n + 2];
        newnums[0] = 1;
        newnums[n + 1] = 1;
        for(int i = 0; i < n; i++){
            newnums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for(int len = 2; len < n + 2; len++){
            for(int left = 0; left + len < n + 2; left++){
                int right = left + len;
                int ij = newnums[left] * newnums[right];
                int ans = 0;
                for(int i = left + 1; i < right; i++){
                    ans = Math.max(ans, ij * newnums[i] + dp[left][i] + dp[i][right]);
                }

                dp[left][right] = ans;
            }
        }

        return dp[0][n + 1];
    }

    public static void main(String[] args) {

        L312_Burst_Balloons s = new L312_Burst_Balloons();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 1, 5, 8};
        int res = s.maxCoins2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}