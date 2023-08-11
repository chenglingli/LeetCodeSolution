import java.util.HashMap;
import java.util.Map;

public class L2085_Count_Common_Words_With_One_Occurrence {

    /*

    Given two string arrays words1 and words2,
    return the number of strings
        that appear exactly once in each of the two arrays.

    1 <= words1.length, words2.length <= 1000
    1 <= words1[i].length, words2[j].length <= 30
    words1[i] and words2[j] consists only of lowercase English letters.

     */
    public int countWords(String[] words1, String[] words2) {

        Map<String, Integer> word1Count = new HashMap<>();
        Map<String, Integer> word2Count = new HashMap<>();

        for (String s : words1) {
            word1Count.put(s, word1Count.getOrDefault(s, 0) + 1);
        }

        for (String s : words2) {
            word2Count.put(s, word2Count.getOrDefault(s, 0) + 1);
        }

        int ans = 0;
        for (String s : word1Count.keySet()) {
            if (word2Count.containsKey(s)) {
                if (word1Count.get(s) == 1 && word2Count.get(s) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int countWords2(String[] words1, String[] words2) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int count = 0;

        for (String word : words2) {
            Integer freq = map.get(word);

            if (freq != null && freq <= 1) {
                if (freq == 1) {
                    count++;
                } else if (freq == 0) {
                    count--;
                }

                map.put(word, freq - 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L2085_Count_Common_Words_With_One_Occurrence s = new L2085_Count_Common_Words_With_One_Occurrence();
        long sysDate1 = System.currentTimeMillis();

        String[] word1 = {"aieuouac"};
        String[] word2 = {"aieuouac"};
        int res = s.countWords(word1, word2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}