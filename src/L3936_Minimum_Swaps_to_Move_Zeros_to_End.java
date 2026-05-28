public class L3936_Minimum_Swaps_to_Move_Zeros_to_End {

    /*
    You are given an integer array nums.

    In one operation, you can choose any two distinct indices i and j and swap nums[i] and nums[j].

    Return an integer denoting the minimum number of operations required to move all 0s to the end of the array.



    Example 1:

    Input: nums = [0,1,0,3,12]

    Output: 2

    Explanation:

    We perform the following swap operations:

    Swap nums[0] and nums[3], giving nums = [3, 1, 0, 0, 12].
    Swap nums[2] and nums[4], giving nums = [3, 1, 12, 0, 0].
    Thus, the answer is 2.

    Example 2:

    Input: nums = [0,1,0,2]

    Output: 1

    Explanation:

    We perform the following swap operations:

    Swap nums[0] and nums[3], giving nums = [2, 1, 0, 0].
    Thus, the answer is 1.

    Example 3:

    Input: nums = [1,2,0]

    Output: 0

    Explanation:

    The array already satisfies the condition. Therefore, no swap operations are needed.



    Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 100

     */
    public int minimumSwaps(int[] nums) {
        int count = 0;

        int i = nums.length - 1;
        int j = 0;
        while (i > j) {
            while (i > j && nums[j] != 0) {
                j++;
            }
            while (i > j && nums[i] == 0) {
                i--;
            }
            if (i > j) {
                swap(nums, i, j);
                count++;
            }
        }

        return count;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {

        L3936_Minimum_Swaps_to_Move_Zeros_to_End s = new L3936_Minimum_Swaps_to_Move_Zeros_to_End();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {0, 1, 0, 3, 12};

        int res = s.minimumSwaps(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}