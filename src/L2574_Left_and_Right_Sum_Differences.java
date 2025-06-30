import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2574_Left_and_Right_Sum_Differences {

    /*
    You are given a 0-indexed integer array nums of size n.

    Define two arrays leftSum and rightSum where:

    leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
    rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
    Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.

    Example 1:
    Input: nums = [10,4,8,3]
    Output: [15,1,11,22]
    Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
    The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].

    Example 2:
    Input: nums = [1]
    Output: [0]
    Explanation: The array leftSum is [0] and the array rightSum is [0].
    The array answer is [|0 - 0|] = [0].


    Constraints:

    1 <= nums.length <= 1000
    1 <= nums[i] <= 10^5

     */
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] leftSum = new int[n];
        int [] rightSum = new int[n];

        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        L2574_Left_and_Right_Sum_Differences s = new L2574_Left_and_Right_Sum_Differences();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {10, 4, 8, 3};
        int[] res = s.leftRightDifference(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}