public class L4038_Count_Integers_Appearing_in_a_Single_Block {

    /*
    You are given an integer array nums.

    An integer x is special if all occurrences of x in nums appear in a single contiguous block.

    Return the number of distinct special integers in nums.



    Example 1:
    Input: nums = [1,2,2,1]

    Output: 1
    Explanation:
    1 appears at indices 0 and 3, forming two separate blocks, so it is not special.
    2 appears in a single contiguous block at indices [1, 2], so it is special.
    Therefore, there is one special integer.

    Example 2:
    Input: nums = [3,3,1,2,2,1]

    Output: 2

    Explanation:
    3 appears in a single contiguous block at indices [0, 1], so it is special.
    1 appears at indices 2 and 5, forming two separate blocks, so it is not special.
    2 appears in a single contiguous block at indices [3, 4], so it is special.
    Therefore, there are two special integers.



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    public int countSpecialIntegers(int[] nums) {
        int ans = 0;
        int i = 0;
        int n = nums.length;

        int[] exists = new int[101];

        while (i < n) {
            int cur = nums[i];
            if (exists[cur] == 0) {
                exists[cur] = 1;
                ans++;
            } else if (exists[cur] == 1) {
                exists[cur] = 2;
                ans--;
            }

            while (i < n && nums[i] == cur) {
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L4038_Count_Integers_Appearing_in_a_Single_Block s = new L4038_Count_Integers_Appearing_in_a_Single_Block();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {42, 42, 42, 42, 42, 42, 10, 10, 10, 10, 10, 10, 42, 12};

        int res = s.countSpecialIntegers(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}