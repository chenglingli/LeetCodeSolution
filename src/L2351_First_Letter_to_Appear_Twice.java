public class L2351_First_Letter_to_Appear_Twice {

    /*
    2 <= s.length <= 100
    s consists of lowercase English letters.
    s has at least one repeated letter.
     */
    public char repeatedCharacter(String s) {

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            if (count[s.charAt(i) - 'a'] == 2) {
                return s.charAt(i);
            }
        }

        return s.charAt(s.length() - 1);
    }

    public static void main(String[] args) {

        L2351_First_Letter_to_Appear_Twice s =
                new L2351_First_Letter_to_Appear_Twice();
        long sysDate1 = System.currentTimeMillis();

        String input = "abccbaacz";
        char res = s.repeatedCharacter(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}