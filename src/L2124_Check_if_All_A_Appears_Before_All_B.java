public class L2124_Check_if_All_A_Appears_Before_All_B {

    public boolean checkString(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == 'a') {
            i++;
        }

        if (i == s.length()) {
            return true;
        }

        while (i < s.length() && s.charAt(i) == 'b') {
            i++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {

        L2124_Check_if_All_A_Appears_Before_All_B s = new L2124_Check_if_All_A_Appears_Before_All_B();
        long sysDate1 = System.currentTimeMillis();

        //        String num = "aaabbb";
        String num = "ba";
        //        String num = "aaabbb";
        boolean res = s.checkString(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}