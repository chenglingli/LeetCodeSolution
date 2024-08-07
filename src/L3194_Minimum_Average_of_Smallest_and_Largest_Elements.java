import java.util.Arrays;

public class L3194_Minimum_Average_of_Smallest_and_Largest_Elements {

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        double ans = Integer.MAX_VALUE;
        int i = 0;
        while ( i < n) {
            ans = Math.min(ans, (nums[i] + nums[n - 1 - i]) / 2.0);
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L3194_Minimum_Average_of_Smallest_and_Largest_Elements s = new L3194_Minimum_Average_of_Smallest_and_Largest_Elements();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 9, 8, 3, 10, 5};
        double res = s.minimumAverage(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}