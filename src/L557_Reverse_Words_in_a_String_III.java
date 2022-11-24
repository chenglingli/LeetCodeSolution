public class L557_Reverse_Words_in_a_String_III {

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();

        String[] stringList = s.split(" ");

        for (int i = 0; i < stringList.length; i++) {
            if (i != 0) {
                sb.append(' ');
            }
            String cur = stringList[i];
            sb.append(reverseString(cur));
        }

        return sb.toString();
    }

    public StringBuilder reverseString(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res;
    }

    public String reverseWords2(String s) {
        int lo = 0, hi = 1;
        char[] ca = s.toCharArray();

        while (hi < ca.length) {

            while (hi < ca.length && ca[hi] != ' ')
                hi++;

            int temp = hi;
            hi--;

            while (lo < hi) {
                char c = ca[lo];
                ca[lo] = ca[hi];
                ca[hi] = c;
                lo++;
                hi--;
            }

            lo = hi = temp + 1;
        }
        return String.valueOf(ca);
    }

    public static void main(String[] args) {

        L557_Reverse_Words_in_a_String_III s = new L557_Reverse_Words_in_a_String_III();
        long sysDate1 = System.currentTimeMillis();
        String ss = "Let's take LeetCode contest";
        String res = s.reverseWords(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}