import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class L502_IPO {

    /*
    1 <= k <= 10^5
    0 <= w <= 10^9
    n == profits.length
    n == capital.length
    1 <= n <= 10^5
    0 <= profits[i] <= 10^4
    0 <= capital[i] <= 10^9

    贪心算法，不断选择当前资本能够投资的项目中利润最大的项目
    用PriorityQueue维护当前资本能够投资的项目的利润，倒序排列

    实现步骤：
    1，将项目按照所需资本从小到大排序
    2，遍历项目，将当前资本能够投资的项目的利润加入PriorityQueue
    3，选择PriorityQueue中利润最大的项目，更新当前资本
    4，重复2，3步骤，直到完成k次投资或者没有项目可以投资

     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // 项目数
        int n = profits.length;
        int[][] projects = new int[n][2];

        // 将项目按照所需资本从小到大排序
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        PriorityQueue<Integer> maximizeCapital = new PriorityQueue<>(Collections.reverseOrder());

        while (k > 0) {

            // 将当前资本能够投资的项目的利润加入PriorityQueue
            while (i < n && projects[i][0] <= w) {
                maximizeCapital.offer(projects[i][1]);
                i++;
            }

            if (maximizeCapital.isEmpty()) {
                break;
            }

            // 选择PriorityQueue中利润最大的项目，更新当前资本
            w += maximizeCapital.poll();

            k--;
        }

        // 返回最终资本
        return w;
    }

    /*
    优化解法：
    1，如果初始资本大于等于所有项目所需的最大资本，直接投资利润最大的k个项目
    2，否则，遍历项目，将当前资本能够投资的项目的利润加入PriorityQueue
    3，选择PriorityQueue中利润最大的项目，更新当前资本
    4，重复2，3步骤，直到完成k次投资或者没有项目可以投资

     */
    public int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        int maxCapital = 0;

        // 寻找最大需要资本
        for (int value : capital) {
            maxCapital = Math.max(maxCapital, value);
        }

        // 如果初始资本大于最大资本
        // 直接做项目
        if (w >= maxCapital) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // 加入小顶堆
            for (int p : profits) {
                minHeap.add(p);

                // 如果堆的大小大于k，弹出堆顶元素（最小的那个）
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            // 完成累加
            for (int h : minHeap) {
                w += h;
            }

            return w;
        }

        int idx;
        int N = profits.length;

        // 否则，遍历项目，选择做当前收益最大的可做项目
        // that requires capital less than the available capital, until we invest in k projects.
        for (int i = 0; i < Math.min(k, N); i++) {
            idx = -1;

            // 找出最大利润可做的项目，坐标是index
            for (int j = 0; j < N; j++) {
                if (w >= capital[j] && (idx == -1 || profits[idx] < profits[j])) {
                    idx = j;
                }
            }

            // 找不到，退出
            if (idx == -1) {
                break;
            }

            // 完成收益累加
            w += profits[idx];

            // 设置门槛为最大值
            capital[idx] = Integer.MAX_VALUE;
        }

        return w;
    }

    public static void main(String[] args) {

        L502_IPO s = new L502_IPO();
        long sysDate1 = System.currentTimeMillis();

        int k = 2;
        int w = 1;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        int res = s.findMaximizedCapital(k, w, profits, capital);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}