import java.util.Arrays;

public class L3190_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three {

    /*
    1 <= nums.length <= 50
    1 <= nums[i] <= 50
     */
    public int minimumOperations(int[] nums) {

        int res = 0;
        for (int x : nums) {
            if (x % 3 != 0) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L3190_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three s = new L3190_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 9, 8, 3, 10, 5};
        double res = s.minimumOperations(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}