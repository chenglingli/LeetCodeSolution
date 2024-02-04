import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L087_Scramble_String {

    /*

    s1.length == s2.length
    1 <= s1.length <= 30
    s1 and s2 consist of lowercase English letters.

    s1 = "great", s2 = "rgeat"

    f[i, j, k] 表示s1[i, i+k]和s2[j, j+k]是否为scramble string
    f[i, j, k] = f[i, j, l] && f[i+l, j+l, k-l] || f[i, j+k-l, l] && f[i+l, j, k-l]

    返回f[0,0,n]

    vfldiodffghyq
    vdgyhfqfdliof

     */
    public boolean isScramble(String s1, String s2) {

        Map<String, Boolean> memo = new HashMap<>();
        return scram(s1, s2, memo);
    }

    public boolean scram(String s1, String s2, Map<String, Boolean> memo) {

        // 相等字符串直接返回
        if (s1.equals(s2))
            return true;

        // 看是否曾经计算过
        String key = s1 + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // 判断字符是否一致，剪枝
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }
        if (!Arrays.equals(f1, f2)) {
            memo.put(key, false);
            return false;
        }

        // 拆分子串分别校验
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // s1 = x + y, s2 = x' + y'
            // 看x和x'是否为scramble string，看y和y'是否为scramble string
            // 或者看x和y'是否为scramble string，看y和x'是否为scramble string
            if (scram(s1.substring(0, i), s2.substring(0, i), memo)
                    && scram(s1.substring(i), s2.substring(i), memo)

                    || scram(s1.substring(0, i), s2.substring(n - i), memo)
                    && scram(s1.substring(i), s2.substring(0, n - i), memo)) {

                memo.put(key, true);
                return true;
            }
        }

        // 记录
        memo.put(key, false);
        return false;
    }


    private static final int[] alphaC = new int[26];
    private static final int CACHE_SIZE = 750;
    private static final int CACHE_MASK = CACHE_SIZE - 1;

    public boolean isScramble2(String s1, String s2) {
        return scramble(s1, s2, 0, s1.length(), 0, s2.length(), new Boolean[CACHE_SIZE]);
    }

    private boolean scramble(
            String s1, String s2,
            int s1Start, int s1End,
            int s2Start, int s2End,
            Boolean[] cache) {

        final int s1Len = s1End - s1Start;
        final int s2Len = s2End - s2Start;
        if (s1Len != s2Len)
            return false;

        if (lettersMismatch(s1, s2, s1Start, s1End, s2Start, s2End))
            return false;

        if (stringRangeEquals(s1, s2, s1Start, s2Start, s1Len))
            return true;

        final int key = (gigaHash(s1, s1Start, s1End) + gigaHash(s2, s2Start, s2End)) & CACHE_MASK;
        final Boolean r = cache[key];

        if (r != null)
            return r;

        for (int i = 1; i < s1Len; i++) {
            if (scramble(s1, s2, s1Start, s1Start + i, s2Start, s2Start + i, cache) &&
                    scramble(s1, s2, s1Start + i, s1End, s2Start + i, s2End, cache)) {
                cache[key] = true;
                return true;
            }
            if (scramble(s1, s2, s1Start, s1Start + i, s2End - i, s2End, cache) &&
                    scramble(s1, s2, s1Start + i, s1End, s2Start, s2End - i, cache)) {
                cache[key] = true;
                return true;
            }
        }

        cache[key] = false;
        return false;
    }

    // 判断 字符个数是否一致
    private static boolean lettersMismatch(
            String s1, String s2,
            int s1Start, int s1End,
            int s2Start, int s2End) {
        Arrays.fill(alphaC, 0);
        for (int i = s1Start; i < s1End; ++i) {
            alphaC[s1.charAt(i) - 'a']++;
        }
        for (int i = s2Start; i < s2End; ++i) {
            alphaC[s2.charAt(i) - 'a']--;
        }
        for (int c : alphaC) {
            if (c != 0) return true;
        }
        return false;
    }

    // 将一个字符串hash为一个数字
    private int gigaHash(String s, int start, int end) {
        int res = 31;
        for (int i = start; i < end; ++i) {
            res *= (i + s.charAt(i));
        }
        return res;
    }

    private boolean stringRangeEquals(
            String s1, String s2,
            int s1Start, int s2Start,
            int len) {

        return s1.substring(s1Start, s1Start + len).equals(s2.substring(s2Start, s2Start + len));

        //        for (int i = 0; i < len; i++) {
        //            if (s1.charAt(s1Start++) != s2.charAt(s2Start++))
        //                return false;
        //        }
        //        return true;
    }


    public static void main(String[] args) {

        L087_Scramble_String s = new L087_Scramble_String();

        long sysDate1 = System.currentTimeMillis();

        String s1 = "abcd";
        String s2 = "cbad";

        boolean x = s.isScramble2(s1, s2);
        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}