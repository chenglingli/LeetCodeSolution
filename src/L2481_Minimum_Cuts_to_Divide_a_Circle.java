public class L2481_Minimum_Cuts_to_Divide_a_Circle {

    /*
        1 <= n <= 100

        1 : 0
        2 : 1
        3 : 3
        4 : 2
        5 : 5
        6 : 3
        7 : 7
        8 : 4
     */
    public int numberOfCuts(int n) {

        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return n / 2;
        }

        return n;
    }

    public static void main(String[] args) {

        L2481_Minimum_Cuts_to_Divide_a_Circle s = new L2481_Minimum_Cuts_to_Divide_a_Circle();
        long sysDate1 = System.currentTimeMillis();

        int n = 5;
        int res = s.numberOfCuts(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}