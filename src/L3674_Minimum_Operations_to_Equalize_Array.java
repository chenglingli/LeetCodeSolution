import java.util.Arrays;

public class L3674_Minimum_Operations_to_Equalize_Array {

    /*

    You are given an integer array nums of length n.

    In one operation, choose any subarray nums[l...r] (0 <= l <= r < n)
        and replace each element in that subarray with the bitwise AND of all elements.

    Return the minimum number of operations required to make all elements of nums equal.

    A subarray is a contiguous non-empty sequence of elements within an array.


    Example 1:

    Input: nums = [1,2]

    Output: 1

    Explanation:

    Choose nums[0...1]: (1 AND 2) = 0, so the array becomes [0, 0] and all elements are equal in 1 operation.

    Example 2:

    Input: nums = [5,5,5]

    Output: 0

    Explanation:

    nums is [5, 5, 5] which already has all elements equal, so 0 operations are required.



    Constraints:

    1 <= n == nums.length <= 100
    1 <= nums[i] <= 10^5
     */
    public int minOperations(int[] nums) {
        int x = nums[0];

        int i = 1;
        while (i < nums.length) {
            if (x != nums[i]) {
                return 1;
            }
            i++;
        }

        return 0;
    }

    public static void main(String[] args) {

        L3674_Minimum_Operations_to_Equalize_Array s = new L3674_Minimum_Operations_to_Equalize_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2};

        int res = s.minOperations(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}