import java.util.Stack;

public class L020_Valid_Parentheses {

    public boolean isValid(String s) {
        Stack st = new Stack();

        int i = 0;
        while (i < s.length()) {
            char curChar = s.charAt(i);
            char topChar;
            switch (curChar) {
                case '{':
                case '[':
                case '(':
                    st.push(curChar);
                    break;

                case '}':
                    if (st.size() < 1) return false;
                    topChar = (char) st.pop();
                    if (topChar != '{') {
                        return false;
                    }
                    break;

                case ']':
                    if (st.size() < 1) return false;
                    topChar = (char) st.pop();
                    if (topChar != '[') {
                        return false;
                    }
                    break;

                case ')':
                    if (st.size() < 1) return false;
                    topChar = (char) st.pop();
                    if (topChar != '(') {
                        return false;
                    }
                    break;

            }
            i++;
        }

        if (st.size() > 0) return false;

        return true;
    }

    public static void main(String[] args) {

        L020_Valid_Parentheses s = new L020_Valid_Parentheses();
        // String str = "{[]}";
        // String str = "([)]";
        String str = "[";

        long sysDate1 = System.currentTimeMillis();

        boolean res = s.isValid(str);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();

        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

