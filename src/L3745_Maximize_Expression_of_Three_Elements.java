import java.util.*;

public class L3745_Maximize_Expression_of_Three_Elements {

    /*
    You are given an integer array nums.

    Choose three elements a, b, and c from nums at distinct indices such that the value of the expression a + b - c is maximized.

    Return an integer denoting the maximum possible value of this expression.



    Example 1:

    Input: nums = [1,4,2,5]

    Output: 8

    Explanation:

    We can choose a = 4, b = 5, and c = 1. The expression value is 4 + 5 - 1 = 8, which is the maximum possible.

    Example 2:

    Input: nums = [-2,0,5,-2,4]

    Output: 11

    Explanation:

    We can choose a = 5, b = 4, and c = -2. The expression value is 5 + 4 - (-2) = 11, which is the maximum possible.



    Constraints:

    3 <= nums.length <= 100
    -100 <= nums[i] <= 100

     */
    public int maximizeExpressionOfThree(int[] nums) {
        // 寻找最大的两个数（a，b）和最小的一个数（c），结果为 a + b- c

        int a = -100;
        int b = -100;
        int c = 100;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            }
            else if (nums[i] > b) {
                b = nums[i];
            }

            c = Math.min(c, nums[i]);

        }

        return a + b - c;
    }

    public static void main(String[] args) {

        L3745_Maximize_Expression_of_Three_Elements s = new L3745_Maximize_Expression_of_Three_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 4, 2, 5};
        int res = s.maximizeExpressionOfThree(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}