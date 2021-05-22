package struct;

public class Interval implements Comparable<Interval> {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public int compareTo(Interval o) {
        if (this.start < o.start) {
            return -1;
        }
        return 1;
    }
}