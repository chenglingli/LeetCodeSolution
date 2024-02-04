public class L2651_Calculate_Delayed_Arrival_Time {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    public static void main(String[] args) {

        L2651_Calculate_Delayed_Arrival_Time s = new L2651_Calculate_Delayed_Arrival_Time();
        long sysDate1 = System.currentTimeMillis();

        int arrivalTime = 15;
        int delayedTime = 10;
        int res = s.findDelayedArrivalTime(arrivalTime, delayedTime);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}