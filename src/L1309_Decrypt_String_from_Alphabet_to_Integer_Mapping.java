import java.util.HashMap;
import java.util.Map;

public class L1309_Decrypt_String_from_Alphabet_to_Integer_Mapping {


    /*

    10#11#12
    1326#

     */

    public String freqAlphabets(String s) {

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int pre = 0;

        while (i < s.length()) {

            while (i < s.length() && s.charAt(i) != '#') {
                i++;
            }

            if (i != s.length()) {
                i++;
            }
            String tempStr = s.substring(pre, i);
            pre = i;

            if (tempStr.charAt(tempStr.length() - 1) == '#') {

                int k = 0;
                for (k = 0; k < tempStr.length() - 3; k++) {
                    sb.append((char) ('a' + (tempStr.charAt(k) - '0') -1 ));
                }

                int a = tempStr.charAt(k) - '0';
                int b = tempStr.charAt(k+1)- '0';
                int c = a * 10 + b;
                sb.append((char) ('a' + c - 1));

            } else {
                for (int k = 0; k < tempStr.length(); k++) {
                    sb.append((char) ('a' + (tempStr.charAt(k) - '0') -1 ));
                }
            }
        }

        return sb.toString();
    }


    public String freqAlphabets2(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '#') {
                int a = s.charAt(i - 2) - '0';
                int b = s.charAt(i - 1) - '0';
                int c = a * 10 + b;

                sb.append((char) ('a' + c - 1));
                i -= 2;

            } else {
                int a = s.charAt(i) - '0';
                sb.append((char) ('a' + a - 1));
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        L1309_Decrypt_String_from_Alphabet_to_Integer_Mapping s = new L1309_Decrypt_String_from_Alphabet_to_Integer_Mapping();
        long sysDate1 = System.currentTimeMillis();

                String input = "1326#";
//        String input = "10#11#12";
        String res = s.freqAlphabets(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}