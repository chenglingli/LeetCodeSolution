public class L1880_Check_if_Word_Equals_Summation_of_Two_Words {

    /*
    1 <= firstWord.length, secondWord.length, targetWord.length <= 8
    firstWord, secondWord, and targetWord consist of lowercase English letters from 'a' to 'j' inclusive.
     */
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getNum(firstWord) + getNum(secondWord) == getNum(targetWord);
    }

    private int getNum(String word) {
        int res = 0;
        int i = 0;
        while (i < word.length()) {
            res *= 10;
            res += (word.charAt(i) - 'a' );
            i++;
        }

        // System.out.println(res);
        return res;
    }

    public static void main(String[] args) {

        L1880_Check_if_Word_Equals_Summation_of_Two_Words s = new L1880_Check_if_Word_Equals_Summation_of_Two_Words();
        long sysDate1 = System.currentTimeMillis();

        String firstWord = "acb";
        String secondWord = "cba";
        String targetWord = "cdb";

        boolean res = s.isSumEqual(firstWord, secondWord, targetWord);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}