import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L910_Smallest_Range_II {

    private static final int MOD = 1_000_000_007;

    /*

    You are given an integer array nums and an integer k.

    For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.

    The score of nums is the difference between the maximum and minimum elements in nums.

    Return the minimum score of nums after changing the values at each index.



    Example 1:

    Input: nums = [1], k = 0
    Output: 0
    Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
    Example 2:

    Input: nums = [0,10], k = 2
    Output: 6
    Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
    Example 3:

    Input: nums = [1,3,6], k = 3
    Output: 3
    Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.


    Constraints:
    1 <= nums.length <= 10^4
    0 <= nums[i] <= 10^4
    0 <= k <= 10^4

     */

    /*

    Intuition

    As in Smallest Range I, smaller A[i] will choose to increase their value ("go up"), and bigger A[i] will decrease their value ("go down").

    Algorithm

    We can formalize the above concept: if A[i] < A[j], we don't need to consider when A[i] goes down while A[j] goes up.
    This is because the interval (A[i] + K, A[j] - K) is a subset of (A[i] - K, A[j] + K) (here, (a, b) for a > b denotes (b, a) instead.)

    That means that it is never worse to choose (up, down) instead of (down, up).
    We can prove this claim that one interval is a subset of another, by showing both A[i] + K and A[j] - K are between A[i] - K and A[j] + K.

    For sorted A, say A[i] is the largest i that goes up.
    Then A[0] + K, A[i] + K, A[i+1] - K, A[A.length - 1] - K are the only relevant values for calculating the answer: every other value is between one of these extremal values.

     */
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = nums[n - 1] - nums[0];

        for (int i = 0; i < n - 1; ++i) {
            // 逻辑：枚举nums[i]作为最大值，枚举nums[i+1]作为最小值
            ans = Math.min(ans,
                    Math.max(nums[i] + k, nums[n - 1] - k)
                            - Math.min(nums[0] + k, nums[i + 1] - k));
        }

        return (int) ans;
    }

    public static void main(String[] args) {

        L910_Smallest_Range_II s = new L910_Smallest_Range_II();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 3, 6};
        int k = 3;

        int res = s.smallestRangeII(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}