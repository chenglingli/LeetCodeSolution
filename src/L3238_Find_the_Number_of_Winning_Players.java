import java.util.HashMap;

public class L3238_Find_the_Number_of_Winning_Players {

    /*
    2 <= n <= 10
    1 <= pick.length <= 100
    pick[i].length == 2
    0 <= xi <= n - 1
    0 <= yi <= 10

    对于任意一个玩家，如果他拿到的球中最大数字比他自己i大，那么他就是赢家
    对于编号0玩家，只要有选择球就算赢
    对于编号1玩家，只要最大数字大于1就算赢
    对于编号2玩家，只要最大数字大于2就算赢

     */
    public int winningPlayerCount(int n, int[][] pick) {

        int ans = 0;

        HashMap<Integer, HashMap<Integer, Integer>> playerCount = new HashMap<>();
        int[] maxNum = new int[n];

        for (int [] cur : pick) {

            int player = cur[0];
            if (maxNum[player] > player) {
                continue;
            }

            int num = cur[1];
            HashMap<Integer, Integer> count = playerCount.computeIfAbsent(player, k -> new HashMap<>());
            count.put(num, count.getOrDefault(num, 0) + 1);
            maxNum[player] = Math.max(count.get(num), maxNum[player]);
            if (maxNum[player] > player) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L3238_Find_the_Number_of_Winning_Players s = new L3238_Find_the_Number_of_Winning_Players();
        long sysDate1 = System.currentTimeMillis();

//        int n = 4;
//        int[][] pick = {{0, 0}, {1, 0}, {1, 0}, {2, 1}, {2, 1}, {2, 0}};

        int n = 2;
        int[][] pick = {{0, 8}, {0, 3}};
        int res = s.winningPlayerCount(n, pick);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}