import java.util.Arrays;

public class L3354_Make_Array_Elements_Equal_to_Zero {

    /*
    You are given an integer array nums.

    Start by selecting a starting position curr such that nums[curr] == 0,
    and choose a movement direction of either left or right.

    After that, you repeat the following process:

    If curr is out of the range [0, n - 1], this process ends.
    If nums[curr] == 0, move in the current direction by incrementing curr if you are moving right,
    or decrementing curr if you are moving left.
    Else if nums[curr] > 0:
    Decrement nums[curr] by 1.
    Reverse your movement direction (left becomes right and vice versa).
    Take a step in your new direction.

    A selection of the initial position curr and movement direction
        is considered valid if every element in nums becomes 0 by the end of the process.

    Return the number of possible valid selections.



    Example 1:

    Input: nums = [1,0,2,0,3]

    Output: 2

    Explanation:

    The only possible valid selections are the following:

    Choose curr = 3, and a movement direction to the left.
    [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,1,0,3] -> [1,0,1,0,3] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,0,0,2] -> [1,0,0,0,2] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,0].
    Choose curr = 3, and a movement direction to the right.
    [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,2,0,2] -> [1,0,2,0,2] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,1,0,1] -> [1,0,1,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [0,0,0,0,0].


    Example 2:

    Input: nums = [2,3,4,0,4,1,0]

    Output: 0

    Explanation:

    There are no possible valid selections.



    Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 100
    There is at least one element i where nums[i] == 0.
     */

    public int countValidSelections(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int ans = 0;
        int curSum = 0;
        for (int num : nums) {

            curSum += num;

            if (num == 0) {

                if (sum % 2 == 0 && curSum == sum / 2) {
                    ans += 2;
                } else if (Math.abs(curSum * 2 - sum) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int countValidSelections2(int[] nums) {
        int n = nums.length;
        int res = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; ++i) {
            left[i] = left[i - 1] + nums[i - 1];
            right[n - i - 1] = right[n - i] + nums[n - i];
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) {
                continue;
            }
            if (left[i] == right[i]) {
                res += 2;
            }
            if (Math.abs(left[i] - right[i]) == 1) {
                res += 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        L3354_Make_Array_Elements_Equal_to_Zero s = new L3354_Make_Array_Elements_Equal_to_Zero();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 0, 2, 0, 3};
        // int[] nums = {16, 13, 10, 0, 0, 0, 10, 6, 7, 8, 7};
        // int[] nums = {16, 0, 0, 12, 5};

        int res = s.countValidSelections(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}