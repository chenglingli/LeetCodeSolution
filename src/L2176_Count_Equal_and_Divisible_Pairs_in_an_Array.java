public class L2176_Count_Equal_and_Divisible_Pairs_in_an_Array {

    /*
    1 <= nums.length <= 100
    1 <= nums[i], k <= 100

    that nums[i] == nums[j] and (i * j) is divisible by k

    Input: nums = [3,1,2,2,2,1,3], k = 2
    Output: 4
    Explanation:
    There are 4 pairs that meet all the requirements:
    - nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
    - nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
    - nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
    - nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.

     */
    public int countPairs(int[] nums, int k) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2176_Count_Equal_and_Divisible_Pairs_in_an_Array s =
                new L2176_Count_Equal_and_Divisible_Pairs_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 1, 2, 2, 2, 1, 3};
        int k = 2;
        int res = s.countPairs(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}