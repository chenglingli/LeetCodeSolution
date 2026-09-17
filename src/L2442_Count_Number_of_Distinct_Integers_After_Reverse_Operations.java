import java.util.HashSet;
import java.util.Set;

public class L2442_Count_Number_of_Distinct_Integers_After_Reverse_Operations {

    /*
    You are given an array nums consisting of positive integers.

    You have to take each integer in the array, reverse its digits, and add it to the end of the array.
    You should apply this operation to the original integers in nums.

    Return the number of distinct integers in the final array.



    Example 1:

    Input: nums = [1,13,10,12,31]
    Output: 6
    Explanation: After including the reverse of each number, the resulting array is [1,13,10,12,31,1,31,1,21,13].
    The reversed integers that were added to the end of the array are underlined.
    Note that for the integer 10, after reversing it, it becomes 01 which is just 1.
    The number of distinct integers in this array is 6 (The numbers 1, 10, 12, 13, 21, and 31).

    Example 2:

    Input: nums = [2,2,2]
    Output: 1
    Explanation: After including the reverse of each number, the resulting array is [2,2,2,2,2,2].
    The number of distinct integers in this array is 1 (The number 2).


    Constraints:

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^6
     */
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
            set.add(reverse(x));
        }
        return set.size();
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public int countDistinctIntegers2(int[] nums) {

        boolean[] seen = new boolean[1000001];
        int count = 0;

        for (int x : nums) {
            if (!seen[x]) {
                seen[x] = true;
                count++;
            }

            int rev = 0;
            while (x > 0) {
                rev = rev * 10 + x % 10;
                x /= 10;
            }

            if (!seen[rev]) {
                seen[rev] = true;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L2442_Count_Number_of_Distinct_Integers_After_Reverse_Operations s = new L2442_Count_Number_of_Distinct_Integers_After_Reverse_Operations();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 13, 10, 12, 31};
        int res = s.countDistinctIntegers(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}