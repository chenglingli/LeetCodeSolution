public class L3010_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_I {

    /*
    3 <= n <= 50
    1 <= nums[i] <= 50

    1 2 3 4 5 6 7 8 1 2

     */
    public int minimumCost(int[] nums) {

        int min1 = 51;
        int min2 = 51;

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
        }

        return nums[0] + min1 + min2;
    }

    public static void main(String[] args) {

        L3010_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_I s = new L3010_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_I();
        long sysDate1 = System.currentTimeMillis();

        //int[] nums = {1, 2, 3, 12};
        int[] nums = {10, 3, 1, 1};
        int res = s.minimumCost(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}