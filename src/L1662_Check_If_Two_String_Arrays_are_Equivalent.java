public class L1662_Check_If_Two_String_Arrays_are_Equivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        int i = 0;
        while (i < word1.length) {
            sb1.append(word1[i]);
            i++;
        }

        StringBuilder sb2 = new StringBuilder();
        i = 0;
        while (i < word2.length) {
            sb2.append(word2[i]);
            i++;
        }

        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {

        L1662_Check_If_Two_String_Arrays_are_Equivalent s = new L1662_Check_If_Two_String_Arrays_are_Equivalent();
        long sysDate1 = System.currentTimeMillis();

        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};

        boolean res = s.arrayStringsAreEqual(word1, word2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}