public class L1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing {

    /*
    2 <= nums.length <= 1000
    1 <= nums[i] <= 1000

     return true if it can be made strictly increasing after removing exactly one element

     */
    public boolean canBeIncreasing(int[] nums) {

        if (nums.length <= 2) {
            return true;
        }

        int i = 0;
        while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == nums.length - 1) {
            return true;
        }

        // 1 2* 34 -> 1 3 4
        boolean ans = canBeIncrease(i + 1, nums.length, nums);
        if (ans) {
            if (i > 0 && i < nums.length - 1) {
                if (nums[i - 1] < nums[i + 1]) {
                    return true;
                }
            } else {
                return true;
            }
        }

        if (i < nums.length - 1) {
            if (ans && nums[i - 1] < nums[i + 1]) {
                return true;
            }
        } else {
            if (ans) {
                return true;
            }
        }

        // 1 2* 3 4 ->1 2 4
        ans = canBeIncrease(i + 2, nums.length, nums);
        if (i < nums.length - 2) {
            return ans && nums[i] < nums[i + 2];
        }
        return ans;

    }

    /*
    [ )
     */
    boolean canBeIncrease(int f, int t, int[] nums) {
        int i = f;
        while (i < t - 1 && nums[i] < nums[i + 1]) {
            i++;
        }

        return i >= t - 1;
    }

    public static void main(String[] args) {

        L1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing s = new L1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing();
        long sysDate1 = System.currentTimeMillis();

        // int[] num = {2,1,3};
        // int[] num = {2, 3, 1};
        int[] num = {100, 21, 100};
        // int[] num = {105, 924, 32, 968};
        // int[] num = {1, 2, 9, 4, 7};

        boolean res = s.canBeIncreasing(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}