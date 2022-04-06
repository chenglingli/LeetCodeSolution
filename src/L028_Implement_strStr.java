public class StrStr {


    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;

        // init next j
        int next[] = new int[100000];
        next[0] = -1;
        int j = 0, i = 0, k = -1;
        while (j < needle.length() - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                ++k;
                ++j;

                if (needle.charAt(j) != needle.charAt(k))
                    next[j] = k;
                else
                    next[j] = next[k];
            } else {
                k = next[k];
            }
        }

        // calc sub string
        i = 0;
        j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == needle.length()) return i - j;
        else return -1;
    }

    public static void main(String[] args) {

        StrStr s = new StrStr();

        long sysDate1 = System.currentTimeMillis();

        String haystack = "aaaaa";
        String needle = "aaa";

        int res = s.strStr(haystack, needle);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}