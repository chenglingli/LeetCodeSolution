import java.util.Objects;
import java.util.Stack;

public class L150_Evaluate_Reverse_Polish_Notation {


    public int calc(int x, int y, String op) {
        switch (op) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
        }
        return 0;
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();

        for (String temp : tokens) {
            if (Objects.equals(temp, "+") ||
                    Objects.equals(temp, "-") ||
                    Objects.equals(temp, "*") ||
                    Objects.equals(temp, "/")) {
                int x = stack.pop();
                int y = stack.pop();
                int res = calc(y, x, temp);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(temp));
            }

        }

        int res = 0;
        res = stack.pop();
        return res;
    }

    public static void main(String[] args) {

        L150_Evaluate_Reverse_Polish_Notation s = new L150_Evaluate_Reverse_Polish_Notation();
        long sysDate1 = System.currentTimeMillis();

        String[] s1 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = s.evalRPN(s1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}