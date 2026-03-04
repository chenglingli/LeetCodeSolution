import java.util.HashSet;
import java.util.Set;

public class L3803_Count_Residue_Prefixes {

    /*
    You are given a string s consisting only of lowercase English letters.

    A prefix of s is called a residue if the number of distinct characters in the prefix is equal to len(prefix) % 3.

    Return the count of residue prefixes in s.

    A prefix of a string is a non-empty substring that starts from the beginning of the string and extends to any point within it.


    Example 1:

    Input: s = "abc"

    Output: 2

    Explanation:

    Prefix "a" has 1 distinct character and length modulo 3 is 1, so it is a residue.
    Prefix "ab" has 2 distinct characters and length modulo 3 is 2, so it is a residue.
    Prefix "abc" does not satisfy the condition. Thus, the answer is 2.

    Example 2:

    Input: s = "dd"

    Output: 1

    Explanation:

    Prefix "d" has 1 distinct character and length modulo 3 is 1, so it is a residue.
    Prefix "dd" has 1 distinct character but length modulo 3 is 2, so it is not a residue. Thus, the answer is 1.

    Example 3:

    Input: s = "bob"

    Output: 2

    Explanation:

    Prefix "b" has 1 distinct character and length modulo 3 is 1, so it is a residue.
    Prefix "bo" has 2 distinct characters and length mod 3 is 2, so it is a residue. Thus, the answer is 2.


    Constraints:

    1 <= s.length <= 100
    s contains only lowercase English letters.

     */
    public int residuePrefixes(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            set.add(s.charAt(i));
            if (set.size() == (i + 1) % 3)
                count++;
        }

        return count;
    }

    public int residuePrefixes2(String s) {
        boolean[] seen = new boolean[26];
        int distinct = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (!seen[idx]) {
                seen[idx] = true;
                distinct++;
            }
            int len = i + 1;
            if (distinct == len % 3) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        L3803_Count_Residue_Prefixes s = new L3803_Count_Residue_Prefixes();
        long sysDate1 = System.currentTimeMillis();

        String ss = "bbbb";
        int res = s.residuePrefixes(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}