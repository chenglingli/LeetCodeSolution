import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class L1046_Last_Stone_Weight {

    public int lastStoneWeight(int[] stones) {

        List<Integer> stonesList = new ArrayList<>();
        for (Integer x : stones) {
            stonesList.add(x);
        }
        Collections.sort(stonesList);

        while (stonesList.size() > 1) {
            int y = stonesList.get(stonesList.size() - 1);
            int x = stonesList.get(stonesList.size() - 2);
            stonesList.remove(stonesList.size() - 1);
            stonesList.remove(stonesList.size() - 1);
            if (x != y) {
                stonesList.add(y - x);
                Collections.sort(stonesList);
            }
        }

        if (stonesList.size() == 0) {
            return 0;
        }
        return stonesList.get(0);
    }

    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        for (int num : stones) {
            maxHeap.add(num);
        }
        int stone1, stone2, diff;
        while (maxHeap.size() > 1) {
            stone1 = maxHeap.poll();
            stone2 = maxHeap.poll();
            diff = stone1 - stone2;
            if (diff != 0) {
                maxHeap.add(diff);
            }
        }
        if (maxHeap.size() > 0) {
            result = maxHeap.peek();
        }
        return result;
    }

    public static void main(String[] args) {

        L1046_Last_Stone_Weight s = new L1046_Last_Stone_Weight();

        long sysDate1 = System.currentTimeMillis();

        //        int[] stones = {2, 7, 4, 1, 8, 1};
        int[] stones = {2, 2};
        int res = s.lastStoneWeight(stones);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}