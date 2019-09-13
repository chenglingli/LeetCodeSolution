public class L014_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {

        // parameter check
        if (strs.length == 0) return "";

        // calc minLen of strings
        String res = "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (minLen > str.length()) minLen = str.length();
        }

        // calc common prefix
        for (int i = 0; i < minLen; i++) {
            char curChar = strs[0].charAt(i);

            int j;
            for (j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != curChar) break;
            }
            if (j == strs.length) res = res + curChar;
            else break;
        }

        // return
        return res;
    }

    public static void main(String[] args) {

        L014_Longest_Common_Prefix s = new L014_Longest_Common_Prefix();

        long sysDate1 = System.currentTimeMillis();
        String inputStr1 = "aca";
        String inputStr2 = "cba";
        String[] strs = {inputStr1, inputStr2};
        String res = s.longestCommonPrefix(strs);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}