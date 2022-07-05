public class L263_Ugly_Number {

    public boolean isUgly(int n) {

        if (n <= 0)
            return false;

        while (n % 5 == 0)
            n /= 5;

        while (n % 3 == 0)
            n /= 3;

        while (n % 2 == 0)
            n /= 2;

        return n == 1;

    }

    public static void main(String[] args) {

        L263_Ugly_Number s = new L263_Ugly_Number();
        long sysDate1 = System.currentTimeMillis();

        boolean res = s.isUgly(6);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}