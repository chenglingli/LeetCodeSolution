import java.util.ArrayList;
import java.util.List;

public class L2273_Find_Resultant_Array_After_Removing_Anagrams {

    /*
    1 <= words.length <= 100
    1 <= words[i].length <= 10
    words[i] consists of lowercase English letters.
     */
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();

        int[] preAnagramCount = new int[26];
        for (String cur : words) {
            int[] anagramCount = Anagram(cur);
            if (!equalAnagram(preAnagramCount, anagramCount)) {
                res.add(cur);
                assignAnagram(anagramCount, preAnagramCount);
            }
        }
        return res;

    }

    private boolean equalAnagram(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private void assignAnagram(int[] a, int[] b) {
        System.arraycopy(a, 0, b, 0, 26);
    }

    private int[] Anagram(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }


    public boolean isAnagram(String p, String q) {

        int[] count = new int[26];
        int res = 0;

        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : q.toCharArray()) {
            count[c - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    public List<String> removeAnagrams2(String[] words) {

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length; ) {
            int j = i + 1;
            while (j < words.length && isAnagram(words[i], words[j])) {
                j++;
            }
            ans.add(words[i]);
            i = j;
        }

        return ans;
    }

    public static void main(String[] args) {

        L2273_Find_Resultant_Array_After_Removing_Anagrams s =
                new L2273_Find_Resultant_Array_After_Removing_Anagrams();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};

        List<String> res = s.removeAnagrams(words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}