
class MyDate {
    int month;
    int day;

    MyDate(int d1, int d2) {
        month = d1;
        day = d2;
    }

    boolean before(MyDate d) {
        if (month < d.month || (month == d.month && day < d.day)) {
            return true;
        }
        return false;
    }

    boolean after(MyDate d) {
        if (month > d.month || (month == d.month && day > d.day)) {
            return true;
        }
        return false;
    }

    boolean equal(MyDate d) {
        if (month == d.month && day == d.day) {
            return true;
        }
        return false;
    }

    int getMonth() {
        return month;
    }

    int getDay() {
        return day;
    }
}

public class L2409_Count_Days_Spent_Together {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] arriveAliceArray = arriveAlice.split("-");
        int arriveAliceMonth = Integer.parseInt(arriveAliceArray[0]);
        int arriveAliceDay = Integer.parseInt(arriveAliceArray[1]);
        MyDate a1 = new MyDate(arriveAliceMonth, arriveAliceDay);

        String[] leaveAliceArray = leaveAlice.split("-");
        int leaveAliceMonth = Integer.parseInt(leaveAliceArray[0]);
        int leaveAliceDay = Integer.parseInt(leaveAliceArray[1]);
        MyDate a2 = new MyDate(leaveAliceMonth, leaveAliceDay);

        String[] arriveBobArray = arriveBob.split("-");
        int arriveBobMonth = Integer.parseInt(arriveBobArray[0]);
        int arriveBobDay = Integer.parseInt(arriveBobArray[1]);
        MyDate b1 = new MyDate(arriveBobMonth, arriveBobDay);

        String[] leaveBobArray = leaveBob.split("-");
        int leaveBobMonth = Integer.parseInt(leaveBobArray[0]);
        int leaveBobDay = Integer.parseInt(leaveBobArray[1]);
        MyDate b2 = new MyDate(leaveBobMonth, leaveBobDay);

        if (a1.after(b2) || b1.after(a2)) {
            return 0;
        }

        if (a1.before(b1) && a2.after(b2)) {
            return countDaysDuration(b1, b2);
        }

        if (b1.before(a1) && b2.after(a2)) {
            return countDaysDuration(a1, a2);
        }

        if (a1.before(b1) && a2.before(b2)) {
            return countDaysDuration(b1, a2);
        }

        if (b1.before(a1) && b2.before(a2)) {
            return countDaysDuration(a1, b2);
        }

        if (a1.equal(b1)) {
            if (a2.after(b2)) {
                return countDaysDuration(a1, b2);
            } else if (a2.before(b2)) {
                return countDaysDuration(a1, a2);
            } else {
                return countDaysDuration(a1, a2);
            }
        }

        if (a2.equal(b2)) {
            if (a1.before(b1)) {
                return countDaysDuration(b1, a2);
            } else if (a1.after(b1)) {
                return countDaysDuration(a1, a2);
            } else {
                return countDaysDuration(a1, a2);
            }
        }

        if (a1.equal(b2) || a2.equal(b1)) {
            return 1;
        }

        return 0;
    }

    private int countDaysDuration(MyDate d1, MyDate d2) {
        int[] monthDayCount = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = 0;
        for (int i = d1.getMonth() + 1; i < d2.getMonth(); i++) {
            ans += monthDayCount[i];
        }
        if (d1.getMonth() == d2.getMonth()) {
            return d2.getDay() - d1.getDay() + 1;
        } else {
            ans += monthDayCount[d1.getMonth()] - d1.getDay() + 1 + d2.getDay();
        }
        return ans;
    }


    public int countDaysTogether2(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int rsdm = Integer.parseInt(arriveAlice.substring(0, 2));
        int rsdd = Integer.parseInt(arriveAlice.substring(3));

        int redm = Integer.parseInt(leaveAlice.substring(0, 2));
        int redd = Integer.parseInt(leaveAlice.substring(3));

        int ssdm = Integer.parseInt(arriveBob.substring(0, 2));
        int ssdd = Integer.parseInt(arriveBob.substring(3));

        int sedm = Integer.parseInt(leaveBob.substring(0, 2));
        int sedd = Integer.parseInt(leaveBob.substring(3));

        int months[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < months.length; i++) {
            months[i] = months[i] + months[i - 1];
        }

        return Math.max(Math.min((months[sedm - 1] + sedd), (months[redm - 1] + redd)) - Math.max((months[ssdm - 1] + ssdd), (months[rsdm - 1] + rsdd)) + 1, 0);

    }

    public static void main(String[] args) {

        L2409_Count_Days_Spent_Together s = new L2409_Count_Days_Spent_Together();
        long sysDate1 = System.currentTimeMillis();

        String arriveAlice = "09-01";
        String leaveAlice = "10-19";
        String arriveBob = "09-01";
        String leaveBob = "10-19";
        int res = s.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}