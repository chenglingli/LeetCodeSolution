import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L436_Find_Right_Interval {

    /*
    1 <= intervals.length <= 2 * 10^4
    intervals[i].length == 2
    -10^6 <= start-i <= end-i <= 10^6
    The start point of each interval is unique.

    1，因为起始点唯一
    2，使用Hashmap，记录起始点对应的index
    3，基于起始点排序
    4，对于每个终点，找到第一个大于等于该终点的起始点，使用二分查找

     */
    public int[] findRightInterval(int[][] intervals) {

        // 变量定义
        int len = intervals.length;
        int[] res = new int[len];

        // 存储 起始点对应的index 到map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(intervals[i][0], i);
        }

        // copy以下原始数据，并对起始点排序
        int[][] copyIntervals = new int[len][2];
        for (int i = 0; i < len; i++) {
            copyIntervals[i][0] = intervals[i][0];
            copyIntervals[i][1] = intervals[i][1];
        }
        Arrays.sort(copyIntervals, (a, b) -> a[0] - b[0]);

        // 针对每个intervals的终点，在排序集合中二分查找起点
        for (int i = 0 ; i < len; i++) {
            int target = intervals[i][1];

            int left = 0;
            int right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (copyIntervals[mid][0] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (copyIntervals[left][0] >= target) {
                res[i] = map.get(copyIntervals[left][0]);
            } else {
                res[i] = -1;
            }
        }

        // 返回结果
        return res;
    }

    /*
    Solution 2: count sort alike
        - use a bucket array where
            after 1st pass => bucket[i] is the index of interval with a start == i
            after 2nd pass => bucket[i] is the index of interval with a start == i
            `                                   or the smallest index of interval with a start >= i
                            => for every end, res[end's interval index] = bucket[end]
        - TC: O(n)
        - SC: O(n)

        第一轮遍历，找到起点最小值和终点最大值
        第二轮遍历，找到每个终点对应的起点
        第三轮遍历，找到每个终点对应的起点，或者最小的大于等于终点的起点
     */
    public int[] findRightInterval2(int[][] intervals) {

        int n = intervals.length;
        int[] result = new int[n];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 找到 终点最大值 和 起点最小值
        for(int[] interval : intervals){
            int x = interval[0];
            int y = interval[1];
            max = Math.max(max, y);
            min = Math.min(min, x);
        }

        // 定义一个bucket，存储 每个intervals 起点-min 对应的index
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, -1);
        for(int i = 0; i < intervals.length; i++){
            bucket[intervals[i][0] - min] = i;
        }

        // 对于 bucket中，没有对应index的，设置为 前一个index
        for(int i = bucket.length - 2; i >= 0; i--){
            if(bucket[i] == -1){
                bucket[i] = bucket[i + 1];
            }
        }

        // 遍历intervals，找到每个终点对应的起点
        for(int i = 0; i < n; i++){
            result[i] = bucket[intervals[i][1] - min];
        }

        return result;
    }

    public static void main(String[] args) {

        L436_Find_Right_Interval s = new L436_Find_Right_Interval();
        long sysDate1 = System.currentTimeMillis();

        int[][] intervals = {{5, 6}, {2, 5}, {1, 4}};

        int[] res = s.findRightInterval2(intervals);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}