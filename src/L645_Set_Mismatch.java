import java.util.Arrays;

public class L645_Set_Mismatch {

    /*
    2 <= nums.length <= 10^4
    1 <= nums[i] <= 10^4


     */
    public int[] findErrorNums(int[] nums) {

        int[] count = new int[nums.length];

        int i = 0;
        int repeatNum = -1;
        while (i < nums.length) {
            count[nums[i] - 1]++;
            if (count[nums[i] - 1] == 2) {
                repeatNum = nums[i];
            }
            i++;
        }

        i = 0;
        int missNum = -1;
        while (i < nums.length) {
            if (count[i] == 0) {
                missNum = i + 1;
                break;
            }
            i++;
        }

        return new int[]{repeatNum, missNum};
    }


    public int[] findErrorNums2(int[] nums) {
        int[] out = new int[2];
        int[] count = new int[nums.length];

        for (int num : nums) {
            count[num - 1]++;
            if (count[num - 1] == 2) {
                out[0] = num;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                out[1] = i + 1;
            }
        }

        return out;
    }

    public static void main(String[] args) {

        L645_Set_Mismatch s = new L645_Set_Mismatch();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 2};
        //        int[] nums = {3, 2, 2};
        int[] res = s.findErrorNums(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}