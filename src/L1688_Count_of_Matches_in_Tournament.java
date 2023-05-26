public class L1688_Count_of_Matches_in_Tournament {


    /*
    1 <= n <= 200
     */
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            res += n / 2;
            n = n - n / 2;
        }

        return res;
    }

    public static void main(String[] args) {

        L1688_Count_of_Matches_in_Tournament s = new L1688_Count_of_Matches_in_Tournament();
        long sysDate1 = System.currentTimeMillis();

        int n = 7;
        int res = s.numberOfMatches(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}