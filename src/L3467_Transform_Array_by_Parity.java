import java.util.Arrays;

public class L3467_Transform_Array_by_Parity {

    /*
    You are given an integer array nums.
    Transform nums by performing the following operations in the exact order specified:

    Replace each even number with 0.
    Replace each odd numbers with 1.
    Sort the modified array in non-decreasing order.
    Return the resulting array after performing these operations.


    Example 1:

    Input: nums = [4,3,2,1]

    Output: [0,0,1,1]

    Explanation:

    Replace the even numbers (4 and 2) with 0 and the odd numbers (3 and 1) with 1. Now, nums = [0, 1, 0, 1].
    After sorting nums in non-descending order, nums = [0, 0, 1, 1].
    Example 2:

    Input: nums = [1,5,1,4,2]

    Output: [0,0,1,1,1]

    Explanation:

    Replace the even numbers (4 and 2) with 0 and the odd numbers (1, 5 and 1) with 1. Now, nums = [1, 1, 1, 0, 0].
    After sorting nums in non-descending order, nums = [0, 0, 1, 1, 1].


    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 1000
     */
    public int[] transformArray(int[] nums) {
        int[] res = new int[nums.length];
        int oddCount = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        int n = nums.length;
        for (int i = 0; i < n - oddCount; i++) {
            res[i] = 0;
        }
        for (int i = n - oddCount; i < n; i++) {
            res[i] = 1;
        }

        return res;
    }

    public static void main(String[] args) {

        L3467_Transform_Array_by_Parity s = new L3467_Transform_Array_by_Parity();
        long sysDate1 = System.currentTimeMillis();

        int nums[] = {1, 5, 1, 4, 2};

        int[] res = s.transformArray(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}