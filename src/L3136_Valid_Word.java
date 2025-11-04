public class L3136_Valid_Word {

    /*

    A word is considered valid if:

    It contains a minimum of 3 characters.
    It contains only digits (0-9), and English letters (uppercase and lowercase).
    It includes at least one vowel.
    It includes at least one consonant.
    You are given a string word.

    Return true if word is valid, otherwise, return false.

    Notes:

    'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
    A consonant is an English letter that is not a vowel.


    Example 1:

    Input: word = "234Adas"

    Output: true

    Explanation:

    This word satisfies the conditions.

    Example 2:

    Input: word = "b3"

    Output: false

    Explanation:

    The length of this word is fewer than 3, and does not have a vowel.

    Example 3:

    Input: word = "a3$e"

    Output: false

    Explanation:

    This word contains a '$' character and does not have a consonant.



    Constraints:

    1 <= word.length <= 20
    word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.

     */
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }

            if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        hasVowel = true;
                        break;
                    default:
                        hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }

    public static void main(String[] args) {

        L3136_Valid_Word s = new L3136_Valid_Word();
        long sysDate1 = System.currentTimeMillis();

        String word = "234Adas";

        boolean res = s.isValid(word);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}