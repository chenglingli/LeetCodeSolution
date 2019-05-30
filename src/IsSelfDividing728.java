import java.util.ArrayList;
import java.util.List;

public class IsSelfDividing728 {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> res = new ArrayList<>();

        for (int i = left ; i <= right ; i++) {

            if (isSelfDividing(i)) {
                res.add(i);
            }
        }
        return res;
    }

    boolean isSelfDividing(int x) {

        int m = x;
        while (m != 0) {
            int temp = m % 10;
            if (temp != 0 && x % temp == 0) {
                m = m/10;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        IsSelfDividing728 s = new IsSelfDividing728();

        long sysDate1 = System.currentTimeMillis();

        int m = 1;
        int n = 100;

        List<Integer> res = s.selfDividingNumbers(m, n);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}