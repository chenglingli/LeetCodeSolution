import java.util.*;

public class L290_Word_Pattern {

    public boolean wordPattern(String pattern, String s) {

        LinkedHashMap<Character, String> resMap = new LinkedHashMap<>();
        LinkedHashMap<String, Character> res2Map = new LinkedHashMap<>();

        String[] letterList = s.split(" ");
        char[] chatList = pattern.toCharArray();

        if (letterList.length != chatList.length) {
            return false;
        }

        for (int i = 0; i < letterList.length; i++) {
            if (!resMap.containsKey(chatList[i])) {
                resMap.put(chatList[i], letterList[i]);
            } else {
                if (!Objects.equals(resMap.get(chatList[i]), letterList[i])) {
                    return false;
                }
            }
        }


        for (int i = 0; i < letterList.length; i++) {
            if (!res2Map.containsKey(letterList[i])) {
                res2Map.put(letterList[i], chatList[i]);
            } else {
                if (!Objects.equals(res2Map.get(letterList[i]), chatList[i])) {
                    return false;
                }
            }
        }

        return true;
    }


    public boolean wordPattern2(String pattern, String s) {
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        Map<Character, String> dict = new HashMap<>();
        Set<String> seen = new HashSet<>();

        if (words.length != chars.length)
            return false;

        for (int i = 0; i < words.length; ++i) {
            String mappedWord = dict.get(chars[i]);
            if (mappedWord != null) {
                if (!mappedWord.equals(words[i]))
                    return false;
            } else {
                if (seen.contains(words[i]))
                    return false;
                dict.put(chars[i], words[i]);
                seen.add(words[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L290_Word_Pattern s = new L290_Word_Pattern();
        long sysDate1 = System.currentTimeMillis();

        boolean res = s.wordPattern("abba", "dog dog dog dog");
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}