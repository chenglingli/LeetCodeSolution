public class L3707_Equal_Score_Substrings {

    /*
    You are given a string s consisting of lowercase English letters.

    The score of a string is the sum of the positions of its characters in the alphabet, where 'a' = 1, 'b' = 2, ..., 'z' = 26.

    Determine whether there exists an index i such that the string can be split into two non-empty substrings s[0..i]
        and s[(i + 1)..(n - 1)] that have equal scores.

    Return true if such a split exists, otherwise return false.



    Example 1:

    Input: s = "adcb"

    Output: true

    Explanation:

    Split at index i = 1:

    Left substring = s[0..1] = "ad" with score = 1 + 4 = 5
    Right substring = s[2..3] = "cb" with score = 3 + 2 = 5
    Both substrings have equal scores, so the output is true.

    Example 2:

    Input: s = "bace"

    Output: false

    Explanation:​​​​​​

    ​​​​​​​No split produces equal scores, so the output is false.



    Constraints:

    2 <= s.length <= 100
    s consists of lowercase English letters.
     */

    public boolean scoreBalance(String s) {
        int[] cumulativeScore = new int[s.length()];

        cumulativeScore[0] = s.charAt(0) - 'a' + 1;
        for (int i = 1; i < s.length(); i++) {
            cumulativeScore[i] = cumulativeScore[i - 1] + (s.charAt(i) - 'a' + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (cumulativeScore[i] * 2 == cumulativeScore[s.length() - 1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        L3707_Equal_Score_Substrings s = new L3707_Equal_Score_Substrings();
        long sysDate1 = System.currentTimeMillis();

        String ss = "adcb";

        boolean res = s.scoreBalance(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}