import java.util.*;

public class L049_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();

        if (strs.length == 0) {
            return res;
        }

        for (String s : strs) {
            String tmp = s;
            char[] arrayCh = tmp.toCharArray();
            Arrays.sort(arrayCh);
            String sortedStr = new String(arrayCh);
            if (m.containsKey(sortedStr)) {
                m.get(sortedStr).add(s);
            }
            else {
                m.put(sortedStr, new ArrayList<String>(Collections.singleton(s)));
            }
        }

        for (String s : m.keySet()) {
            res.add(m.get(s));
        }

        return res;
    }

    public static void main(String[] args) {

        L049_Group_Anagrams s = new L049_Group_Anagrams();

        long sysDate1 = System.currentTimeMillis();

        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = s.groupAnagrams(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}