public class L908_Smallest_Range_I {

    public int smallestRangeI(int[] nums, int k) {

        if (nums.length <= 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        return (max - min) <= k * 2 ? 0 : (max - min) - k * 2;

    }

    public static void main(String[] args) {

        L908_Smallest_Range_I s = new L908_Smallest_Range_I();

        long sysDate1 = System.currentTimeMillis();
        // int [] nums = {2, 5, 4, 8, 10, 9, 15};
        // int [] nums = {3,1,2,4};
        int[] nums = {1, 3, 6};
        int k = 3;
        int res = s.smallestRangeI(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}