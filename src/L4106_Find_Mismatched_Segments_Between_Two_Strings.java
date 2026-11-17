import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L4106_Find_Mismatched_Segments_Between_Two_Strings {

    /*
    You are given two strings s1 and s2 of the same length.

    A mismatched segment is a maximal contiguous range of indices where the characters of s1 and s2 differ at every index.

    Return a 2D array containing [sub1, sub2] for each mismatched segment,
    where sub1 and sub2 are the corresponding substrings from s1 and s2, respectively.

    Return the segments in increasing order of their starting indices. If there are no mismatched segments, return an empty array.



    Example 1:
    Input: s1 = "earth", s2 = "empty"
    Output: [["ar","mp"],["h","y"]]

    Explanation:
    The characters at indices 1 and 2 differ, forming the mismatched segment ["ar","mp"].
    The characters at index 4 differ, forming the mismatched segment ["h","y"].

    Example 2:
    Input: s1 = "action", s2 = "nation"

    Output: [["ac","na"]]

    Explanation:
    The characters at indices 0 and 1 differ, forming the mismatched segment ["ac","na"]. All remaining characters are equal in both strings.

    Example 3:

    Input: s1 = "hot", s2 = "hot"

    Output: []

    Explanation:

    The two strings are identical, so there are no mismatched segments.



    Constraints:

    1 <= s1.length == s2.length <= 100
    s1 and s2 consist of lowercase English letters.
     */

    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> res = new ArrayList<>();

        int i = 0;
        int n = s1.length();
        while (i < n) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            while (i < n && s1.charAt(i) != s2.charAt(i)) {
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
                i++;
            }
            if (sb1.length() > 0) {
                List<String> temp = new ArrayList<>();
                temp.add(sb1.toString());
                temp.add(sb2.toString());
                res.add(temp);
            }

            i++;
        }

        return res;
    }

    public List<List<String>> findMismatchedSegments2(String s1, String s2) {
        List<List<String>> ans = new ArrayList<>();
        int n = s1.length();

        for (int i = 0; i < n; ) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
                continue;
            }

            int j = i;
            while (j < n && s1.charAt(j) != s2.charAt(j)) {
                j++;
            }

            ans.add(Arrays.asList(s1.substring(i, j), s2.substring(i, j)));
            i = j;
        }

        return ans;
    }

    public static void main(String[] args) {

        L4106_Find_Mismatched_Segments_Between_Two_Strings s = new L4106_Find_Mismatched_Segments_Between_Two_Strings();
        long sysDate1 = System.currentTimeMillis();

        String s1 = "earth";
        String s2 = "empty";

        List<List<String>> res = s.findMismatchedSegments(s1, s2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}