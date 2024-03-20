import java.util.PriorityQueue;

public class L215_Kth_Largest_Element_in_an_Array {

    /*
    使用小顶堆
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : nums) {
            minHeap.add(x);
        }

        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    /*
    1 <= k <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4

    使用计数排序
    然后从后往前遍历，k不断减去频次，直到k<=0

     */
    public int findKthLargest2(int[] nums, int k) {
        int[] freq = new int[20001];
        for (int num : nums) {
            ++freq[num + 10000];
        }

        for (int i = freq.length - 1; i >= 0; --i) {
            k -= freq[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {

        L215_Kth_Largest_Element_in_an_Array s = new L215_Kth_Largest_Element_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int res = s.findKthLargest(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}