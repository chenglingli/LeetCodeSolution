public class L1910_Remove_All_Occurrences_of_a_Substring {

    /*
    1 <= s.length <= 1000
    1 <= part.length <= 1000
    s and part consists of lowercase English letters.

     */
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }

        return s;
    }

    public String removeOccurrences2(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.indexOf(part) != -1) {
            int idx = sb.indexOf(part);
            sb.delete(idx, idx + part.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        L1910_Remove_All_Occurrences_of_a_Substring s = new L1910_Remove_All_Occurrences_of_a_Substring();
        long sysDate1 = System.currentTimeMillis();

        String ss = "daabcbaabcbc";
        String part = "abc";

        String res = s.removeOccurrences(ss, part);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }

}
