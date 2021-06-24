public class L081_Search_in_Rotated_Sorted_Array_II {

    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {

            while(low < high && nums[low]==nums[low+1]) low++;
            while(low < high && nums[high]==nums[high-1]) high--;

            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[low]) {

                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }

            } else {
                if (target <= nums[mid] && target >= nums[low]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        L081_Search_in_Rotated_Sorted_Array_II s = new L081_Search_in_Rotated_Sorted_Array_II();

        long sysDate1 = System.currentTimeMillis();
        int[] nums = {1, 0, 1, 1, 1, 1, 1, 1};
        boolean res = s.search(nums, 0);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}