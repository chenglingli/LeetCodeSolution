import java.util.HashSet;
import java.util.Set;

public class L1763_Longest_Nice_Substring {

    /*

    1 <= s.length <= 100
    s consists of uppercase and lowercase English letters.

    YazaAay

     */

    public String longestNiceSubstring(String s) {
        int ans = 0;
        String curAnsString = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                String cur = s.substring(i, j);

                if (cur.length() > ans) {
                    if (satisfy(cur)) {
                        ans = cur.length();
                        curAnsString = cur;
                    }
                }

            }
        }

        return curAnsString;
    }

    private boolean satisfy(String cur) {
        int[][] dict = new int[26][2];
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) >= 'a') {
                dict[cur.charAt(i) - 'a'][1] = 1;
            } else {
                dict[cur.charAt(i) - 'A'][0] = 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (dict[i][0] + dict[i][1] == 1) {
                return false;
            }
        }

        return true;
    }

    public String longestNiceSubstring2(String s) {

        int n = s.length() - 1;
        int sm = 0, cl = 0;

        return getSubString(s, 0, n);
    }

    public String getSubString(String s, int st, int ed) {
        // System.out.println(st+"  "+ed);

        if (st > (ed - 1)) return "";
        int sm = 0, cl = 0;

        for (int i = st; i <= ed; i++) {
            if (s.charAt(i) >= 'a') {
                sm |= (1 << (s.charAt(i) - 'a'));
            } else {
                cl |= (1 << (s.charAt(i) - 'A'));
            }
        }

        int cxor = (cl ^ sm);
        String ans = "";
        if (cxor == 0) {
            ans = s.substring(st, ed + 1);
        } else {
            int pi = st;
            for (int i = st; i <= ed; i++) {
                char ch = Character.toLowerCase(s.charAt(i));
                if ((cxor & (1 << (s.charAt(i) - 'a'))) != 0) {
                    String a = getSubString(s, pi, i - 1);
                    if (a.length() > ans.length()) {
                        ans = a;
                    }
                    // System.out.print( ans+"\t");
                    pi = i + 1;
                }
            }

            if (pi < ed) {
                String a = getSubString(s, pi, ed);
                if (a.length() > ans.length()) {
                    ans = a;
                }
            }
        }

        return ans;
    }

    public String longestNiceSubstring3(String s) {

        if (s.length() < 2) {
            return "";
        }

        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            set.add(ch);
        }

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) {
                continue;
            }
            String s1 = longestNiceSubstring3(s.substring(0, i));
            String s2 = longestNiceSubstring3(s.substring(i + 1));
            return s1.length() >= s2.length() ? s1 : s2;
        }

        return s;
    }


    public static void main(String[] args) {

        L1763_Longest_Nice_Substring s = new L1763_Longest_Nice_Substring();
        long sysDate1 = System.currentTimeMillis();

        String input = "bB";
        String res = s.longestNiceSubstring(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}