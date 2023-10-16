public class L2243_Calculate_Digit_Sum_of_a_String {

    /*
    1 <= s.length <= 100
    2 <= k <= 100
    s consists of digits only.
     */
    public String digitSum(String s, int k) {

        if (s.length() <= k) {
            return s;
        }
        String ss = getNewString(s, k);
        while (ss.length() > k) {
            ss = getNewString(ss, k);
        }

        return ss;
    }

    public String getNewString(String s, int k) {

        StringBuilder newString = new StringBuilder();
        Integer curSum = 0;
        int i = 0;

        while (i < s.length()) {
            curSum += s.charAt(i) - '0';
            i++;

            if (i % k == 0) {
                newString.append(curSum);
                curSum = 0;
            }
        }

        if (i % k != 0) {
            newString.append(curSum);
        }

        return newString.toString();
    }

    public String digitSum2(String s, int k) {

        if (s.length() <= k)
            return s;

        StringBuilder r = new StringBuilder();
        for (int i = 1, sum = 0; i <= s.length(); i++) {
            sum += s.charAt(i - 1) - '0';
            if (i % k == 0 || i == s.length()) {
                r.append(sum);
                sum = 0;
            }
        }

        return digitSum2(r.toString(), k);
    }

    public static void main(String[] args) {

        L2243_Calculate_Digit_Sum_of_a_String s =
                new L2243_Calculate_Digit_Sum_of_a_String();
        long sysDate1 = System.currentTimeMillis();

        //        String ss = "11111222223";
        String ss = "233";

        int k = 3;
        String res = s.digitSum(ss, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}