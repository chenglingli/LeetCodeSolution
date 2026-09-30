import java.util.Arrays;

public class L4065_Rearrange_Array_by_Removing_Distinct_Values {

    /*
    You are given an integer array nums.

    You start with an empty array ans. Repeat the following operation until nums is empty:

    Identify all distinct values currently present in nums.
    Remove one occurrence of every distinct value currently in nums, and append those values to ans in ascending order.
    Return the array ans.


    Example 1:
    Input: nums = [3,1,3,2,1,3]
    Output: [1,2,3,1,3,3]
    Explanation:
    Operation	Appended to ans	nums after	ans after
    1	1, 2, 3	[3, 1, 3]	[1, 2, 3]
    2	1, 3	[3]	[1, 2, 3, 1, 3]
    3	3	[]	[1, 2, 3, 1, 3, 3]
    nums is now empty, so the answer is [1, 2, 3, 1, 3, 3].

    Example 2:
    Input: nums = [7,7,4,4,4]
    Output: [4,7,4,7,4]
    Explanation:
    Operation	Appended to ans	nums after	ans after
    1	4, 7	[7, 4, 4]	[4, 7]
    2	4, 7	[4]	[4, 7, 4, 7]
    3	4	[]	[4, 7, 4, 7, 4]
    nums is now empty, so the answer is [4, 7, 4, 7, 4].



    Constraints:
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
     */
    public int[] rearrangeArray(int[] nums) {

        int[] res = new int[nums.length];

        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }

        int idx = 0;
        while (idx < nums.length) {
            for (int i = 1; i < freq.length; i++) {
                if (freq[i] > 0) {
                    res[idx++] = i;
                    freq[i]--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L4065_Rearrange_Array_by_Removing_Distinct_Values s = new L4065_Rearrange_Array_by_Removing_Distinct_Values();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 1, 3, 2, 1, 3};

        int[] res = s.rearrangeArray(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}