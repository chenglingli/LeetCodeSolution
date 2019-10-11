import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L392_Is_Subsequence {

    /**
     Given a string s and a string t, check if s is subsequence of t.

     You may assume that there is only lower case English
     letters in both s and t. t is potentially a very
     long (length ~= 500,000) string, and s is a short string (<=100).

     A subsequence of a string is a new string
     which is formed from the original string
     by deleting some (can be none) of the
     characters without disturbing the relative
     positions of the remaining characters.
     (ie, "ace" is a subsequence of "abcde" while "aec" is not).

     Example 1:
     s = "abc", t = "ahbgdc"

     Return true.

     Example 2:
     s = "axc", t = "ahbgdc"

     Return false.

     Follow up:
     If there are lots of incoming S, say S1, S2, ... ,
     Sk where k >= 1B, and you want to check one by
     one to see if T has its subsequence. In this scenario,
     how would you change your code?
     */

    public boolean isSubsequence(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();
        int i=0, j =0;
        while (i < len1 && j<len2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        if (i == len1) {
            return true;
        }
        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        char[] ss = s.toCharArray();
        int j = 0;
        for(int i = 0; i < ss.length; i++) {
            j = t.indexOf(ss[i], j);
            if(j == -1)
                return false;
            j++;
        }
        return true;
    }

    public boolean isSubsequence3(String s, String t) {
        List<Integer>[] positions = new List[26];

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = c - 'a';
            if (positions[index] == null) {
                positions[index] = new ArrayList<>();
            }
            positions[index].add(i);
        }

        int last = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (positions[index] == null) {
                return false;
            }
            int insertion = Collections.binarySearch(positions[index], last);
            if (insertion < 0) {
                insertion = - (insertion + 1);
            }
            if (insertion == positions[index].size()) {
                return false;
            }
            last = positions[index].get(insertion) + 1;
        }

        return true;
    }

    public static void main(String[] args) {

        L392_Is_Subsequence s = new L392_Is_Subsequence();
        long sysDate1 = System.currentTimeMillis();

        String a = "ab";
        String b = "cad";
        boolean res = s.isSubsequence(a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}