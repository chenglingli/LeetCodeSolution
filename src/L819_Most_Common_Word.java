import java.util.*;

public class L819_Most_Common_Word {

    /*

    1 <= paragraph.length <= 1000
    paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
    0 <= banned.length <= 100
    1 <= banned[i].length <= 10
    banned[i] consists of only lowercase English letters.

    The words in paragraph are case-insensitive
        and the answer should be returned in lowercase.

     */

    public String mostCommonWord(String paragraph, String[] banned) {

        List<Character> chaList = new ArrayList<>();
        chaList.add('!');
        chaList.add('?');
        chaList.add('\'');
        chaList.add(';');
        chaList.add('.');
        chaList.add(',');
        String[] paList = polished(paragraph, chaList).split(" ");

        Map<String, Integer> countMap = new HashMap<>();
        for (String str : banned) {
            countMap.put(str, -1);
        }

        for (String cur : paList) {

            if (Objects.equals(cur, " ") || cur.length() == 0) {
                continue;
            }

            int count = countMap.getOrDefault(cur, 0);
            if(count == -1) {
                continue;
            }
            countMap.put(cur, count + 1);
        }

        int ans = 0;
        StringBuilder res = new StringBuilder();
        for (String k : countMap.keySet()) {

            if (countMap.get(k) > ans) {
                ans = countMap.get(k);
                res = new StringBuilder(k);
            }
        }

        return res.toString();
    }

    private String polished(String input, List<Character> chaList) {

        StringBuilder res = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (chaList.contains(c)) {
                res.append(" ");
            } else {
                res.append(c);
            }
        }

        return res.toString().toLowerCase();
    }


    public String mostCommonWord2(String paragraph, String[] banned) {

        // 初始化 计数map
        Map<String, Integer> map = new HashMap<>();
        for (String str : banned) {
            map.put(str, -1);
        }

        // 预处理 paragraph
        int len = paragraph.length();
        paragraph = paragraph.toLowerCase();

        // 返回结果记录
        int max = 0;
        String res = null;

        // 遍历 paragraph
        for (int i = 0; i < len; i++) {

            // 取出可用单词 [i, j) 段
            int j = i;
            while (j < len && Character.isLetter(paragraph.charAt(j))) {
                j++;
            }
            if (i == j)
                continue;
            String word = paragraph.substring(i, j);

            // 更新游标
            i = j;

            // 更新计数器
            int count = map.getOrDefault(word, 0);
            if (count == -1)
                continue;
            count++;
            map.put(word, count);

            // 更新当前结果
            if (count > max) {
                res = word;
                max = count;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L819_Most_Common_Word s = new L819_Most_Common_Word();
        long sysDate1 = System.currentTimeMillis();

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        //        String paragraph = "a, a, a, a, b,b,b,c, c";
        //        String[] banned = {"a"};

        String res = s.mostCommonWord(paragraph, banned);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}