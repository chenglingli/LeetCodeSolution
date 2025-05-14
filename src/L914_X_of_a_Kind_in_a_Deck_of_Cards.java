import java.util.HashMap;
import java.util.Map;

public class L914_X_of_a_Kind_in_a_Deck_of_Cards {


    /*
     You are given an integer array deck where deck[i] represents the number written on the ith card.

    Partition the cards into one or more groups such that:

    Each group has exactly x cards where x > 1, and
    All the cards in one group have the same integer written on them.
    Return true if such partition is possible, or false otherwise.



    Example 1:

    Input: deck = [1,2,3,4,4,3,2,1]
    Output: true
    Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

    Example 2:

    Input: deck = [1,1,1,2,2,2,3,3]
    Output: false
    Explanation: No possible partition.


    Constraints:

    1 <= deck.length <= 10^4
    0 <= deck[i] < 10^4
     */

    public boolean hasGroupsSizeX(int[] deck) {
        // 按照数值进行分组，然后统计每个数值的出现次数
        // 如果各个数值出现次数的最大公约数大于1，则可以分组，否则不可以
        // 或者各个数字出现仅1次，则可以分组

        // 统计每个数字的出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 计算最大公约数
        int gcd = 0;
        for (Integer count : map.values()) {
            if (count == 1) return false;
            gcd = gcd(gcd, count);
        }

        // 如果最大公约数大于1，则可以分组，否则不可以
        return gcd > 1;
    }

    // 辗转相除法求最大公约数
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public boolean hasGroupsSizeX2(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        int max = 0;
        for (int i : deck) {
            if (i > max) {
                max = i;
            }
        }

        int[] a = new int[max + 1];
        for (int i : deck) {
            a[i]++;
        }

        int g = 0;
        for (int i : a) {
            if (i != 0)
                g = gcd(g, i);
        }

        return g > 1;
    }


    public static void main(String[] args) {

        L914_X_of_a_Kind_in_a_Deck_of_Cards s = new L914_X_of_a_Kind_in_a_Deck_of_Cards();

        long sysDate1 = System.currentTimeMillis();

        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};

        boolean res = s.hasGroupsSizeX(deck);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}