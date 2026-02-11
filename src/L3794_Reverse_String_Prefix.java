public class L3794_Reverse_String_Prefix {

    /*
    You are given a string s and an integer k.

    Reverse the first k characters of s and return the resulting string.



    Example 1:

    Input: s = "abcd", k = 2

    Output: "bacd"

    Explanation:

    The first k = 2 characters "ab" are reversed to "ba". The final resulting string is "bacd".

    Example 2:

    Input: s = "xyz", k = 3

    Output: "zyx"

    Explanation:

    The first k = 3 characters "xyz" are reversed to "zyx". The final resulting string is "zyx".

    Example 3:

    Input: s = "hey", k = 1

    Output: "hey"

    Explanation:

    The first k = 1 character "h" remains unchanged on reversal. The final resulting string is "hey".



    Constraints:

    1 <= s.length <= 100
    s consists of lowercase English letters.
    1 <= k <= s.length

     */
    public String reversePrefix(String s, int k) {
        StringBuilder sb = new StringBuilder(s.substring(0, k));
        return sb.reverse() + s.substring(k);
    }

    public String reversePrefix2(String s, int k) {
        char[] ch = s.toCharArray();

        int i = 0, j = k - 1;
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }

        return new String(ch);
    }

    public static void main(String[] args) {

        L3794_Reverse_String_Prefix s = new L3794_Reverse_String_Prefix();
        long sysDate1 = System.currentTimeMillis();

        String ss = "abcd";
        int k = 2;
        String res = s.reversePrefix(ss, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}