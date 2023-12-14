public class L2455_Average_Value_of_Even_Numbers_That_Are_Divisible_by_Three {

    /*
    1 <= nums.length <= 1000
    1 <= nums[i] <= 1000
     */
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;

        for (int x : nums) {
            if (x % 6 == 0) {
                sum += x;
                count++;
            }
        }

        if (count != 0) {
            return sum / count;
        }
        return 0;
    }

    public static void main(String[] args) {

        L2455_Average_Value_of_Even_Numbers_That_Are_Divisible_by_Three s = new L2455_Average_Value_of_Even_Numbers_That_Are_Divisible_by_Three();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 3, 6, 10, 12, 15};
        int res = s.averageValue(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}