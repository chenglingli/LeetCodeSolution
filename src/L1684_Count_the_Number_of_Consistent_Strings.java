public class L1684_Count_the_Number_of_Consistent_Strings {


    /*

    1 <= words.length <= 104
    1 <= allowed.length <= 26
    1 <= words[i].length <= 10
    The characters in allowed are distinct.
    words[i] and allowed contains only lowercase English letters.

     */
    public int countConsistentStrings(String allowed, String[] words) {

        int res = 0;

        for (String cur : words) {
            int i = 0;
            for (i = 0; i < cur.length(); i++) {
                if (allowed.indexOf(cur.charAt(i)) == -1) {
                    break;
                }
            }
            if (i == cur.length()) {
                res++;
            }
        }

        return res;
    }

    public int countConsistentStrings2(String allowed, String[] words) {
        int res = 0;

        boolean[] booleans = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            booleans[allowed.charAt(i) - 'a'] = true;
        }

        for (String word : words) {
            if (checkWord(word, booleans)) {
                res++;
            }
        }
        return res;
    }

    public boolean checkWord(String word, boolean[] booleans) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!booleans[c - 'a']) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        L1684_Count_the_Number_of_Consistent_Strings s = new L1684_Count_the_Number_of_Consistent_Strings();
        long sysDate1 = System.currentTimeMillis();

        String allowed = "cad";
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        int res = s.countConsistentStrings(allowed, words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}