public class L033_Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
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

        return -1;
    }

    public static void main(String[] args) {

        L033_Search_in_Rotated_Sorted_Array s = new L033_Search_in_Rotated_Sorted_Array();

        long sysDate1 = System.currentTimeMillis();
        int[] nums = {5, 6, 7, 8, 0, 1, 2, 3};
        int res = s.search(nums, 3);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}