public class L3866_First_Unique_Even_Element {

    /*
    You are given an integer array nums.

    Return an integer denoting the first even integer (earliest by array index) that appears exactly once in nums. If no such integer exists, return -1.

    An integer x is considered even if it is divisible by 2.



    Example 1:

    Input: nums = [3,4,2,5,4,6]

    Output: 2

    Explanation:

    Both 2 and 6 are even and they appear exactly once. Since 2 occurs first in the array, the answer is 2.

    Example 2:

    Input: nums = [4,4]

    Output: -1

    Explanation:

    No even integer appears exactly once, so return -1.



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    public int firstUniqueEven(int[] nums) {

        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        for (int num : nums) {
            if (num % 2 == 0 && count[num] == 1) {
                return num;
            }
        }
        return -1;
    }

    public int firstUniqueEven2(int[] arr) {
        for (int k : arr) {
            if (k % 2 == 0) {
                int count = 0;
                for (int i : arr) {
                    if (k == i) {
                        count++;
                    }
                }
                if (count == 1) {
                    return k;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        L3866_First_Unique_Even_Element s = new L3866_First_Unique_Even_Element();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 4, 2, 5, 4, 6};

        int res = s.firstUniqueEven(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}