import java.util.Arrays;

public class L4074_Maximum_Product_Pair_With_Target_Sum {

    /*
    You are given an integer array nums and an integer target.

    A pair of distinct indices (i, j) is valid if:

    nums[i] + nums[j] == target
    nums[i] > nums[j]
    Return a valid pair [i, j] whose product nums[i] * nums[j] is maximum among all valid pairs. If no valid pair exists, return [-1, -1].

    If multiple valid pairs achieve the maximum product, you may return any of them.



    Example 1:

    Input: nums = [1,2,3,4], target = 5

    Output: [2,1]

    Explanation:

    There are 2 valid pairs:

    No.	(i, j)	nums[i]	nums[j]	Sum	Product
    1	(3, 0)	4	1	5	4
    2	(2, 1)	3	2	5	6
    Both pairs sum to 5 and satisfy nums[i] > nums[j]. The second pair has the larger product, 3 * 2 = 6, so the answer is [2, 1].

    Example 2:

    Input: nums = [-3,-1,4,2], target = 1

    Output: [3,1]

    Explanation:

    There are 2 valid pairs:

    No.	(i, j)	nums[i]	nums[j]	Sum	Product
    1	(2, 0)	4	-3	1	-12
    2	(3, 1)	2	-1	1	-2
    Since -2 > -12, the pair at indices (3, 1) is chosen and the answer is [3, 1].

    Example 3:

    Input: nums = [3,3,5], target = 6

    Output: [-1,-1]

    Explanation:

    No valid pair exists, since nums[0] and nums[1] sum to 6 but are equal.



    Constraints:

    2 <= nums.length <= 100
    -100 <= nums[i], target <= 100
     */
    public int[] maxProductPair(int[] nums, int target) {
        int[] res = {-1, -1};
        int curMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                if (nums[i] + nums[j] == target && nums[i] * nums[j] > curMax) {
                    if (nums[i] > nums[j]) {
                        res[0] = i;
                        res[1] = j;
                    } else {
                        res[0] = j;
                        res[1] = i;
                    }
                    curMax = nums[i] * nums[j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L4074_Maximum_Product_Pair_With_Target_Sum s = new L4074_Maximum_Product_Pair_With_Target_Sum();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4};
        int target = 5;

        int[] res = s.maxProductPair(nums, target);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}