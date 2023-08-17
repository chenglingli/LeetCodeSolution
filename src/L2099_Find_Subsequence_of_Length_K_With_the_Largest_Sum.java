import java.util.*;

public class L2099_Find_Subsequence_of_Length_K_With_the_Largest_Sum {

    /*
    1 <= nums.length <= 1000
    -10^5 <= nums[i] <= 10^5
    1 <= k <= nums.length
     */

    // 优先队列做法，结果需要转化
    public int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(numComparator);
        for (int i = 0; i < nums.length; i++) {

            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(nums[i]);

            priorityQueue.add(temp);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] alLen = new int[nums.length];
        for (List<Integer> l : priorityQueue) {
            alLen[l.get(0)] = l.get(1) + 100001;
        }

        int i = 0;
        int[] ans = new int[k];
        for (int x : alLen) {
            if (x != 0) {
                ans[i++] = x - 1000001;
            }
        }

        return ans;
    }

    private Comparator<List<Integer>> numComparator = new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> s1, List<Integer> s2) {
            return s1.get(1) - s2.get(1);
        }
    };


    // O(N)
    public int[] maxSubsequence2(int[] nums, int k) {

        int[] copy = Arrays.copyOf(nums, nums.length);

        int val = quickSelect(copy, k);

        int dup = 0;
        for (int i = 0; i < k; i++)
            if (copy[i] == val) dup++;

        int[] ans = new int[k];
        int i = 0;
        for (int a : nums) {
            if (a > val || a == val && dup-- > 0)
                ans[i++] = a;
        }

        return ans;
    }

    private int quickSelect(int[] nums, int k) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int p = partition(nums, left, right);
            if (p + 1 < k) {
                left = p + 1;
            } else if (p + 1 > k) {
                right = p - 1;
            } else {
                return nums[p];
            }
        }

        return nums[right];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        for (int j = left + 1; j <= right; j++)
            if (nums[j] > pivot) swap(nums, ++i, j);
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        L2099_Find_Subsequence_of_Length_K_With_the_Largest_Sum s = new L2099_Find_Subsequence_of_Length_K_With_the_Largest_Sum();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {-100000};
        int k = 1;
        int[] res = s.maxSubsequence(nums, k);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}