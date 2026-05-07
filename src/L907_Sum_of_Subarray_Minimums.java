import java.util.ArrayDeque;
import java.util.Deque;

public class L907_Sum_of_Subarray_Minimums {

    private static final int MOD = 1_000_000_007;

    /*

    Given an array of integer arr, find the sum of min(b),
    where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 10^9 + 7.

    Example 1:
    Input: arr = [3,1,2,4]
    Output: 17
    Explanation:
    Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
    Sum is 17.

    Example 2:
    Input: arr = [11,81,94,43,3]
    Output: 444

    Constraints:
    1 <= arr.length <= 3 * 10^4
    1 <= arr[i] <= 3 * 10^4

     */
    public int sumSubarrayMins(int[] arr) {
        // 数组长度
        int n = arr.length;
        int[] prevLess = new int[n];
        int[] nextLessOrEqual = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // 找左边第一个小于当前元素的索引
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // 找右边第一个小于等于当前元素的索引
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nextLessOrEqual[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 计算每个元素作为最小值的子数组个数
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLessOrEqual[i] - i;
            sum = (sum + (long) arr[i] * left * right % MOD) % MOD;
        }

        // 返回结果
        return (int) sum;
    }

    public int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        int[] right = new int[n + 1];
        int[] left = new int[n + 1];

        int[] sum = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            right[i + 1] = arr[i];
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            int curr = right[i];
            int j = i - 1;
            while (right[j] >= curr) {
                j = left[j];
            }
            left[i] = j;
            sum[i] = sum[j] + curr * (i - j);
            res = (res + sum[i]) % mod;
        }

        return res;
    }

    public static void main(String[] args) {

        L907_Sum_of_Subarray_Minimums s = new L907_Sum_of_Subarray_Minimums();
        long sysDate1 = System.currentTimeMillis();

        int[] arr = {3, 1, 2, 4};

        int res = s.sumSubarrayMins(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}