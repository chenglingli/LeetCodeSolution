import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastTemp = new ArrayList<>();
        for (int i = 1; i <= rowIndex + 1; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                } else {
                    temp.add(lastTemp.get(j - 1) + lastTemp.get(j));
                }
            }
            lastTemp = temp;
        }

        return lastTemp;
    }

    public static void main(String[] args) {

        PascalTriangle2 s = new PascalTriangle2();

        long sysDate1 = System.currentTimeMillis();
        int numRows = 3;

        List<Integer> res = s.getRow(numRows);
        System.out.println(res.size());

        for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                System.out.print(" ");
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}