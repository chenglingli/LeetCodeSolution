import java.util.Arrays;

public class L435_Non_overlapping_Intervals {

    /*
    1. 因此，我们对所有区间，根据end进行排序。
        尽量选取排在前面的区间，这样，我们选取的区间，都是尽可能end早的区间，
        留下的空余选择空间就更长，更有利于选择更多区间。

    2. 然后，遍历排过序的区间。
        若start>=前一个选择区间的end，那么该区间入选（该区间end是目前待选区间中最早的。）入选区间数count++

    3. 最后，得到的count数，则为留下的最多互不重叠的区间数。
        那么要求的去掉最少多少个区间数=总区间数-count
     */
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int end = intervals[0][1];
        int count = intervals.length - 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count--;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L435_Non_overlapping_Intervals s = new L435_Non_overlapping_Intervals();
        long sysDate1 = System.currentTimeMillis();

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        int res = s.eraseOverlapIntervals(intervals);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}