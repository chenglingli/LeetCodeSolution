public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (i < s.length()
                    && !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'
                    || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'
                    || s.charAt(i) >= '0' && s.charAt(i) <= '9'
            )) {
                i++;
            }
            while (j > 0
                    && !(s.charAt(j) >= 'a' && s.charAt(j) <= 'z'
                    || s.charAt(j) >= 'A' && s.charAt(j) <= 'Z'
                    || s.charAt(j) >= '0' && s.charAt(j) <= '9'
            )) {
                j--;
            }

            if (i == s.length() || j == -1) {
                return true;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


    public static void main(String[] args) {

        ValidPalindrome s = new ValidPalindrome();

        long sysDate1 = System.currentTimeMillis();

        //String x = "A man, a plan, a canal: Panama";
        String x = ".,";

        boolean res = s.isPalindrome(x);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}