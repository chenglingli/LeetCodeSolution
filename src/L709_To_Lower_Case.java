import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L709_To_Lower_Case {

    /**
     *

     Implement function ToLowerCase() that has a string parameter str,
     and returns the same string in lowercase.



     Example 1:

     Input: "Hello"
     Output: "hello"


     Example 2:

     Input: "here"
     Output: "here"


     Example 3:

     Input: "LOVELY"
     Output: "lovely"

     */

    public String toLowerCase(String str) {

        StringBuilder res = new StringBuilder();

        for (int i = 0 ; i< str.length();i++) {
            char ch = str.charAt(i);
            if (ch <= 'Z' && ch >= 'A') {
                ch = (char)(ch - ('A' - 'a'));
            }
            res.append(ch);
        }

        return res.toString();
    }

    public String toLowerCase2(String str) {
        return Stream.of(str).map(String::toLowerCase).collect(Collectors.joining(""));

    }

    public static void main(String[] args) {

        L709_To_Lower_Case s = new L709_To_Lower_Case();
        long sysDate1 = System.currentTimeMillis();

        String t = "Hello";
        String res = s.toLowerCase(t);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}