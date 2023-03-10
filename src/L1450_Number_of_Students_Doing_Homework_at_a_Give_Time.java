public class L1450_Number_of_Students_Doing_Homework_at_a_Give_Time {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;

        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L1450_Number_of_Students_Doing_Homework_at_a_Give_Time s = new L1450_Number_of_Students_Doing_Homework_at_a_Give_Time();
        long sysDate1 = System.currentTimeMillis();

        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        int queryTime = 4;

        int res = s.busyStudent(startTime, endTime, queryTime);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}