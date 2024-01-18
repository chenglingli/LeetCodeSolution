public class L2414_Length_of_the_Longest_Alphabetical_Continuous_Substring {

    /*
    1 <= s.length <= 105
    s consists of only English lowercase letters.
     */
    public int longestContinuousSubstring(String s) {

        int res = 1;
        int i = 1;
        int j = 1;

        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) - s.charAt(i - 1) == 1) {
                i++;
                j++;
            }

            if (j > res) {
                res = j;
            }

            j = 1;
            i++;
        }

        return res;
    }

    public int longestContinuousSubstring2(String s) {
        int clen = 1, len = 1;
        char[] sc = s.toCharArray();

        for (int i = 1; i < sc.length; i++) {
            if (sc[i] - sc[i - 1] == 1) {
                clen++;
                len = Math.max(clen, len);
            } else {
                clen = 1;
            }
        }

        return len;
    }

    public static void main(String[] args) {

        L2414_Length_of_the_Longest_Alphabetical_Continuous_Substring s = new L2414_Length_of_the_Longest_Alphabetical_Continuous_Substring();
        long sysDate1 = System.currentTimeMillis();

        String input = "yrpjofyzubfsiypfre";
        int res = s.longestContinuousSubstring(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}