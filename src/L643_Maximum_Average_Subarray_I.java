public class L643_Maximum_Average_Subarray_I {

    /**
     * Given an array consisting of n integers,
     * find the contiguous subarray of given length k that has the maximum average value.
     * And you need to output the maximum average value.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,12,-5,-6,50,3], k = 4
     * Output: 12.75
     * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= k <= n <= 30,000.
     * Elements of the given array will be in the range [-10,000, 10,000].
     */

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            if (i >= nums.length) break;
            sum += nums[i];
        }

        int ans = sum;
        for (int i = k; i < nums.length; i++) {
            int post = nums[i];
            int pre = nums[i - k];

            sum = sum + post - pre;
            ans = Integer.max(ans, sum);
        }
        return ans * 1.0 / k;
    }

    public static void main(String[] args) {

        L643_Maximum_Average_Subarray_I s = new L643_Maximum_Average_Subarray_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 12, -5, -6, 50, 3};
        double res = s.findMaxAverage(nums, 1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}