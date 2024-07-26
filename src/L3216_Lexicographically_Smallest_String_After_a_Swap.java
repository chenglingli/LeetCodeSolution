public class L3216_Lexicographically_Smallest_String_After_a_Swap {

    /*
    2 <= s.length <= 100
    s consists only of digits.

    swapping adjacent digits in s with the same parity at most once.

    Digits have the same parity if both are odd or both are even.
    For example, 5 and 9, as well as 2 and 4, have the same parity, while 6 and 9 do not.

     */
    public String getSmallestString(String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length() - 1) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) % 2 == 0 && s.charAt(i) > s.charAt(i + 1)) {
                break;
            }
            sb.append(s.charAt(i));
            i++;
        }

        if (i == s.length() - 1) {
            sb.append(s.charAt(i));
        }
        else {
            sb.append(s.charAt(i + 1));
            sb.append(s.charAt(i));
            sb.append(s.substring(i + 2));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        L3216_Lexicographically_Smallest_String_After_a_Swap s = new L3216_Lexicographically_Smallest_String_After_a_Swap();
        long sysDate1 = System.currentTimeMillis();

        String input = "45320";
        String res = s.getSmallestString(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}