public class L1859_Sorting_the_Sentence {

    /*
    2 <= s.length <= 200
    s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
    The number of words in s is between 1 and 9.
    The words in s are separated by a single space.
    s contains no leading or trailing spaces.
     */
    public String sortSentence(String s) {
        String[] stringList = s.split(" ");
        String[] stringBuf = new String[stringList.length + 1];
        for (String cur : stringList) {
            int num = cur.charAt(cur.length() - 1) - '0';
            stringBuf[num] = cur.substring(0, cur.length() - 1);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 1 ; i < stringBuf.length - 1; i++) {
            res.append(stringBuf[i]);
            res.append(" ");
        }

        res.append(stringBuf[stringBuf.length - 1]);

        return res.toString();
    }

    public static void main(String[] args) {

        L1859_Sorting_the_Sentence s = new L1859_Sorting_the_Sentence();
        long sysDate1 = System.currentTimeMillis();

        String ss = "is2 sentence4 This1 a3";
        String res = s.sortSentence(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}