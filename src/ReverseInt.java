
public class ReverseInt {

    public int reverse(int x) {

        long max = 2147483647L;
        long min = -2147483648L;
        long tempX = (long)x;
        long res = 0L;

        while (tempX != 0) {
            res = res * 10 + tempX % 10;
            if (res > max || res < min ) {
                return 0;
            }
            tempX /= 10;
        }

        return (int)res;
    }

    public static void main(String[] args) {

        ReverseInt s = new ReverseInt();
        // int x = 1534236469;
        // int x = -123;
        int x = -2147483648;
        // int y = -2147483648;

        long sysDate1 = System.currentTimeMillis();

        int res = s.reverse(x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();

        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

