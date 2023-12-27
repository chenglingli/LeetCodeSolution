import java.util.Arrays;

public class L2974_Minimum_Number_Game {

    public int[] numberGame(int[] nums) {

        Arrays.sort(nums);
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i += 2) {
            res[i] = nums[i + 1];
            res[i + 1] = nums[i];
        }

        return res;
    }

    public int[] numberGame2(int[] nums) {

        int[] count = new int[101];
        for (int x : nums)
            count[x]++;
        int n = nums.length;

        int index = 0;
        for (int i = 1; i <= 100; ++i) {
            int c = count[i];
            while (c-- > 0) {
                nums[index++] = i;
            }
        }

        for (int i = 0; i < n; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {

        L2974_Minimum_Number_Game s = new L2974_Minimum_Number_Game();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {6, 5, 7, 8};
        int[] res = s.numberGame(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}