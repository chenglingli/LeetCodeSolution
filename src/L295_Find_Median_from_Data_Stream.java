import java.util.PriorityQueue;

public class L295_Find_Median_from_Data_Stream {

    /*
    The median is the middle value in an ordered integer list.
    If the size of the list is even, there is no middle value,
        and the median is the mean of the two middle values.
     */
    public static void main(String[] args) {

        L295_Find_Median_from_Data_Stream s = new L295_Find_Median_from_Data_Stream();
        long sysDate1 = System.currentTimeMillis();

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

class MedianFinder {

    private PriorityQueue<Integer> qLeft;
    private PriorityQueue<Integer> qRight;

    /*
    qLeft 前半段 （从大到小排列）
    q2 后半段 （从小到大排列）
    qLeft 多一个元素
     */
    public MedianFinder() {
        this.qLeft = new PriorityQueue<>((a, b) -> b - a);
        this.qRight = new PriorityQueue<>((a, b) -> a - b);
    }

    /*
    1 2 3(qLeft  =  3 2 1)

    5 6 7(qRight = 5 6 7)

    这时过来2，直接插入qLeft
    如果过来8，直接插入qLeft，然后qLeft最大值和qRight最小值比较，如果大于，则交换

     */
    public void addNum(int num) {
        if (qLeft.size() == qRight.size()) {
            qLeft.add(num);
            if (!qRight.isEmpty() && qLeft.peek() > qRight.peek()) {
                int left = qLeft.poll();
                int right = qRight.poll();
                qLeft.add(right);
                qRight.add(left);
            }
        } else {
            qRight.add(num);
            if (qLeft.peek() > qRight.peek()) {
                int left = qLeft.poll();
                int right = qRight.poll();
                qLeft.add(right);
                qRight.add(left);
            }
        }
    }

    public double findMedian() {
        if (qLeft.size() == qRight.size()) {
            return (qLeft.peek() + qRight.peek()) / 2.0;
        } else {
            return qLeft.peek();
        }
    }
}