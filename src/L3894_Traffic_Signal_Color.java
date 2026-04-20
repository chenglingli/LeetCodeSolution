public class L3894_Traffic_Signal_Color {

    /*
    You are given an integer timer representing the remaining time (in seconds) on a traffic signal.

    The signal follows these rules:

    If timer == 0, the signal is "Green"
    If timer == 30, the signal is "Orange"
    If 30 < timer <= 90, the signal is "Red"
    Return the current state of the signal. If none of the above conditions are met, return "Invalid".



    Example 1:

    Input: timer = 60

    Output: "Red"

    Explanation:

    Since timer = 60, and 30 < timer <= 90, the answer is "Red".

    Example 2:

    Input: timer = 5

    Output: "Invalid"

    Explanation:

    Since timer = 5, it does not satisfy any of the given conditions, the answer is "Invalid".



    Constraints:

    0 <= timer <= 1000

     */
    public String trafficSignal(int timer) {
        if (timer == 0) return "Green";
        else if (timer == 30) return "Orange";
        else if (timer > 30 && timer <= 90) return "Red";
        else return "Invalid";
    }

    public static void main(String[] args) {

        L3894_Traffic_Signal_Color s = new L3894_Traffic_Signal_Color();
        long sysDate1 = System.currentTimeMillis();

        int timer = 60;

        String res = s.trafficSignal(timer);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}