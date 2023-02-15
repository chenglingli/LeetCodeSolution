import java.util.Arrays;

public class L1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X {

    /*
        判断 是否存在，有x个数字大于x

        先进行nums 排序，然后从高到低，依次判断是否满足 当前count就是ans
     */
    public int specialArray(int[] nums) {

        Arrays.sort(nums);

        int i = nums.length - 1;
        while (i >= 1) {

            while (i >= 1 && nums[i - 1] == nums[i]) {
                i--;
            }

            if (i == 0) {
                break;
            }

            int count = nums.length - i;
            if (nums[i - 1] < count && nums[i] >= count) {
                return count;
            }

            i--;
        }

        if (nums[0] >= nums.length) {
            return nums.length;
        }

        return -1;
    }

    // 对ans进行二分尝试

    public int specialArray2(int[] nums) {

        int s = 0;
        int e = nums.length;
        int count = 0;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            count = 0;

            for (int num : nums) {
                if (num >= mid) {
                    count++;
                }
            }

            if (count == mid) {
                return mid;
            } else if (count > mid) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        L1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X s = new L1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X();
        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {0, 4, 3, 0, 4};
        //        int[] nums = {3, 5};
        //                int[] nums = {0, 0};
        int[] nums = {3, 6, 7, 7, 0};
        int res = s.specialArray(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}