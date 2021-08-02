public class L209_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int sum = 0, len = nums.length;
        int res = Integer.MAX_VALUE;

        while (right < len) {
            while (sum < target && right < len) {
                sum += nums[right++];
            }

            while (sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE? 0 : res;
    }


    public static void main(String[] args) {

        L209_Minimum_Size_Subarray_Sum s = new L209_Minimum_Size_Subarray_Sum();
        long sysDate1 = System.currentTimeMillis();

        int[] cost = {1, 2, 3, 4};

        int res = s.minSubArrayLen(7, cost);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}