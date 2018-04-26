public class MyAtoi {

    public int myAtoi(String str) {

        // init local var
        long res = 0L;
        int sign = 1, i;

        // trim spaces
        str = str.trim();
        if (str.length() == 0) return 0;
        int len = str.length();

        // handle sign
        i = 0;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        }

        // all char should be numbers here
        while (i < len) {
            // loop end condition
            if (!(str.charAt(i) <= '9' && str.charAt(i) >= '0')) break;

            // calc
            int temp = str.charAt(i) - '0';
            res = 10 * res + temp;

            // handle overflow
            if (res > Integer.MAX_VALUE && sign > 0) return Integer.MAX_VALUE;
            if (res * (-1) < Integer.MIN_VALUE && sign < 0) return Integer.MIN_VALUE;

            i++;
        }

        // detect the cause of while break
        // if (0 || - || other char without numbers)
        if (i == 0 || (sign < 0 && i == 1)) return 0;

        // return result
        return (int)(res * sign);
    }

    public static void main(String[] args) {

        MyAtoi s = new MyAtoi();

        long sysDate1 = System.currentTimeMillis();
        // String inputStr = " 4193 with words";
        // String inputStr = "with words 4193 ";
        String inputStr = "1";
        // String inputStr = "--";
        // String inputStr = "-1";
        // String inputStr = "-0";
        // String inputStr = "-a";
        // String inputStr = "-91283472332";
        // String inputStr = "+12";
        int res = s.myAtoi(inputStr);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

