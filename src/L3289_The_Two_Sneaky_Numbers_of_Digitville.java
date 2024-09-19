import java.util.Arrays;

public class L3289_The_Two_Sneaky_Numbers_of_Digitville {

    /*
    2 <= n <= 100
    nums.length == n + 2
    0 <= nums[i] < n
     */
    public int[] getSneakyNumbers(int[] nums) {
        int len = nums.length;
        int[] res = new int[2];
        int i = 0;

        int[] count = new int[len - 2];
        for (int x : nums) {
            count[x]++;
            if (count[x] == 2) {
                res[i++] = x;
                if (i == 2) {
                    return res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L3289_The_Two_Sneaky_Numbers_of_Digitville s = new L3289_The_Two_Sneaky_Numbers_of_Digitville();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {0, 3, 2, 1, 3, 2};

        int[] res = s.getSneakyNumbers(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}