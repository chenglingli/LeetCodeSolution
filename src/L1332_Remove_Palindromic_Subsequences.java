public class L1332_Remove_Palindromic_Subsequences {

    public int removePalindromeSub(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return 2;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        L1332_Remove_Palindromic_Subsequences s = new L1332_Remove_Palindromic_Subsequences();
        long sysDate1 = System.currentTimeMillis();

        String num = "a";

        int res = s.removePalindromeSub(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}