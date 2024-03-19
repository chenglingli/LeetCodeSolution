import java.util.Stack;

public class L224_Basic_Calculator {

    /*
    1 <= s.length <= 3 * 10^5
    s consists of digits, '+', '-', '(', ')', and ' '.
    s represents a valid expression.
    '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
    '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
    There will be no two consecutive operators in the input.
    Every number and running calculation will fit in a signed 32-bit integer.

    实现计算器，只有+，-，括号，数字，空格

    使用栈保存之前计算的结果，
    遇到数字，则累加到当前的数字
    遇到+，-，则计算当前的结果，重置number和符号
    遇到(，则将之前的结果和符号入栈，重置number和符号
    遇到)，则将栈顶的结果和符号出栈，计算当前的结果

     */
    public int calculate(String s) {

        char[] expression = s.toCharArray();

        Stack<Integer> st = new Stack<Integer>();

        // 已经计算好的结果
        int result = 0;
        // 当前的数字
        int number = 0;
        // 当前number的符号
        int sign = 1;

        for (char cur : expression) {
            if (Character.isDigit(cur)) {
                number = number * 10 + (cur - '0');
            } else if (cur == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (cur == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (cur == '(') {
                st.push(result);
                st.push(sign);

                // reset
                sign = 1;
                result = 0;

            } else if (cur == ')') {

                result += sign * number;
                number = 0;

                // 此时pop出来是之前的sign
                result *= st.pop();

                // 此时pop出来是之前的result
                result += st.pop();
            }
        }

        // 处理最后一个数
        if (number != 0)
            result += sign * number;

        return result;
    }


    /*
     使用递归的方式计算
     */

    // 坐标，穿透递归
    int idx;

    public int calculate2(String s) {
        idx = 0;
        return calc(s);
    }

    private int calc(String s) {

        int res = 0, num = 0, sign = 1;

        while (idx < s.length()) {

            char c = s.charAt(idx);
            idx++;

            if (c >= '0' && c <= '9') {
                // 累积计算当前number
                num = num * 10 + c - '0';
            }

            else if (c == '(') {
                // '(' 是一个新的子问题的开始，让递归来解决子问题
                num = calc(s);
            }

            else if (c == ')') {
                // ')' 是一个子问题的结束，返回当前的结果
                return res + sign * num;
            }

            else if (c == '+' || c == '-') {

                // 遇到一个新的符号，说明之前的数字已经读完了
                // 开始计算之前的结果
                res += sign * num;

                num = 0;
                // 更新下一个数字的符号
                sign = c == '-' ? -1 : 1;
            }
        }

        // 处理最后一个数
        return res + sign * num;
    }


    public static void main(String[] args) {

        L224_Basic_Calculator s = new L224_Basic_Calculator();
        long sysDate1 = System.currentTimeMillis();

        String ss = "(1+(4+5+2)-3)+(6+8)";
        // String ss = " 2-1 + 2 ";

        int res = s.calculate(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}