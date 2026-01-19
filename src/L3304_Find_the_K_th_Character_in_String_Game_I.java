import java.util.Arrays;

public class L3304_Find_the_K_th_Character_in_String_Game_I {

    /*
    Alice and Bob are playing a game. Initially, Alice has a string word = "a".

    You are given a positive integer k.

    Now Bob will ask Alice to perform the following operation forever:

    Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
    For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

    Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.



    Example 1:

    Input: k = 5

    Output: "b"

    Explanation:

    Initially, word = "a". We need to do the operation three times:

    Generated string is "b", word becomes "ab".
    Generated string is "bc", word becomes "abbc".
    Generated string is "bccd", word becomes "abbcbccd".

    Example 2:

    Input: k = 10

    Output: "c"



    Constraints:

    1 <= k <= 500

     */
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();

        sb.append("a");
        while (sb.length() < k) {
            String s = sb.toString();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == 'z') {
                    sb.append('a');
                } else {
                    sb.append((char)(c + 1));
                }
            }
        }

        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {

        L3304_Find_the_K_th_Character_in_String_Game_I s = new L3304_Find_the_K_th_Character_in_String_Game_I();
        long sysDate1 = System.currentTimeMillis();

        int k = 10;
        char res = s.kthCharacter(k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}