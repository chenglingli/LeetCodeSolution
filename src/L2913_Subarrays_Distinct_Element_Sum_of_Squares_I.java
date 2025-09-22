import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L2913_Subarrays_Distinct_Element_Sum_of_Squares_I {

    /*
    You are given a 0-indexed integer array nums.

    The distinct count of a subarray of nums is defined as:

    Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length.
    Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
    Return the sum of the squares of distinct counts of all subarrays of nums.

    A subarray is a contiguous non-empty sequence of elements within an array.



    Example 1:

    Input: nums = [1,2,1]
    Output: 15
    Explanation: Six possible subarrays are:
    [1]: 1 distinct value
    [2]: 1 distinct value
    [1]: 1 distinct value
    [1,2]: 2 distinct values
    [2,1]: 2 distinct values
    [1,2,1]: 2 distinct values
    The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 + 22 + 22 + 22 = 15.


    Example 2:
    Input: nums = [1,1]
    Output: 3
    Explanation: Three possible subarrays are:
    [1]: 1 distinct value
    [1]: 1 distinct value
    [1,1]: 1 distinct value
    The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 = 3.


    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    public int sumCounts(List<Integer> nums) {

        int n = nums.size();
        long ans = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                Set<Integer> set = new HashSet<>();
                for (int k = i; k <= j; ++k) {
                    set.add(nums.get(k));
                }
                ans += (int) Math.pow(set.size(), 2);
            }
        }

        return (int) ans;
    }

    public int sumCounts2(List<Integer> nums) {

        int ans = 0;
        int n = nums.size();

        for (int i = 0; i < n; ++i) {
            int[] s = new int[101];
            int cnt = 0;

            for (int j = i; j < n; ++j) {
                if (++s[nums.get(j)] == 1) {
                    ++cnt;
                }
                ans += cnt * cnt;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2913_Subarrays_Distinct_Element_Sum_of_Squares_I s = new L2913_Subarrays_Distinct_Element_Sum_of_Squares_I();
        long sysDate1 = System.currentTimeMillis();

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);

        int res = s.sumCounts(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}