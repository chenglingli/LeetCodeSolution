public class L1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n {


    /*

    A happy string is a string that:

    consists only of letters of the set ['a', 'b', 'c'].
    s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
    For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa",
        "baa" and "ababbc" are not happy strings.

    Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

    Return the kth string of this list or return an empty string if there are less than k happy strings of length n.



    Example 1:

    Input: n = 1, k = 3
    Output: "c"
    Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
    Example 2:

    Input: n = 1, k = 4
    Output: ""
    Explanation: There are only 3 happy strings of length 1.
    Example 3:

    Input: n = 3, k = 9
    Output: "cab"
    Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca",
        "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"


    Constraints:

    1 <= n <= 10
    1 <= k <= 100
     */

    private int count = 0;

    public String getHappyString(int n, int k) {
        count = k;
        StringBuilder sb = new StringBuilder();
        return dfs(sb, n);
    }

    private String dfs(StringBuilder sb, int n) {

        System.out.print(count + " ");
        System.out.println(sb);

        if (sb.length() == n) {
            count--;
            return count == 0 ? sb.toString() : "";
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c)
                continue;

            sb.append(c);
            String res = dfs(sb, n);
            if (!res.isEmpty())
                return res;
            sb.deleteCharAt(sb.length() - 1);
        }

        return "";
    }



    public String getHappyString2(int n, int k) {
        String chars = "abc";
        StringBuilder s = new StringBuilder();

        String[] res = new String[]{""};

        dfs(n, k, chars, 0, s, res);

        if (count < k)
            return "";

        return res[0];
    }

    private void dfs(int n, int k, String chars, int index, StringBuilder s, String[] res) {
        if (s.length() == n) {
            if (count == k)
                res[0] = s.toString();
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (s.length() != 0 && s.charAt(index - 1) == chars.charAt(i))
                continue;

            s.append(chars.charAt(i));
            if (s.length() == n)
                count++;
            dfs(n, k, chars, index + 1, s, res);
            if (!res[0].isEmpty())
                return;
            s.deleteCharAt(s.length() - 1);
        }
    }


    public static void main(String[] args) {

        L1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n s
                = new L1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n();
        long sysDate1 = System.currentTimeMillis();

        int n = 3;
        int k = 9;
        String res = s.getHappyString2(n, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}