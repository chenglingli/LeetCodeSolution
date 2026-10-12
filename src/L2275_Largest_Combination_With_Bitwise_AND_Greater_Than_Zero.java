public class L2275_Largest_Combination_With_Bitwise_AND_Greater_Than_Zero {

    /*
    The bitwise AND of an array nums is the bitwise AND of all integers in nums.

    For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1.
    Also, for nums = [7], the bitwise AND is 7.
    You are given an array of positive integers candidates.
    Compute the bitwise AND for all possible combinations of elements in the candidates array.

    Return the size of the largest combination of candidates with a bitwise AND greater than 0.

    Example 1:
    Input: candidates = [16,17,71,62,12,24,14]
    Output: 4
    Explanation: The combination [16,17,62,24] has a bitwise AND of 16 & 17 & 62 & 24 = 16 > 0.
    The size of the combination is 4.
    It can be shown that no combination with a size greater than 4 has a bitwise AND greater than 0.
    Note that more than one combination may have the largest size.
    For example, the combination [62,12,24,14] has a bitwise AND of 62 & 12 & 24 & 14 = 8 > 0.

    Example 2:
    Input: candidates = [8,8]
    Output: 2
    Explanation: The largest combination [8,8] has a bitwise AND of 8 & 8 = 8 > 0.
    The size of the combination is 2, so we return 2.


    Constraints:

    1 <= candidates.length <= 10^5
    1 <= candidates[i] <= 10^7

     */
    public int largestCombination(int[] candidates) {

        int ans = 0;

        for (int bit = 0; bit < 24; bit++) {
            int count = 0;
            for (int x : candidates) {
                if ((x >> bit & 1) == 1) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }

    public int largestCombination2(int[] candidates) {
        
        // 创建一个长度为32的数组，用于统计每个位上1的个数
        int[] bits = new int[32];

        // 遍历每个数，统计每个位上1的个数
        for (int num : candidates) {
            int i = 0;

            // 统计每个位上1的个数
            while (num > 0) {
                bits[i++] += num & 1;
                num >>= 1;
            }
        }

        // 找出最大的位数
        int max = 0;
        for (int num : bits)
            max = Math.max(max, num);

        // 返回最大的位数
        return max;
    }

    public static void main(String[] args) {

        L2275_Largest_Combination_With_Bitwise_AND_Greater_Than_Zero s =
                new L2275_Largest_Combination_With_Bitwise_AND_Greater_Than_Zero();
        long sysDate1 = System.currentTimeMillis();

        int[] candidates = {16, 17, 71, 62, 12, 24, 14};

        int res = s.largestCombination(candidates);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}