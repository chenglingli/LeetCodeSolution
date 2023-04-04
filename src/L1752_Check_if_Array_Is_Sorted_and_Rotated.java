public class L1752_Check_if_Array_Is_Sorted_and_Rotated {


    public boolean check(int[] nums) {

        int i = 0;

        while (i + 1 < nums.length) {
            if (nums[i] <= nums[i + 1]) {
                i++;
            } else {
                return (nums[nums.length - 1] <= nums[0]
                        && isNonDecreasing(nums, i + 1, nums.length));
            }
        }

        return true;
    }

    /*
    from f to t : [1, 10]
    inclusive
     */
    private boolean isNonDecreasing(int[] nums, int from, int to) {
        int i = from;

        while (i + 1 < to) {
            if (nums[i + 1] < nums[i]) return false;
            i++;
        }

        return true;
    }

    public static void main(String[] args) {

        L1752_Check_if_Array_Is_Sorted_and_Rotated s = new L1752_Check_if_Array_Is_Sorted_and_Rotated();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {6, 1, 2, 3, 4, 5};
        //        int[] nums = {1};
        //        int[] nums = {6, 6, 1, 2, 3, 4, 5};
        int[] nums = {2, 1, 3, 4};
        boolean res = s.check(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}