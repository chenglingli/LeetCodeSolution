public class L2357_Make_Array_Zero_by_Subtracting_Equal_Amounts {

    /*
    1 <= nums.length <= 100
    0 <= nums[i] <= 100
     */
    public int minimumOperations(int[] nums) {
        int[] count = new int[101];
        for (int x : nums) {
            count[x]++;
        }
        int ans = 0;
        for (int i = 1; i < 101; i++) {
            if (count[i] != 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2357_Make_Array_Zero_by_Subtracting_Equal_Amounts s =
                new L2357_Make_Array_Zero_by_Subtracting_Equal_Amounts();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 5, 0, 3, 5};
        int res = s.minimumOperations(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}