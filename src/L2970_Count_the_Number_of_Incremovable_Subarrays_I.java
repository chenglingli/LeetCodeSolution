public class L2970_Count_the_Number_of_Incremovable_Subarrays_I {

    public int incremovableSubarrayCount(int[] nums) {

        int len = nums.length, maxi = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (check(nums, i, j)) {
                    maxi++;
                }
            }
        }

        return maxi;
    }

    private boolean check(int[] nums, int low, int high) {

        for (int i = 0; i < low - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }

        if (low > 0 && high < nums.length - 1 && nums[low - 1] >= nums[high + 1]) {
            return false;
        }

        for (int i = high + 1; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public int incremovableSubarrayCount2(int[] nums) {

        int n = nums.length;
        int pos1 = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pos1 = i;
            } else {
                break;
            }
        }

        //boundary case
        if (pos1 == 0) {
            return n * (n + 1) / 2;
        }

        int pos2 = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                pos2 = i;
            } else {
                break;
            }
        }

        //System.out.println(pos+" "+pos2);

        //[0,pos2]....[pos1,n-1]

        //nothing on the left
        int ans = (n - pos1 + 1);


        /*
        9 8 7  6 7  5 7 8

         */
        for (int i = 0; i <= pos2; i++) {
            while (pos1 < n && nums[pos1] <= nums[i]) {
                pos1++;
            }
            ans += n - pos1 + 1;
        }

        return ans;
    }

    public static void main(String[] args) {

        L2970_Count_the_Number_of_Incremovable_Subarrays_I s = new L2970_Count_the_Number_of_Incremovable_Subarrays_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {6, 5, 7, 8};
        int res = s.incremovableSubarrayCount2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}