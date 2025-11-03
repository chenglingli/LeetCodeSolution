public class L3407_Substring_Matching_Pattern {

    /*
    You are given a string s and a pattern string p, where p contains exactly one '*' character.

    The '*' in p can be replaced with any sequence of zero or more characters.

    Return true if p can be made a substring of s, and false otherwise.



    Example 1:

    Input: s = "leetcode", p = "ee*e"

    Output: true

    Explanation:

    By replacing the '*' with "tcod", the substring "eetcode" matches the pattern.

    Example 2:

    Input: s = "car", p = "c*v"

    Output: false

    Explanation:

    There is no substring matching the pattern.

    Example 3:

    Input: s = "luck", p = "u*"

    Output: true

    Explanation:

    The substrings "u", "uc", and "uck" match the pattern.


    Constraints:

    1 <= s.length <= 50
    1 <= p.length <= 50
    s contains only lowercase English letters.
    p contains only lowercase English letters and exactly one '*'
     */
    public boolean hasMatch(String s, String p) {
        int starIndex = p.indexOf('*');
        String prefix = p.substring(0, starIndex);
        String suffix = p.substring(starIndex + 1);

        if (prefix.isEmpty()) {
            if (s.indexOf(suffix) == -1) {
                return false;
            }
            return true;
        }

        if (suffix.isEmpty()) {
            if (s.indexOf(prefix) == -1) {
                return false;
            }
            return true;
        }

        // 前后缀均有
        int prefixIndex = s.indexOf(prefix);
        if (prefixIndex == -1) {
            return false;
        }
        int suffixIndex = s.indexOf(suffix, prefixIndex + prefix.length());

        if (suffixIndex == -1) {
            return false;
        }

        return true;
    }

    public boolean hasMatch2(String s, String p) {

        if (p.length() == 1) {
            return true;
        }

        int index = 0;

        for(char c: p.toCharArray()) {
            if (c == '*') {
                break;
            }
            index++;
        }

        String firstPattern = p.substring(0, index);
        String secondPattern = p.substring(index + 1);

        int firstIndex = s.indexOf(firstPattern);

        if (firstIndex == -1) {
            return false;
        }

        if (secondPattern.length() == 0) {
            return true;
        }

        int secondIndex = s.substring(firstIndex + firstPattern.length()).indexOf(secondPattern);

        if (secondIndex == -1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        L3407_Substring_Matching_Pattern s = new L3407_Substring_Matching_Pattern();
        long sysDate1 = System.currentTimeMillis();

//        String ss = "leetcode";
//        String pp = "ee*e";

        String ss = "tokk";
        String pp = "t*t";

        boolean res = s.hasMatch(ss, pp);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}