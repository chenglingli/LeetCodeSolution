public class L1071_Greatest_Common_Divisor_of_Strings {

    public String gcdOfStrings(String str1, String str2) {

        String s1 = str1;
        String s2 = str2;
        if (str1.length() < str2.length()) {
            s1 = str2;
            s2 = str1;
        }

        if (!s1.contains(s2)) {
            return "";
        }

        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 % l2 == 0) {
            if (DivisorOfString(s1, s2)) return s2;
            else return "";
        } else {
            for (int i = l2, k = 1; i > 1; k++, i = l2 / k) {
                String cur = s2.substring(0, i);
                if (DivisorOfString(s1, cur)) return cur;
            }
        }

        return "";
    }

    private boolean DivisorOfString(String mother, String child) {

        int l1 = mother.length();
        int l2 = child.length();
        if (l1 % l2 != 0) return false;

        int fromIndex = 0;
        while (fromIndex != -1) {
            int tempIndex = mother.indexOf(child, fromIndex);
            if (tempIndex == -1 || tempIndex != fromIndex) return false;

            fromIndex = tempIndex + l2;
            if (fromIndex == l1) return true;
        }

        return false;
    }

    // 递归做法
    public String gcdOfStrings2(String str1, String str2) {

        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return str1;
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }

    }

    public static void main(String[] args) {

        L1071_Greatest_Common_Divisor_of_Strings s = new L1071_Greatest_Common_Divisor_of_Strings();

        long sysDate1 = System.currentTimeMillis();

        String str1 = "ABABABAB";
        String str2 = "ABAB";

        //        String str1 = "efgabc";
        //        String str2 = "abc";

        String res = s.gcdOfStrings(str1, str2);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}