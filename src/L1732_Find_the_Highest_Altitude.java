public class L1732_Find_the_Highest_Altitude {


    public int largestAltitude(int[] gain) {
        int max = 0;
        int pre = 0;
        for (int x : gain) {
            int cur = x + pre;
            max = Math.max(max, cur);
            pre = cur;
        }

        return max;
    }

    public static void main(String[] args) {

        L1732_Find_the_Highest_Altitude s = new L1732_Find_the_Highest_Altitude();
        long sysDate1 = System.currentTimeMillis();

        int[] gain = {-5, 1, 5, 0, -7};
        int res = s.largestAltitude(gain);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}