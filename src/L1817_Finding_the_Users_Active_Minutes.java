import java.util.*;

public class L1817_Finding_the_Users_Active_Minutes {

    /*
    You are given the logs for users' actions on LeetCode, and an integer k.
    The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute timei.

    Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.

    The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode.
    A minute can only be counted once, even if multiple actions occur during it.

    You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.

    Return the array answer as described above.



    Example 1:

    Input: logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
    Output: [0,2,0,0,0]
    Explanation:
    The user with ID=0 performed actions at minutes 5, 2, and 5 again. Hence, they have a UAM of 2 (minute 5 is only counted once).
    The user with ID=1 performed actions at minutes 2 and 3. Hence, they have a UAM of 2.
    Since both users have a UAM of 2, answer[2] is 2, and the remaining answer[j] values are 0.

    Example 2:
    Input: logs = [[1,1],[2,2],[2,3]], k = 4
    Output: [1,1,0,0]
    Explanation:
    The user with ID=1 performed a single action at minute 1. Hence, they have a UAM of 1.
    The user with ID=2 performed actions at minutes 2 and 3. Hence, they have a UAM of 2.
    There is one user with a UAM of 1 and one with a UAM of 2.
    Hence, answer[1] = 1, answer[2] = 1, and the remaining values are 0.


    Constraints:

    1 <= logs.length <= 10^4
    0 <= IDi <= 10^9
    1 <= timei <= 10^5
    k is in the range [The maximum UAM for a user, 10^5].
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        /*
        题目意思：
        给定一个二维数组，每个元素是一个用户ID和该用户在某个时间点执行操作的分钟数。
        我们需要：计算uma为i的用户个数

        解法：
        用一个map，记录每个用户操作的分钟数

         */
        Map<Integer, Set<Integer>> op = new HashMap<>();
        for (int[] log : logs) {
            if (!op.containsKey(log[0])) {
                op.put(log[0], new HashSet<>());
            }
            op.get(log[0]).add(log[1]);
        }

        int[] res = new int[k];
        for (Set<Integer> set : op.values()) {
            res[set.size() - 1]++;
        }

        return res;
    }

    public int[] findingUsersActiveMinutes2(int[][] logs, int k) {

        HashMap<Integer, HashSet<Integer>> mp = new HashMap<>();

        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            if (!mp.containsKey(id)) {
                mp.put(id, new HashSet<>());
            }
            mp.get(id).add(time);
        }

        int[] ans = new int[k + 1];
        for (int id : mp.keySet()) {
            int uam = mp.get(id).size();
            ans[uam]++;
        }

        int[] result = new int[k];
        for (int i = 1; i <= k; i++) {
            result[i - 1] = ans[i];
        }
        return result;
    }


    public static void main(String[] args) {

        L1817_Finding_the_Users_Active_Minutes s = new L1817_Finding_the_Users_Active_Minutes();
        long sysDate1 = System.currentTimeMillis();

        int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k = 5;
        int[] res = s.findingUsersActiveMinutes(logs, k);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}