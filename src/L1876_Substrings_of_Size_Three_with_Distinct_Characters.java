public class L1876_Substrings_of_Size_Three_with_Distinct_Characters {

    /*
    1 <= s.length <= 100
    s consists of lowercase English letters.
     */
    public int countGoodSubstrings(String s) {

        if (s.length() < 3) {
            return 0;
        }

        StringBuilder temp = new StringBuilder();
        int ans = 0;

        temp.append(s.charAt(0));
        temp.append(s.charAt(1));
        int i = 2;
        while (i < s.length()) {
            temp.append(s.charAt(i));
            if (temp.charAt(0) != temp.charAt(1)
                    && temp.charAt(0) != temp.charAt(2)
                    && temp.charAt(1) != temp.charAt(2)) {
                ans++;
            }
            temp.deleteCharAt(0);
            i++;
        }

        return ans;
    }

    public int countGoodSubstrings2(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 2; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]
                    && chars[i] != chars[i - 2]
                    && chars[i - 1] != chars[i - 2]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        L1876_Substrings_of_Size_Three_with_Distinct_Characters s = new L1876_Substrings_of_Size_Three_with_Distinct_Characters();
        long sysDate1 = System.currentTimeMillis();

        //        String ss = "xyzzaz";
        String ss = "aababcabc";
        int res = s.countGoodSubstrings(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}