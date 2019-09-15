import java.util.Objects;

public class L151_Reverse_Words_in_a_String {

    /**

     Given an input string, reverse the string word by word.



     Example 1:

     Input: "the sky is blue"
     Output: "blue is sky the"

     Example 2:

     Input: "  hello world!  "
     Output: "world! hello"
     Explanation: Your reversed string should not contain
     leading or trailing spaces.

     Example 3:

     Input: "a good   example"
     Output: "example good a"
     Explanation: You need to reduce multiple spaces
     between two words to a single space in the reversed string.


     Note:

     A word is defined as a sequence of non-space characters.
     Input string may contain leading or trailing spaces.
     However, your reversed string should not contain
     leading or trailing spaces.
     You need to reduce multiple spaces between two
     words to a single space in the reversed string.

     */

    public String reverseWords(String s) {

        if (s == null || s.length() == 0) return "";
        
        String trimString = s.trim();
        String[] stringList = trimString.split(" ");

        StringBuilder ans = new StringBuilder();
        for (int i = stringList.length - 1; i >=0 ; i--) {
            if (!Objects.equals(stringList[i].trim(), "")) {
                ans.append(stringList[i].trim());
                ans.append(" ");
            }
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {

        L151_Reverse_Words_in_a_String s = new L151_Reverse_Words_in_a_String();
        long sysDate1 = System.currentTimeMillis();

        String s1 = "a good   example";
        String res = s.reverseWords(s1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}