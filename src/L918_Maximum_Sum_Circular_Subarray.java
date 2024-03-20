public class L918_Maximum_Sum_Circular_Subarray {


    /*
    n == nums.length
    1 <= n <= 3 * 10^4
    -3 * 10^4 <= nums[i] <= 3 * 10^4

    f[i] 表示以nums[i]结尾的最大子数组和
    若不是环状，则
    如果 f[i-1] >= 0, f[i] = f[i - 1] + nums[i]
    如果 f[i-1] < 0, f[i] = nums[i]

    Find max sum subArray
    Find min sum subArray
    answer =  max{(max sum subArray) , (totalSum - min sum subArray)}

    需要处理全是负数情况
     */
    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int[] maxF = new int[n];
        int[] minF = new int[n];
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        maxF[0] = nums[0];
        maxSum = nums[0];
        minF[0] = nums[0];
        minSum = nums[0];
        sum += nums[0];

        for (int i = 1; i < n; i++) {
            
            sum += nums[i];

            maxF[i] = Math.max(maxF[i - 1] + nums[i], nums[i]);
            minF[i] = Math.min(minF[i - 1] + nums[i], nums[i]);

            maxSum = Math.max(maxSum, maxF[i]);
            minSum = Math.min(minSum, minF[i]);
        }

        if (sum == minSum) {
            return maxSum;
        }

        return Math.max(maxSum, sum - minSum);
    }

    /*

     */
    public int maxSubarraySumCircular2(int[] nums) {

        // 计算正常的最大子数组和
        int n = nums.length;
        int max_normal = maxSubarraySun(nums);
        if (max_normal <= 0) {
            return max_normal;
        }

        // 计算总和，并且反向符号
        int arr_sum = 0;
        for (int i = 0; i < n; i++) {
            arr_sum = arr_sum + nums[i];
            nums[i] = -nums[i];
        }

        int max_circular = arr_sum + maxSubarraySun(nums);
        return Math.max(max_normal, max_circular);
    }

    public int maxSubarraySun(int[] nums) {

        int n = nums.length;
        int maxEnding = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            res = Math.max(res, maxEnding);
        }

        return res;
    }

    public static void main(String[] args) {

        L918_Maximum_Sum_Circular_Subarray s = new L918_Maximum_Sum_Circular_Subarray();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {-3, -2, -3};
        int res = s.maxSubarraySumCircular(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}