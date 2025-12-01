import java.util.Arrays;

public class L3300_Minimum_Element_After_Replacement_With_Digit_Sum {

    /*
    You are given an integer array nums.

    You replace each element in nums with the sum of its digits.

    Return the minimum element in nums after all replacements.


    Example 1:

    Input: nums = [10,12,13,14]

    Output: 1

    Explanation:

    nums becomes [1, 3, 4, 5] after all replacements, with minimum element 1.

    Example 2:

    Input: nums = [1,2,3,4]

    Output: 1

    Explanation:

    nums becomes [1, 2, 3, 4] after all replacements, with minimum element 1.

    Example 3:

    Input: nums = [999,19,199]

    Output: 10

    Explanation:

    nums becomes [27, 10, 19] after all replacements, with minimum element 10.



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 104
     */
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            min = Math.min(min, sumOfDigits(num));
        }

        return min;
    }

    private int sumOfDigits(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {

        L3300_Minimum_Element_After_Replacement_With_Digit_Sum s = new L3300_Minimum_Element_After_Replacement_With_Digit_Sum();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {10, 12, 13, 14};

        int res = s.minElement(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}