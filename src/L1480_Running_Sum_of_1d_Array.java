import java.util.Arrays;

public class L1480_Running_Sum_of_1d_Array {

    public int[] runningSum(int[] nums) {
        int [] res = new int[nums.length];

        res[0] = nums[0];
        for (int i = 1 ; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

        L1480_Running_Sum_of_1d_Array s = new L1480_Running_Sum_of_1d_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4};
        int [] res = s.runningSum(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}