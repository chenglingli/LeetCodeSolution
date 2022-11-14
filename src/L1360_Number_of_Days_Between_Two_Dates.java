public class L1360_Number_of_Days_Between_Two_Dates {

    // 月份天数数组
    int[] DaysList = {0, 31, 28, 31, 30, 31,
            30, 31, 31, 30, 31,
            30, 31};

    /*
     * The given dates are valid dates between the years 1971 and 2100.
     * date1和date2大小不确定
     */
    public int daysBetweenDates(String date1, String date2) {

        String[] date1StrList = date1.split("-");
        String[] date2StrList = date2.split("-");

        int y1, m1, d1;
        int y2, m2, d2;

        y1 = Integer.parseInt(date1StrList[0]);
        m1 = Integer.parseInt(date1StrList[1]);
        d1 = Integer.parseInt(date1StrList[2]);

        y2 = Integer.parseInt(date2StrList[0]);
        m2 = Integer.parseInt(date2StrList[1]);
        d2 = Integer.parseInt(date2StrList[2]);

        int res = 0;

        // 同年同月
        if (y1 == y2 && m1 == m2) {
            return Math.abs(d1 - d2);
        }

        // 处理两个日期的前后关系
        boolean tag = false;
        if (y1 < y2) {
            tag = true;
        } else if (y1 == y2) {
            if (m1 < m2) tag = true;
        }

        if (!tag) {
            int temp = 0;

            temp = y1;
            y1 = y2;
            y2 = temp;

            temp = m1;
            m1 = m2;
            m2 = temp;

            temp = d1;
            d1 = d2;
            d2 = temp;
        }


        // 计算年份之间的天数
        if ((y2 - y1) > 1) {
            res += countDaysBetweenYear(y1 + 1, y2 - 1);
        }

        // 非同年
        if ((y2 - y1) != 0) {
            if (m1 != 12) res += countDaysBetweenMonth(m1 + 1, 12, y1);
            res += DaysOfMonth(m1, y1) - d1;

            if (m2 != 1) res += countDaysBetweenMonth(1, m2 - 1, y2);
            res += d2;
        }
        // 同一年
        else {
            res += countDaysBetweenMonth(m1 + 1, m2 - 1, y1);
            res += DaysOfMonth(m1, y1) - d1;
            res += d2;
        }

        return res;
    }

    private int DaysOfMonth(int m, int y) {
        if (m == 2 && isLeapYear(y)) return DaysList[m] + 1;
        return DaysList[m];
    }

    /*
    计算年份之前的天数，绝对年份
    譬如，2001~2003，指的是这3年完全在里面
     */
    private int countDaysBetweenYear(int a, int b) {

        if (b - a < 0) return 0;

        int res = 0;

        // 初步计算天数
        res = (b - a + 1) * 365;

        // 加上闰年数字
        for (int i = a; i <= b; i++)
            if (isLeapYear(i)) res += 1;

        return res;
    }

    /*
    计算月份之间的天数，绝对月份
    譬如，3~12，指的是这10个月完全在里面
     */
    private int countDaysBetweenMonth(int m1, int m2, int y) {

        if (m2 - m1 < 0)
            return 0;

        int res = 0;

        //  初步计算天数
        for (int i = m1; i <= m2; i++) res += DaysList[i];

        // 闰年处理
        if (isLeapYear(y) && m1 <= 2 && m2 >= 2) res += 1;

        // 返回结果
        return res;
    }

    private boolean isLeapYear(int y) {
        if (y % 100 == 0) {
            if (y % 400 == 0)
                return true;
            else
                return false;
        } else if (y % 4 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        L1360_Number_of_Days_Between_Two_Dates s = new L1360_Number_of_Days_Between_Two_Dates();
        long sysDate1 = System.currentTimeMillis();

        //        String date1 = "1971-06-29";
        //        String date2 = "2010-09-23";

        //        String date1 = "2020-01-15";
        //        String date2 = "2019-12-31";

        //        String date1 = "2023-01-13";
        //        String date2 = "2044-02-11";

        String date1 =
                "1976-02-19";
        String date2 =
                "1976-02-26";

        int res = s.daysBetweenDates(date1, date2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}