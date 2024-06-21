public class L1576_Replace_All_s_to_Avoid_Consecutive_Repeating_Characters {


    /*
    1 <= s.length <= 100
    s consist of lowercase English letters and '?'
     */
    public String modifyString(String s) {

        StringBuilder res = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) != '?') {
                res.append(s.charAt(i));
                i++;
            }
            else {

                // 初始值
                char temp = '0';

                if (i == 0) { // 第一位
                    if (i + 1 < s.length()) { // 不是最后一位
                        if (s.charAt(i + 1) == '?') {
                            temp = 'a';
                        }
                        else {
                            temp = getNext(s.charAt(i + 1), 1);;
                        }
                    }
                    else { // 是最后一位
                        temp = 'a';
                    }
                } else { // 不是第一位

                    if (i + 1 < s.length()) { // 不是最后一位
                        if (s.charAt(i + 1) == '?') {
                            temp = getNext(res.charAt(i - 1), 1);;
                        }
                        else {
                            if (s.charAt(i + 1) != getNext(res.charAt(i - 1), 1)) {
                                temp = getNext(res.charAt(i - 1), 1);
                            } else {
                                temp = getNext(res.charAt(i - 1), 2);
                            }
                        }
                    }
                    else { // 是最后一位
                        temp = getNext(res.charAt(i - 1), 1);
                    }
                }
                i++;

                res.append(temp);
            }
        }

        return res.toString();
    }

    // 获取下一个字符
    private char getNext(char cur, int step) {
        if (cur + step > 'z') {
            return (char) ('a' + (cur + step - 'z' - 1));
        }
        else {
            return (char)(cur + step);
        }
    }

    public static void main(String[] args) {

        L1576_Replace_All_s_to_Avoid_Consecutive_Repeating_Characters s =
                new L1576_Replace_All_s_to_Avoid_Consecutive_Repeating_Characters();
        long sysDate1 = System.currentTimeMillis();

        String input = "?????qr?cub??d";
        String res = s.modifyString(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}