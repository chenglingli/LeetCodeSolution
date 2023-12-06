import java.util.HashSet;
import java.util.Set;

public class L2395_Find_Subarrays_With_Equal_Sum {

    /*
        2 <= nums.length <= 1000
        -10^9 <= nums[i] <= 10^9
     */
    public boolean findSubarrays(int[] nums) {
        Set<Integer> existSum = new HashSet<>();

        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp += nums[i];
            if (existSum.contains(temp)) {
                return true;
            } else {
                existSum.add(temp);
            }

            temp -= nums[i - 1];
        }

        return false;
    }

    public boolean findSubarrays2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i < nums.length; i++) {
            if (!set.add(nums[i - 1] + nums[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        L2395_Find_Subarrays_With_Equal_Sum s =
                new L2395_Find_Subarrays_With_Equal_Sum();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4};
        boolean res = s.findSubarrays(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}