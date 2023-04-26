import java.util.Objects;
import java.util.Stack;

public class L844_Backspace_String_Compare {

    /*
    1 <= s.length, t.length <= 200
    s and t only contain lowercase letters and '#' characters.

     */
    public boolean backspaceCompare(String s, String t) {
        return Objects.equals(afterBackProcess(s), afterBackProcess(t));
    }

    private String afterBackProcess(String s) {

        Stack st = new Stack();

        for (char cur : s.toCharArray()) {
            if (cur == '#') {
                if (!st.empty()) {
                    st.pop();
                }
            } else {
                st.push(cur);
            }
        }

        return st.toString();
    }

    private String afterBackProcess2(String s) {

        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (str.length() > 0) {
                    str.deleteCharAt(str.length() - 1);
                }
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {

        L844_Backspace_String_Compare s = new L844_Backspace_String_Compare();
        long sysDate1 = System.currentTimeMillis();

        String a = "ac#";
        String b = "abd#";

        boolean res = s.backspaceCompare(a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}