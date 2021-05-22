import struct.Interval;

import java.util.*;

// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

public class MergeIntervals {

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }


    public static void main(String[] args) {

        MergeIntervals s = new MergeIntervals();

        long sysDate1 = System.currentTimeMillis();

        List<Interval> input = new ArrayList<>();
        input.add(new Interval(4, 5));
        input.add(new Interval(1, 4));
        input.add(new Interval(0, 1));

        List<Interval> res = s.merge(input);

        for (Interval i : res) {
            System.out.print(i.start);
            System.out.print(" ");
            System.out.println(i.end);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}