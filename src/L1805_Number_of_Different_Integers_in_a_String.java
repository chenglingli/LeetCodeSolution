import java.util.HashSet;
import java.util.Set;

public class L1805_Number_of_Different_Integers_in_a_String {

    /*
    1 <= word.length <= 1000
    word consists of digits and lowercase English letters.

     */

    public int numDifferentIntegers(String word) {
        int i = 0;

        Set<String> res = new HashSet<>();

        StringBuilder cur = new StringBuilder();
        while (i < word.length()) {

            while (i < word.length() && word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                cur.append(word.charAt(i));
                i++;
            }
            if (cur.length() > 0) {

                // process leading zero
                int j = 0;
                while (cur.length() > 0 && cur.charAt(j) == '0') {
                    cur.deleteCharAt(j);
                }

                res.add(cur.toString());

                cur = new StringBuilder();
            }

            i++;
        }

        return res.size();
    }

    public int numDifferentIntegers2(String word) {

        int n = word.length();
        Set<String> set = new HashSet<>();
        StringBuilder digit = new StringBuilder();

        for (int i = 0; i < n; i++) {

            char c = word.charAt(i);
            int ascii = c - '0';

            // non leading zero
            if (ascii >= 1 && ascii < 10) {
                while (i + 1 < n && ascii >= 0 && ascii < 10) {
                    digit.append(c);
                    c = word.charAt(++i);
                    ascii = c - '0';
                }
                if (i + 1 == n && ascii >= 0 && ascii < 10) {
                    digit.append(c);
                }

                set.add(digit.toString());
                digit = new StringBuilder();
            }
            // zero
            else if (ascii == 0 && ((i + 1 < n && word.charAt(i + 1) - '0' > 9) || i + 1 == n)) {
                set.add("0");
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

        L1805_Number_of_Different_Integers_in_a_String s = new L1805_Number_of_Different_Integers_in_a_String();
        long sysDate1 = System.currentTimeMillis();

        // String word = "a123bc34d8ef34";
//        String word = "0a0";
                String word = "a023bc23d8ef8";
        int res = s.numDifferentIntegers2(word);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}