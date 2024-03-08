import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L446_Arithmetic_Slices_II_Subsequence {

    /*
    dp[i][k]都是表示到数组第i为底公差为k的超过长度3的个数

    dp(i, d) = sum(dp(j, d) + 1)
    dp(i, nums[i]-nums[j]) = 1 for any pair j, i, 0 <= j < i
    result(3位数的序列个数) = sum(dp(j, d))

     */
    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;
        int total_count = 0;

        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long diff = (long) nums[i] - nums[j];

                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }

                int diffInt = (int) diff;

                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + 1);
                // 说明满足长度大于等于3
                if (dp[j].containsKey(diffInt)) {
                    dp[i].put(diffInt, dp[i].get(diffInt) + dp[j].get(diffInt));
                    total_count += dp[j].get(diffInt);
                }
            }
        }

        return total_count;
    }

    /*
        序列要求是三位数的长度，如果以3位数为base case这个并不好计算，
        如果放松一下条件2位数算作wealy arithmetic sequence, 上面的公式依然成立，2位数的base case也好计算，

        dp(i, nums[i]-nums[j]) = 1 for any pair j, i, 0 <= j < i

        我们来走一下例子：[1, 1, 2, 3, 4, 5]

        i = 0,
            dp(0, d) = 0

        i = 1,
            j = 0, diff = 1 - 1 = 0, dp(1, 0) = 1, sequence: [1, 1]

        i = 2,
            j = 0, diff = 2 - 1 = 1, dp(2, 1) = 1;
            j = 1, diff = 2 - 1 = 1, dp(2, 1) = 1 + 1 = 2 sequence: [1, 2], [1, 2]

        i = 3,
            j = 0, diff = 2, dp(3, 2) = 1;
            j = 1, diff = 2, dp(3, 2) = 2;
            j = 2, diff = 1, dp(3, 1) = dp(2, 1) + 1 = 3, sequence: [1, 3], [1, 3], [1, 2, 3], [1, 2, 3], [2, 3]

        i = 4,
            j = 0, diff = 3, dp(4, 3) = 1;
            j = 1, diff = 3, dp(4, 3) = 2;
            j = 2, diff = 2, dp(4, 2) = 1;
            j = 3, dp(4, 1) = dp(3, 1) + 1 = 4, sequence: [1, 4], [1, 4], [2, 4], [1, 2, 3, 4], [1, 2, 3, 4], [2, 3, 4], [3, 4]

        i = 5,
            j = 0, diff = 4, dp(5, 4) = 1, sequence[1, 5];
            j = 1, diff = 4, dp(5, 4) = 2, sequence [1, 5] [1, 5];
            j = 2, diff = 3, dp(5, 3) = 1;
            j = 3, diff = 2, dp(3, 2) = 2, dp(5, 2) = dp(3, 2) + 1 = 3, sequence [1, 3, 5], [1, 3, 5], [3, 5];
            j = 4, dp(5, 1) = dp(4, 1) = 5, sequence [1, 2, 3, 4, 5], [1, 2, 3, 4, 5], [2, 3, 4, 5], [3, 4, 5], [4, 5]

        从例子可以看出来符合至少3位数的序列个数其实取决于前面sequence个数dp(j, d),
        公式中的+1是pair (nums[j], nums[i])2位数的序列,总结公式如下：
            dp(i, d) = sum(dp(j, d) + 1)
            dp(i, nums[i]-nums[j]) = 1 for any pair j, i, 0 <= j < i
            result(3位数的序列个数) = sum(dp(j, d))
     */
    public int numberOfArithmeticSlices3(int[] A) {

        int result = 0;
        List<Map<Integer, Integer> > dp = new ArrayList();

        for(int i = 0; i < A.length; ++i) {
            dp.add(new HashMap());

            for(int j = 0; j < i; ++j) {
                long delta = (long)A[i] - A[j];
                if(delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }

                int diff = (int) delta;

                int prev = dp.get(j).getOrDefault(diff, 0);
                int curr = dp.get(i).getOrDefault(diff, 0);

                dp.get(i).put(diff, curr + prev + 1);
                result += prev;
            }
        }

        return result;
    }

    public int numberOfArithmeticSlices2(int[] nums) {

        int n = nums.length, ans = 0;

        HashMap<Integer, Integer>[] dp = new HashMap[n];
        //dp[i].get(d)表示当前以nums[i]为尾项，公差为d，长度不小于2的子序列数量
        for (int i = 0; i < n; i++)
            dp[i] = new HashMap<>();


        // 动态规划

        // 遍历尾项
        for (int i = 0; i < n; i++) {
            // 遍历倒数第二项
            for (int j = 0; j < i; j++) {

                // nums[i]为int，等差子序列长度至少为3，则有效的公差d一定在int范围内
                if (Math.abs((long)nums[i] - nums[j]) > Integer.MAX_VALUE)
                    continue;

                int d = nums[i] - nums[j];//公差

                //获得以nums[j]为尾项，公差为d，长度不小于2的子序列数量
                int count = dp[j].getOrDefault(d, 0);

                //上述子序列添加nums[i]后可组成等差子序列
                ans += count;

                // 以nums[i]为尾项，公差为d，长度不小于2的子序列数量+=count
                // (由nums[j]原有子序列和nums[i]构成)+1 (由nums[j]和nums[i]构成)
                dp[i].put(d, dp[i].getOrDefault(d, 0) + count + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L446_Arithmetic_Slices_II_Subsequence s = new L446_Arithmetic_Slices_II_Subsequence();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 4, 6, 8, 10};
//        int[] nums = {7, 7, 7, 7, 7};
        int res = s.numberOfArithmeticSlices(nums);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}