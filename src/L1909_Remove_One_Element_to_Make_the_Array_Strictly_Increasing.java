public class L1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing {

    /*
    2 <= nums.length <= 1000
    1 <= nums[i] <= 1000

     return true if it can be made strictly increasing after removing exactly one element

     */
    public boolean canBeIncreasing(int[] nums) {

        int i = 1;
        while (i < nums.length && nums[i] > nums[i - 1]) {
            i++;
        }

        if (i == nums.length) {
            return true;
        }

        nums[i - 1] = 0;
        while (i < nums.length && nums[i] > nums[i - 1]) {
            i++;
        }

        return i == nums.length;
    }

    public static void main(String[] args) {

        L1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing s = new L1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing();
        long sysDate1 = System.currentTimeMillis();

        int[] num = {1, 2, 10, 5, 17};
        // int[] num = {1, 2, 9, 4, 7};

        boolean res = s.canBeIncreasing(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}