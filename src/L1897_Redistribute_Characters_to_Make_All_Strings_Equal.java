public class L1897_Redistribute_Characters_to_Make_All_Strings_Equal {

    /*
    1 <= words.length <= 100
    1 <= words[i].length <= 100
    words[i] consists of lowercase English letters.
     */
    public boolean makeEqual(String[] words) {

        int[] alph = new int[26];
        for (String word : words)
            for (char c : word.toCharArray())
                alph[c - 'a']++;

        for (int n : alph)
            if (n % words.length != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {

        L1897_Redistribute_Characters_to_Make_All_Strings_Equal s = new L1897_Redistribute_Characters_to_Make_All_Strings_Equal();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"abc", "aabc", "bc"};

        boolean res = s.makeEqual(words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}