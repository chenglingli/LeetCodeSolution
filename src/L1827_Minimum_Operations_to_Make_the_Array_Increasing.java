public class L1827_Minimum_Operations_to_Make_the_Array_Increasing {

    /*
    1 <= nums.length <= 5000
    1 <= nums[i] <= 10^4

    1 5 6 7 8

    4 + 3 + 7 = 14
     */
    public int minOperations(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int i = 1;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] <= nums[i - 1]) {
                count += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
            i++;
        }

        return count;

    }

    public int minOperations2(int[] nums) {
        int ops = 0;
        int last = 0;

        for (int num : nums) {
            if (num <= last) {
                ops += (last + 1 - num);
                num = last + 1;
            }
            last = num;
        }

        return ops;
    }

    public static void main(String[] args) {

        L1827_Minimum_Operations_to_Make_the_Array_Increasing s = new L1827_Minimum_Operations_to_Make_the_Array_Increasing();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 5, 2, 4, 1};
        int res = s.minOperations(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}