public class L3471_Find_the_Largest_Almost_Missing_Integer {

    /*
    You are given an integer array nums and an integer k.

    An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.

    Return the largest almost missing integer from nums. If no such integer exists, return -1.

    A subarray is a contiguous sequence of elements within an array.


    Example 1:

    Input: nums = [3,9,2,1,7], k = 3

    Output: 7

    Explanation:

    1 appears in 2 subarrays of size 3: [9, 2, 1] and [2, 1, 7].
    2 appears in 3 subarrays of size 3: [3, 9, 2], [9, 2, 1], [2, 1, 7].
    3 appears in 1 subarray of size 3: [3, 9, 2].
    7 appears in 1 subarray of size 3: [2, 1, 7].
    9 appears in 2 subarrays of size 3: [3, 9, 2], and [9, 2, 1].
    We return 7 since it is the largest integer that appears in exactly one subarray of size k.

    Example 2:

    Input: nums = [3,9,7,2,1,7], k = 4

    Output: 3

    Explanation:

    1 appears in 2 subarrays of size 4: [9, 7, 2, 1], [7, 2, 1, 7].
    2 appears in 3 subarrays of size 4: [3, 9, 7, 2], [9, 7, 2, 1], [7, 2, 1, 7].
    3 appears in 1 subarray of size 4: [3, 9, 7, 2].
    7 appears in 3 subarrays of size 4: [3, 9, 7, 2], [9, 7, 2, 1], [7, 2, 1, 7].
    9 appears in 2 subarrays of size 4: [3, 9, 7, 2], [9, 7, 2, 1].
    We return 3 since it is the largest and only integer that appears in exactly one subarray of size k.

    Example 3:

    Input: nums = [0,0], k = 1

    Output: -1

    Explanation:

    There is no integer that appears in only one subarray of size 1.



    Constraints:

    1 <= nums.length <= 50
    0 <= nums[i] <= 50
    1 <= k <= nums.length
     */
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;
        int x = nums[0];
        int y = nums[n - 1];
        if (k == 1) {
            int maxValue = -1;
            int[] count = new int[51];
            for (int num : nums) {
                count[num]++;
            }
            for (int i = 0; i < 51; i++) {
                if (count[i] == 1) {
                    maxValue = Math.max(maxValue, i);
                }
            }
            return maxValue;
        }
        if (k == n) {
            int maxValue = -1;
            for (int num : nums) {
                maxValue = Math.max(maxValue, num);
            }
            return maxValue;
        }

        boolean flagX = true;
        boolean flagY = true;
        for (int i = 1; i < n - 1; i++) {
            if (flagX && nums[i] == x) {
                flagX = false;
            }
            if (flagY && nums[i] == y) {
                flagY = false;
            }
        }

        if (flagX && flagY) {
            if (x == y) {
                return -1;
            }
            return Math.max(x, y);
        } else if (flagX) {
            return x;
        } else if (flagY) {
            return y;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        L3471_Find_the_Largest_Almost_Missing_Integer s = new L3471_Find_the_Largest_Almost_Missing_Integer();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {0, 0};
        int k = 1;

        int[] nums2 = {3, 0, 12, 7, 1, 11};
        int k2 = 6;

        int[] nums3 = {10, 12, 9, 7, 10};
        int k3 = 3;

        int[] nums4 = {2, 0, 11, 6, 10, 1, 0, 10};
        int k4 = 2;

        int[] nums5 = {3, 9, 2, 1, 7};
        int k5 = 3;

        int res = s.largestInteger(nums5, k5);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}