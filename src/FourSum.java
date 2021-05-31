import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int sum3 = target - nums[i];  // 后3个数之和需等于sum3
            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int sum2 = sum3 - nums[j];  // 后2个数之和需等于sum3
                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == sum2) {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        res.add(quad);

                        while (left < right && nums[left++] == nums[left]) {
                        }
                        while (left < right && nums[right--] == nums[right]) {
                        }

                    } else if (nums[left] + nums[right] < sum2) {
                        while (left < right && nums[left++] == nums[left]) {
                        }

                    } else {
                        while (left < right && nums[right--] == nums[right]) {
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        FourSum s = new FourSum();

        long sysDate1 = System.currentTimeMillis();

        int[] num = {-498, -492, -473, -455, -441, -412, -390, -378, -365, -359, -358, -326, -311, -305, -277, -265, -264, -256, -254, -240, -237, -234, -222, -211, -203, -201, -187, -172, -164, -134, -131, -91, -84, -55, -54, -52, -50, -27, -23, -4, 0, 4, 20, 39, 45, 53, 53, 55, 60, 82, 88, 89, 89, 98, 101, 111, 134, 136, 209, 214, 220, 221, 224, 254, 281, 288, 289, 301, 304, 308, 318, 321, 342, 348, 354, 360, 383, 388, 410, 423, 442, 455, 457, 471, 488, 488};
        List<List<Integer>> res = s.fourSum(num, -2808);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}