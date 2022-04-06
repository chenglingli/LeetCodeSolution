public class L172_Factorial_Trailing_Zeroes {

    public int trailingZeroes(int n) {
        int res = 0;
        int temp = n / 5;
        while (temp > 0) {
            res += temp;
            temp /= 5;
        }
        return res;
    }


    public static void main(String[] args) {

        L172_Factorial_Trailing_Zeroes s = new L172_Factorial_Trailing_Zeroes();

        long sysDate1 = System.currentTimeMillis();

        int x = 30;

        int res = s.trailingZeroes(x);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}