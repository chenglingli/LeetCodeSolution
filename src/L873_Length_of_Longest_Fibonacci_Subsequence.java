import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L873_Length_of_Longest_Fibonacci_Subsequence {


    /*

    A sequence x1, x2, ..., xn is Fibonacci-like if:

    n >= 3
    xi + xi+1 == xi+2 for all i + 2 <= n
    Given a strictly increasing array arr of positive integers forming a sequence,
    return the length of the longest Fibonacci-like subsequence of arr.
    If one does not exist, return 0.

    A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr,
    without changing the order of the remaining elements.

    For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].



    Example 1:

    Input: arr = [1,2,3,4,5,6,7,8]
    Output: 5
    Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].

    Example 2:

    Input: arr = [1,3,7,11,12,14,18]
    Output: 3
    Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].


    Constraints:

    3 <= arr.length <= 1000
    1 <= arr[i] < arr[i + 1] <= 10^9

     */


    /*

    dp[i][j] 表示以 arr[i] 和 arr[j] 结尾的斐波那契序列的长度
    超时
     */
    public int lenLongestFibSubseq2(int[] arr) {

        int n = arr.length;

        // dp[i][j] 表示以 arr[i] 和 arr[j] 结尾的斐波那契序列的长度
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], 2);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = 2;
                for (int k = 0; k < i; ++k) {
                    if (arr[j] - arr[i] == arr[k]) {
                        dp[i][j] = dp[k][i] + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }

        return ans > 2 ? ans : 0;
    }

    /*
    算法步骤
    1. 将数组元素存储在 set 中，以便进行 O(1) 查找
    2. 对于数组中的每个可能的起始数字和下一个数字，我们尝试构建斐波那契序列
    3. 我们使用一个 while 循环来找到斐波那契序列的下一个数字，直到找不到为止
    4. 我们更新斐波那契序列的长度，并检查是否超过了当前的最大长度

     */
    public int lenLongestFibSubseq(int[] arr) {

        int n = arr.length;

        // Store array elements in set for O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int maxLen = 0;
        // Try all possible first two numbers of sequence
        for (int start = 0; start < n; ++start) {
            for (int next = start + 1; next < n; ++next) {

                if (arr[next] * Math.pow(1.618, maxLen - 2) > arr[arr.length - 1])
                    break;

                // Start with first two numbers
                int prev = arr[next];
                int curr = arr[start] + arr[next];
                int len = 2;

                // Keep finding next Fibonacci number
                while (numSet.contains(curr)) {
                    // Update values for next iteration
                    int temp = curr;
                    curr += prev;
                    prev = temp;

                    maxLen = Math.max(maxLen, ++len);
                }
            }
        }

        return maxLen;
    }

    /*
    算法步骤
    做了个剪枝，斐波那契数列的相邻两项的比值是1.618，所以如果当前两项的比值大于1.618，那么后面的项肯定更大，没必要再继续算了

     */
    public int lenLongestFibSubseq3(int[] arr) {

        Set<Integer> index = new HashSet<>();
        for (int n : arr) {
            index.add(n);
        }

        int max = 2;

        for (int i = 0; i < arr.length - max; i++) {

            if (arr[i] * Math.pow(1.618, max - 1) > arr[arr.length - 1])
                break;

            for (int j = i + 1; j < arr.length - max + 1; j++) {
                if (arr[j] * Math.pow(1.618, max - 2) > arr[arr.length - 1])
                    break;
                int n2 = arr[i];
                int n1 = arr[j];
                int len = 2;

                while (index.contains(n1 + n2)) {
                    n1 = n1 + n2;
                    n2 = n1 - n2;
                    len++;
                }

                if (len > max)
                    max = len;
            }
        }


        return max < 3 ? 0 : max;
    }

    public static void main(String[] args) {

        L873_Length_of_Longest_Fibonacci_Subsequence s = new L873_Length_of_Longest_Fibonacci_Subsequence();
        long sysDate1 = System.currentTimeMillis();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int res = s.lenLongestFibSubseq(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}