import java.util.Arrays;

public class L3986_Number_of_Elapsed_Seconds_Between_Two_Times {

    /*
    You are given two valid times startTime and endTime, each represented as a string in the format "HH:MM:SS".

    Return the number of seconds that have elapsed from startTime to endTime.



    Example 1:

    Input: startTime = "01:00:00", endTime = "01:00:25"

    Output: 25

    Explanation:

    endTime is 25 seconds ahead of startTime.

    Example 2:
    Input: startTime = "12:34:56", endTime = "13:00:00"
    Output: 1504

    Explanation:
    endTime is 25 minutes and 4 seconds ahead of startTime, which equals 1504 seconds.



    Constraints:

    startTime.length == 8
    endTime.length == 8
    startTime and endTime are valid times in the format "HH:MM:SS"
    00 <= HH <= 23
    00 <= MM <= 59
    00 <= SS <= 59
    endTime is not earlier than startTime
     */
    public int secondsBetweenTimes(String startTime, String endTime) {
        int res = 0;

        int startHour = Integer.parseInt(startTime.substring(0, 2));
        int startMin = Integer.parseInt(startTime.substring(3, 5));
        int startSec = Integer.parseInt(startTime.substring(6, 8));

        int endHour = Integer.parseInt(endTime.substring(0, 2));
        int endMin = Integer.parseInt(endTime.substring(3, 5));
        int endSec = Integer.parseInt(endTime.substring(6, 8));

        res = (endHour * 3600 + endMin * 60 + endSec) - (startHour * 3600 + startMin * 60 + startSec);

        return res;
    }

    public static void main(String[] args) {

        L3986_Number_of_Elapsed_Seconds_Between_Two_Times s = new L3986_Number_of_Elapsed_Seconds_Between_Two_Times();
        long sysDate1 = System.currentTimeMillis();

        String startTime = "12:34:56";
        String endTime = "13:00:00";
        int res = s.secondsBetweenTimes(startTime, endTime);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}