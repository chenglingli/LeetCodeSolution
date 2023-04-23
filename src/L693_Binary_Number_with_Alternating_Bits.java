public class L693_Binary_Number_with_Alternating_Bits {


    /*
    1 <= n <= 2^31 - 1
     */
    public boolean hasAlternatingBits(int n) {

        int pre = n % 2;
        n /= 2;

        while (n > 0) {
            if (n % 2 == pre) {
                return false;
            }

            pre = n % 2;
            n /= 2;
        }

        return true;
    }

    public static void main(String[] args) {

        L693_Binary_Number_with_Alternating_Bits s = new L693_Binary_Number_with_Alternating_Bits();
        long sysDate1 = System.currentTimeMillis();

        int n = 5;
        boolean res = s.hasAlternatingBits(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}