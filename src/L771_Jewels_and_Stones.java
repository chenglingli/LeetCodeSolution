public class L771_Jewels_and_Stones {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        int[] mark = new int[70];

        for (int i = 0; i < J.length(); i++) {
            mark[J.charAt(i) - 'A'] = 1;
        }

        for (int i = 0; i < S.length(); i++) {
            if (mark[S.charAt(i) - 'A'] == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        L771_Jewels_and_Stones s = new L771_Jewels_and_Stones();

        long sysDate1 = System.currentTimeMillis();

        String x = "z";
        //String y = "nagaram";
        String y = "ZZ";

        int res = s.numJewelsInStones(x, y);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}