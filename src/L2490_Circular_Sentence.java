public class L2490_Circular_Sentence {

    /*
    1 <= sentence.length <= 500
    sentence consist of only lowercase and uppercase English letters and spaces.
    The words in sentence are separated by a single space.
    There are no leading or trailing spaces.
     */
    public boolean isCircularSentence(String sentence) {

        String[] senArray = sentence.split(" ");
        int len = senArray.length;

        for (int i = 0; i < len; i++) {
            String cur = senArray[i];
            String next = senArray[(i + 1) % len];
            if (cur.charAt(cur.length() - 1) != next.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    /*
    解法2：不用split，直接遍历sentence
     */
    public boolean isCircularSentence2(String sentence) {

        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }

        int index = -1;

        while ((index = sentence.indexOf(' ', index + 1)) != -1) {
            if (sentence.charAt(index - 1) != sentence.charAt(index + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        L2490_Circular_Sentence s = new L2490_Circular_Sentence();
        long sysDate1 = System.currentTimeMillis();

        //        String sentence = "lee exercises sound delightful";
        //        String sentence = "eetcode";
        String sentence = "Leetcode is cool";
        boolean res = s.isCircularSentence(sentence);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}