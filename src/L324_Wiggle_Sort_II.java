import java.util.Arrays;

public class L324_Wiggle_Sort_II {

    /*

    Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

    You may assume the input array always has a valid answer.



    Example 1:

    Input: nums = [1,5,1,1,6,4]
    Output: [1,6,1,5,1,4]
    Explanation: [1,4,1,5,1,6] is also accepted.

    Example 2:
    Input: nums = [1,3,2,2,3,1]
    Output: [2,3,1,3,1,2]


    Constraints:

    1 <= nums.length <= 5 * 10^4
    0 <= nums[i] <= 5000
    It is guaranteed that there will be an answer for the given input nums.

     */
    public void wiggleSort(int[] nums) {
        // 1. 先排序
        // 2. 找到中位数
        // 3. 重新排列

        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[n];
        int mid = (n - 1) / 2;

        for (int i = n - 1, j = mid, k = 0; k < n; k++) {
            if (k % 2 == 0) {
                res[k] = nums[j--];
            } else {
                res[k] = nums[i--];
            }
        }

        System.arraycopy(res, 0, nums, 0, n);
    }

    public void wiggleSort2(int[] nums) {
        int n = nums.length - 1;

        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = arr[n--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = arr[n--];
        }
    }

    /*
        1. 计数排序
        此方法更快的原因是：数组长度可能达到 50000，但数组最大值是5000，所以没必要对整个数组进行排序
     */
    public void wiggleSort3(int[] nums) {

        int n = nums.length;

        // Step 1: Count frequencies
        int[] count = new int[5001];
        for (int num : nums) {
            count[num]++;
        }

        // Step 2: Fill from largest → smallest
        int idx = 5000;

        // Fill odd indices first (1,3,5...)
        for (int i = 1; i < n; i += 2) {
            while (count[idx] == 0) idx--;
            nums[i] = idx;
            count[idx]--;
        }

        // Fill even indices (0,2,4...)
        for (int i = 0; i < n; i += 2) {
            while (count[idx] == 0) idx--;
            nums[i] = idx;
            count[idx]--;
        }
    }

    public static void main(String[] args) {


        L324_Wiggle_Sort_II s = new L324_Wiggle_Sort_II();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 5, 1, 1, 6, 4};
        s.wiggleSort(nums);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}