import java.util.Arrays;

public class L3550_Smallest_Index_With_Digit_Sum_Equal_to_Index {

    /*
    You are given an integer array nums.

    Return the smallest index i such that the sum of the digits of nums[i] is equal to i.

    If no such index exists, return -1.



    Example 1:

    Input: nums = [1,3,2]

    Output: 2

    Explanation:

    For nums[2] = 2, the sum of digits is 2, which is equal to index i = 2. Thus, the output is 2.
    Example 2:

    Input: nums = [1,10,11]

    Output: 1

    Explanation:

    For nums[1] = 10, the sum of digits is 1 + 0 = 1, which is equal to index i = 1.
    For nums[2] = 11, the sum of digits is 1 + 1 = 2, which is equal to index i = 2.
    Since index 1 is the smallest, the output is 1.
    Example 3:

    Input: nums = [1,2,3]

    Output: -1

    Explanation:

    Since no index satisfies the condition, the output is -1.


    Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 1000
     */
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == sumOfDigits(nums[i]))
                return i;
        }
        return -1;
    }

    private int sumOfDigits(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {

        L3550_Smallest_Index_With_Digit_Sum_Equal_to_Index s = new L3550_Smallest_Index_With_Digit_Sum_Equal_to_Index();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 3, 2};

        int res = s.smallestIndex(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}