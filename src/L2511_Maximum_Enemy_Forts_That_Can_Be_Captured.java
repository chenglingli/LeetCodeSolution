import java.util.HashMap;

public class L2511_Maximum_Enemy_Forts_That_Can_Be_Captured {

    /*
    You are given a 0-indexed integer array forts of length n representing the positions of several forts.
        forts[i] can be -1, 0, or 1 where:

    -1 represents there is no fort at the ith position.
    0 indicates there is an enemy fort at the ith position.
    1 indicates the fort at the ith the position is under your command.
    Now you have decided to move your army from one of your forts at position i to an empty position j such that:

    0 <= i, j <= n - 1
    The army travels over enemy forts only. Formally, for all k where min(i,j) < k < max(i,j), forts[k] == 0.
    While moving the army, all the enemy forts that come in the way are captured.

    Return the maximum number of enemy forts that can be captured.
        In case it is impossible to move your army, or you do not have any fort under your command, return 0.



    Example 1:
    Input: forts = [1,0,0,-1,0,0,0,0,1]
    Output: 4
    Explanation:
    - Moving the army from position 0 to position 3 captures 2 enemy forts, at 1 and 2.
    - Moving the army from position 8 to position 3 captures 4 enemy forts.
    Since 4 is the maximum number of enemy forts that can be captured, we return 4.

    Example 2:
    Input: forts = [0,0,1,-1]
    Output: 0
    Explanation: Since no enemy fort can be captured, 0 is returned.


    Constraints:
    1 <= forts.length <= 1000
    -1 <= forts[i] <= 1
     */

    /*

    解法1：顺向1寻找-1，找其中的0的个数
    再逆向1寻找-1，找其中的0的个数
    取最大的0个个数值

     */
    public int captureForts(int[] forts) {
        int ans = 0;
        int n = forts.length;
        int k = 0;
        int i = 0;

        for (i = 0; i < n; ) {
            if (forts[i] == 1) {
                k = i + 1;
                while (k < n && forts[k] != -1 && forts[k] != 1) {
                    k++;
                }
                if (k < n && forts[k] == -1) {
                    ans = Math.max(ans, k - i - 1);
                }
                i = k;
            } else {
                while (i < n && (forts[i] == -1 || forts[i] == 0)) {
                    i++;
                }
            }
        }

        for (i = n - 1; i >= 0; ) {
            if (forts[i] == 1) {
                k = i - 1;
                while (k >= 0 && forts[k] != -1 && forts[k] != 1) {
                    k--;
                }

                if (k >= 0 && forts[k] == -1) {
                    ans = Math.max(ans, i - k - 1);
                }
                i = k;
            } else {
                while (i >= 0 && (forts[i] == -1 || forts[i] == 0)) {
                    i--;
                }
            }
        }

        return ans;
    }

    /*

    解法更为巧妙，就是找1和-1之间的0的数量，然后取最大值。

     */
    public int captureForts2(int[] forts) {

        int n = forts.length;
        int ans = 0, i = 0;

        while (i < n) {
            int j = i + 1;
            if (forts[i] != 0) {
                while (j < n && forts[j] == 0) {
                    ++j;
                }
                if (j < n && forts[i] + forts[j] == 0) {
                    ans = Math.max(ans, j - i - 1);
                }
            }
            i = j;
        }

        return ans;
    }


    public static void main(String[] args) {

        L2511_Maximum_Enemy_Forts_That_Can_Be_Captured s = new L2511_Maximum_Enemy_Forts_That_Can_Be_Captured();
        long sysDate1 = System.currentTimeMillis();

        int[] forts = {1, 0, 0, -1, 0, 0, 0, 0, 1};
        //int[] forts = {0,0,1,-1};
        int res = s.captureForts(forts);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}