import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L300_Longest_Increasing_Subsequence {

    /*

    1 <= nums.length <= 2500
    -10^4 <= nums[i] <= 10^4

    f[i]

     */
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] record = new int[n];
        record[0] = 1;
        int ans = record[0];

        for (int i = 1; i < n; i++) {
            int cur = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && record[j] >= cur) {
                    cur = record[j] + 1;
                }
            }
            record[i] = cur;
            ans = Math.max(record[i], ans);
        }

        return ans;
    }

    /**
     * f
     */
    public int lengthOfLIS2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> orderList = new ArrayList<>();
        orderList.add(nums[0]);
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > orderList.getLast()) {
                // nums[i] > the last element of orderList array
                orderList.add(nums[i]);
                len++;

            } else {
                // Replacement step
                int ind = Collections.binarySearch(orderList, nums[i]);

                if (ind < 0) {
                    ind = -ind - 1;
                }

                orderList.set(ind, nums[i]);
            }
        }

        return len;
    }

    /*
    和2一样方法，维护一个数组，保持当前的最长增长序列
     */
    public int lengthOfLIS3(int[] nums) {

        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;

            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }

            tails[i] = x;

            if (i == size)
                ++size;
        }

        return size;
    }

    public static void main(String[] args) {

        L300_Longest_Increasing_Subsequence s = new L300_Longest_Increasing_Subsequence();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int res = s.lengthOfLIS2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}