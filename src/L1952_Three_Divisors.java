import java.util.ArrayList;
import java.util.List;

public class L1952_Three_Divisors {


    public boolean isThree(int n) {

        if (n == 1) {
            return false;
        }

        List<Integer> divisorList = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (!divisorList.contains(i)) {
                    divisorList.add(i);
                }
                if (!divisorList.contains(n / i)) {
                    divisorList.add(n / i);
                }
            }
            if (divisorList.size() > 3) {
                return false;
            }
        }

        return divisorList.size() == 1;
    }

    public boolean isThree2(int n) {

        if (n == 1) {
            return false;
        }

        int m = (int)Math.sqrt(n);
        if(m * m != n) {
            return false;
        }

        for (int i = 2; i < m ;i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L1952_Three_Divisors s = new L1952_Three_Divisors();
        long sysDate1 = System.currentTimeMillis();

        int n = 1;
        boolean res = s.isThree2(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}