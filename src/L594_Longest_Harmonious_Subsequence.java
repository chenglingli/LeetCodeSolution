import java.util.Arrays;

public class L594_Longest_Harmonious_Subsequence {


    public int findLHS(int[] nums) {

        Arrays.sort(nums);

        int ans = 0;

        int i = 0;

        int preCount = 0;
        int preValue = nums[0] - 1;

        while (i < nums.length) {

            int postCount = 0;

            while (i < nums.length && nums[i] - preValue == 1) {
                i++;
                postCount++;
            }

            if (postCount == 0) {
                int j = i;
                while (i < nums.length && nums[i] == nums[j]) {
                    i++;
                    postCount++;
                }

                preCount = postCount;

                preValue = nums[i - 1];
                continue;
            }

            int tempCount = preCount + postCount;
            if (preCount != 0 && tempCount > ans) {
                ans = tempCount;
            }

            preCount = postCount;
            preValue = nums[i - 1];

        }

        return ans;
    }

    public int findLHS2(int[] nums) {

        int result = 0;

        int bcount = 0;
        int count = 0;
        int before = Integer.MIN_VALUE;
        int now = Integer.MIN_VALUE;

        Arrays.sort(nums);

        for (int num : nums) {

            if (now == num) {
                count++;
            } else {
                if (before + 1 == now) {
                    result = Math.max(result, bcount + count);
                }
                before = now;
                bcount = count;
                now = num;
                count = 1;
            }
        }

        if (before + 1 == now) {
            result = Math.max(result, bcount + count);
        }

        return result;
    }

    public static void main(String[] args) {

        L594_Longest_Harmonious_Subsequence s = new L594_Longest_Harmonious_Subsequence();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        // int[] nums = {1,1,1,1};
        // int[] nums = {1,2,-1,1,2,5,2,5,2};
        // int [] nums = {1, 2, 4, 8, 9, 15};
        // int [] nums = {2, 1};
        // int[] nums = {1, 3, 2, 2, 2};
        // int [] nums = {1,2,4,5,3};
        int res = s.findLHS(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}