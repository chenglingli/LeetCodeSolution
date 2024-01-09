public class L2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum {

    public int missingInteger(int[] nums) {
        int ps = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                ps += nums[i];
            } else {
                break;
            }
        }

        int missInt = ps;
        while (contains(nums, missInt)) {
            missInt++;
        }
        return missInt;
    }

    private static boolean contains(int[] nums, int value) {
        for (int num : nums) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        L2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum s = new L2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {3, 4, 5, 1, 12, 14, 13};
        int[] nums = {37, 1, 2, 9, 5, 8, 5, 2, 9, 4};
        int res = s.missingInteger(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}