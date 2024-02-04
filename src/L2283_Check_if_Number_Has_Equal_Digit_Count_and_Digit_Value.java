public class L2283_Check_if_Number_Has_Equal_Digit_Count_and_Digit_Value {

    /*
    n == num.length
    1 <= n <= 10
    num consists of digits.

    Input: num = "1210"
    Output: true
    Explanation:
    num[0] = '1'. The digit 0 occurs once in num.
    num[1] = '2'. The digit 1 occurs twice in num.
    num[2] = '1'. The digit 2 occurs once in num.
    num[3] = '0'. The digit 3 occurs zero times in num.
    The condition holds true for every index in "1210", so return true.

     */
    public boolean digitCount(String num) {

        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            if (count[i] != (num.charAt(i) - '0')) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        L2283_Check_if_Number_Has_Equal_Digit_Count_and_Digit_Value s =
                new L2283_Check_if_Number_Has_Equal_Digit_Count_and_Digit_Value();
        long sysDate1 = System.currentTimeMillis();

        String ss = "030";

        boolean res = s.digitCount(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}