import java.util.Arrays;

public class L2239_Find_Closest_Number_to_Zero {

    /*
    1 <= n <= 1000
    -10^5 <= nums[i] <= 10^5
     */
    public int findClosestNumber(int[] nums) {

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int mid = (i + j) / 2;

            if (nums[mid] < 0) {
                i = mid + 1;
            } else if (nums[mid] > 0) {
                j = mid;
            } else {
                return 0;
            }
        }

        if (i >= 1 && nums[i - 1] < 0 && nums[i - 1] * (-1) < nums[i]) {
            return nums[i - 1];
        }
        return nums[i];
    }

    public int findClosestNumber2(int[] nums) {
        int ans = 0, d = 1000000;

        for (int v : nums) {
            int t = Math.abs(v);
            if (t < d || (t == d && v > ans)) {
                ans = v;
                d = t;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2239_Find_Closest_Number_to_Zero s =
                new L2239_Find_Closest_Number_to_Zero();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {-4, -2, 3, 4, 8};
        //        int[] nums = {-4, -1, 3, 4, 8};
        //        int[] nums = {0};
        int res = s.findClosestNumber2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}