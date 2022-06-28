public class L065_Valid_Number {


    // 两种实现:
    // 一种 硬编码，子函数判断
    // 一种 正则表达式

    public boolean isNumber(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        int eIndex = s.indexOf("e");
        int EIndex = s.indexOf("E");

        int index = eIndex != -1 ? eIndex : EIndex;

        if (index == -1) {
            // 没有E情况
            return isDecimal(s) || isInteger(s);
        } else {
            // 有E情况
            if (s.length() == 1) {
                return false;
            }
            String firstPart = s.substring(0, index);
            String secondPart = s.substring(index + 1);

            return (isInteger(firstPart) || isDecimal(firstPart))
                    && isInteger(secondPart);
        }
    }

    public boolean isInteger(String s) {

        if (s == null ||s.length() == 0) {
            return false;
        }

        // 解析符号位
        int start = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            start = 1;

            // 有符号位，至少要有一位数字
            if (s.length() == 1) {
                return false;
            }
        }

        // 数字位遍历，确保全是 '0-9'
        return isOneOrMoreDigits(s.substring(start));
    }

    public boolean isDecimal(String s) {

        // 入参判断
        if (s == null || s.length() == 0) {
            return false;
        }

        // 解析符号位
        int start = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            start = 1;

            // 有符号位，至少要有一位数字
            if (s.length() == 1) {
                return false;
            }
        }

        // 解析 '.'
        int index = s.indexOf('.');
        if (index == -1) {
            return false;
        }

        // 解析第一部分和第二部分
        String firstPart = s.substring(start, index);
        String secondPart = s.substring(index + 1);
        boolean resFirstPart = isOneOrMoreDigits(firstPart);
        boolean resSecondPart = isOneOrMoreDigits(secondPart);

        if (resFirstPart && resSecondPart) return true;
        if (resFirstPart && secondPart.length() == 0) return true;
        if (resSecondPart && firstPart.length() == 0) return true;

        return false;
    }

    boolean isOneOrMoreDigits(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) <= '9' && s.charAt(i) >= '0')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        L065_Valid_Number s = new L065_Valid_Number();

        long sysDate1 = System.currentTimeMillis();

        String[] x = {".1", "e9", "e", "2", "0089", "-0.1", "+3.14", "4.", "-.9",
                "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};

        for (int i = 0 ;i < x.length; i++) {
            boolean res = s.isNumber(x[i]);
            System.out.print(x[i]);
            System.out.print(" ");
            System.out.println(res);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}