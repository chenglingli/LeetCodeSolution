public class removeDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0, j = 0;
        int curIndex = 0;
        int val = nums[curIndex];
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
            } else {
                // update val
                curIndex = j;
                val = nums[curIndex];

                if (i != j - 1) {
                    i++;
                    nums[i] = nums[j];
                } else {
                    i++;
                }

                j++;
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {

        removeDuplicates s = new removeDuplicates();

        long sysDate1 = System.currentTimeMillis();

        int nums[] = {1, 2};
        int res = s.removeDuplicates(nums);
        System.out.print("res:");
        System.out.println(res);

        System.out.println("nums:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}