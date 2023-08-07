public class L2057_Smallest_Index_With_Equal_Value {


    /*
    1 <= nums.length <= 100
    0 <= nums[i] <= 9
     */
    public int smallestEqual(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i % 10 == nums[i]) {
                return i;
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {

        L2057_Smallest_Index_With_Equal_Value s = new L2057_Smallest_Index_With_Equal_Value();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {7, 8, 3, 5, 2, 6, 3, 1, 1, 4, 5, 4, 8, 7, 2, 0, 9, 9, 0, 5, 7, 1, 6};
        int res = s.smallestEqual(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}