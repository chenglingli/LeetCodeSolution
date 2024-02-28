import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L368_Largest_Divisible_Subset {

    /*
    every pair

    f[i] = Max{f[k] + 1} if a[i]%a[k]

     */
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        int[] f = new int[n];
        int[] path = new int[n];
        f[0] = 1;
        path[0] = -1;

        // 结果长度
        int ans = 1;
        // 结果起始index
        int ansIndex = 0;

        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            int tempAns = 1;
            int p = -1;
            for (int k = i - 1; k >= 0; k--) {
                if (nums[i] % nums[k] == 0 && f[k] + 1 > tempAns) {
                    tempAns = f[k] + 1;
                    p = k;
                }
            }

            f[i] = tempAns;
            if (f[i] > ans) {
                ans = f[i];
                ansIndex = i;
            }
            path[i] = p;
        }

        List<Integer> res = new ArrayList<>();

        int x = ansIndex;
        while (x != -1) {
            res.add(nums[x]);
            x = path[x];
        }
        Collections.reverse(res);

        return res;
    }

    /*
    和上面比，少一个reverse
     */
    public List<Integer> largestDivisibleSubset2(int[] nums) {

        int n = nums.length;
        int[] f = new int[n];
        int[] path = new int[n];
        f[n - 1] = 1;
        path[n - 1] = -1;

        // 结果长度
        int ans = 1;
        // 结果起始index
        int ansIndex = 0;

        Arrays.sort(nums);

        for (int i = n - 2; i >= 0; i--) {
            int tempAns = 1;
            int p = -1;
            for (int k = i + 1; k < n; k++) {
                if (nums[k] % nums[i] == 0 && f[k] + 1 > tempAns) {
                    tempAns = f[k] + 1;
                    p = k;
                }
            }

            f[i] = tempAns;
            if (f[i] > ans) {
                ans = f[i];
                ansIndex = i;
            }
            path[i] = p;
        }

        List<Integer> res = new ArrayList<>();

        int x = ansIndex;
        while (x != -1) {
            res.add(nums[x]);
            x = path[x];
        }

        return res;
    }

    /*
    搜索 起始位置 用二叉搜索做了优化

     */
    public List<Integer> largestDivisibleSubset3(int[] nums) {

        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] bestPrev = new int[nums.length];
        int bestCount = 0, bestIdx = -1;

        for (int i = 0; i < nums.length; i++) {

            dp[i] = 1;
            bestPrev[i] = i;

            // 不用从i开始，而是 i/2 地方
            int maxJ = Arrays.binarySearch(nums, 0, i, nums[i] / 2);

            if (maxJ < 0)
                maxJ = -maxJ - 2;
            for (int j = 0; j <= maxJ; j++) {
                if (dp[j] >= dp[i] && nums[i] % nums[j] == 0) {
                    dp[i] = dp[j] + 1;
                    bestPrev[i] = j;
                }
            }

            if (dp[i] > bestCount) {
                bestCount = dp[i];
                bestIdx = i;
            }
        }


        List<Integer> res = new ArrayList<>(bestCount);
        res.add(nums[bestIdx]);
        for (int i = bestIdx; bestPrev[i] != i; i = bestPrev[i])
            res.add(nums[bestPrev[i]]);

        return res;
    }

    public static void main(String[] args) {

        L368_Largest_Divisible_Subset s = new L368_Largest_Divisible_Subset();

        long sysDate1 = System.currentTimeMillis();

        //        int[] nums = {1, 2, 4, 8};
        int[] nums = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};

        List<Integer> res = s.largestDivisibleSubset2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}