import java.util.*;

public class L884_Uncommon_Words_from_Two_Sentences {

    /*

    1 <= s1.length, s2.length <= 200
    s1 and s2 consist of lowercase English letters and spaces.
    s1 and s2 do not have leading or trailing spaces.
    All the words in s1 and s2 are separated by a single space.

    A word is uncommon
        if it appears exactly once in one of the sentences,
        and does not appear in the other sentence.

     */
    public String[] uncommonFromSentences(String s1, String s2) {

        String[] s1Array = s1.split(" ");
        String[] s2Array = s2.split(" ");

        Map<String, Integer> countMap = new HashMap<>();
        for (String s : s1Array) {
            int count = countMap.getOrDefault(s, 0);
            countMap.put(s, count + 1);
        }
        for (String s : s2Array) {
            int count = countMap.getOrDefault(s, 0);
            countMap.put(s, count + 1);
        }

        List<String> resArray = new ArrayList<>();
        for (String s : countMap.keySet()) {
            if (countMap.get(s) == 1) resArray.add(s);
        }

        int size = resArray.size();
        String[] res = new String[size];

        int i = 0;
        for (String s : resArray) res[i++] = s;

        return res;
    }

    public static void main(String[] args) {

        L884_Uncommon_Words_from_Two_Sentences s = new L884_Uncommon_Words_from_Two_Sentences();
        long sysDate1 = System.currentTimeMillis();

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        String[] res = s.uncommonFromSentences(s1, s2);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}