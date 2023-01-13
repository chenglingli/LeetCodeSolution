public class L1370_Increasing_Decreasing_String {


    public String sortString(String s) {

        StringBuilder sb = new StringBuilder();
        int letterLen = 26;

        char[] dict = new char[letterLen];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            dict[cur - 'a']++;
        }

        int count = s.length();
        while (count > 0) {
            for (int i = 0; i < letterLen; i++) {
                if (dict[i] > 0) {
                    sb.append((char) ('a' + i));
                    count--;
                    dict[i]--;
                }
            }

            for (int i = letterLen - 1; i >= 0; i--) {
                if (dict[i] > 0) {
                    sb.append((char) ('a' + i));
                    count--;
                    dict[i]--;
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        L1370_Increasing_Decreasing_String s = new L1370_Increasing_Decreasing_String();
        long sysDate1 = System.currentTimeMillis();

        // String ss = "aaaabbbbcccc";
        String ss = "rat";

        String res = s.sortString(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}