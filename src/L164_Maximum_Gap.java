import java.util.Arrays;

public class L164_Maximum_Gap {

    /*
        1 <= nums.length <= 10^5
        0 <= nums[i] <= 10^9
        linear time and uses linear extra space.

        排序
     */
    public int maximumGap(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = 0;

        if (n <= 1) return 0;

        for (int i = 1; i < n; i++) {
            max = Math.max((nums[i] - nums[i - 1]), max);
        }
        return max;
    }

    /*
        基于bucket sort的方法：

        有n个未排序的数字。

        1、先求出数组内最大数max和最小数min。

        2、求出每个桶内的数字范围：gap = （max - min） / (n - 1)。

        3、算出桶的数量： N = （max - min）/ gap + 1  (可知 N >= n)
            每个桶对应的数字范围为：
                第1个：[min, min + gap)
                第2个：[min + gap, min + 2*gap)
                ......

                第N个：[min + （N-1）gap, min + N*gap)

        由于至少有n个桶。因此最平均的情况是每个桶里一个数字。这时是要算出每个相邻桶内数字的差即可得出结果。
        若数字分布不均匀，有若干个数字在同一个桶内。那么一定起码有一个桶是空的。存在两个相邻数字的差 > gap 。

        因此只要通过记录：
            每个桶内最大数
            和最小数
        然后通过不断比较 第i个桶的最小值 与 前一个非空桶的最大值的差值，即可得到结果。
     */
    public int maximumGap3(int[] nums) {

        if (nums.length < 1)
            return 0;

        int res = 0;
        int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE, n = nums.length;

        // 计算最大值和最小值
        for (int i : nums) {
            maxV = Math.max(maxV, i);
            minV = Math.min(minV, i);
        }
        if (maxV == minV)
            return 0;

        // 计算 桶间距 和 桶数量
        int gap = (maxV - minV) / (n - 1) > 0 ?  (maxV - minV) / (n - 1) : 1;
        int bucketNum = (maxV - minV) / gap + 1;

        // 初始化桶
        int [] bucketMin = new int[bucketNum];
        int [] bucketMax = new int[bucketNum];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // 计算每个桶的最大值和最小值
        for (int i : nums) {
            int index = (i - minV) / gap;
            bucketMin[index] = Math.min(i, bucketMin[index]);
            bucketMax[index] = Math.max(i, bucketMax[index]);
        }

        // 用当前桶 最小值 减去 前一个非空桶的最大值，得到最大间隔
        int preIndex = 0;// 前一个非空桶的下标
        for (int i = 1; i < bucketNum; i++){
            // 空桶
            if (bucketMin[i] == Integer.MAX_VALUE)
                continue;

            res = Math.max(bucketMin[i] - bucketMax[preIndex], res);
            preIndex = i;
        }

        // 返回结果
        return res;
    }


    public static void main(String[] args) {

        L164_Maximum_Gap s = new L164_Maximum_Gap();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {3, 6, 9, 1};
        int res = s.maximumGap3(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}