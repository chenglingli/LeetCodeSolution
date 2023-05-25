public class L1694_Reformat_Phone_Number {

    /*
    2 <= number.length <= 100
    number consists of digits and the characters '-' and ' '.
    There are at least two digits in number.

    group the digits from left to right into blocks of length 3
        until there are 4 or fewer digits.

    The final digits are then grouped as follows:
    2 digits: A single block of length 2.
    3 digits: A single block of length 3.
    4 digits: Two blocks of length 2 each.

    123-456-789-0 -> 123-456-78-90
    123-4 -> 12-34

    1 -> 1
    12 -> 12
    123 -> 123
    1234 -> 12-34 (123-4)
    12345 -> 123-45
    123456 -> 123-456
    1234567 -> 123-45-67 (123-456-7)
     */

    public String reformatNumber(String number) {

        StringBuilder res = new StringBuilder();
        int curSize = 0;

        for (char ch : number.toCharArray()) {
            if (ch == ' ' || ch == '-') {
                continue;
            }

            if (curSize == 3) {
                res.append('-');
                curSize = 0;
            }
            res.append(ch);
            curSize++;
        }

        int len = res.length();
        if (res.charAt(len - 2) == '-') {
            res.setCharAt(len - 2, res.charAt(len - 3));
            res.setCharAt(len - 3, '-');
        }

        return res.toString();
    }


    public String reformatNumber2(String number) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : number.toCharArray()) {
            if (c == ' ' || c == '-') {
                continue;
            }
            if (count == 3) {
                count = 0;
                sb.append("-");
            }
            count++;
            sb.append(c);
        }

        if (count == 1) {
            int n = sb.length();
            char c = sb.charAt(n - 3);
            sb.setCharAt(n - 2, c);
            sb.setCharAt(n - 3, '-');
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        L1694_Reformat_Phone_Number s = new L1694_Reformat_Phone_Number();
        long sysDate1 = System.currentTimeMillis();

        // String number = "123 4-5678";
        String number = "123 456";
        String res = s.reformatNumber(number);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}