import java.util.HashSet;
import java.util.Set;

public class L3760_Maximum_Substrings_With_Distinct_Start {

    /*

    You are given a string s consisting of lowercase English letters.

    Return an integer denoting the maximum number of substrings
        you can split s into such that each substring starts with a distinct character
    (i.e., no two substrings start with the same character).



    Example 1:

    Input: s = "abab"

    Output: 2

    Explanation:

    Split "abab" into "a" and "bab".
    Each substring starts with a distinct character i.e 'a' and 'b'. Thus, the answer is 2.

    Example 2:
    Input: s = "abcd"

    Output: 4

    Explanation:

    Split "abcd" into "a", "b", "c", and "d".
    Each substring starts with a distinct character. Thus, the answer is 4.

    Example 3:
    Input: s = "aaaa"

    Output: 1

    Explanation:

    All characters in "aaaa" are 'a'.
    Only one substring can start with 'a'. Thus, the answer is 1.


    Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.

     */
    public int maxDistinct(String s) {
        // 题意是，给定一个字符串，求最多可以分成多少个子串，使得每个子串的起始字符都不相同
        // 贪心算法，从左到右遍历字符串，用一个集合记录已经出现过的字符
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

    public int maxDistinct2(String s) {
        boolean[] freq = new boolean[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!freq[s.charAt(i) - 'a']) {
                freq[s.charAt(i) - 'a'] = true;
                count++;
            }
            if (count == 26) return count;
        }
        return count;
    }

    public static void main(String[] args) {

        L3760_Maximum_Substrings_With_Distinct_Start s = new L3760_Maximum_Substrings_With_Distinct_Start();
        long sysDate1 = System.currentTimeMillis();

        String ss = "abab";

        int res = s.maxDistinct(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}