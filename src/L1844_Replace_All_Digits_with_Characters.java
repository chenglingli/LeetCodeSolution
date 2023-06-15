public class L1844_Replace_All_Digits_with_Characters {

    public String replaceDigits(String s) {

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(s.charAt(i));
            } else {
                sb.append((char) (s.charAt(i - 1) + s.charAt(i) - '0'));
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        L1844_Replace_All_Digits_with_Characters s = new L1844_Replace_All_Digits_with_Characters();
        long sysDate1 = System.currentTimeMillis();

        String nums = "a1b2c3d4e";
        String res = s.replaceDigits(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}