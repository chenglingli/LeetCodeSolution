import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L128_Longest_Consecutive_Sequence {

    /*
    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9

    return the length of the longest consecutive elements sequence.

    You must write an algorithm that runs in O(n) time.


    实现难点：
    1，不能排序，一排序就是nlogn
    2，不能用额外空间，一用额外空间就是n
     */

    // 超出空间
    public int longestConsecutive(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int[] mark = new int[max - min + 1];

        for (int x : nums) {
            mark[x - min] = 1;
        }

        int ans = 0;
        for (int i = min; i <= max; i++) {
            if (mark[i - min] == 0) {
                continue;
            }

            int j = i;
            while (j <= max && mark[j - min] == 1) {
                j++;
            }
            ans = Math.max(ans, j - i);
        }

        return ans;
    }

    // 超时
    public int longestConsecutive2(int[] nums) {

        Arrays.sort(nums);

        int ans = 0;
        int n = nums.length;

        int i = 0;
        while (i < nums.length) {

            int j = i;
            while (j < n - 1 && (nums[j] + 1 == nums[j + 1] || nums[j] == nums[j + 1])) {
                j++;
            }

            ans = Math.max(ans, nums[j] - nums[i] + 1);
            i++;
        }

        return ans;
    }


    /*
    使用Set 解决
    23ms
     */
    public int longestConsecutive3(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        int ans = 0;

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int y = x + 1;
                while (set.contains(y)) {
                    y++;
                }
                ans = Math.max(ans, y - x);
            }
        }

        return ans;
    }

    // pass
    // 比set还快 9ms
    public int longestConsecutive4(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int res = 0;

        // <1000 用排序
        if (nums.length < 1000) {

            Arrays.sort(nums);
            int current = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }

                if (nums[i] - nums[i - 1] == 1) {
                    current++;
                } else {
                    res = Math.max(res, current + 1);
                    current = 0;
                }
            }

            res = Math.max(res, current + 1);

        } else {
            // >=1000 用bit

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int num : nums) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            byte[] bits = new byte[max - min + 1];
            for (int num : nums) {
                bits[num - min] = 1;
            }

            int current = 0;
            for (byte bit : bits) {
                if (bit > 0) {
                    current++;
                } else {
                    res = Math.max(res, current);
                    current = 0;
                }
            }

            res = Math.max(res, current);
        }

        return res;
    }

    public static void main(String[] args) {

        L128_Longest_Consecutive_Sequence s = new L128_Longest_Consecutive_Sequence();

        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {100, 4, 200, 1, 3, 2};
        // int[] nums = {1, 2, 0, 1};
        int[] nums = {0, 1, 2, 4, 8, 5, 6, 7, 9, 3, 55, 88, 77, 99, 999999999};
        int x = s.longestConsecutive4(nums);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}