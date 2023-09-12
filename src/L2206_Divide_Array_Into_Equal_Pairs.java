public class L2206_Divide_Array_Into_Equal_Pairs {

    /*
    nums.length == 2 * n
    1 <= n <= 500
    1 <= nums[i] <= 500
     */
    public boolean divideArray(int[] nums) {

        int[] count = new int[501];

        for (int x : nums) {
            count[x]++;
        }

        for (int i = 1; i <= 500; i++) {
            if (count[i] != 0) {
                if (count[i] % 2 != 0) {
                    return false;
                }
            }
        }

        return true;
    }


    public boolean divideArray2(int[] nums) {

        long xor = 0;

        for (int num : nums) {
            xor ^= (1L << num);
        }

        return xor == 0;
    }

    public static void main(String[] args) {

        L2206_Divide_Array_Into_Equal_Pairs s =
                new L2206_Divide_Array_Into_Equal_Pairs();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 2, 3, 2, 2, 2};
        boolean res = s.divideArray(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}