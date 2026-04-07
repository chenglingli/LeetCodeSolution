public class L3880_Minimum_Absolute_Difference_Between_Two_Values {

    /*
    You are given an integer array nums consisting only of 0, 1, and 2.

    A pair of indices (i, j) is called valid if nums[i] == 1 and nums[j] == 2.

    Return the minimum absolute difference between i and j among all valid pairs. If no valid pair exists, return -1.

    The absolute difference between indices i and j is defined as abs(i - j).



    Example 1:

    Input: nums = [1,0,0,2,0,1]

    Output: 2

    Explanation:

    The valid pairs are:

    (0, 3) which has absolute difference of abs(0 - 3) = 3.
    (5, 3) which has absolute difference of abs(5 - 3) = 2.
    Thus, the answer is 2.

    Example 2:

    Input: nums = [1,0,1,0]

    Output: -1

    Explanation:

    There are no valid pairs in the array, thus the answer is -1.



    Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 2

     */
    public int minAbsoluteDifference(int[] nums) {
        // 思路，找到1和2的索引，然后计算差值
        // 遍历，找到1后，找下一个2。
        // 找到2后，找下一个1，然后计算差值
        // 优化：如果存在，最小值一定是1。如果不存在就是-1

        int min = Integer.MAX_VALUE;
        int i = 0;
        int n = nums.length;

        while (i < n) {

            if (nums[i] == 1) {
                int j = i + 1;
                while (j < n) {
                    if (nums[j] == 2) {
                        min = Math.min(min, j - i);
                        break;
                    }
                    j++;
                }
                if (min == 1) {
                    return min;
                }
            }

            if (nums[i] == 2) {
                int j = i + 1;
                while (j < n) {
                    if (nums[j] == 1) {
                        min = Math.min(min, j - i);
                        break;
                    }
                    j++;
                }
                if (min == 1) {
                    return min;
                }
            }

            i++;
        }

        return min != Integer.MAX_VALUE ? min : -1;
    }

    public int minAbsoluteDifference2(int[] nums) {

        int l1 = -1, l2 = -1, minD = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                l1 = i;
                if (l2 != -1) {
                    minD = Math.min(minD, Math.abs(l1 - l2));
                }

            } else if (nums[i] == 2) {
                l2 = i;
                if (l1 != -1) {
                    minD = Math.min(minD, Math.abs(l2 - l1));
                }
            }

            if (minD == 1)  {
                return 1;
            }
        }

        return (minD == Integer.MAX_VALUE) ? -1 : minD;
    }

    public static void main(String[] args) {

        L3880_Minimum_Absolute_Difference_Between_Two_Values s = new L3880_Minimum_Absolute_Difference_Between_Two_Values();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 0, 0, 2, 0, 1};

        int res = s.minAbsoluteDifference(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}