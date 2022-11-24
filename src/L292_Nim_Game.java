public class L292_Nim_Game {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {

        L292_Nim_Game s = new L292_Nim_Game();
        long sysDate1 = System.currentTimeMillis();

        boolean res = s.canWinNim(6);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}