public class L2656_Maximum_Sum_With_Exactly_K_Elements {

    /*
    You are given a 0-indexed integer array nums and an integer k.
    Your task is to perform the following operation exactly k times in order to maximize your score:

    Select an element m from nums.
    Remove the selected element m from the array.
    Add a new element with a value of m + 1 to the array.
    Increase your score by m.
    Return the maximum score you can achieve after performing the operation exactly k times.



    Example 1:

    Input: nums = [1,2,3,4,5], k = 3
    Output: 18
    Explanation: We need to choose exactly 3 elements from nums to maximize the sum.
    For the first iteration, we choose 5. Then sum is 5 and nums = [1,2,3,4,6]
    For the second iteration, we choose 6. Then sum is 5 + 6 and nums = [1,2,3,4,7]
    For the third iteration, we choose 7. Then sum is 5 + 6 + 7 = 18 and nums = [1,2,3,4,8]
    So, we will return 18.
    It can be proven, that 18 is the maximum answer that we can achieve.
    Example 2:

    Input: nums = [5,5,5], k = 2
    Output: 11
    Explanation: We need to choose exactly 2 elements from nums to maximize the sum.
    For the first iteration, we choose 5. Then sum is 5 and nums = [5,5,6]
    For the second iteration, we choose 6. Then sum is 5 + 6 = 11 and nums = [5,5,7]
    So, we will return 11.
    It can be proven, that 11 is the maximum answer that we can achieve.


    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
    1 <= k <= 100
     */
    public int maximizeSum(int[] nums, int k) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(num, maxValue);
        }

        int sum = ((maxValue + k - 1) + maxValue) * k / 2;
        return sum;
    }


    public static void main(String[] args) {

        L2656_Maximum_Sum_With_Exactly_K_Elements s = new L2656_Maximum_Sum_With_Exactly_K_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int res = s.maximizeSum(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}