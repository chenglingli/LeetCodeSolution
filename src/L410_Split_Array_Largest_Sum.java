public class L410_Split_Array_Largest_Sum {

    /**
     * Given an array which consists of non-negative integers
     * and an integer m, you can split the array into m non-empty continuous subarrays.
     * <p>
     * Write an algorithm to minimize the largest sum among these m subarrays.
     * <p>
     * Note:
     * If n is the length of array, assume the following constraints are satisfied:
     * <p>
     * 1 ≤ n ≤ 1000
     * 1 ≤ m ≤ min(50, n)
     * Examples:
     * <p>
     * Input:
     * nums = [7,2,5,10,8]
     * m = 2
     * <p>
     * Output:
     * 18
     * <p>
     * Explanation:
     * There are four ways to split nums into two subarrays.
     * The best way is to split it into [7,2,5] and [10,8],
     * where the largest sum among the two subarrays is only 18.
     */

    public int splitArray(int[] nums, int m) {

        long left = 0, right = 0;
        for (int i = 0; i < nums.length; ++i) {
            left = Integer.max((int) left, nums[i]);
            right += nums[i];
        }

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canSplit(nums, m, (int) mid))
                right = mid;
            else
                left = mid + 1;
        }
        return (int) left;
    }

    private boolean canSplit(int[] nums, int m, int sum) {
        int cnt = 1, curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > sum) {
                curSum = nums[i];
                cnt++;
                if (cnt > m)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        L410_Split_Array_Largest_Sum s = new L410_Split_Array_Largest_Sum();
        long sysDate1 = System.currentTimeMillis();

        int[] matrix = {7, 2, 5, 10, 8};

        int res = s.splitArray(matrix, 2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}