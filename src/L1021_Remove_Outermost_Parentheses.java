import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L1021_Remove_Outermost_Parentheses {

    public String removeOuterParentheses(String s) {

        StringBuilder res = new StringBuilder();
        List<String> parenthesesList = new ArrayList<>();
        Stack<Character> st = new Stack<>();

        int preI = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                if (st.empty() && i != 0) {
                    parenthesesList.add(s.substring(preI, i));
                    preI = i;
                }
                st.push(cur);
            } else {
                if (!st.empty()) {
                    st.pop();
                }
            }
        }
        parenthesesList.add(s.substring(preI));

        for (String x : parenthesesList) {
            res.append(x, 1, x.length() - 1);
        }

        return res.toString();
    }

    /*
    更为巧妙的办法，用counter记录深度，当深度不为1的时候，就接入字符
    深度的变化是

        " (" 加一
        ")"减一

    来操作
     */
    public String removeOuterParentheses2(String s) {

        StringBuilder string = new StringBuilder();
        int counter = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (counter != 0)
                    string.append(c);
                counter++;
            } else {
                counter--;
                if (counter != 0)
                    string.append(c);
            }
        }
        return string.toString();
    }

    public static void main(String[] args) {


        long sysDate1 = System.currentTimeMillis();

        // String ss = "(()())(())(()(()))";
        // "()()()()(())"

        String ss = "()()";
        // ""

        L1021_Remove_Outermost_Parentheses s = new L1021_Remove_Outermost_Parentheses();
        String res = s.removeOuterParentheses(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}