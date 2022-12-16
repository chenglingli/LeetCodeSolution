public class L1446_Consecutive_Characters {

    public int maxPower(String s) {

        int resCount = -1;
        int curCount = 0;
        char curChar = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == curChar) {
                curCount++;
            } else {
                resCount = Math.max(resCount, curCount);

                curChar = s.charAt(i);
                curCount = 1;
            }
        }

        return Math.max(resCount, curCount);
    }

    public static void main(String[] args) {

        L1446_Consecutive_Characters s = new L1446_Consecutive_Characters();
        long sysDate1 = System.currentTimeMillis();

        String xx = "a";
        int res = s.maxPower(xx);
        System.out.println(res);
        
        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}