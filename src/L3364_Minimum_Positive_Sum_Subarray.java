import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3364_Minimum_Positive_Sum_Subarray {

    /*
    You are given an integer array nums and two integers l and r.
    Your task is to find the minimum sum of a subarray whose size is between l and r (inclusive) and whose sum is greater than 0.

    Return the minimum sum of such a subarray. If no such subarray exists, return -1.

    A subarray is a contiguous non-empty sequence of elements within an array.



    Example 1:

    Input: nums = [3, -2, 1, 4], l = 2, r = 3

    Output: 1

    Explanation:

    The subarrays of length between l = 2 and r = 3 where the sum is greater than 0 are:

    [3, -2] with a sum of 1
    [1, 4] with a sum of 5
    [3, -2, 1] with a sum of 2
    [-2, 1, 4] with a sum of 3
    Out of these, the subarray [3, -2] has a sum of 1, which is the smallest positive sum. Hence, the answer is 1.

    Example 2:

    Input: nums = [-2, 2, -3, 1], l = 2, r = 3

    Output: -1

    Explanation:

    There is no subarray of length between l and r that has a sum greater than 0. So, the answer is -1.

    Example 3:

    Input: nums = [1, 2, 3, 4], l = 2, r = 4

    Output: 3

    Explanation:

    The subarray [1, 2] has a length of 2 and the minimum sum greater than 0. So, the answer is 3.



    Constraints:

    1 <= nums.length <= 100
    1 <= l <= r <= nums.length
    -1000 <= nums[i] <= 1000
     */
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int res = Integer.MAX_VALUE;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int tempSum = 0;
            int j = i;
            while (j - i + 1 <= r && j < n) {
                tempSum += nums.get(j);

                if (tempSum > 0 && (j - i + 1) >= l) {
                    res = Math.min(res, tempSum);
                }

                j++;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /*

    为什么第二个方法比第一个快？

    尽管两个方法的渐进时间复杂度 (Big O) 都是 O(n * r)，但第二个方法在实际执行时通常会快很多，原因如下：
    子数组求和的效率差异：
    方法一在内层 while 循环中，每次计算 tempSum 都需要累加当前子数组的元素。对于一个长度为 k 的子数组，它需要进行 k 次加法操作。
    整个过程相当于对每个 i，执行了 1 + 2 + ... + r 次加法操作（粗略估计，实际上是 r 次 nums.get 和 r 次加法）。
    方法二在内层 for 循环中，计算子数组的和 sum 只需要一次减法操作 (prefix[end] - prefix[start])。
    这是利用了前缀和的优势，将求和操作从 O(k) 降低到 O(1)。虽然外层循环的次数不变 (r*n 对)，但每次循环内部的工作量大大减少了。

    内存访问模式 / 缓存效率：
    方法一在 tempSum += nums.get(j) 中，nums.get(j) 可能会涉及到 List 对象的额外开销（尽管对于 ArrayList 来说是 O(1)），
    并且 List<Integer> 存储的是 Integer 对象，可能存在自动装箱/拆箱的性能损耗。
    方法二在计算前缀和时，prefix 数组是 int[] 类型的，存储的是基本数据类型。对 prefix 数组的访问 prefix[i] 是直接的内存访问，
    通常比 List.get() 更加高效和缓存友好。尤其是在 Step 2 中，prefix[start + len] - prefix[start] 是两次快速的数组元素访问和一次减法。

    总结来说：
    两个方法的理论复杂度都是 O(n * r)。

    但是：
    方法一的 O(1) 操作中包含了多次 List.get() 和 r 次加法操作。
    方法二的 O(1) 操作在计算 sum 时只包含两次数组访问和一次减法。在 Step 1 还有一个 O(n) 的前缀和计算，它虽然是额外的开销，但通常非常高效。

    因此，方法二的常数因子 (constant factor) 更小。这意味着，在相同的 n 和 r 值下，方法二执行的总指令数更少，或者说，指令的执行速度更快，所以它会更快。

    例如，如果 n=1000, r=100：
    方法一的内循环会执行约 100 次加法来计算一个长度为 100 的子数组和。总操作数约 1000 * 100 * (add + get)。
    方法二的内循环每次只执行 1 次减法来获取子数组和。总操作数约 1000 * (add + get) + 1000 * 100 * (sub + 2*array_access)。

    很明显，sub + 2*array_access 的成本远低于 100 * (add + get)。
     */
    public int minimumSumSubarray2(List<Integer> nums, int l, int r) {

        int n = nums.size();
        int[] prefix = new int[n + 1];

        // Step 1: 计算前缀和
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int minSum = Integer.MAX_VALUE;

        // Step 2: 遍历所有可能的子数组长度和起始位置，计算最小正数和
        for (int len = l; len <= r; len++) {
            for (int start = 0; start + len <= n; start++) {
                int sum = prefix[start + len] - prefix[start];
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        // Step 3: 返回结果
        return (minSum == Integer.MAX_VALUE) ? -1 : minSum;
    }

    public static void main(String[] args) {

        L3364_Minimum_Positive_Sum_Subarray s = new L3364_Minimum_Positive_Sum_Subarray();
        long sysDate1 = System.currentTimeMillis();

        Integer[] numsArr = {3, -2, 1, 4};
        List<Integer> nums = new ArrayList<>(Arrays.asList(numsArr));
        int l = 2;
        int r = 3;

        int res = s.minimumSumSubarray(nums, l, r);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}