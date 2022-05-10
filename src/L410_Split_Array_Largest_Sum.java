public class L410_Split_Array_Largest_Sum {

    /**
     * Given an array which consists of non-negative integers
     * and an integer m, you can split the array into m non-empty continuous subarrays.
     * <p>
     * Write an algorithm to minimize the largest sum among these m subarrays.
     * <p>
     * Note:
     * If n is the length of array, assume the following constraints are satisfied:
     * <p>
     * 1 ≤ n ≤ 1000
     * 1 ≤ m ≤ min(50, n)
     * Examples:
     * <p>
     * Input:
     * nums = [7,2,5,10,8]
     * m = 2
     * <p>
     * Output:
     * 18
     * <p>
     * Explanation:
     * There are four ways to split nums into two subarrays.
     * The best way is to split it into [7,2,5] and [10,8],
     * where the largest sum among the two subarrays is only 18.
     */

    public int splitArray(int[] nums, int m) {

        long left = 0, right = 0;
        for (int i = 0; i < nums.length; ++i) {
            left = Integer.max((int) left, nums[i]);
            right += nums[i];
        }

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canSplit(nums, m, (int) mid))
                right = mid;
            else
                left = mid + 1;
        }
        return (int) left;
    }

    private boolean canSplit(int[] nums, int m, int sum) {
        int cnt = 1, curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > sum) {
                curSum = nums[i];
                cnt++;
                if (cnt > m)
                    return false;
            }
        }
        return true;
    }


    /**
     * 相对来说，这种方法应该更容易理解一些。我们建立一个二维数组dp，
     * 其中dp[i][j]表示将数组中前j个数字分成i组所能得到的最小的各个子数组中最大值，初始化为整型最大值，
     * 如果无法分为i组，那么还是保持为整型最大值。
     * <p>
     * 为了能快速的算出子数组之和，我们还是要建立累计和数组，难点就是在于要求递推公式了。
     * <p>
     * 我们来分析，如果前j个数字要分成i组，那么i的范围是什么，由于只有j个数字，如果每个数字都是单独的一组，那么最多有j组；
     * 如果将整个数组看为一个整体，那么最少有1组，所以i的范围是[1, j]，所以我们要遍历这中间所有的情况，假如中间任意一个位置k，
     * dp[i-1][k]表示数组中前k个数字分成i-1组所能得到的最小的各个子数组中最大值，
     * 而sums[j]-sums[k]就是后面的数字之和，我们取二者之间的较大值，然后和dp[i][j]原有值进行对比，
     * 更新dp[i][j]为二者之中的较小值，这样k在[1, j]的范围内扫过一遍，dp[i][j]就能更新到最小值，我们最终返回dp[m][n]即可，
     * <p>
     * 博主认为这道题所用的思想应该是之前那道题Reverse Pairs中解法二中总结的分割重现关系(Partition Recurrence Relation)，
     * 由此看来很多问题的本质都是一样，但是披上华丽的外衣，难免会让人有些眼花缭乱了.
     */
    public int splitArray2(int[] nums, int m) {
        int n = nums.length;
        int[] sums = new int[n + 1];

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = i - 1; k < j; k++) {
                    int val = Integer.max(dp[i - 1][k], sums[j] - sums[k]);
                    dp[i][j] = Integer.min(dp[i][j], val);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        L410_Split_Array_Largest_Sum s = new L410_Split_Array_Largest_Sum();
        long sysDate1 = System.currentTimeMillis();

        int[] matrix = {7, 2, 5, 10, 8};

        int res = s.splitArray2(matrix, 2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}