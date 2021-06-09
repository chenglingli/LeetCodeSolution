public class L053_Maximum_Subarray {

    /*
     *
     * sum[i] 表示以i元素结尾的最大子串和
     * sum[i] = max {sum[i-1] + num[i], num[i]}
     *
     */

    public int maxSubArray(int[] nums) {
        int[] max = new int[100000];
        max[0] = nums[0];
        int res = max[0];
        for (int i = 1; i < nums.length; i++) {
            if (max[i - 1] >= 0) {
                max[i] = max[i - 1] + nums[i];
            } else {
                max[i] = nums[i];
            }
            if (max[i] > res) {
                res = max[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L053_Maximum_Subarray s = new L053_Maximum_Subarray();

        long sysDate1 = System.currentTimeMillis();

        int input[] = {1, 2, -3, 8, -1, 10};

        int res = s.maxSubArray(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}