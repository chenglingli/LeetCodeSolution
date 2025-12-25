import java.util.Arrays;

public class L3507_Minimum_Pair_Removal_to_Sort_Array_I {

    /*
    Given an array nums, you can perform the following operation any number of times:

    Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
    Replace the pair with their sum.
    Return the minimum number of operations needed to make the array non-decreasing.

    An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).



    Example 1:

    Input: nums = [5,2,3,1]

    Output: 2

    Explanation:

    The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
    The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
    The array nums became non-decreasing in two operations.

    Example 2:

    Input: nums = [1,2,2]

    Output: 0

    Explanation:

    The array nums is already sorted.


    Constraints:

    1 <= nums.length <= 50
    -1000 <= nums[i] <= 1000
     */
    public int minimumPairRemoval(int[] nums) {

        int count = 0;
        int len = nums.length;

        while (!isSorted(nums, len)) {

            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;

            // 寻找最小的相邻元素对
            for (int i = 0; i < len - 1; i++) {
                int tempValue = nums[i] + nums[i + 1];
                if (tempValue < minValue) {
                    minValue = tempValue;
                    minIndex = i;
                }
            }

            // 替换最小的相邻元素对
            nums[minIndex] = minValue;
            for (int i = minIndex + 1; i < nums.length - 1; i++) {
                nums[i] = nums[i + 1];
            }

            // 数组长度减1，操作数加1
            len--;
            count++;
        }

        return count;
    }

    private boolean isSorted(int[] nums, int len) {
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > nums[i])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

        L3507_Minimum_Pair_Removal_to_Sort_Array_I s = new L3507_Minimum_Pair_Removal_to_Sort_Array_I();
        long sysDate1 = System.currentTimeMillis();

//        int[] nums = {5, 2, 3, 1};
        int[] nums = {1,2,2};

        int res = s.minimumPairRemoval(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}