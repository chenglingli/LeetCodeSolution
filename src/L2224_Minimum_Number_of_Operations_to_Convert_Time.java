public class L2224_Minimum_Number_of_Operations_to_Convert_Time {

    /*
    can increase the time current by 1, 5, 15, or 60 minutes

    current and correct are in the format "HH:MM"
    current <= correct
     */
    public int convertTime(String current, String correct) {
        int res = 0;

        String[] currentTime = current.split(":");
        String[] correctTime = correct.split(":");

        int cuHour = Integer.parseInt(currentTime[0]);
        int coHour = Integer.parseInt(correctTime[0]);
        res += coHour - cuHour;

        int cuMinute = Integer.parseInt(currentTime[1]);
        int coMinute = Integer.parseInt(correctTime[1]);
        int duration = coMinute - cuMinute;

        if (duration < 0) {
            duration += 60;
            res -= 1;
        }

        res += duration / 15;
        duration = duration % 15;
        res += duration / 5;
        duration = duration % 5;
        res += duration;

        return res;
    }

    public int convertTime2(String current, String correct) {
        int res = 0;

        String[] currentTime = current.split(":");
        String[] correctTime = correct.split(":");

        int cuHour = Integer.parseInt(currentTime[0]);
        int coHour = Integer.parseInt(correctTime[0]);
        int cuMinute = Integer.parseInt(currentTime[1]);
        int coMinute = Integer.parseInt(correctTime[1]);

        int duration = (coHour * 60 + coMinute) - (cuHour * 60 + cuMinute);

        res += duration / 60;
        duration = duration % 60;
        res += duration / 15;
        duration = duration % 15;
        res += duration / 5;
        duration = duration % 5;
        res += duration;

        return res;
    }


    public static void main(String[] args) {

        L2224_Minimum_Number_of_Operations_to_Convert_Time s =
                new L2224_Minimum_Number_of_Operations_to_Convert_Time();
        long sysDate1 = System.currentTimeMillis();

        String current = "02:30";
        String correct = "04:35";
        int res = s.convertTime2(current, correct);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}