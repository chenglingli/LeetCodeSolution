import java.util.Arrays;

public class L3360_Stone_Removal_Game {

    /*
    Alice and Bob are playing a game where they take turns removing stones from a pile, with Alice going first.

    Alice starts by removing exactly 10 stones on her first turn.
    For each subsequent turn, each player removes exactly 1 fewer stone than the previous opponent.
    The player who cannot make a move loses the game.

    Given a positive integer n, return true if Alice wins the game and false otherwise.


    Example 1:
    Input: n = 12
    Output: true

    Explanation:
    Alice removes 10 stones on her first turn, leaving 2 stones for Bob.
    Bob cannot remove 9 stones, so Alice wins.

    Example 2:
    Input: n = 1
    Output: false

    Explanation:
    Alice cannot remove 10 stones, so Alice loses.

    Constraints:
    1 <= n <= 50
     */
    public boolean canAliceWin(int n) {

        // 依旧从10，9，8，7，6，5，4，3，2，1，这样的顺序来，如果remain不足，则看当前是否为偶数，如果是偶数则Alice赢

        int cur = 10;
        int turn = 1;
        int remain = n;

        while (remain >= cur) {
            remain -= cur;
            cur--;
            turn++;
        }

        return turn % 2 == 0;
    }
    public static void main(String[] args) {

        L3360_Stone_Removal_Game s = new L3360_Stone_Removal_Game();
        long sysDate1 = System.currentTimeMillis();

        int n = 12;

        boolean res = s.canAliceWin(20);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}