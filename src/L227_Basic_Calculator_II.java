import java.util.Stack;

public class L227_Basic_Calculator_II {

    /*
     * 
     * Given a string s which represents an expression, evaluate this expression and
     * return its value.
     * 
     * The integer division should truncate toward zero.
     * 
     * You may assume that the given expression is always valid. All intermediate
     * results will be in the range of [-2^31, 2^31 - 1].
     * 
     * Note: You are not allowed to use any built-in function which evaluates
     * strings as mathematical expressions, such as eval().
     * 
     * 
     * 
     * Example 1:
     * Input: s = "3+2*2"
     * Output: 7
     * 
     * Example 2:
     * Input: s = " 3/2 "
     * Output: 1
     * 
     * Example 3:
     * Input: s = " 3+5 / 2 "
     * Output: 5
     * 
     * 
     * Constraints:
     * 
     * 1 <= s.length <= 3 * 10^5
     * s consists of integers and operators ('+', '-', '*', '/') separated by some
     * number of spaces.
     * s represents a valid expression.
     * All the integers in the expression are non-negative integers in the range [0,
     * 2^31 - 1].
     * The answer is guaranteed to fit in a 32-bit integer.
     * 
     */
    public int calculate(String s) {
        /*
         * 条件：只有数字和加减乘除
         * 期望：计算表达式结果
         * 思路：
         * 1. 使用两个栈存储
         * 2，一个存储数字，一个存储运算符
         * 3，读到完整数字 → 压入数字栈。
         * 4，读到运算符 op（或串结束）：
         * 5，当运算符栈非空 且 precedence(栈顶) >= precedence(op)，弹出栈顶运算符，从数字栈弹出两个数，算完，结果压回数字栈。
         * 6，重复上一步，再把 op 压入运算符栈。
         * 7，串处理完后，把运算符栈里剩下的依次弹出并计算。
         * 8，数字栈剩一个数即为答案。
         * 9，数字栈剩一个数即为答案。
         */

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            // 处理完整数字
            if (Character.isDigit(cur)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                numStack.push(num);
            }

            // 处理运算符
            else if (cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                // 处理运算符栈非空且栈顶运算符优先级大于等于当前运算符
                while (!opStack.isEmpty() && precedence(opStack.peek()) >= precedence(cur)) {
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    int result = calculate(num1, num2, opStack.pop());
                    numStack.push(result);
                }
                opStack.push(cur);
            }
        }

        // 处理剩余的运算符
        while (!opStack.isEmpty()) {
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            int result = calculate(num1, num2, opStack.pop());
            numStack.push(result);
        }

        return numStack.pop();
    }

    // 计算运算符优先级
    private int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    // 计算两个数字的运算结果
    private int calculate(int num1, int num2, char op) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else if (op == '*') {
            return num1 * num2;
        } else if (op == '/') {
            return num1 / num2;
        }
        return 0;
    }


    /*
    
    核心想法
    表达式可以看成：若干项相加，每一项内部是连乘、连除（优先级更高）。

    result：已经结算完的、用 + / - 分开的前面的那些项的和。
    lastNumber：当前这一项的值（这一项里可能已经做过 *、/）。
    operator：上一个已经读完整的数字，应该跟它左边哪个运算符结合还没处理完——更准确说：是「即将要和下一个完整数字做运算」的那个运算符。一开始设为 '+'，等价于「第一个数当作 + 第一个数」。
    每当你遇到一个运算符，或者走到最后一个字符时，就认为当前数字 currentNumber 已经读完整，用上一次的 operator 把 lastNumber 和 currentNumber 算一步，然后更新状态。

    四种运算符分别做什么
    operator == '+'

    先把上一项 lastNumber 并进总和：result += lastNumber
    再开始新的一项，且为正：lastNumber = currentNumber
    operator == '-'

    同样先把上一项并进总和：result += lastNumber
    新的一项为负：lastNumber = -currentNumber
    operator == '*' / '/'

    不碰 result，只在当前这一项里算：lastNumber = lastNumber * currentNumber 或 lastNumber / currentNumber
    这正好对应「乘除优先于加减」：加减才会把项提交到 result。
    处理完后：operator = currentChar（最后一个字符若是数字，这里会变成数字字符，但循环已结束，不影响最后的 return result + lastNumber），并把 currentNumber 清零准备读下一个数。

    最后为什么 return result + lastNumber
    循环里每次遇到 +/- 时，都是先把旧的 lastNumber 加进 result 再开新项，所以最后还会剩一项在 lastNumber 里，要再执行一次 result + lastNumber 才是完整答案。

    */
    public int calculate2(String s) {
        
        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;
        char operator = '+';

        // Convert to array for blazing-fast raw memory access
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i++) {
            char currentChar = chars[i];

            // Faster than Character.isDigit()
            if (currentChar >= '0' && currentChar <= '9') {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            // Only trigger math if we hit a specific operator or the end of the string
            if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || i == n - 1) {
                if (operator == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (operator == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (operator == '*') {
                    lastNumber *= currentNumber;
                } else if (operator == '/') {
                    lastNumber /= currentNumber;
                }

                operator = currentChar;
                currentNumber = 0;
            }
        }

        // Add the final piece
        return result + lastNumber;
    }

    public static void main(String[] args) {
        L227_Basic_Calculator_II s = new L227_Basic_Calculator_II();
        long sysDate1 = System.currentTimeMillis();

        String ss = "3+2*2";

        System.out.println(s.calculate(ss));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}