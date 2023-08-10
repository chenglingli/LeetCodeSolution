public class L2042_Check_if_Numbers_Are_Ascending_in_a_Sentence {


    public boolean areNumbersAscending(String s) {
        
        String[] sList = s.split(" ");

        int preNum = -1;
        int curNum = 0;

        for (String cur : sList) {
            if (!(cur.charAt(0) >= '0' && cur.charAt(0) <= '9')) {
                continue;
            }

            curNum = Integer.parseInt(cur);

            if (curNum <= preNum) {
                return false;
            } else {
                preNum = curNum;
            }

        }

        return true;
    }

    public boolean areNumbersAscending2(String s) {

        int lastNum = -1;

        for (int i = 0; i < s.length(); i++) {

            if (!Character.isDigit(s.charAt(i))) {
                continue;
            }

            int num = 0;
            while (i < s.length() && s.charAt(i) != ' ') {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }

            if (lastNum >= num) {
                return false;
            } else {
                lastNum = num;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L2042_Check_if_Numbers_Are_Ascending_in_a_Sentence s = new L2042_Check_if_Numbers_Are_Ascending_in_a_Sentence();
        long sysDate1 = System.currentTimeMillis();

        String ss = "sunset is at 7 51 pm overnight lows will be in the low 52 and 60 s";
        boolean res = s.areNumbersAscending(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}