public class L3210_Find_the_Encrypted_String {

    /*
    1 <= s.length <= 100
    1 <= k <= 104
    s consists only of lowercase English letters.
     */
    public String getEncryptedString(String s, int k) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        int i = 0;
        while (i < len) {
            res.append(s.charAt((i + k + len ) % len));
            i++;
        }

        return res.toString();
    }

    public static void main(String[] args) {

        L3210_Find_the_Encrypted_String s = new L3210_Find_the_Encrypted_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "dart";
        int k = 3;
        String res = s.getEncryptedString(ss, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}