import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3318_Find_X_Sum_of_All_K_Long_Subarrays_I {

    /*
    You are given an array nums of n integers and two integers k and x.

    The x-sum of an array is calculated by the following procedure:

    Count the occurrences of all elements in the array.
    Keep only the occurrences of the top x most frequent elements.

    If two elements have the same number of occurrences,
    the element with the bigger value is considered more frequent.

    Calculate the sum of the resulting array.
    Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

    Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].



    Example 1:

    Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2

    Output: [6,10,12]

    Explanation:

    For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
    For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4.
    Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
    For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.

    Example 2:

    Input: nums = [3,8,7,8,7,5], k = 2, x = 2

    Output: [11,15,15,15,12]

    Explanation:

    Since k == x, answer[i] is equal to the sum of the subarray nums[i..i + k - 1].

    Constraints:

    1 <= n == nums.length <= 50
    1 <= nums[i] <= 50
    1 <= x <= k <= nums.length

     */

    class Num {
        int value;
        int count;

        Num(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public int[] findXSum(int[] nums, int k, int x) {

        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {

            int[] count = new int[51];
            for (int j = i; j < i + k; j++) {
                count[nums[j]]++;
            }

            List<Num> list = new ArrayList<>();
            for (int j = 0; j < count.length; j++) {
                if (count[j] > 0) {
                    list.add(new Num(j, count[j]));
                }
            }
            list.sort((a, b) -> a.count != b.count ? Integer.compare(b.count, a.count) : Integer.compare(b.value, a.value));

            int sum = 0;
            for (int j = 0; j < x && j < list.size(); j++) {
                sum += list.get(j).value * list.get(j).count;
            }

            res[i] = sum;
        }

        return res;
    }

    public int[] findXSum2(int[] nums, int k, int x) {

        // 变量定义
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // 计算每个子数组的x-sum
        for (int i = 0; i < result.length; i++) {
            result[i] = calculateXSumForSubarray(nums, i, i + k - 1, x);
        }

        // 返回结果
        return result;
    }

    private int calculateXSumForSubarray(int[] nums, int start, int end, int x) {

        // 统计频率和总数
        final int MAX_VALUE = 50;
        int[] frequency = new int[MAX_VALUE + 1];


        // 优化：如果x大于总数，直接返回总和
        int distinctCount = 0;
        int totalSum = 0;
        for (int i = start; i <= end; i++) {
            int num = nums[i];
            totalSum += num;
            if (frequency[num] == 0) {
                distinctCount++;
            }
            frequency[num]++;
        }

        if (distinctCount < x) {
            return totalSum;
        }

        // 选择x个最大的数字，并计算它们的总和
        int resultSum = 0;
        for (int selection = 0; selection < x; selection++) {
            int bestNumber = -1;
            int bestFrequency = -1;

            // 不断寻找频率最大的数字
            for (int number = MAX_VALUE; number >= 1; number--) {
                if (frequency[number] > bestFrequency) {
                    bestFrequency = frequency[number];
                    bestNumber = number;
                }
            }

            // 频率最大的数字值更新为0，表示已经选择过
            if (bestNumber != -1) {
                resultSum += bestNumber * bestFrequency;
                frequency[bestNumber] = 0;
            }
        }

        // 返回结果
        return resultSum;
    }


    public static void main(String[] args) {

        L3318_Find_X_Sum_of_All_K_Long_Subarrays_I s = new L3318_Find_X_Sum_of_All_K_Long_Subarrays_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;
        int[] res = s.findXSum(nums, k, x);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}