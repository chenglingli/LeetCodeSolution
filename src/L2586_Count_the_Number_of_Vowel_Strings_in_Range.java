import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L2586_Count_the_Number_of_Vowel_Strings_in_Range {

    /*
    You are given a 0-indexed array of string words and two integers left and right.

    A string is called a vowel string if it starts with a vowel character and ends with a vowel character
        where vowel characters are 'a', 'e', 'i', 'o', and 'u'.

    Return the number of vowel strings words[i] where i belongs to the inclusive range [left, right].



    Example 1:

    Input: words = ["are","amy","u"], left = 0, right = 2
    Output: 2
    Explanation:
    - "are" is a vowel string because it starts with 'a' and ends with 'e'.
    - "amy" is not a vowel string because it does not end with a vowel.
    - "u" is a vowel string because it starts with 'u' and ends with 'u'.
    The number of vowel strings in the mentioned range is 2.
    Example 2:

    Input: words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
    Output: 3
    Explanation:
    - "aeo" is a vowel string because it starts with 'a' and ends with 'o'.
    - "mu" is not a vowel string because it does not start with a vowel.
    - "ooo" is a vowel string because it starts with 'o' and ends with 'o'.
    - "artro" is a vowel string because it starts with 'a' and ends with 'o'.
    The number of vowel strings in the mentioned range is 3.


    Constraints:

    1 <= words.length <= 1000
    1 <= words[i].length <= 10
    words[i] consists of only lowercase English letters.
    0 <= left <= right < words.length
     */
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = left; i <= right; i++) {
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2586_Count_the_Number_of_Vowel_Strings_in_Range s = new L2586_Count_the_Number_of_Vowel_Strings_in_Range();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"are","amy","u"};
        int left = 0;
        int right = 2;
        int ans = s.vowelStrings(words, left, right);
        System.out.println(ans);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}