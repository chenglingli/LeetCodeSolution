import java.util.ArrayList;
import java.util.List;

public class L3324_Find_the_Sequence_of_Strings_Appeared_on_the_Screen {

    /*
    You are given a string target.

    Alice is going to type target on her computer using a special keyboard that has only two keys:

    Key 1 appends the character "a" to the string on the screen.
    Key 2 changes the last character of the string on the screen to its next character in the English alphabet.
    For example, "c" changes to "d" and "z" changes to "a".

    Note that initially there is an empty string "" on the screen, so she can only press key 1.

    Return a list of all strings that appear on the screen as Alice types target, in the order they appear, using the minimum key presses.



    Example 1:

    Input: target = "abc"

    Output: ["a","aa","ab","aba","abb","abc"]

    Explanation:

    The sequence of key presses done by Alice are:

    Press key 1, and the string on the screen becomes "a".
    Press key 1, and the string on the screen becomes "aa".
    Press key 2, and the string on the screen becomes "ab".
    Press key 1, and the string on the screen becomes "aba".
    Press key 2, and the string on the screen becomes "abb".
    Press key 2, and the string on the screen becomes "abc".

    Example 2:
    Input: target = "he"
    Output: ["a","b","c","d","e","f","g","h","ha","hb","hc","hd","he"]



    Constraints:

    1 <= target.length <= 400
    target consists only of lowercase English letters.

     */

    public List<String> stringSequence(String target) {

        /*
         构造目标字符串，屏幕显示的过程
         对于target中的每个字符，都是从a开始，依次向后遍历到当前字符
         */

        List<String> res = new ArrayList<>();
        int n = target.length();
        for (int i = 0; i < n; i++) {
            String cur = target.substring(0, i);

            char c = target.charAt(i);
            for (int j = 0; j < c - 'a'; j++) {
                res.add(cur + (char) ('a' + j));
            }
            res.add(cur + c);
        }

        return res;
    }

    public List<String> stringSequence2(String target) {

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : target.toCharArray()) {
            sb.append('a');
            res.add(sb.toString());

            char currChar = 'a';

            while (currChar != ch) {
                currChar = currChar == 'z' ? 'a' : (char) (currChar + 1);
                sb.setCharAt(sb.length() - 1, currChar);
                res.add(sb.toString());
            }
        }

        return res;
    }

    public List<String> stringSequence3(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (char c : target.toCharArray()) {
            // Step 1: Simulate pressing Key 1 (Appends 'a')
            temp.append('a');
            ans.add(temp.toString());

            // Step 2: Simulate pressing Key 2 (Increments the last char until it matches c)
            for (char ch = 'b'; ch <= c; ch++) {
                temp.setCharAt(temp.length() - 1, ch);
                ans.add(temp.toString());
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L3324_Find_the_Sequence_of_Strings_Appeared_on_the_Screen s = new L3324_Find_the_Sequence_of_Strings_Appeared_on_the_Screen();
        long sysDate1 = System.currentTimeMillis();

        String target = "abc";

        List<String> res = s.stringSequence(target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}