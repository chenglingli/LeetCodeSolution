public class L3718_Smallest_Missing_Multiple_of_K {

    /*
    Given an integer array nums and an integer k, return the smallest positive multiple of k that is missing from nums.

    A multiple of k is any positive integer divisible by k.



    Example 1:

    Input: nums = [8,2,3,4,6], k = 2

    Output: 10

    Explanation:

    The multiples of k = 2 are 2, 4, 6, 8, 10, 12... and the smallest multiple missing from nums is 10.

    Example 2:

    Input: nums = [1,4,7,10,15], k = 5

    Output: 5

    Explanation:

    The multiples of k = 5 are 5, 10, 15, 20... and the smallest multiple missing from nums is 5.



    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
    1 <= k <= 100

     */
    public int missingMultiple(int[] nums, int k) {
        int[] exist = new int[101];
        for (int num : nums) {
            exist[num] = 1;
        }

        int i =1;
        while (k * i <= 100) {
            if (exist[k * i] == 0) {
                return k * i;
            }
            i++;
        }

        return k * i;
    }

    public static void main(String[] args) {

        L3718_Smallest_Missing_Multiple_of_K s = new L3718_Smallest_Missing_Multiple_of_K();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = new int[]{42, 13, 99, 13, 71, 32, 64, 32, 63, 44, 6, 22, 8, 2, 55, 88, 43, 40, 71, 80, 95, 32, 46, 19};
        int k = 44;

        int res = s.missingMultiple(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}