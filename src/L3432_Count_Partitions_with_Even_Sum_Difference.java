public class L3432_Count_Partitions_with_Even_Sum_Difference {

    /*
    You are given an integer array nums of length n.

    A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:

    Left subarray contains indices [0, i].
    Right subarray contains indices [i + 1, n - 1].
    Return the number of partitions where the difference between the sum of the left and right subarrays is even.



    Example 1:

    Input: nums = [10,10,3,7,6]

    Output: 4

    Explanation:

    The 4 partitions are:

    [10], [10, 3, 7, 6] with a sum difference of 10 - 26 = -16, which is even.
    [10, 10], [3, 7, 6] with a sum difference of 20 - 16 = 4, which is even.
    [10, 10, 3], [7, 6] with a sum difference of 23 - 13 = 10, which is even.
    [10, 10, 3, 7], [6] with a sum difference of 30 - 6 = 24, which is even.
    Example 2:

    Input: nums = [1,2,2]

    Output: 0

    Explanation:

    No partition results in an even sum difference.

    Example 3:

    Input: nums = [2,4,6,8]

    Output: 3

    Explanation:

    All partitions result in an even sum difference.
     */
    public int countPartitions(int[] nums) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0)
            return 0;

        int ans = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i];
            if (Math.abs(prefixSum - (totalSum - prefixSum)) % 2 == 0)
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L3432_Count_Partitions_with_Even_Sum_Difference s = new L3432_Count_Partitions_with_Even_Sum_Difference();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {10, 10, 3, 7, 6};

        int res = s.countPartitions(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}