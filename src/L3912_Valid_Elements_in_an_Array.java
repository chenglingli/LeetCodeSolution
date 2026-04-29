import java.util.ArrayList;
import java.util.List;

public class L3912_Valid_Elements_in_an_Array {

    /*

    You are given an integer array nums.

    An element nums[i] is considered valid if it satisfies at least one of the following conditions:

    It is strictly greater than every element to its left.
    It is strictly greater than every element to its right.
    The first and last elements are always valid.

    Return an array of all valid elements in the same order as they appear in nums.



    Example 1:

    Input: nums = [1,2,4,2,3,2]

    Output: [1,2,4,3,2]

    Explanation:

    nums[0] and nums[5] are always valid.
    nums[1] and nums[2] are strictly greater than every element to their left.
    nums[4] is strictly greater than every element to its right.
    Thus, the answer is [1, 2, 4, 3, 2].
    Example 2:

    Input: nums = [5,5,5,5]

    Output: [5,5]

    Explanation:

    The first and last elements are always valid.
    No other elements are strictly greater than all elements to their left or to their right.
    Thus, the answer is [5, 5].
    Example 3:

    Input: nums = [1]

    Output: [1]

    Explanation:

    Since there is only one element, it is always valid. Thus, the answer is [1].



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int[] mark = new int[nums.length];
        int max = nums[0];

        int i = 1;
        while (i < nums.length - 1) {
            if (nums[i] > max) {
                mark[i] = 1;
            }

            max = Math.max(nums[i], max);
            i++;
        }

        max = nums[nums.length - 1];
        i = nums.length - 2;
        while (i > 0) {

            if (nums[i] > max) {
                mark[i] = 1;
            }
            max = Math.max(nums[i], max);
            i--;
        }

        for (i = 0; i < nums.length; i++) {
            if (mark[i] == 1 || i == nums.length - 1 || i == 0) {
                res.add(nums[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L3912_Valid_Elements_in_an_Array s = new L3912_Valid_Elements_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

                int[] nums = {1, 2, 4, 2, 3, 2};
//                int[] nums = {1};
//        int[] nums = {4, 1, 7, 7};

//
        List<Integer> res = s.findValidElements(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}