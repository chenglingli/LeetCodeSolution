import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1630_Arithmetic_Subarrays {


    /*

    A sequence of numbers is called arithmetic if it consists of at least two elements,
    and the difference between every two consecutive elements is the same.

    More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.

    For example, these are arithmetic sequences:

    1, 3, 5, 7, 9
    7, 7, 7, 7
    3, -1, -5, -9
    The following sequence is not arithmetic:

    1, 1, 2, 5, 7
    You are given an array of n integers, nums, and two arrays of m integers each, l and r,
    representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.

    Return a list of boolean elements answer,
    where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.


    Example 1:
    Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
    Output: [true,false,true]
    Explanation:
    In the 0th query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
    In the 1st query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
    In the 2nd query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9], which is an arithmetic sequence.

    Example 2:
    Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
    Output: [false,true,false,false,true,true]


    Constraints:

    n == nums.length
    m == l.length
    m == r.length
    2 <= n <= 500
    1 <= m <= 500
    0 <= l[i] < r[i] < n
    -10^5 <= nums[i] <= 10^5

     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            result.add(checkArithmeticSubarrays(nums, l[i], r[i]));
        }
        return result;
    }

    private boolean checkArithmeticSubarrays(int[] nums, int l, int r) {
        int[] subArray = Arrays.copyOfRange(nums, l, r + 1);
        Arrays.sort(subArray);
        int diff = subArray[1] - subArray[0];
        for (int i = 2; i < subArray.length; i++) {
            if (subArray[i] - subArray[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    public List<Boolean> checkArithmeticSubarrays2(int[] nums, int[] l, int[] r) {

        int m = l.length;
        List<Boolean> ans = new ArrayList<>(m);

        for (int i = 0; i < m; ++i) {
            int left = l[i], right = r[i];
            int k = right - left + 1;
            if (k <= 2) {
                ans.add(true);
                continue;
            }

            // 计算子数组最大值和最小值
            int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;
            for (int j = left; j <= right; ++j) {
                int v = nums[j];
                if (v < mn) mn = v;
                if (v > mx) mx = v;
            }

            // 看是否能整除，不能的直接返回false
            long span = (long) mx - (long) mn;
            if (span % (k - 1) != 0) {
                ans.add(false);
                continue;
            }

            // 计算公差
            long d = span / (k - 1);

            // 全相等情况
            if (d == 0) {
                boolean allEqual = true;
                for (int j = left; j <= right; ++j) {
                    if (nums[j] != mn) {
                        allEqual = false;
                        break;
                    }
                }
                ans.add(allEqual);
                continue;
            }


            /*
            将当前值和最小值对比，计算出差值，然后计算出位置
            看位置是否存在过，如果存在过，则直接返回false，否则标记为出现过

             */
            boolean[] seen = new boolean[k];
            boolean ok = true;
            for (int j = left; j <= right; ++j) {

                // 计算差值，并转换为位置
                long diff = (long) nums[j] - (long) mn;
                if (diff % d != 0) {
                    ok = false;
                    break;
                }
                long posL = diff / d;
                if (posL < 0 || posL >= k) {
                    ok = false;
                    break;
                }

                int pos = (int) posL;
                if (seen[pos]) {
                    ok = false;
                    break;
                }

                seen[pos] = true;
            }


            ans.add(ok);
        }

        return ans;
    }

    public static void main(String[] args) {

        L1630_Arithmetic_Subarrays s = new L1630_Arithmetic_Subarrays();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};
        List<Boolean> res = s.checkArithmeticSubarrays(nums, l, r);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}