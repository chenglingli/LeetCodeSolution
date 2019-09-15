public class L674_Longest_Continuous_Increasing_Subsequence {

    /**

     Given an unsorted array of integers,
     find the length of longest continuous increasing subsequence (subarray).

     Example 1:
     Input: [1,3,5,4,7]
     Output: 3
     Explanation: The longest continuous increasing subsequence is [1,3,5],
     its length is 3.
     Even though [1,3,5,7] is also an increasing subsequence,
     it's not a continuous one where 5 and 7 are separated by 4.

     Example 2:
     Input: [2,2,2,2,2]
     Output: 1
     Explanation: The longest continuous increasing subsequence is [2],
     its length is 1.
     Note: Length of the array will not exceed 10,000.

     */

    public int findLengthOfLCIS(int[] nums) {

        if (nums.length <=1) return nums.length;

        int ans = 0;
        int i = 0;
        int curCount = 1;
        while (i < nums.length - 1) {
            if (nums[i + 1] > nums[i]) {
                curCount ++;
            }
            else {
                if (curCount > ans) ans = curCount;
                curCount = 1;
            }
            i++;
        }

        if (curCount > ans) ans = curCount;
        return ans;
    }

    public static void main(String[] args) {

        L674_Longest_Continuous_Increasing_Subsequence s = new L674_Longest_Continuous_Increasing_Subsequence();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1,2,3,4,5,3,4,5,6,7,8,9};
        int res = s.findLengthOfLCIS(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}