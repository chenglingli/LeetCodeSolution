import java.util.Arrays;
import java.util.PriorityQueue;

public class L3774_Absolute_Difference_Between_Maximum_and_Minimum_K_Elements {

    /*
    You are given an integer array nums and an integer k.

    Find the absolute difference between:

    the sum of the k largest elements in the array; and
    the sum of the k smallest elements in the array.
    Return an integer denoting this difference.


    Example 1:

    Input: nums = [5,2,2,4], k = 2

    Output: 5

    Explanation:

    The k = 2 largest elements are 4 and 5. Their sum is 4 + 5 = 9.
    The k = 2 smallest elements are 2 and 2. Their sum is 2 + 2 = 4.
    The absolute difference is abs(9 - 4) = 5.

    Example 2:
    Input: nums = [100], k = 1

    Output: 0

    Explanation:

    The largest element is 100.
    The smallest element is 100.
    The absolute difference is abs(100 - 100) = 0.


    Constraints:

    1 <= n == nums.length <= 100
    1 <= nums[i] <= 100
    1 <= k <= n

     */
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int sum1 = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            sum1 += nums[i];
        }

        int sum2 = 0;
        for (int i = 0; i < k; i++) {
            sum2 += nums[i];
        }

        return Math.abs(sum1 - sum2);
    }

    public int absDifference2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 最小堆
        for (int n : nums)
            pq.offer(n); // 将所有元素加入堆中

        int sum = 0, minElem = k; // sum为结果，minElem记录剩余最小元素数量
        while (!pq.isEmpty()) {
            if (minElem > 0)
                sum -= pq.peek(); // 减去最小的k个元素

            if (pq.size() <= k)
                sum += pq.peek(); // 加上剩余的元素

            minElem--;
            pq.poll();
        }

        return sum; // 返回绝对差值
    }

    public static void main(String[] args) {

        L3774_Absolute_Difference_Between_Maximum_and_Minimum_K_Elements s = new L3774_Absolute_Difference_Between_Maximum_and_Minimum_K_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {5, 2, 2, 4};
        int k = 2;
        int res = s.absDifference(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}