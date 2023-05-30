public class L1800_Maximum_Ascending_Subarray_Sum {

    /*
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
     */
    public int maxAscendingSum(int[] nums) {
        int i = 1;
        int curAns = nums[0];
        int ans = curAns;

        while (i < nums.length) {

            while (i < nums.length && nums[i] > nums[i - 1]) {
                curAns += nums[i];
                i++;
            }

            ans = Math.max(ans, curAns);
            if (i >= nums.length) {
                break;
            }
            curAns = nums[i];

            i++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L1800_Maximum_Ascending_Subarray_Sum s = new L1800_Maximum_Ascending_Subarray_Sum();
        long sysDate1 = System.currentTimeMillis();

//        int[] nums = {12, 17, 15, 13, 10, 11, 12};
        int[] nums = {12};
        int res = s.maxAscendingSum(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}