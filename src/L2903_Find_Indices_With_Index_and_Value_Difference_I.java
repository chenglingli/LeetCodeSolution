import java.util.Arrays;

public class L2903_Find_Indices_With_Index_and_Value_Difference_I {

    /*
    You are given a 0-indexed integer array nums having length n, an integer indexDifference, and an integer valueDifference.

    Your task is to find two indices i and j, both in the range [0, n - 1], that satisfy the following conditions:

    abs(i - j) >= indexDifference, and
    abs(nums[i] - nums[j]) >= valueDifference
    Return an integer array answer, where answer = [i, j] if there are two such indices, and answer = [-1, -1] otherwise.
    If there are multiple choices for the two indices, return any of them.

    Note: i and j may be equal.



    Example 1:

    Input: nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
    Output: [0,3]
    Explanation: In this example, i = 0 and j = 3 can be selected.
    abs(0 - 3) >= 2 and abs(nums[0] - nums[3]) >= 4.
    Hence, a valid answer is [0,3].
    [3,0] is also a valid answer.

    Example 2:
    Input: nums = [2,1], indexDifference = 0, valueDifference = 0
    Output: [0,0]
    Explanation: In this example, i = 0 and j = 0 can be selected.
    abs(0 - 0) >= 0 and abs(nums[0] - nums[0]) >= 0.
    Hence, a valid answer is [0,0].
    Other valid answers are [0,1], [1,0], and [1,1].

    Example 3:
    Input: nums = [1,2,3], indexDifference = 2, valueDifference = 4
    Output: [-1,-1]
    Explanation: In this example, it can be shown that it is impossible to find two indices that satisfy both conditions.
    Hence, [-1,-1] is returned.


    Constraints:

    1 <= n == nums.length <= 100
    0 <= nums[i] <= 50
    0 <= indexDifference <= 100
    0 <= valueDifference <= 50
     */
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = new int[2];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i + indexDifference); j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        L2903_Find_Indices_With_Index_and_Value_Difference_I s = new L2903_Find_Indices_With_Index_and_Value_Difference_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {5, 1, 4, 1};
        int indexDifference = 2;
        int valueDifference = 4;

        int[] res = s.findIndices(nums, indexDifference, valueDifference);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}