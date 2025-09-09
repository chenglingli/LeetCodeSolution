public class L3330_Find_the_Original_Typed_String_I {

    /*
    Alice is attempting to type a specific string on her computer.
    However, she tends to be clumsy and may press a key for too long,
    resulting in a character being typed multiple times.

    Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.

    You are given a string word, which represents the final output displayed on Alice's screen.

    Return the total number of possible original strings that Alice might have intended to type.



    Example 1:

    Input: word = "abbcccc"

    Output: 5

    Explanation:

    The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".

    Example 2:

    Input: word = "abcd"

    Output: 1

    Explanation:

    The only possible string is "abcd".

    Example 3:

    Input: word = "aaaa"

    Output: 4



    Constraints:

    1 <= word.length <= 100
    word consists only of lowercase English letters.
     */

    public int possibleStringCount(String word) {
        int n = word.length();
        int ans = 0;

        int count = 0;
        for (int i = 0; i < n; ++i) {

            int j = i + 1;
            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            if (j - i > 1) {
                ans += (j - i);
                count++;
            }

            i = j - 1;
        }

        return ans - count + 1;
    }

    public int possibleStringCount2(String word) {
        if (word.length() == 1) {
            return 1;
        }

        int c = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                c++;
            }
        }

        return c + 1;
    }

    public static void main(String[] args) {

        L3330_Find_the_Original_Typed_String_I s = new L3330_Find_the_Original_Typed_String_I();
        long sysDate1 = System.currentTimeMillis();

        // String word = "abbcccc";
        String word = "aabbbcccc";


        int res = s.possibleStringCount(word);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}