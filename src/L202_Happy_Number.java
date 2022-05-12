import java.util.HashSet;
import java.util.Set;

public class L202_Happy_Number {


    public boolean isHappy(int n) {

        int temp = n;
        Set<Integer> resList = new HashSet<>();
        resList.add(n);

        while (temp != 1) {
            temp = sumSquare(temp);

            if (temp == 1) return true;

            if (resList.contains(temp)) return false;

            resList.add(temp);
        }

        return true;
    }

    public int sumSquare(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    public boolean isHappy2(int n) {

        int r = 1, sum = 0;

        while (n > 9) {
            while (n > 0) {
                r = n % 10;
                sum = sum + r * r;
                n = n / 10;
            }
            n = sum;
            sum = 0;
        }

        return n == 1 || n == 7;
    }

    public static void main(String[] args) {

        L202_Happy_Number s = new L202_Happy_Number();

        long sysDate1 = System.currentTimeMillis();

        boolean res = s.isHappy(2);

        System.out.println(res);
        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}