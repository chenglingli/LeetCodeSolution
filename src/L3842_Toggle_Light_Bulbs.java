import java.util.ArrayList;
import java.util.List;

public class L3842_Toggle_Light_Bulbs {

    /*
    You are given an array bulbs of integers between 1 and 100.

    There are 100 light bulbs numbered from 1 to 100. All of them are switched off initially.

    For each element bulbs[i] in the array bulbs:

    If the bulbs[i]th light bulb is currently off, switch it on.
    Otherwise, switch it off.
    Return the list of integers denoting the light bulbs that are on in the end, sorted in ascending order. If no bulb is on, return an empty list.


    Example 1:

    Input: bulbs = [10,30,20,10]

    Output: [20,30]

    Explanation:

    The bulbs[0] = 10th light bulb is currently off. We switch it on.
    The bulbs[1] = 30th light bulb is currently off. We switch it on.
    The bulbs[2] = 20th light bulb is currently off. We switch it on.
    The bulbs[3] = 10th light bulb is currently on. We switch it off.
    In the end, the 20th and the 30th light bulbs are on.
    Example 2:

    Input: bulbs = [100,100]

    Output: []

    Explanation:

    The bulbs[0] = 100th light bulb is currently off. We switch it on.
    The bulbs[1] = 100th light bulb is currently on. We switch it off.
    In the end, no light bulb is on.


    Constraints:

    1 <= bulbs.length <= 100
    1 <= bulbs[i] <= 100

     */
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[101];

        for (Integer bulb : bulbs) {
            arr[bulb]++;
        }

        for (int i = 1; i <= 100; i++) {
            if (arr[i] % 2 != 0) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L3842_Toggle_Light_Bulbs s = new L3842_Toggle_Light_Bulbs();
        long sysDate1 = System.currentTimeMillis();


        List<Integer> bulbs = new ArrayList<>();
        bulbs.add(10);
        bulbs.add(30);
        bulbs.add(20);
        bulbs.add(10);

        List<Integer> res = s.toggleLightBulbs(bulbs);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}