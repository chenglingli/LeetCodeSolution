public class L2582_Pass_the_Pillow {

    /*
    2 <= n <= 1000
    1 <= time <= 1000
     */
    public int passThePillow(int n, int time) {

        int x = time / (n - 1);
        int y = time % (n - 1);

        if (x % 2 == 0) {
            return y + 1;
        } else {
            return n - y;
        }
    }

    public static void main(String[] args) {

        L2582_Pass_the_Pillow s = new L2582_Pass_the_Pillow();
        long sysDate1 = System.currentTimeMillis();

        int n = 4;
        for (int i = 1; i < 10; i++) {
            int res = s.passThePillow(n, i);
            System.out.print(i);
            System.out.print(" ");
            System.out.println(res);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}