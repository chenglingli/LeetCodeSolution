import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class L2062_Count_Vowel_Substrings_of_a_String {

    public int countVowelSubstrings(String word) {

        Map<Character, Integer> vowel = new HashMap<>();
        vowel.put('a', -1);
        vowel.put('e', -1);
        vowel.put('i', -1);
        vowel.put('o', -1);
        vowel.put('u', -1);

        int count = 0;
        int lastSeen = -1;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (vowel.containsKey(c)) {
                vowel.put(c, i);
                count += Math.max(Collections.min(vowel.values()) - lastSeen, 0);
            } else {
                lastSeen = i;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L2062_Count_Vowel_Substrings_of_a_String s = new L2062_Count_Vowel_Substrings_of_a_String();
        long sysDate1 = System.currentTimeMillis();

        String word2 = "cuaieuouac";
        /*
        aieuo
        aieuou

        aieuoua
        ieuoua
         */
        String word = "aieuouac";
        // String word = "poazaeuioauoiioaouuouaui";
        int res = s.countVowelSubstrings(word);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}