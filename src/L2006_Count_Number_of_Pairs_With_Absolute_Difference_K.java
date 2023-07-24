public class L2006_Count_Number_of_Pairs_With_Absolute_Difference_K {


    /*
    1 <= nums.length <= 200
    1 <= nums[i] <= 100
    1 <= k <= 99

    pairs (i, j) where i < j
        such that |nums[i] - nums[j]| == k.

    k = 1;
    111 22


     */
    public int countKDifference(int[] nums, int k) {

        int res = 0;
        int[] mark = new int[101];

        for (int num : nums) {
            mark[num]++;
        }

        for (int i = 1; i + k <= 100; i++) {
            res += mark[i] * mark[i + k];
        }

        return res;
    }

    public static void main(String[] args) {

        L2006_Count_Number_of_Pairs_With_Absolute_Difference_K s = new L2006_Count_Number_of_Pairs_With_Absolute_Difference_K();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 2, 1, 5, 4};
        int k = 2;
        int res = s.countKDifference(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}