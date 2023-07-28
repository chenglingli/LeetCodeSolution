public class L1160_Find_Words_That_Can_Be_Formed_by_Characters {


    /*
    1 <= words.length <= 1000
    1 <= words[i].length, chars.length <= 100
    words[i] and chars consist of lowercase English letters.
    */
    public int countCharacters(String[] words, String chars) {
        int res = 0;

        int[] countMap = new int[26];
        count(countMap, chars);

        for (String s : words) {
            int[] curCountMap = new int[26];
            count(curCountMap, s);
            if (sarisfy(curCountMap, countMap)) {
                res += s.length();
            }
        }

        return res;
    }

    private boolean sarisfy(int[] curCountMap, int[] countMap) {
        for (int i = 0; i < 26; i++) {
            if (curCountMap[i] > countMap[i]) {
                return false;
            }
        }

        return true;
    }

    private void count(int[] countMap, String chars) {
        char[] charArray = chars.toCharArray();
        for (Character ch : charArray) {
            countMap[ch - 'a']++;
        }
    }

    public static void main(String[] args) {

        L1160_Find_Words_That_Can_Be_Formed_by_Characters s = new L1160_Find_Words_That_Can_Be_Formed_by_Characters();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";

        int res = s.countCharacters(words, chars);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}