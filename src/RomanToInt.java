// 罗马数字转化为十进制数字
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000

public class RomanToInt {

    public int romanToInt(String s) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':

                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'V') {
                            res += 4;
                            i++;
                            break;
                        }
                        if (s.charAt(i + 1) == 'X') {
                            res += 9;
                            i++;
                            break;
                        }
                    }

                    res += 1;
                    break;

                case 'V':
                    res += 5;
                    break;
                case 'X':

                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'L') {
                            res += 40;
                            i++;
                            break;
                        }
                        if (s.charAt(i + 1) == 'C') {
                            res += 90;
                            i++;
                            break;
                        }
                    }
                    res += 10;
                    break;


                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if (i + 1 < s.length()) {
                        if (s.charAt(i + 1) == 'D') {
                            res += 400;
                            i++;
                            break;
                        }
                        if (s.charAt(i + 1) == 'M') {
                            res += 900;
                            i++;
                            break;
                        }
                    }
                    res += 100;
                    break;

                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }


        return res;
    }

    public int romanToInt2(String s) {
        int length = s.length();
        // assign initial val to last char
        int last = 0;
        int result = last;
        for (int i = length - 1; i >= 0; i--) {
            int cur = 0;
            switch (s.charAt(i)) {
                case 'I':
                    cur = 1;
                    break;
                case 'V':
                    cur = 5;
                    break;
                case 'X':
                    cur = 10;
                    break;
                case 'L':
                    cur = 50;
                    break;
                case 'C':
                    cur = 100;
                    break;
                case 'D':
                    cur = 500;
                    break;
                case 'M':
                    cur = 1000;
                    break;
            }
            if (last <= cur) {
                result += cur;
            } else {
                result -= cur;
            }
            last = cur;
        }
        return result;
    }

    public static void main(String[] args) {

        RomanToInt s = new RomanToInt();

        long sysDate1 = System.currentTimeMillis();

        // String input = "MCMXCIV";
        String input = "IX";

        int res = s.romanToInt(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}