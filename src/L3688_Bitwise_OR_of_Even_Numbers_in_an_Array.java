public class L3688_Bitwise_OR_of_Even_Numbers_in_an_Array {

    /*
    You are given an integer array nums.

    Return the bitwise OR of all even numbers in the array.

    If there are no even numbers in nums, return 0.



    Example 1:

    Input: nums = [1,2,3,4,5,6]

    Output: 6

    Explanation:

    The even numbers are 2, 4, and 6. Their bitwise OR equals 6.

    Example 2:

    Input: nums = [7,9,11]

    Output: 0

    Explanation:

    There are no even numbers, so the result is 0.

    Example 3:

    Input: nums = [1,8,16]

    Output: 24

    Explanation:

    The even numbers are 8 and 16. Their bitwise OR equals 24.



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
     */
    public int evenNumberBitwiseORs(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans |= num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        L3688_Bitwise_OR_of_Even_Numbers_in_an_Array s = new L3688_Bitwise_OR_of_Even_Numbers_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4, 5, 6};

        int res = s.evenNumberBitwiseORs(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}