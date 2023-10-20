public class L2264_Largest_3_Same_Digit_Number_in_String {

    /*
    3 <= num.length <= 1000
    num only consists of digits.
     */
    public String largestGoodInteger(String num) {

        char cur = '0' - 1;
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if (num.charAt(i) > cur) {
                    cur = num.charAt(i);
                }
                i += 2;
                if (cur == '9') {
                    break;
                }
            }
        }

        if (cur != '0' - 1) {
            String res = String.valueOf(cur) +
                    cur +
                    cur;
            return res;
        }
        return "";
    }

    public String largestGoodInteger2(String num) {
        if (num.contains("999")) return "999";
        if (num.contains("888")) return "888";
        if (num.contains("777")) return "777";
        if (num.contains("666")) return "666";
        if (num.contains("555")) return "555";
        if (num.contains("444")) return "444";
        if (num.contains("333")) return "333";
        if (num.contains("222")) return "222";
        if (num.contains("111"))return "111";
        if (num.contains("000"))return "000";

        return "";
    }

    public static void main(String[] args) {

        L2264_Largest_3_Same_Digit_Number_in_String s =
                new L2264_Largest_3_Same_Digit_Number_in_String();
        long sysDate1 = System.currentTimeMillis();

        String num = "222";
        String res = s.largestGoodInteger(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}