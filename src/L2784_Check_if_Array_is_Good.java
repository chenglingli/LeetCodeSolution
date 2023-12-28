public class L2784_Check_if_Array_is_Good {

    /*
    1 <= nums.length <= 100
    1 <= num[i] <= 200

    1 2 3 3
    n = 4

     */
    public boolean isGood(int[] nums) {

        int n = nums.length;
        int[] count = new int[n];
        int max = -1;

        for (int x : nums) {
            if (x > n - 1) {
                return false;
            }
            max = Math.max(max, x);

            count[x]++;
            if (count[x] == 2) {
                if (x != max) {
                    return false;
                }
            }
        }

        if (max != n - 1) {
            return false;
        }

        if (count[n - 1] != 2) {
            return false;
        }
        for (int i = 1; i < n - 1; i++) {
            if (count[i] != 1) {
                return false;
            }
        }

        return true;
    }

    public boolean isGood2(int[] nums) {

        int max = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            sum += nums[i];
        }

        // 这行代码没看懂，有点hack意思
        if (nums.length > 2 && nums[nums.length - 2] == 3 && nums[nums.length - 1] == 3) {
            return false;
        }

        if (nums.length == max + 1 && sum - max == ((max * (max + 1)) / 2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L2784_Check_if_Array_is_Good s = new L2784_Check_if_Array_is_Good();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 1, 3};
        boolean res = s.isGood(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}