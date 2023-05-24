public class L1629_Slowest_Key {


    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int max = releaseTimes[0];
        char ans = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {

            int cur = releaseTimes[i] - releaseTimes[i - 1];

            if (cur >= max) {
                if (cur > max) {
                    ans = keysPressed.charAt(i);
                    max = cur;
                } else {
                    if (keysPressed.charAt(i) > ans) {
                        ans = keysPressed.charAt(i);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L1629_Slowest_Key s = new L1629_Slowest_Key();
        long sysDate1 = System.currentTimeMillis();

        int[] releaseTimes = {28, 65, 97};
        String keysPressed = "gaf";
        char res = s.slowestKey(releaseTimes, keysPressed);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}