public class L1154_Day_of_the_Year {

    public int dayOfYear(String date) {

        String[] dateArray = date.split("-");
        int y = Integer.parseInt(dateArray[0]);
        int m = Integer.parseInt(dateArray[1]);
        int d = Integer.parseInt(dateArray[2]);
        int ans = 0;

        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1 ; i < m ; i++) {
            ans += monthDays[i];
        }
        if (isLeapYear(y) && m >= 3) {
            ans +=1;
        }

        ans += d;

        return ans;
    }

    private boolean isLeapYear(int y) {
        if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        L1154_Day_of_the_Year s = new L1154_Day_of_the_Year();
        long sysDate1 = System.currentTimeMillis();

        // String date = "2019-02-10";
        String date = "2003-03-01";

        int res = s.dayOfYear(date);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}