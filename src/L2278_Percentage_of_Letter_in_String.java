public class L2278_Percentage_of_Letter_in_String {

    /*
    1 <= s.length <= 100
    s consists of lowercase English letters.
    letter is a lowercase English letter.
     */
    public int percentageLetter(String s, char letter) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }

        return (int) (count * 100 / s.length());
    }

    public static void main(String[] args) {

        L2278_Percentage_of_Letter_in_String s =
                new L2278_Percentage_of_Letter_in_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "foobar";
        char letter = 'o';

        int res = s.percentageLetter(ss, letter);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}