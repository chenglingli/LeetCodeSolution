public class L3120_Count_the_Number_of_Special_Characters_I {

    /*

    You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

    Return the number of special letters in word.



    Example 1:

    Input: word = "aaAbcBC"

    Output: 3

    Explanation:

    The special characters in word are 'a', 'b', and 'c'.

    Example 2:

    Input: word = "abc"

    Output: 0

    Explanation:

    No character in word appears in uppercase.

    Example 3:

    Input: word = "abBCab"

    Output: 1

    Explanation:

    The only special character in word is 'b'.



    Constraints:

    1 <= word.length <= 50
    word consists of only lowercase and uppercase English letters.

     */
    public int numberOfSpecialChars(String word) {
        int[] count = new int[52];
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                count[c - 'A' + 26]++;
            } else if (Character.isLowerCase(c)) {
                count[c - 'a']++;
            }
        }

        int ans = 0;
        for (int i = 0; i < count.length / 2; i++) {
            if (count[i] > 0 && count[i + 26] > 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L3120_Count_the_Number_of_Special_Characters_I s = new L3120_Count_the_Number_of_Special_Characters_I();
        long sysDate1 = System.currentTimeMillis();

        String word = "aaAbcBC";

        int res = s.numberOfSpecialChars(word);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}