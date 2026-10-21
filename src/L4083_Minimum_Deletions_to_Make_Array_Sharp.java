public class L4083_Minimum_Deletions_to_Make_Array_Sharp {

    /*
    You are given an integer array nums.

    You may delete any number of elements from nums. The remaining elements keep their original order.

    The resulting array a is sharp if the bitwise XOR of every pair of adjacent elements is non-zero.
    That is, a[i] XOR a[i + 1] != 0 for every index i such that 0 <= i < a.length - 1. An array with at most one element is sharp.

    Return the minimum number of deletions needed to make nums sharp.

    Bitwise XOR compares the corresponding bits of two integers. A bit in the result is 1 if the corresponding bits differ, and 0 otherwise.



    Example 1:
    Input: nums = [1,1,2,2,2,3]
    Output: 3

    Explanation:
    The pairs at indices (0, 1), (2, 3), and (3, 4) each have an XOR of 0.
    Deleting one 1 and two 2s leaves [1, 2, 3], where 1 XOR 2 == 3 and 2 XOR 3 == 1 are both non-zero. Therefore, the answer is 3.

    Example 2:
    Input: nums = [4,4,9,4]
    Output: 1

    Explanation:
    The pair at indices (0, 1) has an XOR of 0.
    Deleting either of these two 4s leaves [4, 9, 4], where 4 XOR 9 == 13 and 9 XOR 4 == 13 are both non-zero.


    Constraints:
    2 <= nums.length <= 100
    1 <= nums[i] <= 100
     */

    public int minDeletions(int[] nums) {
        /*
        题目意思，删除多少个元素后，可以让数组为sharp
        sharp定义为：相邻两个元素异或不为0

        异或不为0意思是：两个数二进制表示的每一位都不一样，就是 不相等

        解法：
        1. 遍历数组，看下一个数字和当前数字是否一样，如果一样，则删除下一个数字，直到不相等为止
        2. 记录删除次数

         */

        int res = 0;
        int n = nums.length;
        int i = 1;

        int cur = nums[0];

        while (i < n) {
            if (nums[i] == cur) {
                res++;
            } else {
                cur = nums[i];
            }

            i++;
        }

        return res;
    }

    public int minDeletions2(int[] nums) {

        int move = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                move++;
            }
        }

        return move;
    }

    public static void main(String[] args) {

        L4083_Minimum_Deletions_to_Make_Array_Sharp s = new L4083_Minimum_Deletions_to_Make_Array_Sharp();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 1, 2, 2, 2, 3};

        int res = s.minDeletions(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}