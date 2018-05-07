/**
 * 检查两棵树是否长得一样
 *
 * 采用递归的方式判断
 *
 */

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int [] max =  new int[100000];
        max[0] = nums[0];
        int res = max[0];
        for(int i = 1; i< nums.length; i++) {
            if (max[i-1] >= 0) {
                max[i] = max[i-1] + nums[i];
            }
            else {
                max[i] = nums[i];
            }
            if (max[i] > res) {
                res = max[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        MaxSubArray s = new MaxSubArray();

        long sysDate1 = System.currentTimeMillis();

        int input [] = {1, 2, -3, 8, -1, 10};

        int res = s.maxSubArray(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}