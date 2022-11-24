public class L326_Power_of_Three {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 3 != 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {

        L326_Power_of_Three s = new L326_Power_of_Three();

        long sysDate1 = System.currentTimeMillis();

        boolean x = s.isPowerOfThree(-3);
        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}