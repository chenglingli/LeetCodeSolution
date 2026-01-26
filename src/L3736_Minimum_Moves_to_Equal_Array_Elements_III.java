import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L3736_Minimum_Moves_to_Equal_Array_Elements_III {

    /*
    You are given an integer array nums.

    In one move, you may increase the value of any single element nums[i] by 1.

    Return the minimum total number of moves required so that all elements in nums become equal.



    Example 1:

    Input: nums = [2,1,3]

    Output: 3

    Explanation:

    To make all elements equal:

    Increase nums[0] = 2 by 1 to make it 3.
    Increase nums[1] = 1 by 1 to make it 2.
    Increase nums[1] = 2 by 1 to make it 3.
    Now, all elements of nums are equal to 3. The minimum total moves is 3.

    Example 2:

    Input: nums = [4,4,5]

    Output: 2

    Explanation:

    To make all elements equal:

    Increase nums[0] = 4 by 1 to make it 5.
    Increase nums[1] = 4 by 1 to make it 5.
    Now, all elements of nums are equal to 5. The minimum total moves is 2.



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    public int minMoves(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }

        int moves = 0;
        for (int num : nums) {
            moves += maxVal - num;
        }

        return moves;
    }

    public static void main(String[] args) {

        L3736_Minimum_Moves_to_Equal_Array_Elements_III s = new L3736_Minimum_Moves_to_Equal_Array_Elements_III();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 1, 3};
        int res = s.minMoves(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}