import java.util.*;

public class L394_Decode_String {

    /*
     *
     * Given an encoded string, return its decoded string.
        The encoding rule is: k[encoded_string],
        * where the encoded_string inside the square brackets is being repeated exactly k times.
        * Note that k is guaranteed to be a positive integer.
        You may assume that the input string is always valid;
        * there are no extra white spaces, square brackets are well-formed, etc.
        * Furthermore, you may assume that the original data does not contain any digits and
        * that digits are only for those repeat numbers, k.
        *
        * For example, there will not be input like 3a or 2[4].
        The test cases are generated so that the length of the output will never exceed 105.
        *
        * Input: s = "3[a]2[bc]"
        * Output: "aaabcbc"
        *
        * Input: s = "3[a2[c]]"
        * Output: "accaccacc"
        *
        * Input: s = "2[abc]3[cd]ef"
        * Output: "abcabccdcdcdef"
        *
     */

    public String decodeString(String s) {

        // 创建数字栈，在遍历编码字符串过程中记录出现的数字
        Deque<Integer> numStack = new LinkedList<>();
        // 创建字符栈，在遍历编码字符串过程中记录出现的字符串
        Deque<StringBuilder> strStack = new LinkedList<>();

        StringBuilder res = new StringBuilder();

        int digit = 0;

        for (int i = 0 ; i < s.length() ; i++)  {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int num = ch - '0';
                digit = digit * 10 + num;

            } else if((ch >= 'a' && ch <= 'z') ){
                res.append(ch);

            } else if (ch == '[') {
                numStack.push(digit);
                strStack.push(res);
                digit = 0;
                res = new StringBuilder();

            } else {
            // ']' 的情况
                int count = numStack.poll();
                StringBuilder outString = strStack.poll();

                for (int j = 0; j < count; j++) {
                    outString.append(res.toString());
                }

                res = outString;
            }
        }

        return res.toString();
    }


    private int i = 0;
    public String decodeString2(String s) {

        StringBuilder sb = new StringBuilder();

        while(i < s.length()) {

            char c = s.charAt(i);

            if (isNum(c)) {
                int times = 0;
                while (isNum(s.charAt(i))) {
                    times = times * 10 + (s.charAt(i++) - '0');
                }

                i++;

                String tmp = decodeString(s);

                for (int j = 0; j < times; j++) {
                    sb.append(tmp);
                }

            } else if (c == ']') {
                i++;
                return sb.toString();
            } else {
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }

    private boolean isNum(char c) {

        return c >= '0' && c <= '9';

    }


    public static void main(String[] args) {

        L394_Decode_String s = new L394_Decode_String();
        long sysDate1 = System.currentTimeMillis();

        String a = "3[a2[c]]";
        String res = s.decodeString(a);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}