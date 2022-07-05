import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L030_Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {

        // 参数判断
        if (s == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }

        // res
        List<Integer> res = new ArrayList<>();

        // 初始化hash和m
        HashMap<String, Integer> hash = new HashMap<>();
        for (String word : words) {
            hash.put(word, hash.containsKey(word) ? hash.get(word) + 1 : 1);
        }
        int n = words.length;
        int m = words[0].length();

        // 以m段跳跃
        for (int i = 0; i < m; i++) {

            // 当前map
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int count = 0;
            int left = i;

            for (int j = i; j <= s.length() - m; j += m) {
                String curStr = s.substring(j, j + m);

                if (hash.containsKey(curStr)) {
                    curMap.put(curStr, curMap.containsKey(curStr) ? curMap.get(curStr) + 1 : 1);
                    if (curMap.get(curStr) <= hash.get(curStr)) {
                        count++;
                    } else {
                        while (curMap.get(curStr) > hash.get(curStr)) {
                            String t1 = s.substring(left, left + m);
                            curMap.put(t1, curMap.containsKey(t1) ? curMap.get(t1) - 1 : 0);
                            if (curMap.get(t1) < hash.get(t1)) {
                                count--;
                            }
                            left += m;
                        }
                    }

                    if (count == n) {
                        res.add(left);

                        String t2 = s.substring(left, left + m);
                        curMap.put(t2, curMap.get(t2) - 1);
                        count--;
                        left += m;
                    }

                } else {
                    curMap.clear();
                    count = 0;
                    left = j + m;
                }
            }

        }


        return res;
    }

    public static void main(String[] args) {

        L030_Substring_with_Concatenation_of_All_Words s = new L030_Substring_with_Concatenation_of_All_Words();

        long sysDate1 = System.currentTimeMillis();
        String ss = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        List<Integer> res = s.findSubstring(ss, words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}