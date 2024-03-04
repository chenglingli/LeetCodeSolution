public class L376_Wiggle_Subsequence {


    /*

    动态规划做法
    f[i][0] 表示以 nums[i] 结尾的最长「上升摆动序列」的长度。
    f[i][1] 表示以 nums[i] 结尾的最长「下降摆动序列」的长度。

    f[i][0] = max(f[j][1]) + 1, 0 <= j < i, nums[i] > nums[j]
    f[i][1] = max(f[j][0]) + 1, 0 <= j < i, nums[i] < nums[j]

    返回 f[n-1][0] 和 f[n-1][1] 中的较大值。
    f[0][0] = 1, f[0][1] = 1

    1 <= nums.length <= 1000
    0 <= nums[i] <= 1000
     */
    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;
        int[][] f = new int[n][2];

        // f[i][0] 表示以 nums[i] 结尾的最长「上升摆动序列」的长度。
        // f[i][1] 表示以 nums[i] 结尾的最长「下降摆动序列」的长度。

        f[0][0] = 1;
        f[0][1] = 1;

        int ans = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i][0] = Math.max(f[i][0], f[j][1] + 1);
                    ans = Math.max(ans, f[i][0]);
                } else if (nums[i] < nums[j]) {
                    f[i][1] = Math.max(f[i][1], f[j][0] + 1);
                    ans = Math.max(ans, f[i][1]);
                }
            }
        }

        return ans;
    }

    // 寻找数列中的峰值
    public int wiggleMaxLength2(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;

        int count = 1;
        for (int i = 1; i < nums.length; i++) {

            // 得到当前差值
            curDiff = nums[i] - nums[i - 1];

            // 如果当前差值和上一个差值为一正一负
            // 等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }

        return count;
    }

    /*

    贪心做法
    不断寻找峰值，实际就是不断寻找波峰和波谷

     */
    public int wiggleMaxLength3(int[] nums) {

        int n = nums.length;
        if (nums.length < 2) {
            return n;
        }

        int start = 0;
        // skip all equal elements
        while (start < n - 1 && nums[start] == nums[start+1])
            start++;

        // if all elements are equal
        if (start == n-1)
            return 1;

        boolean rising = nums[start] < nums[start+1];
        int maxLen = 1;
        for (int i = 0 ; i < n - 1 ; i++) {
            if ((rising && nums[i] > nums[i+1]) || (!rising && nums[i] < nums[i+1])) {
                maxLen++;
                rising = !rising;
            }
        }

        maxLen++; // the last element in the wiggle wasn't counted yet.

        return maxLen;
    }

    public static void main(String[] args) {

        L376_Wiggle_Subsequence s = new L376_Wiggle_Subsequence();

        long sysDate1 = System.currentTimeMillis();

        // int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int[] nums = {1, 17, 5, 10, 13, 12, 13};
        int res = s.wiggleMaxLength2(nums);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}