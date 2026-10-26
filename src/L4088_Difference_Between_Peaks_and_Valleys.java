public class L4088_Difference_Between_Peaks_and_Valleys {

    /*
    You are given an integer array nums of length n.

    An index i is called a peak if all of the following conditions hold:

    0 < i < n - 1
    nums[i] > nums[i - 1]
    nums[i] > nums[i + 1]

    An index i is called a valley if all of the following conditions hold:
    0 < i < n - 1
    nums[i] < nums[i - 1]
    nums[i] < nums[i + 1]

    Return an integer denoting the difference between the sum of all peak values and the sum of all valley values.

    Example 1:

    Input: nums = [1,5,2,4,1,3,0]

    Output: 9

    Explanation:
    The peak values are nums[1] = 5, nums[3] = 4, and nums[5] = 3.
    The valley values are nums[2] = 2 and nums[4] = 1.
    The difference between the sum of the peak values and the sum of the valley values is (5 + 4 + 3) - (2 + 1) = 9. Hence, the answer is 9.
    Example 2:

    Input: nums = [-5,-6,-1,-2,5,3,2]

    Output: 12

    Explanation:

    The peak values are nums[2] = -1 and nums[4] = 5.
    The valley values are nums[1] = -6 and nums[3] = -2.
    The difference between the sum of the peak values and the sum of the valley values is (-1 + 5) - (-6 + (-2)) = 12. Hence, the answer is 12.
    Example 3:

    Input: nums = [6,5,2,5,5,3,6]

    Output: -5

    Explanation:

    There are no peak values in the array.
    The valley values are nums[2] = 2 and nums[5] = 3.
    The difference between the sum of the peak values and the sum of the valley values is (0) - (2 + 3) = -5. Hence, the answer is -5.


    Constraints:

    3 <= n == nums.length <= 100
    -100 <= nums[i] <= 100
     */

    public int peakValleyDifference(int[] nums) {
        int peakSum = 0;
        int valleySum = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peakSum += nums[i];
            } else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                valleySum += nums[i];
            }
        }

        return peakSum - valleySum;
    }

    public static void main(String[] args) {

        L4088_Difference_Between_Peaks_and_Valleys s = new L4088_Difference_Between_Peaks_and_Valleys();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 5, 2, 4, 1, 3, 0};

        int res = s.peakValleyDifference(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}