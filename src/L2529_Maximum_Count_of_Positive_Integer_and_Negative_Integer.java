public class L2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer {

    /*
    Given an array nums sorted in non-decreasing order,
        return the maximum between the number of positive integers and the number of negative integers.

    In other words, if the number of positive integers in nums is pos and the number of negative integers is neg,
    then return the maximum of pos and neg.
    Note that 0 is neither positive nor negative.



    Example 1:

    Input: nums = [-2,-1,-1,1,2,3]
    Output: 3
    Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

    Example 2:
    Input: nums = [-3,-2,-1,0,0,1,2]
    Output: 3
    Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.

    Example 3:
    Input: nums = [5,20,66,1314]
    Output: 4
    Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.


    Constraints:

    1 <= nums.length <= 2000
    -2000 <= nums[i] <= 2000
    nums is sorted in a non-decreasing order.

     */
    public int maximumCount(int[] nums) {

        // 二分查找，找到第一个正数
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 有可能没有正数，但是left = n-1, 需要positiveIndex = n;
        int positiveIndex = left;
        if (nums[left] == 0) {
            positiveIndex = left + 1;
        }

        // 找到第一个负数
        int negativeIndex = left;
        while (negativeIndex >= 0 && nums[negativeIndex] >= 0) {
            negativeIndex--;
        }

        // 比较正数和负数个数
        return Math.max(negativeIndex + 1, n - positiveIndex);

    }

    public int maximumCount2(int[] nums) {

        int posCount = 0;
        int negCount = 0;
        for (int num : nums) {
            if (num > 0) posCount++;
            else if (num < 0) negCount++;
        }
        return Math.max(posCount, negCount);
    }

    public static void main(String[] args) {

        L2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer s = new L2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {-2, -1, -1, 1, 2, 3};
        // int[] nums = {5, 20, 66, 1314};
        int[] nums = {0, 0 ,0};
        int res = s.maximumCount(nums);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}