public class L1736_Latest_Time_by_Replacing_Hidden_Digits {

    /*

    2?:?0
    1?:??
    1?:22
    0?:3?

    00:00 ~ 23:59

     */

    public String maximumTime(String time) {

        StringBuilder res = new StringBuilder();

        if (time.charAt(0) == '?' || time.charAt(1) == '?') {
            if (time.charAt(0) == '0') res.append("09");
            else if (time.charAt(0) == '1') res.append("19");
            else if (time.charAt(0) == '2') res.append("23");
            else {
                if (time.charAt(1) == '?') {
                    res.append("23");
                } else {
                    if (time.charAt(1) >= '4') res.append('1');
                    else res.append('2');
                    res.append(time.charAt(1));
                }
            }
        } else {
            res.append(time, 0, 2);
        }

        res.append(':');

        if (time.charAt(3) == '?' || time.charAt(4) == '?') {
            if (time.charAt(3) == '?' && time.charAt(4) != '?') {
                res.append('5');
                res.append(time.charAt(4));
            } else if (time.charAt(3) != '?' && time.charAt(4) == '?') {
                res.append(time.charAt(3));
                res.append('9');
            } else {
                res.append("59");
            }
        } else {
            res.append(time, 3, 5);
        }

        return res.toString();
    }

    public static void main(String[] args) {

        L1736_Latest_Time_by_Replacing_Hidden_Digits s = new L1736_Latest_Time_by_Replacing_Hidden_Digits();
        long sysDate1 = System.currentTimeMillis();

        //        String time = "2?:?0";
        //        String time = "1?:??";
        //        String time = "1?:22";
        //        String time = "0?:3?";

        String time = "00:01";

        String res = s.maximumTime(time);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}