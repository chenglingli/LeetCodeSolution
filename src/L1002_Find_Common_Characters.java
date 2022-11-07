import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L1002_Find_Common_Characters {

    // map方法，先统计出每个单词中cur个数，然后取最小值
    public List<String> commonChars(String[] words) {

        int l = words.length;
        List<HashMap<Character, Integer>> stats = new ArrayList<>();

        for (String curString : words) {
            HashMap<Character, Integer> map = convertToMap(curString);
            stats.add(map);
        }

        List<String> res = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            int count = findMin(i, stats);
            if (count == 0) {
                continue;
            }
            for (int j = 0; j < count; j++) {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    public int findMin(char ch, List<HashMap<Character, Integer>> stats) {
        int minCount = 100 * 100;

        for (HashMap<Character, Integer> stat : stats) {
            if (!stat.containsKey(ch)) {
                return 0;
            } else {
                minCount = Math.min(minCount, stat.get(ch));
            }
        }

        return minCount;
    }


    public HashMap<Character, Integer> convertToMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        return map;
    }

    // 方法2，就是模拟，不断取交集
    public List<String> commonChars2(String[] A) {
        int[] last = count(A[0]);

        for (int i = 1; i < A.length; i++) {
            last = intersection(last, count(A[i]));
        }

        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }

        return arr;
    }

    int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) t[c - 'a']++;
        return t;
    }


    public static void main(String[] args) {

        L1002_Find_Common_Characters s = new L1002_Find_Common_Characters();

        long sysDate1 = System.currentTimeMillis();

        String[] words = {"cool", "lock", "cook"};
        List<String> res = s.commonChars(words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}