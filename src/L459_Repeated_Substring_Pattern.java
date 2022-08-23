public class L459_Repeated_Substring_Pattern {

    public boolean repeatedSubstringPattern(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        int len = s.length();
        for (int i = 2; i <= len; i++) {

            if (len % i != 0) {
                continue;
            }

            int subLen = len / i;
            String subString = s.substring(0, subLen);
            boolean satisfy = true;

            for (int j = 0; j <= len - subLen; j += subLen) {
                String tempSubString = s.substring(j, j + subLen);
                if (!tempSubString.equals(subString)) {
                    satisfy = false;
                    break;
                }
            }

            if (satisfy) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        L459_Repeated_Substring_Pattern s = new L459_Repeated_Substring_Pattern();

        long sysDate1 = System.currentTimeMillis();
        String input = "abcabcabcabc";
        boolean res = s.repeatedSubstringPattern(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}