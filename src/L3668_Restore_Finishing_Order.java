import java.util.Arrays;

public class L3668_Restore_Finishing_Order {

    /*

    You are given an integer array order of length n and an integer array friends.

    order contains every integer from 1 to n exactly once,
    representing the IDs of the participants of a race in their finishing order.

    friends contains the IDs of your friends in the race sorted in strictly increasing order.
    Each ID in friends is guaranteed to appear in the order array.
    Return an array containing your friends' IDs in their finishing order.



    Example 1:

    Input: order = [3,1,2,5,4], friends = [1,3,4]

    Output: [3,1,4]

    Explanation:

    The finishing order is [3, 1, 2, 5, 4]. Therefore, the finishing order of your friends is [3, 1, 4].

    Example 2:

    Input: order = [1,4,5,3,2], friends = [2,5]

    Output: [5,2]

    Explanation:

    The finishing order is [1, 4, 5, 3, 2]. Therefore, the finishing order of your friends is [5, 2].



    Constraints:

    1 <= n == order.length <= 100
    order contains every integer from 1 to n exactly once
    1 <= friends.length <= min(8, n)
    1 <= friends[i] <= n
    friends is strictly increasing
     */
    public int[] recoverOrder(int[] order, int[] friends) {

        int[] res = new int[friends.length];
        int index = 0;

        for (int i = 0; i < order.length; i++) {
            int temp = order[i];
            for (int j = 0; j < friends.length; j++) {
                if (temp == friends[j]) {
                    res[index] = order[i];
                    index ++;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L3668_Restore_Finishing_Order s = new L3668_Restore_Finishing_Order();
        long sysDate1 = System.currentTimeMillis();

        int[] order = {3, 1, 2, 5, 4};
        int[] friends = {1, 3, 4};

        int[] res = s.recoverOrder(order, friends);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}