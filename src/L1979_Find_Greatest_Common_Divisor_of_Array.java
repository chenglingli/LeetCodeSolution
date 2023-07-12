public class L1979_Find_Greatest_Common_Divisor_of_Array {


    /*
    2 <= nums.length <= 1000
    1 <= nums[i] <= 1000
     */
    public int findGCD(int[] nums) {
        int min = 1001;
        int max = 0;
        for (int x : nums) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }

        int x = min;
        while (x >= 1) {
            if (min % x == 0 && max % x == 0) {
                return x;
            }
            x--;
        }

        return 1;
    }

    public static void main(String[] args) {

        L1979_Find_Greatest_Common_Divisor_of_Array s = new L1979_Find_Greatest_Common_Divisor_of_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 9, 18};
        int res = s.findGCD(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}