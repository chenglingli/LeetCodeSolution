import java.util.Arrays;

public class L2765_Longest_Alternating_Subarray {

    /*

    You are given a 0-indexed integer array nums. A subarray s of length m is called alternating if:

    m is greater than 1.
    s1 = s0 + 1.
    The 0-indexed subarray s looks like [s0, s1, s0, s1,...,s(m-1) % 2].
    In other words, s1 - s0 = 1, s2 - s1 = -1, s3 - s2 = 1, s4 - s3 = -1, and so on up to s[m - 1] - s[m - 2] = (-1)^m.

    Return the maximum length of all alternating subarrays present in nums or -1 if no such subarray exists.

    A subarray is a contiguous non-empty sequence of elements within an array.



    Example 1:

    Input: nums = [2,3,4,3,4]

    Output: 4

    Explanation:

    The alternating subarrays are [2, 3], [3,4], [3,4,3], and [3,4,3,4]. The longest of these is [3,4,3,4], which is of length 4.


    Example 2:
    Input: nums = [4,5,6]

    Output: 2

    Explanation:

    [4,5] and [5,6] are the only two alternating subarrays. They are both of length 2.



    Constraints:

    2 <= nums.length <= 100
    1 <= nums[i] <= 104

     */
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int j = i + 1;
            while (j < n) {
                if (nums[j] - nums[j - 1] == (((j - i) % 2) == 1 ? 1 : -1)) {
                    j++;
                } else {
                    break;
                }
            }

            res = Math.max(res, j - i);
            i++;
        }

        return res == 1 ? -1 : res;
    }

    public int alternatingSubarray2(int[] nums) {

        int ans = -1;
        int curr = 1;
        int dir = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == dir) {
                curr++;
                dir = -dir;
                ans = Math.max(ans, curr);
            } else {
                if (nums[i] - nums[i - 1] == 1) {
                    curr = 2;
                    dir = -1;
                } else {
                    curr = 1;
                    dir = 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        L2765_Longest_Alternating_Subarray s = new L2765_Longest_Alternating_Subarray();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {2, 3, 4, 3, 4};
        int[] nums = {21, 9, 5};
        //        int[] nums = {2, 3};
        int res = s.alternatingSubarray(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}