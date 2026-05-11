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

    核心直觉：排序后的"分水岭"
    假设数组已排序。对于任意两个数 A[i] < A[j]：
    表格
    选择	结果区间
    A[i] 上升, A[j] 下降	(A[i]+K, A[j]-K)
    A[i] 下降, A[j] 上升	(A[i]-K, A[j]+K)

    关键观察：第一个区间永远是第二个区间的子集（或相等）。
    因为：
    A[i]-K ≤ A[i]+K （显然）
    A[j]-K ≤ A[j]+K （显然）
    且 A[i]+K ≤ A[j]+K，A[i]-K ≤ A[j]-K
    所以 (A[i]+K, A[j]-K) 的两端点都落在 (A[i]-K, A[j]+K) 内部，前者范围更小。

    这意味着什么？
    对于任意一对 A[i] < A[j]，让小的上升、大的下降，永远不会让结果更差。
    因此最优策略一定是：排序后找一个分割点，左边全部上升，右边全部下降。
    为什么只需考虑4个极值？
    设分割点在 i 和 i+1 之间（A[i] 是最后一个上升的）：


    上升组:  A[0], A[1], ..., A[i]      →  都变成 +K
    下降组:  A[i+1], ..., A[n-1]        →  都变成 -K

    上升组的最大值 = A[i] + K（因为排序后A[i]是上升组最大）
    上升组的最小值 = A[0] + K（因为A[0]是全局最小）
    下降组的最大值 = A[n-1] - K（A[n-1]是全局最大）
    下降组的最小值 = A[i+1] - K

    整个数组的最大值只可能是 max(A[i]+K, A[n-1]-K)
    整个数组的最小值只可能是 min(A[0]+K, A[i+1]-K)

    其他所有值都被夹在这四个极值之间，对范围计算无贡献。

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