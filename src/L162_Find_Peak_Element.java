public class L162_Find_Peak_Element {

    /**
     * A peak element is an element that is greater than its neighbors.
     * <p>
     * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
     * <p>
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * <p>
     * You may imagine that nums[-1] = nums[n] = -∞.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,1]
     * Output: 2
     * Explanation: 3 is a peak element and your function should return the index number 2.
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [1,2,1,3,5,6,4]
     * Output: 1 or 5
     * Explanation: Your function can return either index number 1 where the peak element is 2,
     * or index number 5 where the peak element is 6.
     * Note:
     * <p>
     * Your solution should be in logarithmic complexity.
     */

    public int findPeakElement(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        if (nums[0] > nums[len - 1]) {
            return 0;
        }
        return len - 1;
    }

    public int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    public static void main(String[] args) {

        L162_Find_Peak_Element s = new L162_Find_Peak_Element();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 2, 1};
        int res = s.findPeakElement(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}