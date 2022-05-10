public class L152_Maximum_Product_Subarray {

    /**
     * 维持
     * maxValue
     * minValue
     */
    public int maxProduct(int[] nums) {

        int len = nums.length;
        int[] maxValue = new int[len];
        int[] minValue = new int[len];
        maxValue[0] = nums[0];
        minValue[0] = nums[0];
        int maxAns = nums[0];
        for (int i = 1; i < len; i++) {
            maxValue[i] = max(maxValue[i - 1] * nums[i], nums[i], minValue[i - 1] * nums[i]);
            minValue[i] = min(maxValue[i - 1] * nums[i], nums[i], minValue[i - 1] * nums[i]);
            maxAns = Math.max(maxValue[i], maxAns);
        }
        return maxAns;
    }

    int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {

        L152_Maximum_Product_Subarray s = new L152_Maximum_Product_Subarray();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 3, -2, 4};
        int res = s.maxProduct(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}