public class L1961_Check_If_String_Is_a_Prefix_of_Array {


    public boolean isPrefixString(String s, String[] words) {

        int i = 0;
        int index = 0;

        while (i < s.length() && index < words.length) {

            int j = 0;
            while (j < words[index].length()
                    && i < s.length()
                    && s.charAt(i) == words[index].charAt(j)) {
                i++;
                j++;
            }

            // 二者同时到头
            if (i == s.length() && j == words[index].length()) return true;
            // j到头
            else if (j == words[index].length()) index++;
            // 二者均未到头 或 i到头且j未到头
            else return false;
        }

        return false;
    }

    public boolean isPrefixString2(String s, String[] words) {
        int i = 0, j = 0;

        while (i < s.length() && j < words.length) {
            if (!s.startsWith(words[j], i)) {
                return false;
            }
            i += words[j].length();
            j++;
        }

        return i == s.length() && j <= words.length;
    }

    public static void main(String[] args) {

        L1961_Check_If_String_Is_a_Prefix_of_Array s = new L1961_Check_If_String_Is_a_Prefix_of_Array();
        long sysDate1 = System.currentTimeMillis();

        String word = "iloveleetcode";
        String[] words = {"i", "love", "leetcod", "e"};
        boolean res = s.isPrefixString(word, words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}