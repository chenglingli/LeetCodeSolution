import java.util.PriorityQueue;

public class L3066_Minimum_Operations_to_Exceed_Threshold_Value_II {

    /*

    You are given a 0-indexed integer array nums, and an integer k.

    In one operation, you will:

    Take the two smallest integers x and y in nums.
    Remove x and y from nums.
    Add min(x, y) * 2 + max(x, y) anywhere in the array.
    Note that you can only apply the described operation if nums contains at least two elements.

    Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.

    Example 1:

    Input: nums = [2,11,10,1,3], k = 10
    Output: 2
    Explanation: In the first operation, we remove elements 1 and 2, then add 1 * 2 + 2 to nums.
    nums becomes equal to [4, 11, 10, 3].

    In the second operation, we remove elements 3 and 4, then add 3 * 2 + 4 to nums. nums becomes equal to [10, 11, 10].
    At this stage, all the elements of nums are greater than or equal to 10 so we can stop.
    It can be shown that 2 is the minimum number of operations needed so
        that all elements of the array are greater than or equal to 10.

    Example 2:

    Input: nums = [1,1,2,4,9], k = 20
    Output: 4
    Explanation: After one operation, nums becomes equal to [2, 4, 9, 3].
    After two operations, nums becomes equal to [7, 4, 9].
    After three operations, nums becomes equal to [15, 9].
    After four operations, nums becomes equal to [33].
    At this stage, all the elements of nums are greater than 20 so we can stop.
    It can be shown that 4 is the minimum number of operations needed so
        that all elements of the array are greater than or equal to 20.



    2 <= nums.length <= 2 * 10^5
    1 <= nums[i] <= 10^9
    1 <= k <= 10^9
    The input is generated such that an answer always exists.
    That is, there exists some sequence of operations after which
        all elements of the array are greater than or equal to k.
     */
    public int minOperations(int[] nums, int k) {
        // 维护一个小顶堆，每次取出最小的两个元素
        // 每次取出最小的两个元素，然后加上这两个元素的和
        // 直到所有的元素都大于等于k

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            // 如果当前元素小于k，则加入小顶堆中
            if (num < k) {
                minHeap.add((long) num);
            }
        }

        int count = 0;
        while (!minHeap.isEmpty() && minHeap.peek() < k) {
            long x = minHeap.poll();
            count++;

            if (minHeap.isEmpty())
                break;
            long y = minHeap.poll();
            long up = 2 * x + y;
            // 如果加上这两个元素的和还是小于k，则继续加入小顶堆中
            if (up < k)
                minHeap.add(up);
        }

        return count;
    }

    public int minOperations2(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k) pq.add(num);
        }

        int op = 0;

        while (!pq.isEmpty()) {
            int x = pq.poll();
            op++;
            if (pq.isEmpty()) break;
            int y = pq.poll();
            long up = 2l * x + y;
            if (up < k)
                pq.add((int) up);
        }
        return op;
    }

    public static void main(String[] args) {

        L3066_Minimum_Operations_to_Exceed_Threshold_Value_II s = new L3066_Minimum_Operations_to_Exceed_Threshold_Value_II();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {19, 44, 61, 96, 84, 79, 84, 61, 97, 44};
        int k = 44;
        int res = s.minOperations(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}