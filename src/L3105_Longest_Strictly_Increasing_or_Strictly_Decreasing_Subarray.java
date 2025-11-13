public class L3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray {

    /*

    You are given an array of integers nums.
    Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.



    Example 1:

    Input: nums = [1,4,3,3,2]

    Output: 2

    Explanation:

    The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

    The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

    Hence, we return 2.

    Example 2:

    Input: nums = [3,3,3,3]

    Output: 1

    Explanation:

    The strictly increasing subarrays of nums are [3], [3], [3], and [3].

    The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

    Hence, we return 1.

    Example 3:

    Input: nums = [3,2,1]

    Output: 3

    Explanation:

    The strictly increasing subarrays of nums are [3], [2], and [1].

    The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

    Hence, we return 3.



    Constraints:

    1 <= nums.length <= 50
    1 <= nums[i] <= 50

     */
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxIncreasing = 1;
        int maxDecreasing = 1;

        int tempIncreasing = 1;
        int tempDecreasing = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                maxIncreasing = Math.max(maxIncreasing, tempIncreasing);
                maxDecreasing = Math.max(maxDecreasing, tempDecreasing);
                tempIncreasing = 1;
                tempDecreasing = 1;
            } else if (nums[i] > nums[i - 1]) {

                if (tempDecreasing > 1) {
                    maxDecreasing = Math.max(maxDecreasing, tempDecreasing);
                    tempDecreasing = 1;
                }
                tempIncreasing++;

            } else {
                if (tempIncreasing > 1) {
                    maxIncreasing = Math.max(maxIncreasing, tempIncreasing);
                    tempIncreasing = 1;
                }
                tempDecreasing++;
            }
        }

        maxIncreasing = Math.max(maxIncreasing, tempIncreasing);
        maxDecreasing = Math.max(maxDecreasing, tempDecreasing);

        return Math.max(maxIncreasing, maxDecreasing);
    }

    public int longestMonotonicSubarray2(int[] nums) {
        int inc = 1;
        int dec = 1;
        int max_len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                inc = dec = 1;
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else {
                inc = 1;
                dec++;
            }
            max_len = Math.max(Math.max(max_len, dec), inc);
        }
        return max_len;
    }

    public static void main(String[] args) {

        L3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray s = new L3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {1, 2, 1, 3, 2};
        int[] nums = {3, 2, 1};

        int res = s.longestMonotonicSubarray(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}