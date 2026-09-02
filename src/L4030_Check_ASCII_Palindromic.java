public class L4030_Check_ASCII_Palindromic {

    /*
    You are given a string s consisting of lowercase English letters.

    Construct a binary string by replacing each character in s with the 8-bit binary representation of its ASCII value,
    including leading zeros, while preserving the original order of the characters.

    Return true if the resulting binary string is a palindrome. Otherwise, return false.



    Example 1:

    Input: s = "ff"

    Output: true

    Explanation:

    The ASCII value of f is 102, whose 8-bit binary representation is 01100110.
    Thus, the binary string is 0110011001100110.
    Since this binary string is a palindrome, the output is true.
    Example 2:

    Input: s = "leet"

    Output: false

    Explanation:

    The ASCII values of l, e, e, and t are 108, 101, 101, and 116, respectively.
    Their 8-bit binary representations are 01101100, 01100101, 01100101, and 01110100.
    Thus, the binary string is 01101100011001010110010101110100.
    Since this binary string is not a palindrome, the output is false.


    Constraints:

    1 <= s.length <= 100
    s consists of lowercase English letters.
     */

    // 朴素：拼出 8*n 位二进制再双指针判回文。必须补齐 8 位前导 0。
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0'));
        }

        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l++) != sb.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    // 观察：第 i 个字符的第 j 位，对应第 n-1-i 个字符的第 7-j 位。
    // 即 s[i] 的 8 位反转必须等于 s[n-1-i]。奇数长度时中间字符只能是 'f'。
    public boolean isPalindromic2(String s) {
        int n = s.length();
        for (int i = 0; i <= n / 2; i++) {
            if (reverse8(s.charAt(i)) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /*

    这个函数做的事是：把 x 最低 8 位左右翻转，得到一个 0–255 的整数。

    以 'f' = 102 为例，低 8 位是 01100110，翻转后还是 01100110。

    分两步看：

    1. Integer.reverse(x) 翻转的是整 32 位，不是 8 位

    x = 102 在 32 位里实际是：

    00000000 00000000 00000000 01100110
    整段反过来变成：

    01100110 00000000 00000000 00000000
    原来垫在高位的那些 0，现在全挤到低位去了。如果直接拿这个当结果，数值会大得离谱，也不是我们要的 8 位反转。

    2. >>> 24 把高 8 位挪回最低 8 位

    无符号右移 24 位，上面那串变成：

    00000000 00000000 00000000 01100110

     */
    private int reverse8(int x) {
        return Integer.reverse(x) >>> 24;
    }

    public static void main(String[] args) {

        L4030_Check_ASCII_Palindromic s = new L4030_Check_ASCII_Palindromic();
        long sysDate1 = System.currentTimeMillis();

        String ss = "ff";

        boolean res = s.isPalindromic(ss);
        System.out.println(res);
        System.out.println(s.isPalindromic2(ss));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}