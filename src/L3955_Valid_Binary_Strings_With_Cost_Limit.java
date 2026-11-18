import java.util.ArrayList;
import java.util.List;

public class L3955_Valid_Binary_Strings_With_Cost_Limit {

    /*

    You are given two integers n and k.

    The cost of a binary string s is defined as the sum of all indices i (0-based) such that s[i] == '1'.

    A binary string is considered valid if:

    It does not contain two consecutive '1' characters.
    Its cost is less than or equal to k.
    Return a list of all valid binary strings of length n in any order.



    Example 1:
    Input: n = 3, k = 1

    Output: ["000","010","100"]

    Explanation:
    The binary strings of length 3 without consecutive '1' characters are:
    "000" : cost = 0
    "100" : cost = 0
    "010" : cost = 1
    "001" : cost = 2
    "101" : cost = 0 + 2 = 2
    Among these, the strings with cost less than or equal to k = 1 are "000", "010" and "100".

    Thus, the valid strings are ["000", "010", "100"].

    Example 2:
    Input: n = 1, k = 0

    Output: ["0","1"]

    Explanation:
    The valid binary strings of length 1 are "0" and "1".
    Thus the answer is ["0", "1"].


    Constraints:
    1 <= n <= 12
    0 <= k <= n * (n - 1) / 2

     */
    public List<String> generateValidStrings(int n, int k) {
        /*

        对于一个 n 位二进制字符串，找出所有「没有连续 1」且「所有 1 的下标之和 <= k」的字符串。
        代价是 1 所在下标之和，不是 1 的个数。例如 "001" 的代价是 2，"101" 的代价是 0 + 2 = 2。

        从左到右逐位填：
        1. 当前位置永远可以填 0，代价不变
        2. 上一位不是 1，且当前下标不超过剩余预算时，才填 1，并扣掉这个下标

         */

        List<String> res = new ArrayList<>();

        dfs(res, new StringBuilder(), n, k);

        return res;
    }

    void dfs(List<String> res, StringBuilder sb, int n, int k) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        int pos = sb.length();

        // 填 0：不产生代价，也不会和前一个 1 冲突
        sb.append('0');
        dfs(res, sb, n, k);
        sb.deleteCharAt(sb.length() - 1);

        // 填 1：前一位不能是 1，并且当前下标必须装进剩余预算
        boolean lastIsOne = pos > 0 && sb.charAt(pos - 1) == '1';
        if (!lastIsOne && pos <= k) {
            sb.append('1');
            dfs(res, sb, n, k - pos);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {

        L3955_Valid_Binary_Strings_With_Cost_Limit s = new L3955_Valid_Binary_Strings_With_Cost_Limit();
        long sysDate1 = System.currentTimeMillis();

        int n = 4;
        int k = 2;

        List<String> res = s.generateValidStrings(n, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}