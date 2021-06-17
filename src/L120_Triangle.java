import java.util.ArrayList;
import java.util.List;

public class L120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] cost = new int[triangle.size()][triangle.size()];
        cost[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            cost[i][0] = cost[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < triangle.get(i).size() - 1; j++)
                cost[i][j] = Math.min(cost[i - 1][j - 1], cost[i - 1][j]) + triangle.get(i).get(j);
            int end = triangle.get(i).size() - 1;
            cost[i][end] = cost[i - 1][end - 1] + triangle.get(i).get(end);
        }

        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            int end = triangle.size() - 1;
            if (res > cost[end][i]) res = cost[end][i];
        }

        return res;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {

        if (triangle == null || triangle.isEmpty())
            return 0;

        int rowNums = triangle.size();
        int[][] cache = new int[rowNums][rowNums];

        for (int i = 0; i < rowNums; i++) {
            cache[rowNums - 1][i] = triangle.get(rowNums - 1).get(i);
        }

        for (int j = rowNums - 2; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                cache[j][i] = triangle.get(j).get(i) + Math.min(cache[j + 1][i], cache[j + 1][i + 1]);
            }
        }

        return cache[0][0];
    }

    public static void main(String[] args) {

        L120_Triangle s = new L120_Triangle();

        long sysDate1 = System.currentTimeMillis();

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        triangle.add(row1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        triangle.add(row2);

        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        triangle.add(row3);

        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        triangle.add(row4);

        int res = s.minimumTotal(triangle);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}