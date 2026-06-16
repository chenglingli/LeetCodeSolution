public class L3895_Count_Digit_Appearances {

    /*
    You are given an integer array nums and an integer digit.

    Return the total number of times digit appears in the decimal representation of all elements in nums.



    Example 1:

    Input: nums = [12,54,32,22], digit = 2

    Output: 4

    Explanation:

    The digit 2 appears once in 12 and 32, and twice in 22. Thus, the total number of times digit 2 appears is 4.

    Example 2:

    Input: nums = [1,34,7], digit = 9

    Output: 0

    Explanation:

    The digit 9 does not appear in the decimal representation of any element in nums, so the total number of times digit 9 appears is 0.



    Constraints:

    1 <= nums.length <= 1000
    1 <= nums[i] <= 10^6
    0 <= digit <= 9

     */
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for (int num : nums) {
            while (num > 0) {
                if ((num % 10) == digit) count++;
                num /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        L3895_Count_Digit_Appearances s = new L3895_Count_Digit_Appearances();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {12, 54, 32, 22};
        int digit = 2;

        int res = s.countDigitOccurrences(nums, digit);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}