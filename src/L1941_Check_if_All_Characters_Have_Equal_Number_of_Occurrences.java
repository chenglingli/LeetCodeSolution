public class L1941_Check_if_All_Characters_Have_Equal_Number_of_Occurrences {


    /*
        1 <= s.length <= 1000
        s consists of lowercase English letters.
     */
    public boolean areOccurrencesEqual(String s) {

        if (s.length() == 1) return true;

        int[] count = new int[26];
        for (char ch : s.toCharArray()) count[ch - 'a']++;

        int i = 0;
        while (count[i] == 0) i++;
        int k = count[i++];

        while (i < 26 && (count[i] == 0 || count[i] == k)) i++;

        return i == 26;
    }

    public static void main(String[] args) {

        L1941_Check_if_All_Characters_Have_Equal_Number_of_Occurrences s =
                new L1941_Check_if_All_Characters_Have_Equal_Number_of_Occurrences();
        long sysDate1 = System.currentTimeMillis();

        String input = "abdabd";
        boolean res = s.areOccurrencesEqual(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}