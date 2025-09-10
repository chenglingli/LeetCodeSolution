import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3349_Adjacent_Increasing_Subarrays_Detection_I {

    /*
    Given an array nums of n integers and an integer k,
    determine whether there exist two adjacent subarrays of length k such that both subarrays are strictly increasing.

    Specifically, check if there are two subarrays starting at indices a and b (a < b), where:

    Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
    The subarrays must be adjacent, meaning b = a + k.
    Return true if it is possible to find two such subarrays, and false otherwise.



    Example 1:

    Input: nums = [2,5,7,8,9,2,3,4,3,1], k = 3

    Output: true

    Explanation:

    The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
    The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
    These two subarrays are adjacent, so the result is true.
    Example 2:

    Input: nums = [1,2,3,4,4,4,4,5,6,7], k = 5

    Output: false



    Constraints:

    2 <= nums.length <= 100
    1 < 2 * k <= nums.length
    -1000 <= nums[i] <= 1000
     */

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int[] copyNums = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            copyNums[i] = nums.get(i);
        }

        for (int i = 0; i < nums.size() - k; i++) {
            if (isIncreasing(copyNums, i, k) && isIncreasing(copyNums, i + k, k)) {
                return true;
            }
        }

        return false;
    }

    boolean isIncreasing(int[] nums, int startIndex, int len) {
        int i = startIndex;
        if (startIndex + len > nums.length) {
            return false;
        }

        while (i < startIndex + len - 1) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
            i++;
        }

        return true;
    }

    /*
    双指针同时向前跑，只要满足递增，就计数器加1，如果计数器达到了k-1，则返回true。

     */
    public boolean hasIncreasingSubarrays2(List<Integer> nums, int k) {

        int fai = 0;
        int sai = fai + k;
        int count = 0;

        if (k == 1)
            return true;

        while (sai < nums.size() - 1) {
            if (nums.get(fai + 1) > nums.get(fai) && nums.get(sai + 1) > nums.get(sai)) {
                count++;

                if (count == k - 1) {
                    return true;
                }
            } else {
                count = 0;
            }

            sai++;
            fai++;
        }

        return false;
    }


    public static void main(String[] args) {

        L3349_Adjacent_Increasing_Subarrays_Detection_I s = new L3349_Adjacent_Increasing_Subarrays_Detection_I();
        long sysDate1 = System.currentTimeMillis();

        Integer[] nums = {2, 5, 7, 8, 9, 2, 3, 4, 3, 1};
        int k = 3;
        //        Integer[] nums = {1, 2, 3, 4, 4, 4, 4, 5, 6, 7};
        // int k = 5;
        List<Integer> numArray = Arrays.asList(nums);


        boolean res = s.hasIncreasingSubarrays(numArray, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}