public class L2114_Maximum_Number_of_Words_Found_in_Sentences {

    /*
    1 <= sentences.length <= 100
    1 <= sentences[i].length <= 100
    sentences[i] consists only of lowercase English letters and ' ' only.
    sentences[i] does not have leading or trailing spaces.
    All the words in sentences[i] are separated by a single space.
     */
    public int mostWordsFound(String[] sentences) {

        int ans = 0;

        for (String cur : sentences) {
            String[] curList = cur.split(" ");
            ans = Math.max(ans, curList.length);
        }

        return ans;
    }

    public int mostWordsFound2(String[] sentences) {
        int max = 1;
        for (String sen : sentences) {
            int result = mostWordsRecur(sen, 1);
            if (result > max)
                max = result;

        }
        return max;
    }

    public int mostWordsRecur(String S, int count) {
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ' ')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

        L2114_Maximum_Number_of_Words_Found_in_Sentences s = new L2114_Maximum_Number_of_Words_Found_in_Sentences();
        long sysDate1 = System.currentTimeMillis();

        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        int res = s.mostWordsFound(sentences);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}