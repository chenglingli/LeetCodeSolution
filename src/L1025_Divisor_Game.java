public class L1025_Divisor_Game {


    /*
    10 - A赢

    A:5, n=5
    B:1, n=4

    A:1, n=3
    B:1, n=2

    A:1, n=1

    B 输


    9 - A 输
    A:3 n=6
    B:1 n=5

    A:1 4
    B:1 3


    8 -




     */
    public boolean divisorGame(int n) {

        boolean[] mark = new boolean[1001];
        mark[1] = false;
        mark[2] = true;
        mark[3] = false;

        for (int i = 4; i <= n; i++) {

            boolean tempVal = false;
            for (int k = 1; k < Math.sqrt(n); k++) {
                if (i % k == 0) {
                    int temp = i - k;
                    if (!mark[temp]) {
                        tempVal = true;
                        break;
                    }
                }
            }
            mark[i] = tempVal;

        }

        return mark[n];
    }

    public boolean divisorGame2(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {


        long sysDate1 = System.currentTimeMillis();

        L1025_Divisor_Game s = new L1025_Divisor_Game();

        for (int n = 1; n <= 1000; n++) {
            boolean res = s.divisorGame(n);
            System.out.print(n);
            System.out.print(" ");
            System.out.println(res);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}