public class L2047_Number_of_Valid_Words_in_a_Sentence {


    /*

     hyphens ('-'),
     punctuation marks ('!', '.', and ','),

     */
    public int countValidWords(String sentence) {

        int ans = 0;

        String[] senList = sentence.split(" ");
        for (String cur : senList) {
            if (satisfy(cur)) ans++;
        }

        return ans;
    }

    private boolean satisfy(String cur) {

        if (cur.length() == 0) return false;
        boolean existHyphens = false;
        int i = 0;

        while (i < cur.length()) {

            char ch = cur.charAt(i);

            if (ch == ' ') return false;

            if (isDigit(ch)) return false;

            if (ch == '-') {
                if (existHyphens) return false;

                if (i == 0 || i == cur.length() - 1) return false;

                if (!(isLetter(cur.charAt(i - 1))
                        && isLetter(cur.charAt(i + 1)))) {
                    return false;
                }

                existHyphens = true;
            }

            if (isMark(ch)) {
                if (i != cur.length() - 1) return false;
            }

            i++;
        }

        return true;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private boolean isMark(char ch) {
        return ch == '!' || ch == '.' || ch == ',';
    }

    public static void main(String[] args) {

        L2047_Number_of_Valid_Words_in_a_Sentence s = new L2047_Number_of_Valid_Words_in_a_Sentence();
        long sysDate1 = System.currentTimeMillis();

        String ss = "alice and  bob are playing stone-game10";
        //        String ss = "a-b-c";
        int res = s.countValidWords(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}