import java.util.Arrays;

public class L748_Shortest_Completing_Word {


    /*
    1 <= licensePlate.length <= 7
    licensePlate contains digits, letters (uppercase or lowercase), or space ' '.
    1 <= words.length <= 1000
    1 <= words[i].length <= 15

    符合条件的，取最短的，然后取最先出现的

     */

    public String shortestCompletingWord(String licensePlate, String[] words) {

        int[] charCount = new int[26];
        int count = 0;
        String licensePlateLowCase = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlateLowCase.length(); i++) {
            char cur = licensePlateLowCase.charAt(i);
            if (cur >= 'a' && cur <= 'z') {
                charCount[cur - 'a']++;
                count++;
            }
        }

        String ans = null;
        for (String word : words) {
            if (completeWord(word, charCount, count)) {
                if (ans == null) {
                    ans = word;
                } else if (ans.length() > word.length()) {
                    ans = word;
                }
            }
        }

        return ans;
    }

    private boolean completeWord(String str, int[] charCount, int count) {

        if (str.length() < count) {
            return false;
        }

        int[] copyCharCount = Arrays.stream(charCount).toArray();

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (copyCharCount[cur - 'a'] > 0) {
                copyCharCount[cur - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (copyCharCount[i] != 0) {
                return false;
            }
        }

        return true;
    }


    public String shortestCompletingWord2(String licensePlate, String[] words) {

        int minLen = Integer.MAX_VALUE;
        int idx = -1;

        String s = normalizeLetters(licensePlate);

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < minLen && isGoodMatch(s, words[i])) {
                minLen = words[i].length();
                idx = i;
            }
        }

        return words[idx];
    }

    public String normalizeLetters(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'z')
                builder.append(Character.toLowerCase(ch));
        }
        return builder.toString();
    }

    public boolean isGoodMatch(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] letters = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i) - 'a']++;
        }

        for (int j = 0; j < s1.length(); j++) {
            int index = s1.charAt(j) - 'a';
            if (letters[index] == 0) {
                return false;
            }
            letters[index]--;
        }

        return true;
    }


    public static void main(String[] args) {

        L748_Shortest_Completing_Word s = new L748_Shortest_Completing_Word();
        long sysDate1 = System.currentTimeMillis();

        String licensePlate = "1s3 456";
        String[] words = {"looks", "pest", "stew", "show"};

        String res = s.shortestCompletingWord(licensePlate, words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}