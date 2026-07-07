import java.util.Arrays;

public class L3982_Sum_of_Integers_with_Maximum_Digit_Range {

    /*
    You are given an integer array nums.

    The digit range of an integer is defined as the difference between its largest digit and smallest digit.

    For example, the digit range of 5724 is 7 - 2 = 5.

    Return the sum of all integers in nums whose digit range is equal to the maximum digit range among all integers in the array.



    Example 1:

    Input: nums = [5724,111,350]

    Output: 6074

    Explanation:

    i	nums[i]	Largest	Smallest	Digit Range
    0	5724	7	2	5
    1	111	1	1	0
    2	350	5	0	5
    The maximum digit range is 5. The integers with this digit range are 5724 and 350, so the answer is 5724 + 350 = 6074.

    Example 2:

    Input: nums = [90,900]

    Output: 990

    Explanation:

    i	nums[i]	Largest	Smallest	Digit Range
    0	90	9	0	9
    1	900	9	0	9
    The maximum digit range is 9. Both integers have this digit range, so the answer is 90 + 900 = 990.



    Constraints:

    1 <= nums.length <= 100
    10 <= nums[i] <= 105
     */
    public int maxDigitRange(int[] nums) {
        int maxRange = 0;
        for (int num : nums) {
            maxRange = Math.max(maxRange, getDigitRange(num));
        }

        int sum = 0;
        for (int num : nums) {
            if (getDigitRange(num) == maxRange) {
                sum += num;
            }
        }

        return sum;
    }

    private int getDigitRange(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return Character.digit(digits[digits.length - 1], 10) - Character.digit(digits[0], 10);
    }

    public int maxDigitRange2(int[] nums) {

        int length = nums.length;
        // 记录第i的数字的最大最小差值
        int[] arr = new int[length];
        int mx = 0;

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int max = -1;
            int min = 10;
            while (num > 0) {
                max = Math.max(max, num % 10);
                min = Math.min(min, num % 10);
                num /= 10;
            }
            int diff = max - min;
            arr[i] = diff;
            mx = Math.max(mx, diff);
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == mx) {
                res += nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L3982_Sum_of_Integers_with_Maximum_Digit_Range s = new L3982_Sum_of_Integers_with_Maximum_Digit_Range();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {5724, 111, 350};
        int res = s.maxDigitRange(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}