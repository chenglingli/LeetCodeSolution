public class L1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence {

    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] strList = sentence.split(" ");
        for (int i = 0; i < strList.length; i++) {
            if (strList[i].indexOf(searchWord) == 0) {
                return i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        L1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence s = new L1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence();
        long sysDate1 = System.currentTimeMillis();

        String sentence = "this is an easy problem";
        String searchWord = "pro";

        int res = s.isPrefixOfWord(sentence, searchWord);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}