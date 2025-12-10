public class L3602_Hexadecimal_and_Hexatrigesimal_Conversion {

    /*
    You are given an integer n.

    Return the concatenation of the hexadecimal representation of n^2 and the hexatrigesimal representation of n^3.

    A hexadecimal number is defined as a base-16 numeral system that uses the digits 0 – 9 and the uppercase letters A - F to represent values from 0 to 15.

    A hexatrigesimal number is defined as a base-36 numeral system that uses the digits 0 – 9 and the uppercase letters A - Z to represent values from 0 to 35.


    Example 1:

    Input: n = 13

    Output: "A91P1"

    Explanation:

    n2 = 13 * 13 = 169. In hexadecimal, it converts to (10 * 16) + 9 = 169, which corresponds to "A9".
    n3 = 13 * 13 * 13 = 2197. In hexatrigesimal, it converts to (1 * 362) + (25 * 36) + 1 = 2197, which corresponds to "1P1".
    Concatenating both results gives "A9" + "1P1" = "A91P1".

    Example 2:

    Input: n = 36

    Output: "5101000"

    Explanation:

    n2 = 36 * 36 = 1296. In hexadecimal, it converts to (5 * 162) + (1 * 16) + 0 = 1296, which corresponds to "510".
    n3 = 36 * 36 * 36 = 46656. In hexatrigesimal, it converts to (1 * 363) + (0 * 362) + (0 * 36) + 0 = 46656, which corresponds to "1000".
    Concatenating both results gives "510" + "1000" = "5101000".


    Constraints:

    1 <= n <= 1000
     */
    public String concatHex36(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(n * n).toUpperCase());
        sb.append(Long.toString(n * n * n, 36).toUpperCase());
        return sb.toString();
    }

    public String concatHex362(int n) {
        char[] arr = new char[11];
        int idx = 10;

        int cube = n * n * n;
        while (cube > 0) {
            int rem = cube % 36;
            arr[idx--] = (char) (rem < 10 ? rem + '0' : rem + 'A' - 10);
            cube /= 36;
        }

        int sq = n * n;
        while (sq > 0) {
            int rem = sq % 16;
            arr[idx--] = (char) (rem < 10 ? rem + '0' : rem + 'A' - 10);
            sq /= 16;
        }

        return new String(arr, idx + 1, 10 - idx);
    }

    public static void main(String[] args) {

        L3602_Hexadecimal_and_Hexatrigesimal_Conversion s = new L3602_Hexadecimal_and_Hexatrigesimal_Conversion();
        long sysDate1 = System.currentTimeMillis();

        int n = 13;

        String res = s.concatHex36(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}