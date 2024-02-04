public class L680_Valid_Palindrome_II {

    /*
    abc
    abca
    abbca
     */
    public boolean validPalindrome(String s) {

        if (s.length() <= 2) {
            return true;
        }

        int f = 0;
        int t = s.length() - 1;

        while (f < t) {
            if (s.charAt(f) != s.charAt(t)) {
                return isPalindrome(s, f + 1, t)
                        || isPalindrome(s, f, t - 1);
            }

            f++;
            t--;
        }

        return true;
    }

    private boolean isPalindrome(String ss, int f, int t) {

        int p1 = f;
        int p2 = t;

        while (p1 < p2) {
            if (ss.charAt(p1) != ss.charAt(p2)) {
                return false;
            }

            p1++;
            p2--;
        }

        return true;
    }


    public boolean validPalindrome2(String s) {

        if (s == null || s.length() < 1) {
            return false;
        }

        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return palindromeCheck(s, p1, p2 - 1) || palindromeCheck(s, p1 + 1, p2);
            }
            p1++;
            p2--;
        }
        return true;
    }

    public boolean palindromeCheck(String s, int leftIndex, int rightIndex) {
        int p1 = leftIndex;
        int p2 = rightIndex;
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }


    public static void main(String[] args) {

        L680_Valid_Palindrome_II s = new L680_Valid_Palindrome_II();
        long sysDate1 = System.currentTimeMillis();

        String operations = "abc";
        boolean res = s.validPalindrome(operations);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}