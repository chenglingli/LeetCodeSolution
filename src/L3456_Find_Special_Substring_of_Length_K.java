public class L3456_Find_Special_Substring_of_Length_K {

    /*
    You are given a string s and an integer k.

    Determine if there exists a substring of length exactly k in s that satisfies the following conditions:

    The substring consists of only one distinct character (e.g., "aaa" or "bbb").
    If there is a character immediately before the substring, it must be different from the character in the substring.
    If there is a character immediately after the substring, it must also be different from the character in the substring.
    Return true if such a substring exists. Otherwise, return false.



    Example 1:

    Input: s = "aaabaaa", k = 3

    Output: true

    Explanation:

    The substring s[4..6] == "aaa" satisfies the conditions.

    It has a length of 3.
    All characters are the same.
    The character before "aaa" is 'b', which is different from 'a'.
    There is no character after "aaa".
    Example 2:

    Input: s = "abc", k = 2

    Output: false

    Explanation:

    There is no substring of length 2 that consists of one distinct character and satisfies the conditions.



    Constraints:

    1 <= k <= s.length <= 100
    s consists of lowercase English letters only.
     */
    public boolean hasSpecialSubstring(String s, int k) {

        for (int i = 0; i < s.length() - k + 1; i++) {

            String sub = s.substring(i, i + k);

            if (sub.chars().distinct().count() == 1) {

                if (i > 0 && s.charAt(i - 1) != sub.charAt(0) && i + k < s.length() && s.charAt(i + k) != sub.charAt(0)) {
                    return true;
                }

                if (i == 0 && i + k < s.length() && s.charAt(i + k) != sub.charAt(0)) {
                    return true;
                }

                if (i + k == s.length() && i > 0 && s.charAt(i - 1) != sub.charAt(0)) {
                    return true;
                }

                if (i == 0 && i + k == s.length()) {
                    return true;
                }

            }
        }

        return false;
    }

    public boolean hasSpecialSubstring2(String s, int k) {
        int n = s.length();

        for (int i = 0; i + k <= n; i++) {//last valid substring starting - i+(k-1)<n --> i+k<=n

            boolean allSame = true;

            for (int j = i + 1; j < i + k; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    allSame = false;
                    break;
                }
            }

            if (allSame && (i == 0 || s.charAt(i - 1) != s.charAt(i)) && (i + k == n || s.charAt(i + k) != s.charAt(i))) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        L3456_Find_Special_Substring_of_Length_K s = new L3456_Find_Special_Substring_of_Length_K();
        long sysDate1 = System.currentTimeMillis();

        String ss = "aaabaaa";
        int k = 3;

        //        String ss = "ccc";
        //        int k = 2;


        boolean res = s.hasSpecialSubstring(ss, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}