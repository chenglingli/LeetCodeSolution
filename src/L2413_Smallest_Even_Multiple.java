public class L2413_Smallest_Even_Multiple {

    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }
        return 2 * n;
    }

    public static void main(String[] args) {

        L2413_Smallest_Even_Multiple s = new L2413_Smallest_Even_Multiple();
        long sysDate1 = System.currentTimeMillis();

        int n = 100;
        int res = s.smallestEvenMultiple(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}