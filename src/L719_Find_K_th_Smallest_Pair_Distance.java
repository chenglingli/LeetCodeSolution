import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L719_Find_K_th_Smallest_Pair_Distance {

    /**
     Given an integer array, return the k-th smallest distance among all the pairs.
     The distance of a pair (A, B) is defined as the absolute difference between A and B.

     Example 1:
     Input:
     nums = [1,3,1]
     k = 1
     Output: 0

     Explanation:
     Here are all the pairs:
     (1,3) -> 2
     (1,1) -> 0
     (3,1) -> 2
     Then the 1st smallest distance pair is (1,1), and its distance is 0.
     Note:
     2 <= len(nums) <= 10000.
     0 <= nums[i] < 1000000.
     1 <= k <= len(nums) * (len(nums) - 1) / 2.
     */


    // 超时
    public int smallestDistancePair3(int[] nums, int k) {

        int N = nums.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(numComparator);

        for (int i = 0 ; i< N ; i++) {
            for (int j = i+1 ; j<N; j++) {
                int tempValue = Math.abs(nums[i] - nums[j]);
                priorityQueue.add(tempValue);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }

        return priorityQueue.peek();
    }

    private Comparator<Integer> numComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer s1, Integer s2) {
            return s2 - s1;
        }
    };

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length, N = 1000000;
        int [] cnt = new int[N];

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                ++cnt[Math.abs(nums[i] - nums[j])];
            }
        }
        for (int i = 0; i < N; ++i) {
            if (cnt[i] >= k)
                return i;
            k -= cnt[i];
        }
        return -1;
    }

    public int smallestDistancePair2(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n-1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2, cnt = 0, start = 0;
            for (int i = 0; i < n; ++i) {
                while (start < n && nums[i] - nums[start] > mid) ++start;
                cnt += i - start;
            }
            if (cnt < k) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    public static void main(String[] args) {

        L719_Find_K_th_Smallest_Pair_Distance s = new L719_Find_K_th_Smallest_Pair_Distance();
        long sysDate1 = System.currentTimeMillis();

        int[] matrix = {1,3,1};

        int res = s.smallestDistancePair2(matrix, 3);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}