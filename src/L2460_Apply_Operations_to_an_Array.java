import java.util.Arrays;

public class L2460_Apply_Operations_to_an_Array {

    public int[] applyOperations(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int i = 0;
        int j = 0;

        while (j < n) {
            while (i < n && nums[i] != 0) {
                i++;
            }

            j = i;
            while (j < n && nums[j] == 0) {
                j++;
            }
            if (j == n) {
                break;
            }
            nums[i] = nums[j];
            nums[j] = 0;
        }

        return nums;
    }

    public int[] applyOperations2(int[] nums) {

        int curr = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {

                if (i + 1 < n && nums[i + 1] == nums[i]) {
                    nums[curr] = nums[i] * 2;
                    nums[i + 1] = 0;
                } else {
                    nums[curr] = nums[i];
                }

                curr++;
            }
        }

        for (; curr < n; curr++) {
            nums[curr] = 0;
        }

        return nums;
    }

    public static void main(String[] args) {

        L2460_Apply_Operations_to_an_Array s = new L2460_Apply_Operations_to_an_Array();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {1, 2, 2, 1, 1, 0};
        int[] nums = {847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272};
        // 1694,399,832,1758,412,206,272,0,0,0,0,0,0,0
        int[] res = s.applyOperations2(nums);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}