public class L3483_Unique_3_Digit_Even_Numbers {

    /*
    You are given an array of digits called digits. Your task is to determine the number of distinct three-digit even numbers that can be formed using these digits.

    Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.



    Example 1:

    Input: digits = [1,2,3,4]

    Output: 12

    Explanation: The 12 distinct 3-digit even numbers that can be formed are 124, 132, 134, 142, 214, 234, 312, 314, 324, 342, 412, and 432. Note that 222 cannot be formed because there is only 1 copy of the digit 2.

    Example 2:

    Input: digits = [0,2,2]

    Output: 2

    Explanation: The only 3-digit even numbers that can be formed are 202 and 220. Note that the digit 2 can be used twice because it appears twice in the array.

    Example 3:

    Input: digits = [6,6,6]

    Output: 1

    Explanation: Only 666 can be formed.

    Example 4:

    Input: digits = [1,3,5]

    Output: 0

    Explanation: No even 3-digit numbers can be formed.



    Constraints:

    3 <= digits.length <= 10
    0 <= digits[i] <= 9

     */

    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits)
            freq[digit]++;

        int zero = 0;
        int even = 0;
        int all = 0;

        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                if (i == 0) zero++;
                if (i % 2 == 0) even++;
                all++;
            }
        }

        // 3个数字都不同的情况
        int count = even * (all - 1) * (all - 2);
        if (zero == 1) count -= (even - 1) * (all - 2);

        // 2个数字相同，1个不同的情况
        for (int i = 0; i < 10; i++) {
            if (freq[i] >= 2) {
                if (i == 0) count += all - 1;
                else if (i % 2 == 1) count += even;
                else {
                    count += 3 * (even - 1) - zero;
                    count += 2 * (all - even);
                }
            }
        }

        // 三个数字都相同的情况
        for (int i = 2; i < 10; i += 2) {
            if (freq[i] >= 3) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        L3483_Unique_3_Digit_Even_Numbers s = new L3483_Unique_3_Digit_Even_Numbers();
        long sysDate1 = System.currentTimeMillis();

        int[] digits = {1, 2, 3, 4};
        int res = s.totalNumbers(digits);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}