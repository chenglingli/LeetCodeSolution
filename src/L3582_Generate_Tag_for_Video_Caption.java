public class L3582_Generate_Tag_for_Video_Caption {

    /*
    You are given a string caption representing the caption for a video.

    The following actions must be performed in order to generate a valid tag for the video:

    Combine all words in the string into a single camelCase string prefixed with '#'.
    A camelCase string is one where the first letter of all words except the first one is capitalized.
    All characters after the first character in each word must be lowercase.

    Remove all characters that are not an English letter, except the first '#'.

    Truncate the result to a maximum of 100 characters.

    Return the tag after performing the actions on caption.



    Example 1:

    Input: caption = "Leetcode daily streak achieved"

    Output: "#leetcodeDailyStreakAchieved"

    Explanation:

    The first letter for all words except "leetcode" should be capitalized.

    Example 2:

    Input: caption = "can I Go There"

    Output: "#canIGoThere"

    Explanation:

    The first letter for all words except "can" should be capitalized.

    Example 3:

    Input: caption = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"

    Output: "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"

    Explanation:

    Since the first word has length 101, we need to truncate the last two letters from the word.



    Constraints:

    1 <= caption.length <= 150
    caption consists only of English letters and ' '.

    1 <= caption.length <= 150
    caption consists only of English letters and ' '.
     */
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        boolean firstWord = true;

        for (String word : caption.split(" ")) {
            if (word.isEmpty())
                continue;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isLetter(c)) {
                    if (i == 0 && !firstWord) sb.append(Character.toUpperCase(c));
                    else sb.append(Character.toLowerCase(c));
                }
            }

            firstWord = false;
        }

        return sb.toString().length() > 100 ? sb.substring(0, 100) : sb.toString();
    }

    public String generateTag2(String caption) {
        char[] result = new char[100];
        result[0] = '#';
        int k = 1, i = 0, t = caption.length();
        boolean capitalize = false;

        while (i < t && caption.charAt(i) == ' ')
            i++;

        while (i < t && k < 100) {
            char c = caption.charAt(i++);
            if (c == ' ') capitalize = true;
            else {
                boolean isUpper = 'A' <= c && c <= 'Z';
                if (capitalize && !isUpper) c = (char) (c - 'a' + 'A');
                else if (!capitalize && isUpper) c = (char) (c - 'A' + 'a');
                result[k++] = c;
                capitalize = false;
            }
        }

        return new String(result, 0, k);
    }


    public static void main(String[] args) {

        L3582_Generate_Tag_for_Video_Caption s = new L3582_Generate_Tag_for_Video_Caption();
        long sysDate1 = System.currentTimeMillis();

        String caption = "Leetcode daily streak achieved";

        String res = s.generateTag(caption);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}