public class L231_Power_of_Two {

    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }

        while ((n & 1) == 0) {
            n = n >> 1;
        }

        return n == 1;
    }

    public static void main(String[] args) {

        L231_Power_of_Two s = new L231_Power_of_Two();
        long sysDate1 = System.currentTimeMillis();

        boolean res = s.isPowerOfTwo(8);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}