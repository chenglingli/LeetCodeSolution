import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L464_Can_I_Win {

    /*
    1 <= maxChoosableInteger <= 20
    0 <= desiredTotal <= 300

     */
    Map<Integer, Boolean> map = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0)
            return true;
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal)
            return false;

        boolean[] selected = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal, selected);
    }

    /*
        表示基于desiredTotal和selected的状态，当前用户是否能赢

        回溯搜索，遍历selected数组，分别尝试每一个数字，看当前是否可以赢
     */
    public boolean helper(int desiredTotal, boolean[] selected) {

        if (desiredTotal <= 0)
            return false;

        int symbol = format(selected);
        if (map.containsKey(symbol)) {
            return map.get(symbol);
        }

        int size = selected.length;
        for (int i = 1; i < size; i++) {
            if (!selected[i]) {

                selected[i] = true;
                if (!helper(desiredTotal - i, selected)) {
                    selected[i] = false;
                    map.put(symbol, true);
                    return true;
                }
                selected[i] = false;
            }
        }

        map.put(symbol, false);
        return false;
    }

    /*
    将数组二进制化
    1-5，选择1和3
    则00101
     */
    public int format(boolean[] selected) {
        int symbol = 0;
        for (boolean select : selected) {
            symbol <<= 1;
            if (select) {
                symbol |= 1;
            }
        }
        return symbol;
    }


    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= 0) {
            return true;
        }

        if ((maxChoosableInteger * (maxChoosableInteger + 1)) / 2 < desiredTotal) {
            return false; // Sum of all numbers is less than desiredTotal
        }

        return canIWin(0, maxChoosableInteger, desiredTotal, new Boolean[1 << maxChoosableInteger]);
    }

    private boolean canIWin(int usedNumbers, int maxChoosableInteger, int desiredTotal, Boolean[] memo) {

        if (memo[usedNumbers] != null) {
            return memo[usedNumbers];
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            int currentMask = 1 << (i - 1);
            if ((usedNumbers & currentMask) == 0) { // Number i not used
                if (i >= desiredTotal
                        || !canIWin(usedNumbers | currentMask, maxChoosableInteger, desiredTotal - i, memo)) {
                    memo[usedNumbers] = true;
                    return true;
                }
            }
        }

        memo[usedNumbers] = false;
        return false;
    }


    /*
        超时，应该是Arrays.toString(state)导致
     */
    public boolean canIWin3(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        int[] state = new int[maxChoosableInteger + 1];
        Map<String, Boolean> map = new HashMap<>();
        return helper(maxChoosableInteger, desiredTotal, state, map);
    }

    private boolean helper(int maxChoosableInteger, int desiredTotal, int[] state, Map<String, Boolean> map) {

        String curtState = Arrays.toString(state);
        if (map.containsKey(curtState)) {
            return map.get(curtState);
        }

        for (int i = 1; i < state.length; i++) {

            if (state[i] == 1) {
                continue;
            }

            state[i] = 1;
            if (desiredTotal - i <= 0 || !helper(maxChoosableInteger, desiredTotal - i, state, map)) {
                map.put(curtState, true);
                state[i] = 0;
                return true;
            }
            state[i] = 0;
        }

        map.put(curtState, false);
        return false;
    }


    public static void main(String[] args) {

        L464_Can_I_Win s = new L464_Can_I_Win();

        long sysDate1 = System.currentTimeMillis();

        int maxChoosableInteger = 10;
        int desiredTotal = 11;
        boolean res = s.canIWin(maxChoosableInteger, desiredTotal);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}