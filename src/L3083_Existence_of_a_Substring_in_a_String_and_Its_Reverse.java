public class L3083_Existence_of_a_Substring_in_a_String_and_Its_Reverse {

    /*

    Given a string s, find any substring of length 2 which is also present in the reverse of s.

    Return true if such a substring exists, and false otherwise.



    Example 1:

    Input: s = "leetcode"

    Output: true

    Explanation: Substring "ee" is of length 2 which is also present in reverse(s) == "edocteel".

    Example 2:

    Input: s = "abcba"

    Output: true

    Explanation: All of the substrings of length 2 "ab", "bc", "cb", "ba" are also present in reverse(s) == "abcba".

    Example 3:

    Input: s = "abcd"

    Output: false

    Explanation: There is no substring of length 2 in s, which is also present in the reverse of s.



    Constraints:

    1 <= s.length <= 100
    s consists only of lowercase English letters.
     */


    public boolean isSubstringPresent(String s) {

        String reverseString = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length() - 1; i++) {
            String subStr = s.substring(i, i + 2);
            if (reverseString.contains(subStr))
                return true;
        }

        return false;
    }


    public static void main(String[] args) {

        L3083_Existence_of_a_Substring_in_a_String_and_Its_Reverse s = new L3083_Existence_of_a_Substring_in_a_String_and_Its_Reverse();
        long sysDate1 = System.currentTimeMillis();

        String ss = "abcba";

        boolean res = s.isSubstringPresent(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}