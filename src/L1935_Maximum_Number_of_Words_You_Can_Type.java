public class L1935_Maximum_Number_of_Words_You_Can_Type {


    /*
    1 <= text.length <= 104
    0 <= brokenLetters.length <= 26
    text consists of words separated by a single space without any leading or trailing spaces.
    Each word only consists of lowercase English letters.
    brokenLetters consists of distinct lowercase English letters.
     */
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] textList = text.split(" ");
        int count = 0;
        for (String cur : textList) {

            int i = 0;
            while (i < brokenLetters.length()) {
                if (cur.indexOf(brokenLetters.charAt(i)) != -1) {
                    break;
                }
                i++;
            }

            if (i == brokenLetters.length()) {
                count++;
            }
        }

        return count;
    }


    public int canBeTypedWords2(String text, String brokenLetters) {

        if (brokenLetters.length() == 0)
            return text.split(" ").length;

        int res = 0;
        int bc[] = new int[26];

        int i = 0;
        for (char c : brokenLetters.toCharArray())
            bc[c - 'a'] = 1;

        for (String str : text.split(" ")) {
            if (!containsBrokenChar(str, bc)) {
                res += 1;
            }
        }

        return res;
    }

    private boolean containsBrokenChar(String str, int bc[]) {
        for (char c : str.toCharArray()) {
            if (bc[c - 'a'] == 1)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L1935_Maximum_Number_of_Words_You_Can_Type s = new L1935_Maximum_Number_of_Words_You_Can_Type();
        long sysDate1 = System.currentTimeMillis();

        String text = "hello world";
        String brokenLetters = "ad";
        int res = s.canBeTypedWords(text, brokenLetters);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}