public class L1221_Split_a_String_in_Balanced_Strings {

    /*
    2 <= s.length <= 1000
    s[i] is either 'L' or 'R'.
    s is a balanced string.
     */
    public int balancedStringSplit(String s) {
        int countL = 0;
        int countR = 0;
        int i = 0;
        int ans = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'L') {
                countL++;
            } else {
                countR++;
            }
            if (countL == countR) {
                ans++;
                countL = 0;
                countR = 0;
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {

        L1221_Split_a_String_in_Balanced_Strings s = new L1221_Split_a_String_in_Balanced_Strings();
        long sysDate1 = System.currentTimeMillis();

        String x = "RLRRRLLRLL";
        int res = s.balancedStringSplit(x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}