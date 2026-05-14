public class L2396_Strictly_Palindromic_Number {

    /*
    An integer n is strictly palindromic if, for every base b between 2 and n - 2 (inclusive),
    the string representation of the integer n in base b is palindromic.

    Given an integer n, return true if n is strictly palindromic and false otherwise.

    A string is palindromic if it reads the same forward and backward.



    Example 1:

    Input: n = 9
    Output: false
    Explanation: In base 2: 9 = 1001 (base 2), which is palindromic.
    In base 3: 9 = 100 (base 3), which is not palindromic.
    Therefore, 9 is not strictly palindromic so we return false.
    Note that in bases 4, 5, 6, and 7, n = 9 is also not palindromic.

    Example 2:
    Input: n = 4
    Output: false
    Explanation: We only consider base 2: 4 = 100 (base 2), which is not palindromic.
    Therefore, we return false.



    Constraints:

    4 <= n <= 105

     */
    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base <= n - 2; ++base) {
            String numInBaseB = Integer.toString(n, base);
            System.out.println(numInBaseB);
            if (!isPalindrome(numInBaseB))
                return false;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

    public boolean isStrictlyPalindromic2(int n) {
        return false;
    }

    public static void main(String[] args) {

        L2396_Strictly_Palindromic_Number s = new L2396_Strictly_Palindromic_Number();
        long sysDate1 = System.currentTimeMillis();

        int n = 9;
        boolean res = s.isStrictlyPalindromic(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}