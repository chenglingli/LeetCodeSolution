public class L2259_Remove_Digit_From_Number_to_Maximize_Result {

    /*

    2 <= number.length <= 100
    number consists of digits from '1' to '9'.
    digit is a digit from '1' to '9'.
    digit occurs at least once in number.

    1:
    1231 - 231
    2131 - 231

    3:
    312232435 -

    解法：
    1，如果只出现一次digit，则不论头、中、尾，都去除进行拼接
    2，如果出现多次digit，则从左向右寻找满足：其后续字符大于digit的情况，如存在，则去除当前digit
        例子如下：
        123436,3
        -> 12 436

        123236,3
        -> 1232 6

     */
    public String removeDigit(String number, char digit) {

        int i = 0;
        StringBuilder res = new StringBuilder();

        while (i < number.length()) {

            i = number.indexOf(digit, i);

            // 找不到下一个digit
            if (i == -1) return res.toString();

            // 已经到达胃部
            if (i == number.length() - 1) return number.substring(0, i);

            // 寻找i后下一个不等于digit的位置
            while (i < number.length() && number.charAt(i) == digit) i++;
            if (i == number.length()) return number.substring(0, i - 1);

            // i后下一个不等于digit的字符如果大于digit，替换当前发现的digit
            if (number.charAt(i) > digit) {
                return number.substring(0, i - 1) + number.substring(i);
            }
            // 否则就找下一个digit字符再看看
            else {
                res = new StringBuilder();
                res.append(number, 0, i - 1);
                res.append(number.substring(i));
                i++;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {

        L2259_Remove_Digit_From_Number_to_Maximize_Result s =
                new L2259_Remove_Digit_From_Number_to_Maximize_Result();
        long sysDate1 = System.currentTimeMillis();

        //        String number = "1231";
        //        char digit = '1';

        String number = "2232";
        char digit = '3';

        //        String number = "743";
        //        char digit = '7';

        String res = s.removeDigit(number, digit);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}