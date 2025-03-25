import java.util.PriorityQueue;
import java.util.Queue;

public class L703_Kth_Largest_Element_in_a_Stream {

    /*
    You are part of a university admissions office
        and need to keep track of the kth highest test score from applicants in real-time.
    This helps to determine cut-off marks for interviews
        and admissions dynamically as new applicants submit their scores.

    You are tasked to implement a class which,
        for a given integer k, maintains a stream of test scores
            and continuously returns the kth highest test score after a new score has been submitted.
        More specifically, we are looking for the kth highest score in the sorted list of all scores.

    Implement the KthLargest class:

    KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
    int add(int val) Adds a new test score val to the stream
        and returns the element representing the kth largest element in the pool of test scores so far.


    Example 1:

    Input:
    ["KthLargest", "add", "add", "add", "add", "add"]
    [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]

    Output: [null, 4, 5, 5, 8, 8]

    Explanation:

    KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
    kthLargest.add(3); // return 4
    kthLargest.add(5); // return 5
    kthLargest.add(10); // return 5
    kthLargest.add(9); // return 8
    kthLargest.add(4); // return 8

    Example 2:

    Input:
    ["KthLargest", "add", "add", "add", "add"]
    [[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]

    Output: [null, 7, 7, 7, 8]

    Explanation:

    KthLargest kthLargest = new KthLargest(4, [7, 7, 7, 7, 8, 3]);
    kthLargest.add(2); // return 7
    kthLargest.add(10); // return 7
    kthLargest.add(9); // return 7
    kthLargest.add(9); // return 8


    Constraints:

    0 <= nums.length <= 10^4
    1 <= k <= nums.length + 1
    -10^4 <= nums[i] <= 10^4
    -10^4 <= val <= 10^4
    At most 10^4 calls will be made to add.

    */

    static class KthLargest {


        // 小顶堆，存储最大的k个数
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> (x - y));
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            // 如果队列的大小小于k
            if (queue.size() < k) {
                // 将val加入队列
                queue.offer(val);
            } else {
                // 如果val大于队列头部的元素
                if (val > queue.peek()) {
                    // 将队列头部的元素移除
                    queue.poll();
                    // 将val加入队列
                    queue.offer(val);
                }
            }

            // 返回队列头部的元素
            return queue.peek();
        }

    }

    public static void main(String[] args) {

        L703_Kth_Largest_Element_in_a_Stream s = new L703_Kth_Largest_Element_in_a_Stream();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 5, 8, 2};

        KthLargest k = new KthLargest(3, nums);
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}