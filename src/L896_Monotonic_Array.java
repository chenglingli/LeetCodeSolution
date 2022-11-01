public class L896_Monotonic_Array {

    public boolean isMonotonic(int[] nums) {

        if (nums.length <= 2) {
            return true;
        }

        int i = 1;
        while (i < nums.length && nums[i - 1] <= nums[i]) {
            i++;
        }
        if (i == nums.length) {
            return true;
        }

        i = 1;
        while (i < nums.length && nums[i - 1] >= nums[i]) {
            i++;
        }
        if (i == nums.length) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L896_Monotonic_Array s = new L896_Monotonic_Array();

        long sysDate1 = System.currentTimeMillis();
        // int [] nums = {2, 5, 4, 8, 10, 9, 15};
        // int [] nums = {3,1,2,4};
        int[] nums = {2, 1, 3};
        boolean res = s.isMonotonic(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}