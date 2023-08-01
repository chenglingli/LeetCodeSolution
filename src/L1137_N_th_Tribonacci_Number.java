public class L1137_N_th_Tribonacci_Number {

    /*
     0 1 1 2 4 7
     */
    public int tribonacci(int n) {
        int a0 = 0;
        int a1 = 1;
        int a2 = 1;

        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        int i = 3;
        int cur = 2;

        while (i < n) {

            a0 = a1;
            a1 = a2;
            a2 = cur;

            cur = a0 + a1 + a2;
            i++;
        }

        return cur;

    }

    public static void main(String[] args) {

        L1137_N_th_Tribonacci_Number s = new L1137_N_th_Tribonacci_Number();
        long sysDate1 = System.currentTimeMillis();

        int n = 5;

        int res = s.tribonacci(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}