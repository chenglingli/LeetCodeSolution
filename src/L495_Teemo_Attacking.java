public class L495_Teemo_Attacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int res = 0;
        int pre = timeSeries[0] + duration - 1;

        for (int i = 1; i < timeSeries.length; i++) {

            int cur = timeSeries[i];
            if (cur > pre) {
                res += duration;
            } else {
                res += cur - timeSeries[i - 1];
            }

            pre = cur + duration - 1;
        }

        return res + duration;
    }

    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        int out = timeSeries.length * duration;
        for (int i = 1; i < timeSeries.length; i++) {
            int between = timeSeries[i] - timeSeries[i - 1];
            if (between < duration) {
                out -= (duration - between);
            }
        }
        return out;
    }

    public static void main(String[] args) {

        L495_Teemo_Attacking s = new L495_Teemo_Attacking();
        long sysDate1 = System.currentTimeMillis();
        int[] timeSeries = {1, 4};
        int duration = 2;

        int res = s.findPoisonedDuration(timeSeries, duration);
        // System.out.println(Arrays.toString(Arrays.stream(res).toArray()));
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}