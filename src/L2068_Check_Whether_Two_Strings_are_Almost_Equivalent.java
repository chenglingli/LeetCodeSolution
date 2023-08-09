public class L2068_Check_Whether_Two_Strings_are_Almost_Equivalent {

    /*
    Two strings word1 and word2
    are considered almost equivalent
        if the differences between the frequencies of each letter from 'a' to 'z'
        between word1 and word2
        is at most 3.

     n == word1.length == word2.length
    1 <= n <= 100
    word1 and word2 consist only of lowercase English letters.
     */
    public boolean checkAlmostEquivalent(String word1, String word2) {

        int[] word1Count = new int[26];
        int[] word2Count = new int[26];
        char[] word1Array = word1.toCharArray();
        for (char ch : word1Array) {
            word1Count[ch - 'a']++;
        }
        char[] word2Array = word2.toCharArray();
        for (char ch : word2Array) {
            word2Count[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (Math.abs(word1Count[i] - word2Count[i]) > 3) {
                return false;
            }
        }

        return true;
    }

    /*
    此解法也能过，
        但貌似官方测试数据有bug，因为如果word2偏长，且尾部有较多重复字符的话则会不满足
     */
    public boolean checkAlmostEquivalent2(String word1, String word2) {

        int[] charFrequency1 = new int[26];
        int len = word1.length();

        for (int i = 0; i < len; i++) {
            charFrequency1[word1.charAt(i) - 'a']++;
            charFrequency1[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(charFrequency1[i]) > 3) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        L2068_Check_Whether_Two_Strings_are_Almost_Equivalent s = new L2068_Check_Whether_Two_Strings_are_Almost_Equivalent();
        long sysDate1 = System.currentTimeMillis();

        String word1 = "aieuouac";
        String word2 = "aieuouac";
        boolean res = s.checkAlmostEquivalent(word1, word2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}