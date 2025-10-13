import java.util.Arrays;

public class L3079_Find_the_Sum_of_Encrypted_Integers {

    /*

    You are given an integer array nums containing positive integers.
    We define a function encrypt such that encrypt(x) replaces every digit in x with the largest digit in x.

    For example, encrypt(523) = 555 and encrypt(213) = 333.

    Return the sum of encrypted elements.



    Example 1:

    Input: nums = [1,2,3]

    Output: 6

    Explanation: The encrypted elements are [1,2,3]. The sum of encrypted elements is 1 + 2 + 3 == 6.

    Example 2:

    Input: nums = [10,21,31]

    Output: 66

    Explanation: The encrypted elements are [11,22,33]. The sum of encrypted elements is 11 + 22 + 33 == 66.



    Constraints:

    1 <= nums.length <= 50
    1 <= nums[i] <= 1000
     */

    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += encrypt(num);
        }

        return sum;
    }

    private int encrypt(int num) {
        int maxDigit = 0;
        int len = 0;

        while (num > 0) {
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
            len++;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += maxDigit * (int) (Math.pow(10, i));
        }

        return res;
    }


    public static void main(String[] args) {

        L3079_Find_the_Sum_of_Encrypted_Integers s = new L3079_Find_the_Sum_of_Encrypted_Integers();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {10, 21, 31};

        int res = s.sumOfEncryptedInt(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}