public class L1464_Maximum_Product_of_Two_Elements_in_an_Array {

    public int maxProduct(int[] nums) {

        int m1 = Math.max(nums[0], nums[1]);
        int m2 = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > m1) {
                m2 = m1;
                m1 = nums[i];
            } else if (nums[i] > m2) {
                m2 = nums[i];
            }
        }

        return (m1 - 1) * (m2 - 1);
    }

    public static void main(String[] args) {

        L1464_Maximum_Product_of_Two_Elements_in_an_Array s = new L1464_Maximum_Product_of_Two_Elements_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 8, 5, 2, 3};
        int res = s.maxProduct(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}