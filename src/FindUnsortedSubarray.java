import java.util.Arrays;

public class FindUnsortedSubarray {




        public int findUnsortedSubarray1(int[] nums){
            int[] snums = nums.clone();

            Arrays.sort(nums);

            int start = snums.length, end = 0;
            for (int i = 0; i < snums.length; i++) {
                if (snums[i] != nums[i]) {
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            return (end - start >= 0 ? end - start + 1 : 0);
        }


    public int findUnsortedSubarray2( int[] nums){
        int[] snums = nums.clone();

        Arrays.sort(nums);

        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                break;
            }
        }

        for (int i = snums.length - 1; i >= 0; i--) {
            if (snums[i] != nums[i]) {
                end = Math.max(end, i);
                break;
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    int findUnsortedSubarray(int[] nums) {
        int n = nums.length, start = -1, end = -2;
        int mn = nums[n - 1], mx = nums[0];
        for (int i = 1; i < n; ++i) {
            mx = Math.max(mx, nums[i]);
            mn = Math.min(mn, nums[n - 1 - i]);
            if (mx > nums[i]) end = i;
            if (mn < nums[n - 1 - i]) start = n - 1 - i;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {

        FindUnsortedSubarray s = new FindUnsortedSubarray();

        long sysDate1 = System.currentTimeMillis();

        int [] nums = {2, 5, 4, 8, 10, 9, 15};
        // int [] nums = {1, 2, 4, 8, 9, 15};
        // int [] nums = {2, 1};
        // int[] nums = {1, 3, 2, 2, 2};
        // int [] nums = {1,2,4,5,3};
        int res = s.findUnsortedSubarray(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}