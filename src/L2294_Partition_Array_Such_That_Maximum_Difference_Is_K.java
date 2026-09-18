import java.util.Arrays;

public class L2294_Partition_Array_Such_That_Maximum_Difference_Is_K {

    /*

    You are given an integer array nums and an integer k.
    You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.

    Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.

    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.



    Example 1:
    Input: nums = [3,6,1,2,5], k = 2
    Output: 2
    Explanation:
    We can partition nums into the two subsequences [3,1,2] and [6,5].
    The difference between the maximum and minimum value in the first subsequence is 3 - 1 = 2.
    The difference between the maximum and minimum value in the second subsequence is 6 - 5 = 1.
    Since two subsequences were created, we return 2. It can be shown that 2 is the minimum number of subsequences needed.

    Example 2:
    Input: nums = [1,2,3], k = 1
    Output: 2
    Explanation:
    We can partition nums into the two subsequences [1,2] and [3].
    The difference between the maximum and minimum value in the first subsequence is 2 - 1 = 1.
    The difference between the maximum and minimum value in the second subsequence is 3 - 3 = 0.
    Since two subsequences were created, we return 2. Note that another optimal solution is to partition nums into the two subsequences [1] and [2,3].
    Example 3:

    Input: nums = [2,2,4,5], k = 0
    Output: 3
    Explanation:
    We can partition nums into the three subsequences [2,2], [4], and [5].
    The difference between the maximum and minimum value in the first subsequences is 2 - 2 = 0.
    The difference between the maximum and minimum value in the second subsequences is 4 - 4 = 0.
    The difference between the maximum and minimum value in the third subsequences is 5 - 5 = 0.
    Since three subsequences were created, we return 3. It can be shown that 3 is the minimum number of subsequences needed.


    Constraints:

    1 <= nums.length <= 10^5
    0 <= nums[i] <= 10^5
    0 <= k <= 10^5


     */
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - max > k) {
                count++;
                max = nums[i];
            }
        }
        return count;

    }

    public int partitionArray2(int[] nums, int k) {

        // 计算最大最小值
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < minValue) minValue = num;
            if (num > maxValue) maxValue = num;
        }
        if (maxValue - minValue <= k) return 1;

        // 计算频率数组
        int[] frequency = new int[maxValue - minValue + 1];
        for (int num : nums) {
            frequency[num - minValue]++;
        }

        // 计算分组数
        int groupCount = 1;
        int position = k + 1;
        int limit = maxValue - minValue;

        /*
        逻辑：
        1. 找到第一个不为0的位置，即第一个元素
        2. 往后移动k+1个位置，即下一个元素
        3. 如果移动后位置还在数组范围内，则继续循环
        4. 如果移动后位置不在数组范围内，则结束循环

        前半段把数字摊到值域上；后半段从最小值开始，每开一组就往后跳 k+1，跳过空位，数一共跳了几次。
         */
        while (position <= limit) {

            // 跳过0
            while (position <= limit && frequency[position] == 0) {
                position++;
            }

            // 移动k+1个位置，即下一个元素
            if (position <= limit) {
                groupCount++;
                position += k + 1;
            }
        }

        return groupCount;
    }

    public static void main(String[] args) {

        L2294_Partition_Array_Such_That_Maximum_Difference_Is_K s =
                new L2294_Partition_Array_Such_That_Maximum_Difference_Is_K();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 6, 1, 2, 5};
        int k = 2;
        int res = s.partitionArray(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}