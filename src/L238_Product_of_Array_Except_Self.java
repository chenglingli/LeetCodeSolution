
import java.util.Arrays;

public class L238_Product_of_Array_Except_Self {

    /*
    2 <= nums.length <= 10^5
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.

    使用两遍遍历法，左边累积乘一下，右边累积乘一下
    两遍遍历
	第一遍，从左到目前为止的乘积
	第二遍，从右到目前为止的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int cumulateMultiply = 1;
        for (int i = 0; i < len; i++) {
            res[i] = cumulateMultiply;
            cumulateMultiply *= nums[i];
        }

        cumulateMultiply = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= cumulateMultiply;
            cumulateMultiply *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

        L238_Product_of_Array_Except_Self s = new L238_Product_of_Array_Except_Self();

        long sysDate1 = System.currentTimeMillis();

         int[] nums = {1, 2, 3, 4};
//        int[] nums = {-1, 1, 0, -3, 3};

        int[] res = s.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}