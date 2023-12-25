import java.util.ArrayList;
import java.util.List;

public class L2828_Check_if_a_String_Is_an_Acronym_of_Words {

    /*
    1 <= words.length <= 100
    1 <= words[i].length <= 10
    1 <= s.length <= 100
    words[i] and s consist of lowercase English letters.
     */
    public boolean isAcronym(List<String> words, String s) {
        int i = 0;
        for (i = 0; i < words.size(); i++) {
            if (i >= s.length()) {
                return false;
            }
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }

        if (i == s.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        L2828_Check_if_a_String_Is_an_Acronym_of_Words s = new L2828_Check_if_a_String_Is_an_Acronym_of_Words();
        long sysDate1 = System.currentTimeMillis();

        List<String> words = new ArrayList<>();
        words.add("alice");
        words.add("bob");
        words.add("charlie");
        String input = "abc";
        boolean res = s.isAcronym(words, input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}