public class L342_Power_of_Four {

    public boolean isPowerOfFour(int n) {

        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        int x = n;

        if (x % 2 != 0) {
            return false;
        }

        while (x > 1) {
            if (x % 4 == 0) {
                x = x / 4;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L342_Power_of_Four s = new L342_Power_of_Four();
        long sysDate1 = System.currentTimeMillis();
        int str = -2147483648;
        boolean res = s.isPowerOfFour(str);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}