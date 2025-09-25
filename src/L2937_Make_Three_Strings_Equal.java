public class L2937_Make_Three_Strings_Equal {

    /*

    You are given three strings: s1, s2, and s3. In one operation you can choose one of these strings and delete its rightmost character.

    Note that you cannot completely empty a string.

    Return the minimum number of operations required to make the strings equal. If it is impossible to make them equal, return -1.



    Example 1:

    Input: s1 = "abc", s2 = "abb", s3 = "ab"

    Output: 2

    Explanation: Deleting the rightmost character from both s1 and s2 will result in three equal strings.

    Example 2:

    Input: s1 = "dac", s2 = "bac", s3 = "cac"

    Output: -1

    Explanation: Since the first letters of s1 and s2 differ, they cannot be made equal.



    Constraints:

    1 <= s1.length, s2.length, s3.length <= 100
    s1, s2 and s3 consist only of lowercase English letters.
    */
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int o = s3.length();

        int i = 0, j = 0, k = 0;
        while (i < n && j < m && k < o
                && s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
            i++;
            j++;
            k++;
        }

        if (i == 0) {
            return -1;
        }

        return n + m + o - 3 * i;
    }

    public static void main(String[] args) {

        L2937_Make_Three_Strings_Equal s = new L2937_Make_Three_Strings_Equal();
        long sysDate1 = System.currentTimeMillis();

        String s1 = "abc";
        String s2 = "abb";
        String s3 = "ab";

        int res = s.findMinimumOperations(s1, s2, s3);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}