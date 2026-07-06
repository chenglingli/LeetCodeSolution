public class L3978_Unique_Middle_Element {

    /*
    You are given an integer array nums of odd length n.

    Return true if the middle element of nums appears exactly once in the array. Otherwise return false.


    Example 1:

    Input: nums = [1,2,3]

    Output: true

    Explanation:

    The middle element of nums is 2, which appears exactly once.

    Thus, the answer is true.

    Example 2:

    Input: nums = [1,2,2]

    Output: false

    Explanation:

    The middle element of nums is 2, which appears twice.

    Thus, the answer is false.



    Constraints:

    1 <= n == nums.length <= 100
    n is odd.
    1 <= nums[i] <= 100
     */
    public boolean isMiddleElementUnique(int[] nums) {
        int mid = nums.length / 2;
        int midVal = nums[mid];
        for (int i = 0; i < nums.length; i++) {
            if (i != mid && midVal == nums[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        L3978_Unique_Middle_Element s = new L3978_Unique_Middle_Element();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3};
        boolean res = s.isMiddleElementUnique(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}