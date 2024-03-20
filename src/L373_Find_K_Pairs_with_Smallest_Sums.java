import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class L373_Find_K_Pairs_with_Smallest_Sums {

    /*
    1 <= nums1.length, nums2.length <= 10^5
    -10^9 <= nums1[i], nums2[i] <= 10^9
    nums1 and nums2 both are sorted in non-decreasing order.
    1 <= k <= 10^4
    k <= nums1.length * nums2.length

    使用优先队列，存储和最小的pairs，按照sum排序
    不断从优先队列中取出和最小的pair，然后把nums2中的下一个元素和nums1中的当前元素组成新的pair，放入优先队列

     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();

        // 优先队列，存储和最小的pairs，按照sum排序，数组存储两个元素，一个是和，一个是nums2的索引
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 存储 nums1所有元素 和 nums2[0] 的pair，然后按照和排序
        for (int x : nums1) {
            pq.offer(new int[]{x + nums2[0], 0});
        }

        // Pop the k smallest pairs from the priority queue
        while (k > 0 && !pq.isEmpty()) {

            int[] pair = pq.poll();
            int sum = pair[0]; // Get the smallest sum
            int pos = pair[1]; // Get the index of the second element in nums2

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum - nums2[pos]);
            currentPair.add(nums2[pos]);
            res.add(currentPair); // Add the pair to the result list

            // 加入下一个pair
            // 下一个pair是由刚才出去的那个pair变换得来
            // pos+1
            // sum = sum - nums2[pos] + nums2[pos+1]
            if (pos + 1 < nums2.length) {
                pq.offer(new int[]{sum - nums2[pos] + nums2[pos + 1], pos + 1});
            }

            k--;
        }

        return res;
    }

    /*
    方法2：二分查找
    1. 二分查找，找到和最小的pair的和
    2. 二分查找的过程中，统计小于等于mid的pair的个数
    3. 二分查找结束后，找到和最小的pair的和，然后统计小于等于这个和的pair的个数
    4. 生成结果

     */
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {

        int smallest = nums1[0] + nums2[0];
        int largest = nums1[nums1.length - 1] + nums2[nums2.length - 1];

        while (smallest < largest) {

            int midVal = smallest + (largest - smallest) / 2;

            // 统计小于等于midVal的pair的个数
            int smallerOrEqCount = getSmallerOrEqCount(nums1, nums2, k, midVal);

            if (smallerOrEqCount == k) {
                smallest = midVal;
                break;
            } else if (smallerOrEqCount > k) {
                largest = midVal;
            } else {
                smallest = midVal + 1;
            }
        }

        return generateResult(nums1, nums2, smallest, k);
    }

    /*
    统计小于等于val的pair的个数
     */
    public int getSmallerOrEqCount(int[] nums1, int[] nums2, int k, int val) {
        int smallerOrEqCount = 0;

        for (int i = 0; i < nums1.length && nums1[i] + nums2[0] <= val && smallerOrEqCount <= k; i++) {
            smallerOrEqCount += firstLargerIndex(nums2, val - nums1[i]);
        }

        return smallerOrEqCount;
    }

    /*
        在nums数组中，找到第一个大于target的元素的索引
     */
    public int firstLargerIndex(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start] <= target ? start + 1 : start;
    }

    /*
    生成结果

    1. 生成和小于max的pair
    2. 生成和等于max的pair
    3. 用k卡数量

     */
    public List<List<Integer>> generateResult(int[] nums1, int[] nums2, int max, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> eq = new ArrayList<>();

        for (int i = 0; i < nums1.length && k > 0; i++) {
            for (int j = 0; j < nums2.length && (nums1[i] + nums2[j] < max) && k > 0; j++) {
                result.add(Arrays.asList(nums1[i], nums2[j]));
                k--;
            }
        }

        for (int i = 0; i < nums1.length && k > 0; i++) {
            for (int j = 0; j < nums2.length && (nums1[i] + nums2[j] <= max) && k > 0; j++) {
                if (nums1[i] + nums2[j] == max) {
                    result.add(Arrays.asList(nums1[i], nums2[j]));
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        L373_Find_K_Pairs_with_Smallest_Sums s = new L373_Find_K_Pairs_with_Smallest_Sums();

        long sysDate1 = System.currentTimeMillis();

        //        int[] num1 = {1, 7, 11};
        //        int[] num2 = {2, 4, 6};
        //        int k = 2;

        int[] num1 = {1, 2, 4, 5, 6};
        int[] num2 = {3, 5, 7, 9};
        int k = 6;
        List<List<Integer>> res = s.kSmallestPairs2(num1, num2, k);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}