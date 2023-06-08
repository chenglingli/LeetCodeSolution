public class L1816_Truncate_Sentence {

    /*
    1 <= s.length <= 500
    k is in the range [1, the number of words in s].
    s consist of only lowercase and uppercase English letters and spaces.
    The words in s are separated by a single space.
    There are no leading or trailing spaces.
     */
    public String truncateSentence(String s, int k) {

        int i = 0;
        int count = 0;
        StringBuilder res = new StringBuilder();

        while (count < k && i < s.length()) {

            while (i < s.length() && s.charAt(i) != ' ') {
                res.append(s.charAt(i++));
            }

            res.append(' ');
            i++;
            count++;
        }

        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public String truncateSentence2(String s, int k) {

        int count = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {

            if (s.charAt(i) == ' ')
                count++;

            if (count == k) {
                s = s.substring(0, i);
                break;
            }
        }

        return s;
    }

    public static void main(String[] args) {

        L1816_Truncate_Sentence s = new L1816_Truncate_Sentence();
        long sysDate1 = System.currentTimeMillis();

        String word = "What is the solution to this problem";
        int k = 3;
        String res = s.truncateSentence(word, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}