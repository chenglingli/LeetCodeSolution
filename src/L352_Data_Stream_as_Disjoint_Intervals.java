import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;


/*

Given a data stream input of non-negative integers a1, a2, ..., an,
    summarize the numbers seen so far as a list of disjoint intervals.

Implement the SummaryRanges class:

SummaryRanges() Initializes the object with an empty stream.
void addNum(int value) Adds the integer value to the stream.
int[][] getIntervals() Returns a summary of
    the integers in the stream currently as a list of disjoint intervals [starti, endi].
    The answer should be sorted by starti.


Example 1:

Input
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals",
"addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]

Output
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null,
[[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

Explanation
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]


Constraints:

0 <= value <= 10^4
At most 3 * 10^4 calls will be made to addNum and getIntervals.
At most 10^2 calls will be made to getIntervals.


Follow up: What if there are lots of merges and
    the number of disjoint intervals is small compared to the size of the data stream?


 */

class SummaryRanges {

    // {start: {start, end}}
    private TreeMap<Integer, int[]> map = new TreeMap<>();

    public void addNum(int val) {

        // 重复值，直接返回
        if (map.containsKey(val))
            return;

        // lo 和 hi 分别是小于 val 的最大 key 和 大于 val 的最小 key
        final Integer lo = map.lowerKey(val);
        final Integer hi = map.higherKey(val);

        // 处理val能连接前后区间，则合并区间
        // 譬如val = 3， lo的value是 [1, 2]， hi的value是 [4, 5]
        // 则lo的value变为 [1, 5]
        if (lo != null && hi != null && map.get(lo)[1] + 1 == val && val + 1 == hi) {
            map.get(lo)[1] = map.get(hi)[1];
            map.remove(hi);
            // (prevent adding duplicate entry by using '>=' instead of '==')

        // 处理val能与前区间相连
        // 不使用 '==' 因为可能存在重复区间，
        // 譬如val = 3， lo的value是 [1, 3]，则lo的value变为 [1, 3]
        // 再譬如val = 2， lo的value是 [1, 3]，则lo的value变为 [1, 3]
        // 再譬如val = 4， lo的value是 [1, 3]，则lo的value变为 [1, 4]
        } else if (lo != null && map.get(lo)[1] + 1 >= val) {
            map.get(lo)[1] = Math.max(map.get(lo)[1], val);

        // 处理val能与后区间相连
        // 譬如val = 3， hi的value是 [4, 5]，则map变为 {3, [3, 5]}
        } else if (hi != null && val + 1 == hi) {
            map.put(val, new int[]{val, map.get(hi)[1]});
            map.remove(hi);

        // 单独一个区间，不与其他区间相连
        } else {
            map.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>(map.values());
        return intervals.toArray(new int[intervals.size()][]);
    }

}

public class L352_Data_Stream_as_Disjoint_Intervals {

    public static void main(String[] args) {

        SummaryRanges s = new SummaryRanges();
        long sysDate1 = System.currentTimeMillis();

        s.addNum(1);
        int[][] res1 = s.getIntervals();
        System.out.println(Arrays.toString(res1));

        s.addNum(3);
        int[][] res2 = s.getIntervals();
        System.out.println(Arrays.toString(res2));

        s.addNum(7);
        int[][] res3 = s.getIntervals();
        System.out.println(Arrays.toString(res3));

        s.addNum(2);
        int[][] res4 = s.getIntervals();
        System.out.println(Arrays.toString(res4));

        s.addNum(6);
        int[][] res5 = s.getIntervals();
        System.out.println(Arrays.toString(res5));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}