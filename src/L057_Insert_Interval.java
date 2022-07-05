import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L057_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();

        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            } else {
                break;
            }
            i++;
        }

        while (i < intervals.length) {
            if (intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            } else {
                break;
            }
            i++;
        }
        res.add(newInterval);

        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        intervals = res.toArray(new int[0][]);
        return intervals;

    }

    public static void main(String[] args) {

        L057_Insert_Interval s = new L057_Insert_Interval();

        long sysDate1 = System.currentTimeMillis();

        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] res = s.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}