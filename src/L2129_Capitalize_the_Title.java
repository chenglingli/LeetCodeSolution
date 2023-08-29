public class L2129_Capitalize_the_Title {

    /*
    1 <= title.length <= 100
    title consists of words separated by a single space without any leading or trailing spaces.
    Each word consists of uppercase and lowercase English letters and is non-empty.
     */
    public String capitalizeTitle(String title) {
        String[] titleList = title.split(" ");
        StringBuilder res = new StringBuilder();

        for (String cur : titleList) {
            if (cur.length() <= 2) {
                res.append(cur.toLowerCase());
            } else {
                String temp = cur.toLowerCase();
                res.append(Character.toUpperCase(temp.charAt(0)));
                res.append(temp.substring(1));
            }
            res.append(" ");
        }

        res.deleteCharAt(res.length() - 1);

        return res.toString();
    }

    public String capitalizeTitle2(String title) {

        char[] ch = title.toCharArray();
        int len = ch.length;

        for (int i = 0; i < len; ++i) {
            int firstIndex = i;
            while (i < len && ch[i] != ' ') {
                ch[i] |= 32;
                ++i;
            }
            if (i - firstIndex > 2) {
                ch[firstIndex] &= ~32;
            }
        }

        return String.valueOf(ch);
    }

    public static void main(String[] args) {

        L2129_Capitalize_the_Title s = new L2129_Capitalize_the_Title();
        long sysDate1 = System.currentTimeMillis();

        String title = "i lOve leetcode";
        String res = s.capitalizeTitle(title);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}