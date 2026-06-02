import java.util.ArrayList;
import java.util.List;

public class L3211_Generate_Binary_Strings_Without_Adjacent_Zeros {

    /*
    You are given a positive integer n.

    A binary string x is valid if all substrings of x of length 2 contain at least one "1".

    Return all valid strings with length n, in any order.



    Example 1:

    Input: n = 3

    Output: ["010","011","101","110","111"]

    Explanation:

    The valid strings of length 3 are: "010", "011", "101", "110", and "111".

    Example 2:

    Input: n = 1

    Output: ["0","1"]

    Explanation:

    The valid strings of length 1 are: "0" and "1".



    Constraints:

    1 <= n <= 18


     */
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();

        dfs(res, new StringBuilder(), n, false);

        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int n, boolean lastIsZero) {
        // 1. base case
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        // 2. 放 '1'（永远可以）
        sb.append('1');
        dfs(res, sb, n, false);   // 最后一位是 1
        sb.deleteCharAt(sb.length() - 1);
        
        // 3. 放 '0'（上一位不能是 0）
        if (!lastIsZero) {
            sb.append('0');
            dfs(res, sb, n, true);    // 最后一位是 0
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {

        L3211_Generate_Binary_Strings_Without_Adjacent_Zeros s = new L3211_Generate_Binary_Strings_Without_Adjacent_Zeros();
        long sysDate1 = System.currentTimeMillis();

        int n = 3;
        List<String> res = s.validStrings(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}