public class L2698_Find_the_Punishment_Number_of_an_Integer {

    /*

    Given a positive integer n, return the punishment number of n.

    The punishment number of n is defined as the sum of the squares of all integers i such that:

    1 <= i <= n
    The decimal representation of i * i can be partitioned into contiguous substrings
        such that the sum of the integer values of these substrings equals i.


    Example 1:

    Input: n = 10
    Output: 182
    Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
    - 1 since 1 * 1 = 1
    - 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
    - 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
    Hence, the punishment number of 10 is 1 + 81 + 100 = 182

    Example 2:
    Input: n = 37
    Output: 1478
    Explanation: There are exactly 4 integers i in the range [1, 37] that satisfy the conditions in the statement:
    - 1 since 1 * 1 = 1.
    - 9 since 9 * 9 = 81 and 81 can be partitioned into 8 + 1.
    - 10 since 10 * 10 = 100 and 100 can be partitioned into 10 + 0.
    - 36 since 36 * 36 = 1296 and 1296 can be partitioned into 1 + 29 + 6.
    Hence, the punishment number of 37 is 1 + 81 + 100 + 1296 = 1478


    Constraints:

    1 <= n <= 1000

     */

    // n <= 1000，合法 i 只有下面这 29 个，查询直接扫表
    // 它们都满足 i ≡ 0 或 1 (mod 9)，这是切分和 = i 的必要条件，但不是充分条件
    private static final int[] SPECIAL = {
            1, 9, 10, 36, 45, 55, 82, 91, 99, 100,
            235, 297, 369, 370, 379, 414, 657, 675, 703, 756,
            792, 909, 918, 945, 964, 990, 991, 999, 1000
    };

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int x : SPECIAL) {
            if (x > n) {
                break;
            }
            ans += x * x;
        }
        return ans;
    }

    // 不转字符串：从 i*i 的低位按 10^k 切开，判断若干段能否凑成 i
    public int punishmentNumber2(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (canPartition(i * i, i)) {
                ans += i * i;
            }
        }
        return ans;
    }

    private boolean canPartition(int sq, int target) {
        if (sq == target) {
            return true;
        }
        int base = 10;
        while (sq >= base && sq % base <= target) {
            if (canPartition(sq / base, target - sq % base)) {
                return true;
            }
            base *= 10;
        }
        return false;
    }


    public static void main(String[] args) {

        L2698_Find_the_Punishment_Number_of_an_Integer s = new L2698_Find_the_Punishment_Number_of_an_Integer();
        long sysDate1 = System.currentTimeMillis();

        int n = 10;
        int res = s.punishmentNumber2(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}