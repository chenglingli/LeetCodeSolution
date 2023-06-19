public class L1822_Sign_of_the_Product_of_an_Array {

    public int arraySign(int[] nums) {

        int count = 0;
        for (int x : nums) {
            if (x == 0) {
                return 0;
            }
            if (x < 0) {
                count++;
            }
        }

        if (count % 2 == 0) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        L1822_Sign_of_the_Product_of_an_Array s = new L1822_Sign_of_the_Product_of_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {};
        int res = s.arraySign(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}