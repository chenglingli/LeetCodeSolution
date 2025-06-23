public class L2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array {

    /*
    You are given a positive integer array nums.

    The element sum is the sum of all the elements in nums.
    The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.
    Return the absolute difference between the element sum and digit sum of nums.

    Note that the absolute difference between two integers x and y is defined as |x - y|.



    Example 1:

    Input: nums = [1,15,6,3]
    Output: 9
    Explanation:
    The element sum of nums is 1 + 15 + 6 + 3 = 25.
    The digit sum of nums is 1 + 1 + 5 + 6 + 3 = 16.
    The absolute difference between the element sum and digit sum is |25 - 16| = 9.
    Example 2:

    Input: nums = [1,2,3,4]
    Output: 0
    Explanation:
    The element sum of nums is 1 + 2 + 3 + 4 = 10.
    The digit sum of nums is 1 + 2 + 3 + 4 = 10.
    The absolute difference between the element sum and digit sum is |10 - 10| = 0.


    Constraints:

    1 <= nums.length <= 2000
    1 <= nums[i] <= 2000

     */
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;

        for (int x : nums) {
            sum += x;
            digitSum += getDigitSum(x);
        }

        return Math.abs(sum - digitSum);
    }

    private int getDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public int differenceOfSum2(int[] nums) {
        // Method - 3. Optimiesd Approach. TC - O(n). SC - O(1).

        int sum = 0;

        for(int num : nums) {
            sum += (num - (num / 1000 + (num / 100) % 10 + (num / 10) % 10 + (num % 10)));
        }

        return Math.abs(sum);
    }

    public static void main(String[] args) {

        L2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array s = new L2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int [] nums = {1,15,6,3};
        int res = s.differenceOfSum(nums);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}