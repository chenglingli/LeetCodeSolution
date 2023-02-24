public class L1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum {

    public int minStartValue(int[] nums) {

        int sum = nums[0];
        int min = sum;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }

        if (min <= 0) {
            return min * -1 + 1;
        }

        return 1;
    }

    public static void main(String[] args) {

        L1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum s = new L1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum();
        long sysDate1 = System.currentTimeMillis();

//        int[] nums = {-3, 2, -3, 4, 2};
        int[] nums = {1, -1};
//        int[] nums = {1, -2, -3};
        int res = s.minStartValue(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}