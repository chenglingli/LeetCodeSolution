import java.util.HashMap;
import java.util.Map;

public class L3392_Count_Subarrays_of_Length_Three_With_a_Condition {

    /*
    Given an integer array nums,
    return the number of subarrays of length 3 such that the sum of the first
        and third numbers equals exactly half of the second number.



    Example 1:

    Input: nums = [1,2,1,4,1]

    Output: 1

    Explanation:

    Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.

    Example 2:

    Input: nums = [1,1,1]

    Output: 0

    Explanation:

    [1,1,1] is the only subarray of length 3. However, its first and third numbers do not add to half the middle number.



    Constraints:

    3 <= nums.length <= 100
    -100 <= nums[i] <= 100
     */
    public int countSubarrays(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L3392_Count_Subarrays_of_Length_Three_With_a_Condition s = new L3392_Count_Subarrays_of_Length_Three_With_a_Condition();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 1, 4, 1};

        int res = s.countSubarrays(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}