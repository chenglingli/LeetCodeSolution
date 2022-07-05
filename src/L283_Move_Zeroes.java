public class L283_Move_Zeroes {

    public void moveZeroes(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        int len = nums.length;

        int i = 0;
        int j = 0;
        while (i < len) {
            while (j < len && nums[j] == 0) {
                j++;
            }
            while (i < j && nums[i] != 0) {
                i++;
            }

            if (j == len) {
                return;
            }

            if (i != j) {
                swap(nums, i, j);
                nums[j] = 0;
            }

            j++;
            i++;
        }

    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void moveZeroes2(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[cur];
                nums[cur++] = tmp;
            }
        }
    }

    public static void main(String[] args) {

        L283_Move_Zeroes s = new L283_Move_Zeroes();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 0};
        s.moveZeroes(nums);
        System.out.println(nums);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}