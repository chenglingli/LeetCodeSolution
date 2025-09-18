import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L3386_Button_with_Longest_Push_Time {

    /*
    You are given a 2D array events which represents a sequence of events where a child pushes a series of buttons on a keyboard.

    Each events[i] = [indexi, timei] indicates that the button at index indexi was pressed at time timei.

    The array is sorted in increasing order of time.
    The time taken to press a button is the difference in time between consecutive button presses.
    The time for the first button is simply the time at which it was pressed.
    Return the index of the button that took the longest time to push.
    If multiple buttons have the same longest time, return the button with the smallest index.



    Example 1:

    Input: events = [[1,2],[2,5],[3,9],[1,15]]

    Output: 1

    Explanation:

    Button with index 1 is pressed at time 2.
    Button with index 2 is pressed at time 5, so it took 5 - 2 = 3 units of time.
    Button with index 3 is pressed at time 9, so it took 9 - 5 = 4 units of time.
    Button with index 1 is pressed again at time 15, so it took 15 - 9 = 6 units of time.

    Example 2:
    Input: events = [[10,5],[1,7]]

    Output: 10

    Explanation:

    Button with index 10 is pressed at time 5.
    Button with index 1 is pressed at time 7, so it took 7 - 5 = 2 units of time.


    Constraints:

    1 <= events.length <= 1000
    events[i] == [indexi, timei]
    1 <= indexi, timei <= 105
    The input is generated such that events is sorted in increasing order of timei.
     */
    public int buttonWithLongestTotalTime(int[][] events) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] event = events[0];
        int maxIndex = event[0];
        int maxTime = event[1];
        map.put(maxIndex, maxTime);

        for (int i = 1; i < events.length; i++) {
            int[] curEvent = events[i];
            int[] prevEvent = events[i - 1];

            int time = curEvent[1] - prevEvent[1];
            if (map.containsKey(curEvent[0])) {
                int totalTime = map.get(curEvent[0]) + time;
                map.put(curEvent[0], totalTime);
                if (totalTime > maxTime) {
                    maxIndex = curEvent[0];
                    maxTime = totalTime;
                } else if (totalTime == maxTime) {
                    maxIndex = Math.min(curEvent[0], maxIndex);
                }
            }
            else {
                map.put(curEvent[0], time);
                if (time > maxTime) {
                    maxIndex = curEvent[0];
                    maxTime = time;
                } else if (time == maxTime) {
                    maxIndex = Math.min(curEvent[0], maxIndex);
                }
            }
        }

        return maxIndex;
    }

    public int buttonWithLongestTime(int[][] events) {

        int[] event = events[0];
        int maxIndex = event[0];
        int maxTime = event[1];

        for (int i = 1; i < events.length; i++) {
            int[] curEvent = events[i];
            int[] prevEvent = events[i - 1];

            int time = curEvent[1] - prevEvent[1];
            if (time > maxTime) {
                maxIndex = curEvent[0];
                maxTime = time;
            } else if (time == maxTime) {
                maxIndex = Math.min(curEvent[0], maxIndex);
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {

        L3386_Button_with_Longest_Push_Time s = new L3386_Button_with_Longest_Push_Time();
        long sysDate1 = System.currentTimeMillis();

        int[][] events = {{1, 2}, {2, 5}, {3, 9}, {1, 10}};
//        int[][] events = {{10, 5}, {1, 7}};

        int res = s.buttonWithLongestTime(events);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}