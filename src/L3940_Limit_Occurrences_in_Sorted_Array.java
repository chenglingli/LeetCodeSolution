import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3940_Limit_Occurrences_in_Sorted_Array {

    /*
    You are given a sorted integer array nums and an integer k.

    Return an array such that each distinct element appears at most k times, while preserving the relative order of the elements in nums.

    Note: If a distinct element appears at least k times, then it must appear exactly k times in the resulting array.



    Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2

    Output: [1,1,2,2,3]

    Explanation:

    Each element can appear at most 2 times.

    The element 1 appears 3 times, so only 2 occurrences are kept.
    The element 2 appears 2 times, so both occurrences are kept.
    The element 3 appears 1 time, so it is kept.
    Thus, the resulting array is [1, 1, 2, 2, 3].

    Example 2:

    Input: nums = [1,2,3], k = 1

    Output: [1,2,3]

    Explanation:

    All elements are distinct and already appear at most once, so the array remains unchanged.



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
    nums is sorted in non-decreasing order.
    1 <= k <= nums.length


    Follow-up:

    Can you solve this in-place using O(1) extra space?
    Note that the space used for returning or resizing the result does not count toward the space complexity mentioned above, as some languages do not support in-place resizing.

     */
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        int i = 0;
        int pre = nums[0];
        int count = 1;

        while (i < n) {
            if (count <= k && nums[i] == pre) {
                list.add(nums[i]);
                count++;
                i++;
            } else {
                while (i < n && nums[i] == pre) {
                    i++;
                }

                if (i < n) {
                    pre = nums[i];
                    count = 1;
                }
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] limitOccurrences2(int[] nums, int k) {

        if (nums.length <= k) {
            return nums;
        }

        int write = k;

        for (int read = k; read < nums.length; read++) {
            if (nums[read] != nums[write - k]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return Arrays.copyOf(nums, write);
    }

    public static void main(String[] args) {

        L3940_Limit_Occurrences_in_Sorted_Array s = new L3940_Limit_Occurrences_in_Sorted_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        //        int[] nums = {5, 5};
        //        int k = 1;

        //        int[] nums = {31,43,43,43};
        //        int k = 2;

        int[] res = s.limitOccurrences2(nums, k);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}