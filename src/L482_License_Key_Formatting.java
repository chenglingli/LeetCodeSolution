public class L482_License_Key_Formatting {

    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();
        StringBuilder cur = new StringBuilder();

        for(int i = s.length()-1 ; i >= 0; i--) {

            char curChar = s.charAt(i);

            if (curChar == '-') {
                continue;
            }
            else {
                if (curChar >= 'a' && curChar <= 'z') {
                    curChar = Character.toUpperCase(curChar);
                }
                cur.append(curChar);
            }

            if (cur.length() == k) {
                if(sb.length() != 0) {
                    sb.append('-');
                }
                sb.append(cur);

                cur = new StringBuilder();
            }
        }

        if (cur.length() > 0) {
            if(sb.length() != 0) {
                sb.append('-');
            }
            sb.append(cur);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        L482_License_Key_Formatting s = new L482_License_Key_Formatting();
        long sysDate1 = System.currentTimeMillis();

        String input = "2";
        int k = 4;
        String res = s.licenseKeyFormatting(input, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}