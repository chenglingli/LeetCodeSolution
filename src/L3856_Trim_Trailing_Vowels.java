import java.util.Arrays;

public class L3856_Trim_Trailing_Vowels {

    /*
    You are given a string s that consists of lowercase English letters.

    Return the string obtained by removing all trailing vowels from s.

    The vowels consist of the characters 'a', 'e', 'i', 'o', and 'u'.



    Example 1:

    Input: s = "idea"

    Output: "id"

    Explanation:

    Removing "idea", we obtain the string "id".

    Example 2:

    Input: s = "day"

    Output: "day"

    Explanation:

    There are no trailing vowels in the string "day".

    Example 3:

    Input: s = "aeiou"

    Output: ""

    Explanation:

    Removing "aeiou", we obtain the string "".



    Constraints:

    1 <= s.length <= 100
    s consists of only lowercase English letters.

     */
    public String trimTrailingVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        while (n > 0 && (chars[n - 1] == 'a' || chars[n - 1] == 'e' || chars[n - 1] == 'i' || chars[n - 1] == 'o' || chars[n - 1] == 'u')) {
            n--;
        }

        return s.substring(0, n);
    }

    public String trimTrailingVowels2(String s) {
        int n = s.length();

        while (n > 0 && (s.charAt(n - 1) == 'a' || s.charAt(n - 1) == 'e' || s.charAt(n - 1) == 'i' || s.charAt(n - 1) == 'o' || s.charAt(n - 1) == 'u')) {
            n--;
        }

        return s.substring(0, n);
    }

    public static void main(String[] args) {

        L3856_Trim_Trailing_Vowels s = new L3856_Trim_Trailing_Vowels();
        long sysDate1 = System.currentTimeMillis();

//        String ss = "idea";
        String ss = "aeiou";

        String res = s.trimTrailingVowels2(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}