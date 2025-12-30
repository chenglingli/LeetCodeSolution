import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3701_Compute_Alternating_Sum {

    /*
    You are given an integer array nums.

    The alternating sum of nums is the value obtained by adding elements at even indices and subtracting elements at odd indices.
    That is, nums[0] - nums[1] + nums[2] - nums[3]...

    Return an integer denoting the alternating sum of nums.



    Example 1:

    Input: nums = [1,3,5,7]

    Output: -4

    Explanation:

    Elements at even indices are nums[0] = 1 and nums[2] = 5 because 0 and 2 are even numbers.
    Elements at odd indices are nums[1] = 3 and nums[3] = 7 because 1 and 3 are odd numbers.
    The alternating sum is nums[0] - nums[1] + nums[2] - nums[3] = 1 - 3 + 5 - 7 = -4.
    Example 2:

    Input: nums = [100]

    Output: 100

    Explanation:

    The only element at even indices is nums[0] = 100 because 0 is an even number.
    There are no elements on odd indices.
    The alternating sum is nums[0] = 100.


    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
     */
    public int alternatingSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            } else {
                sum -= nums[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        L3701_Compute_Alternating_Sum s = new L3701_Compute_Alternating_Sum();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 3, 5, 7};

        int res = s.alternatingSum(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}