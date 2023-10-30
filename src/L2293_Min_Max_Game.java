import java.util.Arrays;

public class L2293_Min_Max_Game {

    public int minMaxGame(int[] nums) {

        int len = nums.length;

        while (len > 1) {

            for (int i = 0; i < len; i += 2) {
                if ((i / 2) % 2 == 0) {
                    nums[i / 2] = Math.min(nums[i], nums[i + 1]);
                } else {
                    nums[i / 2] = Math.max(nums[i], nums[i + 1]);
                }
            }

            len /= 2;
        }

        return nums[0];
    }

    public int minMaxGame2(int[] nums) {

        if (nums.length == 1) return nums[0];

        for (int i = 0; i < nums.length / 2; i++) {
            if (i % 2 == 0) nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            else nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
        }

        return minMaxGame2(Arrays.copyOf(nums, nums.length / 2));
    }

    public static void main(String[] args) {

        L2293_Min_Max_Game s =
                new L2293_Min_Max_Game();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {1, 3, 5, 2, 4, 8, 2, 2};
        int[] nums = {5, 3, 2, 2};
        int res = s.minMaxGame(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}