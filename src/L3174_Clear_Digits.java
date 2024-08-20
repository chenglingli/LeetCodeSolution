public class L3174_Clear_Digits {

    /*
    1 <= s.length <= 100
    s consists only of lowercase English letters and digits.
    The input is generated such that it is possible to delete all digits.
     */
    public String clearDigits(String s) {

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                sb.append(c);
            }
            else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        L3174_Clear_Digits s = new L3174_Clear_Digits();
        long sysDate1 = System.currentTimeMillis();

        String nums = "cb34";
        String res = s.clearDigits(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}