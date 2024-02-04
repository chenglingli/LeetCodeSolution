import java.util.Arrays;

public class L2341_Maximum_Number_of_Pairs_in_Array {

    /*
    1 <= nums.length <= 100
    0 <= nums[i] <= 100
     */
    public int[] numberOfPairs(int[] nums) {

        int[] count = new int[101];
        int pairsCount = 0;

        for (int x : nums) {
            count[x]++;
        }

        for (int i = 0; i < 101; i++) {
            if (count[i] >= 2) {
                pairsCount += count[i] / 2;
            }
        }

        int[] ans = new int[2];
        ans[0] = pairsCount;
        ans[1] = nums.length - pairsCount * 2;
        return ans;
    }

    public static void main(String[] args) {

        L2341_Maximum_Number_of_Pairs_in_Array s =
                new L2341_Maximum_Number_of_Pairs_in_Array();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        int[] nums = {0};
        int[] res = s.numberOfPairs(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}