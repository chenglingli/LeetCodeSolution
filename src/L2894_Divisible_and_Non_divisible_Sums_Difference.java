public class L2894_Divisible_and_Non_divisible_Sums_Difference {

    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }

        return num1 - num2;
    }

    public static void main(String[] args) {

        L2894_Divisible_and_Non_divisible_Sums_Difference s = new L2894_Divisible_and_Non_divisible_Sums_Difference();
        long sysDate1 = System.currentTimeMillis();

        int n = 10;
        int m = 3;
        int res = s.differenceOfSums(n, m);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}