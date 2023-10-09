import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class L2423_Remove_Letter_To_Equalize_Frequency {

    /*
    2 <= word.length <= 100
    word consists of lowercase English letters only.

    aa bb ccc ddd
    2: 2
    3: 2

    2 : 1
    3 : 2

    2: 2
    3: 1

     */
    public boolean equalFrequency(String word) {

        // 统计各个字母频次
        // abcdd -> 1112
        int[] wordCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            wordCount[word.charAt(i) - 'a']++;
        }

        // 统计各个频次对应的数字
        // 1112 -> 1:3 2:1
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : wordCount) {
            if (num == 0) {
                continue;
            }

            int freq = frequency.getOrDefault(num, 0);
            frequency.put(num, freq + 1);

            if (frequency.keySet().size() > 2) {
                return false;
            }
        }


        // 处理 出现频次统计值全是1的情况
        /*
        只有如下两类可以被接受：
             abcdef -> k == 1
             aaaaaaa -> get(k) == 1
         */
        if (frequency.keySet().size() == 1) {
            for (Integer k : frequency.keySet()) {
                if (k == 1 || frequency.get(k) == 1) {
                    return true;
                }
            }
        }

        // 处理 出现频次统计值全是2的情况
        /*

        可能的情况有：
        1:3
        2:4

        1:1
        2:3

        只有如下两类可以被接受：
             1 : 1
             y : m

             "abbcc"

             或

             x : m
             y : 1
             且 y - x == 1
             "aabbddddeee"
         */
        if (frequency.keySet().size() == 2) {

            int[] temp1 = new int[2];
            int[] temp2 = new int[2];
            int index = 0;
            for (Integer k : frequency.keySet()) {
                temp1[index] = k;
                temp2[index++] = frequency.get(k);
            }

            if (temp1[0] < temp1[1]) {
                if (temp1[0] + 1 == temp1[1] && temp2[1] == 1) {
                    return true;
                }
                if (temp1[0] == 1 && temp2[0] == 1) {
                    return true;
                }
            } else {
                if (temp1[1] + 1 == temp1[0] && temp2[0] == 1) {
                    return true;
                }
                if (temp1[1] == 1 && temp2[1] == 1) {
                    return true;
                }
            }

            return false;
        }

        // 其余全部false
        return false;
    }

    public boolean equalFrequency2(String word) {

        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : count) {
            if (num == 0) {
                continue;
            }
            int freq = map.getOrDefault(num, 0);
            map.put(num, freq + 1);
        }

        if (map.size() == 2
                && map.firstKey() + 1 == map.lastKey()
                && map.get(map.lastKey()) == 1) {
            return true;
        }

        if (map.size() == 2
                && map.firstKey() == 1
                && map.get(map.firstKey()) == 1) {
            return true;
        }

        if (map.size() == 1) {
            if (map.firstKey() == 1
                    || map.get(map.firstKey()) == 1) {
                return true;
            }
        }

        return false;
    }


    public boolean equalFrequency3(String word) {

        int len = word.length();
        int[] count = new int[26];

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            count[c - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            count[c - 'a']--;
            if (equalCount(count)) {
                return true;
            }
            count[c - 'a']++;
        }

        return false;
    }

    public boolean equalCount(int[] count) {
        int c = 0;

        for (int i : count) {
            if (i == 0) {
                continue;
            } else if (c == 0) {
                c = i;
            } else if (c == i) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L2423_Remove_Letter_To_Equalize_Frequency s = new L2423_Remove_Letter_To_Equalize_Frequency();
        long sysDate1 = System.currentTimeMillis();

        //                String word = "aazz";
        //                String word = "aaz";
        //                String word = "aazzbbbddd";
        //        String word = "bac";
        //        String word = "abbcc";
        //        String word = "zz";
        //                String word = "cccd";
        //                String word = "ddaccb";
        String word = "cbccca";

        boolean res = s.equalFrequency(word);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}