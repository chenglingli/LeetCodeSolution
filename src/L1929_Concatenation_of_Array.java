import java.util.Arrays;

public class L1929_Concatenation_of_Array {

    /*
    n == nums.length
    1 <= n <= 1000
    1 <= nums[i] <= 1000
     */
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }

        for (; i < nums.length * 2; i++) {
            res[i] = nums[i - nums.length];
        }

        return res;
    }

    public int[] getConcatenation2(int[] nums) {

        int res[] = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }

        return res;
    }


    public static void main(String[] args) {

        L1929_Concatenation_of_Array s = new L1929_Concatenation_of_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 3, 2, 1};
        int[] res = s.getConcatenation(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}