import java.util.Arrays;

public class L1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores {


    /*
    1 <= k <= nums.length <= 1000
    0 <= nums[i] <= 105
     */
    public int minimumDifference(int[] nums, int k) {

        if (k == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int ans = 100001;

        int i = 0;
        int j = i + k - 1;
        while (j < nums.length) {
            ans = Math.min(nums[j] - nums[i], ans);
            i++;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores s = new L1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {87063, 61094, 44530, 21297, 95857, 93551, 9918};
        int k = 6;
        int res = s.minimumDifference(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}