public class L1185_Day_of_the_Week {
    
    /*
    Given a date, return the corresponding day of the week for that date.

    The input is given as three integers representing the day, month and year respectively.

    Return the answer as one of the following values
        {"Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday", "Saturday"}.

    The given dates are valid dates between the years 1971 and 2100.

    // 1971.1.1
    // 周五
     */
    public String dayOfTheWeek(int day, int month, int year) {

        int duration = 0;

        duration += countDayForYear(year);
        //        System.out.print("after year ");
        //        System.out.println(duration);

        duration += countDayForMonth(year, month);
        //        System.out.print("after month ");
        //        System.out.println(duration);

        duration += day - 1;
        //        System.out.print("after day ");
        //        System.out.println(duration);

        duration = duration % 7;
        String[] weekDay = {
                "Friday", "Saturday", "Sunday", "Monday",
                "Tuesday", "Wednesday", "Thursday"
        };

        return weekDay[duration];
    }

    private int countDayForMonth(int year, int month) {

        int[] monthDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;

        for (int i = 1; i <= month - 1; i++) {
            count += monthDay[i];
        }

        if (isLeapYear(year) && month >= 3) {
            count += 1;
        }

        return count;
    }

    private int countDayForYear(int year) {
        int count = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                count += 366;
            } else {
                count += 365;
            }
        }
        return count;
    }

    private boolean isLeapYear(int y) {
        if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L1185_Day_of_the_Week s = new L1185_Day_of_the_Week();
        long sysDate1 = System.currentTimeMillis();

        //        int day = 31;
        //        int month = 8;
        //        int year = 2019;

        //        int day = 18;
        //        int month = 7;
        //        int year = 1999;


        int day = 15;
        int month = 8;
        int year = 1993;

        //        int day = 1;
        //        int month = 2;
        //        int year = 1972;

        String res = s.dayOfTheWeek(day, month, year);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}