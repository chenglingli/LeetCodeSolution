import java.util.Arrays;

public class L3925_Concatenate_Array_With_Reverse {

    /*
    You are given an integer array nums of length n.

    Construct a new array ans of length 2 * n such that the first n elements are the same as nums, and the next n elements are the elements of nums in reverse order.

    Formally, for 0 <= i <= n - 1:

    ans[i] = nums[i]
    ans[i + n] = nums[n - i - 1]
    Return an integer array ans.



    Example 1:

    Input: nums = [1,2,3]

    Output: [1,2,3,3,2,1]

    Explanation:

    The first n elements of ans are the same as nums.

    For the next n = 3 elements, each element is taken from nums in reverse order:

    ans[3] = nums[2] = 3
    ans[4] = nums[1] = 2
    ans[5] = nums[0] = 1
    Thus, ans = [1, 2, 3, 3, 2, 1].

    Example 2:

    Input: nums = [1]

    Output: [1,1]

    Explanation:

    The array remains the same when reversed. Thus, ans = [1, 1].



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    public int[] concatWithReverse(int[] nums) {
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[nums.length + i] = nums[nums.length - i - 1];
        }
        return res;
    }

    public static void main(String[] args) {

        L3925_Concatenate_Array_With_Reverse s = new L3925_Concatenate_Array_With_Reverse();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3};

        int[] res = s.concatWithReverse(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}