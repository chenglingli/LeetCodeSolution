public class L3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array {

    /*
    Given a circular array nums, find the maximum absolute difference between adjacent elements.

    Note: In a circular array, the first and last elements are adjacent.



    Example 1:

    Input: nums = [1,2,4]

    Output: 3

    Explanation:

    Because nums is circular, nums[0] and nums[2] are adjacent. They have the maximum absolute difference of |4 - 1| = 3.

    Example 2:

    Input: nums = [-5,-10,-5]

    Output: 5

    Explanation:

    The adjacent elements nums[0] and nums[1] have the maximum absolute difference of |-5 - (-10)| = 5.



    Constraints:

    2 <= nums.length <= 100
    -100 <= nums[i] <= 100

     */
    public int maxAdjacentDistance(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.max(ans, Math.abs(nums[i] - nums[i + 1]));
        }

        ans = Math.max(ans, Math.abs(nums[0] - nums[nums.length - 1]));

        return ans;
    }

    public static void main(String[] args) {

        L3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array s = new L3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 4};

        int res = s.maxAdjacentDistance(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}