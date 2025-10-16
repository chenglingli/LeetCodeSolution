import java.util.HashMap;
import java.util.Map;

public class L3095_Shortest_Subarray_With_OR_at_Least_K_I {

    /*

    You are given an array nums of non-negative integers and an integer k.

    An array is called special if the bitwise OR of all of its elements is at least k.

    Return the length of the shortest special non-empty subarray of nums, or return -1 if no special subarray exists.



    Example 1:

    Input: nums = [1,2,3], k = 2

    Output: 1

    Explanation:

    The subarray [3] has OR value of 3. Hence, we return 1.

    Note that [2] is also a special subarray.

    Example 2:

    Input: nums = [2,1,8], k = 10

    Output: 3

    Explanation:

    The subarray [2,1,8] has OR value of 11. Hence, we return 3.

    Example 3:

    Input: nums = [1,2], k = 0

    Output: 1

    Explanation:

    The subarray [1] has OR value of 1. Hence, we return 1.



    Constraints:

    1 <= nums.length <= 50
    0 <= nums[i] <= 50
    0 <= k < 64

     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = nums.length + 1;

        for (int i = 0; i < nums.length; ++i) {
            long or = 0;
            for (int j = i; j < nums.length; ++j) {
                or |= nums[j];
                if (or >= k) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }

        return ans > nums.length ? -1 : ans;
    }

    public int minimumSubarrayLength2(int[] nums, int k) {

        int min = nums.length;
        int temp = 0;
        boolean found = false;
        int i = 0, j = 0;

        while (j < nums.length) {
            temp = temp | nums[j];
            while (temp >= k && i <= j) {
                min = Math.min(min, j - i + 1);
                found = true;
                if (i == j) {
                    break;
                }
                i++;
                temp = 0;
                for (int m = i; m <= j; m++) {
                    temp = temp | nums[m];
                }
            }
            j++;
        }

        return found ? min : -1;
    }

    public static void main(String[] args) {

        L3095_Shortest_Subarray_With_OR_at_Least_K_I s = new L3095_Shortest_Subarray_With_OR_at_Least_K_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3};
        int k = 2;

        int res = s.minimumSubarrayLength(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}