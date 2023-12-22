import java.util.Arrays;

public class L2733_Neither_Minimum_nor_Maximum {

    /*

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
    All values in nums are distinct

    3,2,1,4 -> 2/3
    2,3,1 -> 2

     */
    public int findNonMinOrMax(int[] nums) {
        if (nums.length <= 2) {
            return -1;
        }

        int min = 101, max = 0;

        for (int x : nums) {
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }

            if (min < x && max > x) {
                return x;
            }
        }

        // max 或 min 在最后一位
        for (int x : nums) {
            if (min < x && max > x) {
                return x;
            }
        }

        return -1;
    }

    public int findNonMinOrMax2(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        return Math.max(
                Math.min(
                        Math.max(nums[0], nums[1]),
                        nums[2]),
                Math.min(nums[0], nums[1]));
    }


    public int findNonMinOrMax3(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }

        if (nums[0] < nums[1] && nums[1] < nums[2]) {
            return nums[1];
        }
        if (nums[2] < nums[1] && nums[1] < nums[0]) {
            return nums[1];
        }

        if (nums[1] < nums[2] && nums[2] < nums[0]) {
            return nums[2];
        }
        if (nums[0] < nums[2] && nums[2] < nums[1]) {
            return nums[2];
        }

        if (nums[1] < nums[0] && nums[0] < nums[2]) {
            return nums[0];
        }
        if (nums[2] < nums[0] && nums[0] < nums[1]) {
            return nums[0];
        }

        return nums[0];
    }

    public int findNonMinOrMax4(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int[] newNums = {nums[0], nums[1], nums[2]};
        Arrays.sort(newNums);

        return newNums[1];
    }

    public static void main(String[] args) {

        L2733_Neither_Minimum_nor_Maximum s = new L2733_Neither_Minimum_nor_Maximum();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {19, 8, 17};
        int res = s.findNonMinOrMax3(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}