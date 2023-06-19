public class L1832_Check_if_the_Sentence_Is_Pangram {

    public boolean checkIfPangram(String sentence) {
        int[] existRecord = new int[26];

        for (int i = 0; i < sentence.length(); i++) {
            existRecord[sentence.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < 26; i++) {
            if (existRecord[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean checkIfPangram2(String sentence) {

        int count = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            if (sentence.contains(String.valueOf(c))) {
                count++;
            }
        }

        return count == 26;

    }

    public static void main(String[] args) {

        L1832_Check_if_the_Sentence_Is_Pangram s = new L1832_Check_if_the_Sentence_Is_Pangram();
        long sysDate1 = System.currentTimeMillis();

        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        String sentence2 = "leetcode";

        boolean res = s.checkIfPangram2(sentence2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}