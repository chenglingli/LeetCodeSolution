public class L2710_Remove_Trailing_Zeros_From_a_String {

    /*

    Given a positive integer num represented as a string, return the integer num without trailing zeros as a string.



    Example 1:
    Input: num = "51230100"
    Output: "512301"
    Explanation: Integer "51230100" has 2 trailing zeros, we remove them and return integer "512301".

    Example 2:
    Input: num = "123"
    Output: "123"
    Explanation: Integer "123" has no trailing zeros, we return integer "123".


    Constraints:

    1 <= num.length <= 1000
    num consists of only digits.
    num doesn't have any leading zeros.

     */
    public String removeTrailingZeros(String num) {
        int n = num.length();
        for (int i = n - 1; i >= 0; --i) {
            if (num.charAt(i) != '0')
                return num.substring(0, i + 1);
        }

        return "0";
    }

    public static void main(String[] args) {

        L2710_Remove_Trailing_Zeros_From_a_String s = new L2710_Remove_Trailing_Zeros_From_a_String();
        long sysDate1 = System.currentTimeMillis();

        String num = "51230100";

        String res = s.removeTrailingZeros(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}