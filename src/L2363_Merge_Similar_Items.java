import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L2363_Merge_Similar_Items {

    /*
    1 <= items1.length, items2.length <= 1000
    items1[i].length == items2[i].length == 2
    1 <= valuei, weighti <= 1000
    Each valuei in items1 is unique.
    Each valuei in items2 is unique.
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        int[] count = new int[1001];
        for (int[] cur : items1) {
            count[cur[0]] += cur[1];
        }
        for (int[] cur : items2) {
            count[cur[0]] += cur[1];
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            if (count[i] != 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(count[i]);
                res.add(temp);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2363_Merge_Similar_Items s =
                new L2363_Merge_Similar_Items();
        long sysDate1 = System.currentTimeMillis();

        int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
        int[][] items2 = {{3, 1}, {1, 5}};
        List<List<Integer>> res = s.mergeSimilarItems(items1, items2);
        System.out.println(Collections.unmodifiableList(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}