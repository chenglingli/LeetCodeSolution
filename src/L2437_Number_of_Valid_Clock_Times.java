public class L2437_Number_of_Valid_Clock_Times {

    /*

    00:00 - 23:59

    1: 0,1,2
    2: 0-9

    2的时候只能 0，1，2

    1+2 : 24

    4: 0-6
    5: 1-9

    4+5: 60

     */
    public int countTime(String time) {

        int ans = 0;
        char ch1 = time.charAt(0);
        char ch2 = time.charAt(1);
        char ch4 = time.charAt(3);
        char ch5 = time.charAt(4);

        int x = 0;
        if (ch1 == '?' || ch2 == '?') {

            if (ch1 == '?' && ch2 == '?') {
                x = 24;
            } else {
                if (ch1 == '?') {
                    if (ch2 >= '4') x += 2;
                    else x += 3;
                }

                if (ch2 == '?') {
                    if (ch1 == '2') x += 4;
                    else x += 10;
                }
            }
        }

        int y = 0;
        if (ch4 == '?' || ch5 == '?') {
            if (ch4 == '?' && ch5 == '?') {
                y = 60;
            } else {
                y += ch4 == '?' ? 6 : 0;
                y += ch5 == '?' ? 10 : 0;
            }
        }

        ans = (x == 0 ? 1 : x) * (y == 0 ? 1 : y);
        return ans;
    }

    public static void main(String[] args) {

        L2437_Number_of_Valid_Clock_Times s = new L2437_Number_of_Valid_Clock_Times();
        long sysDate1 = System.currentTimeMillis();

        // String time = "?5:00";
        // String time = "??:??";
        //        String time = "0?:0?";
        String time = "2?:??";
        int res = s.countTime(time);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}