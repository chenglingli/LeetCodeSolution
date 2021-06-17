import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */

public class L118_Pascal_Triangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lastTemp = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    temp.add(lastTemp.get(j - 1) + lastTemp.get(j));
                }
            }
            res.add(temp);
            lastTemp = temp;
        }

        return res;
    }

    public static void main(String[] args) {

        L118_Pascal_Triangle s = new L118_Pascal_Triangle();

        long sysDate1 = System.currentTimeMillis();
        int numRows = 5;

        List<List<Integer>> res = s.generate(numRows);
        System.out.println(res.size());

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}