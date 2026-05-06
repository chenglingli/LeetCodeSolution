import java.util.Arrays;

public class L3917_Count_Indices_With_Opposite_Parity {

    /*

    You are given an integer array nums of length n.

    The score of an index i is defined as the number of indices j such that:

    i < j < n, and
    nums[i] and nums[j] have different parity (one is even and the other is odd).
    Return an integer array answer of length n, where answer[i] is the score of index i.



    Example 1:
    Input: nums = [1,2,3,4]
    Output: [2,1,1,0]
    Explanation:
    nums[0] = 1, which is odd. Thus, the indices j = 1 and j = 3 satisfy the conditions, so the score of index 0 is 2.
    nums[1] = 2, which is even. Thus, the index j = 2 satisfies the conditions, so the score of index 1 is 1.
    nums[2] = 3, which is odd. Thus, the index j = 3 satisfies the conditions, so the score of index 2 is 1.
    nums[3] = 4, which is even. Thus, no index satisfies the conditions, so the score of index 3 is 0.
    Thus, the answer = [2, 1, 1, 0].

    Example 2:
    Input: nums = [1]
    Output: [0]
    Explanation:
    There is only one element in nums. Thus, the score of index 0 is 0.



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    public int[] countOppositeParity(int[] nums) {
        int len = nums.length;
        // 统计到从右向左，到i为止，有多少个偶数和奇数，分别放在二维数组的0和1位置上
        int[][] count = new int[len + 1][2];
        count[len][0] = 0;
        count[len][1] = 0;

        for (int i = len - 1; i >= 0; --i) {
            if (nums[i] % 2 == 0) {
                count[i][0] = count[i + 1][0] + 1;
                count[i][1] = count[i + 1][1];
            } else {
                count[i][0] = count[i + 1][0];
                count[i][1] = count[i + 1][1] + 1;
            }
        }

        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            if (nums[i] % 2 == 0) {
                res[i] = count[i + 1][1];
            } else {
                res[i] = count[i + 1][0];
            }
        }

        return res;
    }

    public int[] countOppositeParity2(int[] nums) {

        int n = nums.length;
        int evncnt = 0;
        int oddcnt = 0;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                ans[i] = oddcnt;
                evncnt++;

            } else {
                ans[i] = evncnt;
                oddcnt++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        L3917_Count_Indices_With_Opposite_Parity s = new L3917_Count_Indices_With_Opposite_Parity();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4};

        int[] res = s.countOppositeParity(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}