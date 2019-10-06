import java.util.Arrays;
import java.util.Comparator;

public class L646_Maximum_Length_of_Pair_Chain {

    /**
     You are given n pairs of numbers. In every pair,
     the first number is always smaller than the second number.

     Now, we define a pair (c, d) can follow another pair (a, b)
     if and only if b < c. Chain of pairs can be formed in this fashion.

     Given a set of pairs, find the length longest chain which can be formed.
     You needn't use up all the given pairs. You can select pairs in any order.

     Example 1:
     Input: [[1,2], [2,3], [3,4]]
     Output: 2
     Explanation: The longest chain is [1,2] -> [3,4]
     Note:
     The number of given pairs will be in the range [1, 1000].
     */

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });

        int ans = -1;
        int len = pairs.length;
        int [] f =  new int[len];

        for (int i = 0 ; i < len; i++) {
            f[i] = 1;
            for (int j = i-1; j >=0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    if (f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                    }
                }
            }
            ans = Integer.max(ans, f[i]);
        }

        return ans;
    }

    // 对尾部进行排序
    // Consider pairs as jobs, with [start time, end time],
    // Then the problem is converted to ask the maximum jobs we can accomplish.
    public int findLongestChain2(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int ans = 0;
        int len = pairs.length;
        int end = Integer.MIN_VALUE;

        for (int i = 0 ; i < len; i++) {
            if (pairs[i][0] > end) {
                ans ++;
                end = pairs[i][1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L646_Maximum_Length_of_Pair_Chain s = new L646_Maximum_Length_of_Pair_Chain();
        long sysDate1 = System.currentTimeMillis();

        int[][] pairs = {{1,2},{3,4},{2,3}};

        int res = s.findLongestChain2(pairs);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}