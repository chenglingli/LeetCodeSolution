public class L2044_Count_Number_of_Maximum_Bitwise_OR_Subsets {


    /*

    Given an integer array nums, find the maximum possible bitwise OR of a subset of nums
    and return the number of different non-empty subsets with the maximum bitwise OR.

    An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
    Two subsets are considered different if the indices of the elements chosen are different.

    The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).



    Example 1:

    Input: nums = [3,1]
    Output: 2
    Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
    - [3]
    - [3,1]

    Example 2:
    Input: nums = [2,2,2]
    Output: 7
    Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 2^3 - 1 = 7 total subsets.

    Example 3:
    Input: nums = [3,2,1,5]
    Output: 6
    Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
    - [3,5]
    - [3,1,5]
    - [3,2,5]
    - [3,2,1,5]
    - [2,5]
    - [2,1,5]


    Constraints:
    1 <= nums.length <= 16
    1 <= nums[i] <= 10^5

     */
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int x : nums) {
            maxOr |= x;
        }

        int n = nums.length;
        boolean[] essential = new boolean[n];
        int essentialCount = 0;
        for (int i = 0; i < n; i++) {
            int restOr = 0;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    restOr |= nums[j];
                }
            }
            if (restOr < maxOr) {
                essential[i] = true;
                essentialCount++;
            }
        }

        int essentialOr = 0;
        int[] optional = new int[n];
        int optionalSize = 0;
        for (int i = 0; i < n; i++) {
            if (essential[i]) {
                essentialOr |= nums[i];
            } else {
                optional[optionalSize++] = nums[i];
            }
        }

        int need = maxOr & ~essentialOr;
        int count = 0;
        for (int mask = 0; mask < (1 << optionalSize); mask++) {
            if (essentialCount == 0 && mask == 0) {
                continue;
            }
            int or = 0;
            for (int i = 0; i < optionalSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    or |= optional[i];
                }
            }
            if ((or & need) == need) {
                count++;
            }
        }
        return count;
    }


    public int countMaxOrSubsets2(int[] nums) {
        int maxOR = 0;
        for (int num : nums) {
            maxOR |= num;
        }

        return backtrack(nums, maxOR, 0, 0);
    }

    public int countMaxOrSubsets3(int[] nums) {
        int maxOr = 0;
        for (int x : nums) {
            maxOr |= x;
        }
        int n = nums.length;
        int count = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            int or = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    or |= nums[i];
                }
            }
            if (or == maxOr) {
                count++;
            }
        }
        return count;
    }

    private int backtrack(int[] nums, int maxOR, int index, int currentOR) {
        if (index == nums.length) {
            return currentOR == maxOR ? 1 : 0;
        }

        if (currentOR == maxOR) {
            return 1 << (nums.length - index);
        }

        return backtrack(nums, maxOR, index + 1, currentOR | nums[index]) +
                backtrack(nums, maxOR, index + 1, currentOR);
    }

    public static void main(String[] args) {

        L2044_Count_Number_of_Maximum_Bitwise_OR_Subsets s = new L2044_Count_Number_of_Maximum_Bitwise_OR_Subsets();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 1};

        int res = s.countMaxOrSubsets(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}