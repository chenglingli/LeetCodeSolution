import java.util.Arrays;
import java.util.HashMap;

public class L1331_Rank_Transform_of_an_Array {

    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;
        int[] brr = new int[n];
        for (int i = 0; i < n; i++)
            brr[i] = arr[i];

        Arrays.sort(brr);

        int[] rank = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(brr[i])) {
                val++;
                map.put(brr[i], val);
            }
        }

        for (int i = 0; i < n; i++)
            rank[i] = map.get(arr[i]);

        return rank;
    }

    public static void main(String[] args) {

        L1331_Rank_Transform_of_an_Array s = new L1331_Rank_Transform_of_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] num = {37, 12, 28, 12, 100, 56, 80, 5, 12};

        int[] res = s.arrayRankTransform(num);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}