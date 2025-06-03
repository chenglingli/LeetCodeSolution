import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L2670_Find_the_Distinct_Difference_Array {

    /*

    You are given a 0-indexed array nums of length n.

    The distinct difference array of nums is an array diff of length n such that
        diff[i] is equal to the number of distinct elements in the suffix nums[i + 1, ..., n - 1]
        subtracted from the number of distinct elements in the prefix nums[0, ..., i].

    Return the distinct difference array of nums.

    Note that nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j inclusive.
    Particularly, if i > j then nums[i, ..., j] denotes an empty subarray.



    Example 1:

    Input: nums = [1,2,3,4,5]
    Output: [-3,-1,1,3,5]
    Explanation: For index i = 0, there is 1 element in the prefix and 4 distinct elements in the suffix. Thus, diff[0] = 1 - 4 = -3.
    For index i = 1, there are 2 distinct elements in the prefix and 3 distinct elements in the suffix. Thus, diff[1] = 2 - 3 = -1.
    For index i = 2, there are 3 distinct elements in the prefix and 2 distinct elements in the suffix. Thus, diff[2] = 3 - 2 = 1.
    For index i = 3, there are 4 distinct elements in the prefix and 1 distinct element in the suffix. Thus, diff[3] = 4 - 1 = 3.
    For index i = 4, there are 5 distinct elements in the prefix and no elements in the suffix. Thus, diff[4] = 5 - 0 = 5.
    Example 2:

    Input: nums = [3,2,3,4,2]
    Output: [-2,-1,0,2,3]
    Explanation: For index i = 0, there is 1 element in the prefix and 3 distinct elements in the suffix. Thus, diff[0] = 1 - 3 = -2.
    For index i = 1, there are 2 distinct elements in the prefix and 3 distinct elements in the suffix. Thus, diff[1] = 2 - 3 = -1.
    For index i = 2, there are 2 distinct elements in the prefix and 2 distinct elements in the suffix. Thus, diff[2] = 2 - 2 = 0.
    For index i = 3, there are 3 distinct elements in the prefix and 1 distinct element in the suffix. Thus, diff[3] = 3 - 1 = 2.
    For index i = 4, there are 3 distinct elements in the prefix and no elements in the suffix. Thus, diff[4] = 3 - 0 = 3.


    Constraints:

    1 <= n == nums.length <= 50
    1 <= nums[i] <= 50

     */

    /**
     * 通过set方式
     */
    public int[] distinctDifferenceArray(int[] nums) {

        // 分别从前往后遍历和从后往前的遍历，分别记录前缀和后缀的distinct elements
        // 前缀的distinct elements可以直接用set来记录
        // 后缀的distinct elements可以用一个数组来记录
        // 然后直接相减即可

        int n = nums.length;
        int[] prefix = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            prefix[i] = set.size();
        }

        int[] suffix = new int[n];
        set.clear();
        for (int i = n - 1; i >= 1; i--) {
            set.add(nums[i]);
            suffix[i - 1] = set.size();
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] - suffix[i];
        }

        return res;
    }

    /**
     * 通过位运算方式
     */
    public int[] distinctDifferenceArray2(int[] nums) {

        int n = nums.length;
        int[] diff = new int[n];

        long prefix = 0L;
        long suffix = 0L;

        int prefixCount = 0;
        int suffixCount = 0;

        for (int i = 0, j = n - 1; j >= 0; i++, j--) {
            int v = nums[i];
            prefixCount += 1 - ((int) (prefix >> v) & 1);
            prefix |= 1L << v;
            diff[i] += prefixCount;

            diff[j] -= suffixCount;
            v = nums[j];
            suffixCount += 1 - ((int) (suffix >> v) & 1);
            suffix |= 1L << v;
        }

        return diff;
    }

    public static void main(String[] args) {

        L2670_Find_the_Distinct_Difference_Array s = new L2670_Find_the_Distinct_Difference_Array();
        long sysDate1 = System.currentTimeMillis();

        int nums[] = {3, 2, 3, 4, 2};
        //        int nums[] = {37, 37, 37, 37, 33};
        //                int nums[] = {1, 2, 3, 4, 5};
        int[] res = s.distinctDifferenceArray(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}