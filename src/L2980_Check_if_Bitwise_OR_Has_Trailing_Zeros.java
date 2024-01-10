public class L2980_Check_if_Bitwise_OR_Has_Trailing_Zeros {

    public boolean hasTrailingZeros(int[] nums) {

        int count = 0;

        for (int x : nums) {
            if (x % 2 == 0) {
                count++;
                if (count == 2) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        L2980_Check_if_Bitwise_OR_Has_Trailing_Zeros s = new L2980_Check_if_Bitwise_OR_Has_Trailing_Zeros();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {6, 5, 7, 8};
        boolean res = s.hasTrailingZeros(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}