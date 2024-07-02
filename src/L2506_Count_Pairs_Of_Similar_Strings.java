import java.util.HashMap;

public class L2506_Count_Pairs_Of_Similar_Strings {

    /*
    1 <= words.length <= 100
    1 <= words[i].length <= 100
    words[i] consist of only lowercase English letters.

    Return the number of pairs (i, j) such that
        0 <= i < j <= word.length - 1
        and the two strings words[i] and words[j] are similar.

    将每个单词转为字符集，再转为数字，然后看数字数组中有多少值count > 1
     */
    public int similarPairs(String[] words) {

        HashMap<Integer, Integer> valueCount = new HashMap<>();
        for (String cur : words) {
            int value = countValue(cur);
            if (valueCount.containsKey(value)) {
                valueCount.put(value, valueCount.get(value) + 1);
            } else {
                valueCount.put(value, 1);
            }
        }

        int res = 0;
        for (Integer curValue : valueCount.keySet()) {
            int curCount = valueCount.get(curValue);
            if (curCount > 1) {
                res += curCount * (curCount - 1) / 2;
            }
        }

        return res;
    }

    private int countValue(String word) {

        int[] charList = new int[26];
        for (char ch : word.toCharArray()) {
            charList[ch - 'a'] = 1;
        }
        int value = 0;
        int power = 10;
        for (int i = 0; i < 26; i++) {
            if (charList[i] == 1) {
                value += (i + 1) * power;
            }
            power *= 10;
        }
        return value;
    }

    public static void main(String[] args) {

        L2506_Count_Pairs_Of_Similar_Strings s = new L2506_Count_Pairs_Of_Similar_Strings();
        long sysDate1 = System.currentTimeMillis();

        //        String[] words = {"aba", "aabb", "abcd", "bac", "aabc"};
        String[] words = {"aabb", "ab", "ba"};
        int res = s.similarPairs(words);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}