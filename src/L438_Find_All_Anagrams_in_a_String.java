import java.util.ArrayList;
import java.util.List;

public class L438_Find_All_Anagrams_in_a_String {

    /*
    1 <= s.length, p.length <= 3 * 10^4
    s and p consist of lowercase English letters.

    解决思路：
    1，使用滑动窗口
    2，使用两个数组，分别记录 p 中字符出现的次数，和滑动窗口中字符出现的次数
    3，遍历 s，如果当前字符在 p 中，滑动窗口中字符出现次数加一
    4，如果滑动窗口长度大于 p 的长度，移动左指针，滑动窗口中字符出现次数减一
    5，如果滑动窗口中字符出现次数和 p 中字符出现次数相等，则找到一个 anagram
    6，将左指针加一，继续遍历
    7，最后返回结果

     */
    public List<Integer> findAnagrams(String s, String p) {

        // 记录 p和滑动窗口 中字符出现的次数
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        int pLen = p.length();
        int sLen = s.length();

        // 初始化 pCount数组
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        // 记录滑动窗口中字符 和 p 中字符相等的字符个数
        int count = 0;
        List<Integer> res = new ArrayList<>();

        while (right < sLen) {

            char c = s.charAt(right);

            // 如果当前字符在 p 中，滑动窗口中字符出现次数加一
            if (pCount[c - 'a'] > 0) {
                sCount[c - 'a']++;
                // 如果该字符出现次数小于等于 p 中字符出现次数，则 count 加一
                if (sCount[c - 'a'] <= pCount[c - 'a']) {
                    count++;
                }
            }
            right++;

            // 如果滑动窗口长度大于 p 的长度，移动左指针，滑动窗口中字符出现次数减一
            if (right - left > pLen) {
                char t = s.charAt(left);
                if (pCount[t - 'a'] > 0) {
                    sCount[t - 'a']--;
                    if (sCount[t - 'a'] < pCount[t - 'a']) {
                        count--;
                    }
                }
                left++;
            }

            // 如果滑动窗口中字符出现次数和 p 中字符出现次数相等，则找到一个 anagram
            if (count == pLen) {
                res.add(left);
            }
        }

        // 返回结果
        return res;
    }

    public static void main(String[] args) {

        L438_Find_All_Anagrams_in_a_String s = new L438_Find_All_Anagrams_in_a_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "cbaebabacd";
        String p = "abc";

        //        String ss = "aba";
        //        String p = "aa";
        List<Integer> res = s.findAnagrams(ss, p);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}