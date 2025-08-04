import struct.Node;

import java.util.Stack;

public class L2696_Minimum_String_Length_After_Removing_Substrings {

    /*

    You are given a string s consisting only of uppercase English letters.

    You can apply some operations to this string where,
        in one operation, you can remove any occurrence of one of the substrings "AB" or "CD" from s.

    Return the minimum possible length of the resulting string that you can obtain.

    Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.



    Example 1:

    Input: s = "ABFCACDB"
    Output: 2
    Explanation: We can do the following operations:
    - Remove the substring "ABFCACDB", so s = "FCACDB".
    - Remove the substring "FCACDB", so s = "FCAB".
    - Remove the substring "FCAB", so s = "FC".
    So the resulting length of the string is 2.
    It can be shown that it is the minimum length that we can obtain.
    Example 2:

    Input: s = "ACBBD"
    Output: 5
    Explanation: We cannot do any operations on the string so the length remains the same.


    Constraints:

    1 <= s.length <= 100
    s consists only of uppercase English letters.

     */
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur_char = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(cur_char);
                continue;
            }

            if (cur_char == 'B' && stack.peek() == 'A') {
                stack.pop();
            } else if (cur_char == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(cur_char);
            }
        }

        return stack.size();
    }

    public int minLength2(String s) {

        char[] str = s.toCharArray();
        int n = str.length;
        int w = 0;

        for (int r = 0; r < n; r++) {

            if (w == 0) {
                str[w] = str[r];
                w++;
                continue;
            }

            if (str[r] == 'B' && str[w - 1] == 'A') {
                w--;
            } else if (str[r] == 'D' && str[w - 1] == 'C') {
                w--;
            } else {
                str[w] = str[r];
                w++;
            }
        }

        return w;
    }

    public static void main(String[] args) {

        L2696_Minimum_String_Length_After_Removing_Substrings s = new L2696_Minimum_String_Length_After_Removing_Substrings();
        long sysDate1 = System.currentTimeMillis();

        String ss = "ABFCACDB";
        int res = s.minLength(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}