public class L1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {

    /*
        You are given two strings of the same length s and t.
        In one step you can choose any character of t and replace it with another character.

    Return the minimum number of steps to make t an anagram of s.

    An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.



    Example 1:

    Input: s = "bab", t = "aba"
    Output: 1
    Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

    Example 2:
    Input: s = "leetcode", t = "practice"
    Output: 5
    Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
    Example 3:

    Input: s = "anagram", t = "mangaar"
    Output: 0
    Explanation: "anagram" and "mangaar" are anagrams.


    Constraints:

    1 <= s.length <= 5 * 10^4
    s.length == t.length
    s and t consist of lowercase English letters only.
     */

    public int minSteps(String s, String t) {
        int[] sMark = new int[26];
        int[] tMark = new int[26];

        for (char c : s.toCharArray()) {
            sMark[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tMark[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(sMark[i] - tMark[i]);
        }

        return res / 2;
    }

    public static void main(String[] args) {

        L1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram s = new L1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram();
        long sysDate1 = System.currentTimeMillis();

        String ss = "bab";
        String t = "aba";
        int res = s.minSteps(ss, t);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}