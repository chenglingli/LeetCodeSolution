import java.util.Arrays;

public class L1920_Build_Array_from_Permutation {

    /*
    ans[i] = nums[nums[i]]

    1 <= nums.length <= 1000
    0 <= nums[i] < nums.length
    The elements in nums are distinct.

     */
    public int[] buildArray(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];

        for (int i = 0; i < l; i++) {
            res[i] = nums[nums[i]];
        }

        return res;
    }

    public static void main(String[] args) {

        L1920_Build_Array_from_Permutation s = new L1920_Build_Array_from_Permutation();
        long sysDate1 = System.currentTimeMillis();

        int[] num = {0, 2, 1, 5, 3, 4};
        int[] res = s.buildArray(num);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}