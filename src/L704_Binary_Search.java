public class L704_Binary_Search {

    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        L704_Binary_Search s = new L704_Binary_Search();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int[] nums2 = {-2, 2, 4, 6, 10, 100};
        //        int target = 4;
        //        int res = s.search(nums, 2);
        //        System.out.println(res);

        for (int i = 0; i < nums.length; i++) {
            int res = s.search(nums, nums[i]);
            System.out.println(res);
        }

        for (int i = 0; i < nums2.length; i++) {
            int res = s.search(nums, nums2[i]);
            System.out.println(res);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}