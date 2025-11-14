public class L3114_Latest_Time_You_Can_Obtain_After_Replacing_Characters {

    /*

    You are given a string s representing a 12-hour format time
        where some of the digits (possibly none) are replaced with a "?".

    12-hour times are formatted as "HH:MM", where HH is between 00 and 11, and MM is between 00 and 59.
    The earliest 12-hour time is 00:00, and the latest is 11:59.

    You have to replace all the "?" characters in s with digits such that the time we obtain by the resulting string is a valid 12-hour format time and is the latest possible.

    Return the resulting string.



    Example 1:

    Input: s = "1?:?4"

    Output: "11:54"

    Explanation: The latest 12-hour format time we can achieve by replacing "?" characters is "11:54".

    Example 2:

    Input: s = "0?:5?"

    Output: "09:59"

    Explanation: The latest 12-hour format time we can achieve by replacing "?" characters is "09:59".



    Constraints:

    s.length == 5
    s[2] is equal to the character ":".
    All characters except s[2] are digits or "?" characters.
    The input is generated such that there is at least one time between "00:00" and "11:59" that you can obtain after replacing the "?" characters.

     */
    public String findLatestTime(String s) {
        char h1 = s.charAt(0);
        char h2 = s.charAt(1);
        char m1 = s.charAt(3);
        char m2 = s.charAt(4);

        StringBuilder sb = new StringBuilder();

        if (h1 == '?') {
            if (h2 == '?') {
                h1 = '1';
                h2 = '1';
            }
            else if (h2 == '0' || h2 == '1') {
                h1 = '1';
            }
            else {
                h1 = '0';
            }
        }
        sb.append(h1);

        if (h2== '?') {
            if (h1 == '0') {
                h2 = '9';
            }
            else {
                h2 = '1';
            }
        }
        sb.append(h2);
        sb.append(":");

        if (m1 == '?') {
            m1 = '5';
        }
        sb.append(m1);

        if (m2 == '?') {
            m2 = '9';
        }
        sb.append(m2);

        return sb.toString();
    }

    public static void main(String[] args) {

        L3114_Latest_Time_You_Can_Obtain_After_Replacing_Characters s = new L3114_Latest_Time_You_Can_Obtain_After_Replacing_Characters();
        long sysDate1 = System.currentTimeMillis();

//        String ss = "1?:?4";
        String ss = "?1:?6";

        String res = s.findLatestTime(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}