import java.util.ArrayList;
import java.util.List;

public class L1863_Sum_of_All_Subset_XOR_Totals {

    /*
    The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

    For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
    Given an array nums, return the sum of all XOR totals for every subset of nums.

    Note: Subsets with the same elements should be counted multiple times.

    An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.



    Example 1:

    Input: nums = [1,3]
    Output: 6
    Explanation: The 4 subsets of [1,3] are:
    - The empty subset has an XOR total of 0.
    - [1] has an XOR total of 1.
    - [3] has an XOR total of 3.
    - [1,3] has an XOR total of 1 XOR 3 = 2.
    0 + 1 + 3 + 2 = 6


    Example 2:

    Input: nums = [5,1,6]
    Output: 28
    Explanation: The 8 subsets of [5,1,6] are:
    - The empty subset has an XOR total of 0.
    - [5] has an XOR total of 5.
    - [1] has an XOR total of 1.
    - [6] has an XOR total of 6.
    - [5,1] has an XOR total of 5 XOR 1 = 4.
    - [5,6] has an XOR total of 5 XOR 6 = 3.
    - [1,6] has an XOR total of 1 XOR 6 = 7.
    - [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
    0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28


    Example 3:

    Input: nums = [3,4,5,6,7,8]
    Output: 480
    Explanation: The sum of all XOR totals for every subset is 480.


    Constraints:

    1 <= nums.length <= 12
    1 <= nums[i] <= 20

     */
    // 方法1：递归回溯法
    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }
        return backtrack(nums, index + 1, currentXor ^ nums[index])
             + backtrack(nums, index + 1, currentXor);
    }

    // 方法2：迭代法
    public int subsetXORSum2(int[] nums) {
        List<Integer> xorResults = new ArrayList<>();
        xorResults.add(0); // 空集的异或结果为0

        for (int num : nums) {
            int size = xorResults.size();
            for (int i = 0; i < size; i++) {
                xorResults.add(xorResults.get(i) ^ num);
            }
        }

        int sum = 0;
        for (int res : xorResults) {
            sum += res;
        }
        return sum;
    }

    public int subsetXORSum3(int[] nums) {

        // 解决思路：
        // 1. 枚举所有子集
        // 2. 计算每个子集的 XOR 总和
        // 3. 求所有子集的和
        int n = nums.length;
        int totalSum = 0;

        for (int i = 0; i < (1 << n); i++) {
            int xorTotal = 0;
            for (int j = 0; j < n; j++) {
                // 如果当前位为1，则将对应的元素加入到 xorTotal 中
                // 这里使用了位运算，如果 i 的第 j 位为 1，则 xorTotal ^= nums[j]
                if ((i & (1 << j)) != 0) {
                    xorTotal ^= nums[j];
                }
            }
            totalSum += xorTotal;
        }

        return totalSum;

    }

    public static void main(String[] args) {

        L1863_Sum_of_All_Subset_XOR_Totals s = new L1863_Sum_of_All_Subset_XOR_Totals();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {5, 1, 6};
        int res = s.subsetXORSum(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}