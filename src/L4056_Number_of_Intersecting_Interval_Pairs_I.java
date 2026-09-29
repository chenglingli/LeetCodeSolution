public class L4056_Number_of_Intersecting_Interval_Pairs_I {

    /*
    You are given a 2D integer array intervals of n elements, where intervals[i] = [starti, endi] represents the closed interval from starti to endi.

    Return the number of pairs of indices (i, j) such that 0 <= i < j < n and intervals[i] and intervals[j] intersect.

    Two intervals intersect if they have at least one point in common, including when they only share an endpoint.



    Example 1:

    Input: intervals = [[1,2],[2,3],[3,4]]

    Output: 2

    Explanation:

    There are 2 intersecting interval pairs:

    Intervals [1, 2] and [2, 3] intersect at the point 2.
    Intervals [2, 3] and [3, 4] intersect at the point 3.

    Example 2:

    Input: intervals = [[1,5],[2,4],[3,6]]

    Output: 3

    Explanation:

    There are 3 intersecting interval pairs:

    The intersection of [1, 5] and [2, 4] is [2, 4].
    The intersection of [1, 5] and [3, 6] is [3, 5].
    The intersection of [2, 4] and [3, 6] is [3, 4].

    Example 3:
    Input: intervals = [[1,2],[3,4],[5,6]]

    Output: 0

    Explanation:

    There are no intersecting interval pairs. Hence, the answer is 0.



    Constraints:
    2 <= n == intervals.length <= 100
    intervals[i] = [starti, endi]
    0 <= starti <= endi <= 100

     */

    /*
     * Time: O(n^2)
     * Space: O(1)
     *
     * Explanation:
     *
     * 1. 遍历每个区间
     * 2. 遍历每个区间
     * 3. 判断两个区间是否相交
     * 4. 如果相交，则计数加1
     * 5. 返回计数
     */
    public int countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int start1 = intervals[i][0];
            int end1 = intervals[i][1];

            for (int j = i + 1; j < n; j++) {
                int start2 = intervals[j][0];
                int end2 = intervals[j][1];

                if (!(end1 < start2 || end2 < start1)) {
                    count++;
                }
            }
        }

        return count;
    }

    /*
    Time: O(n)，具体是100 + n
    Space: O(1)，具体是100

    Explanation:

    1. 统计每个区间的结束点出现的频率
    2. 计算前缀和
    3. 计算非交集的区间对数
    4. 计算总的区间对数
    5. 返回非交集的区间对数
    */
    public int countIntersectingIntervals2(int[][] intervals) {

        int n = intervals.length;

        // 统计每个区间的结束点出现的频率
        int[] endingFreq = new int[101];
        for (int[] i : intervals) {
            endingFreq[i[1]]++;
        }

        // 计算前缀和
        // 前缀和的含义是：在区间 [0, i] 内，有多少个区间的结束点出现了
        int[] prefix = new int[101];
        for (int i = 1; i < 101; i++) {
            prefix[i] = prefix[i - 1] + endingFreq[i - 1];
        }

        // 计算非交集的区间对数
        int nonIntersect = 0;
        for (int[] inter : intervals) {
            nonIntersect += prefix[inter[0]];
        }

        // 计算总的区间对数
        int total = (n * (n - 1)) / 2;
        return total - nonIntersect;
    }

    public static void main(String[] args) {

        L4056_Number_of_Intersecting_Interval_Pairs_I s = new L4056_Number_of_Intersecting_Interval_Pairs_I();
        long sysDate1 = System.currentTimeMillis();

        int[][] intervals = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4}
        };

        int res = s.countIntersectingIntervals(intervals);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}