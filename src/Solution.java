import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack st = new Stack();

        int i = 0;
        while (i < s.length()) {
            char curChar = s.charAt(i);
            char topChar;
            switch (curChar){
                case '{':
                case '[':
                case '(':
                    st.push(curChar);
                    break;

                case '}':
                    if (st.size() < 1) return false;
                    topChar = (char)st.pop();
                    if (topChar != '{') {
                        return false;
                    }
                    break;

                case ']':
                    if (st.size() < 1) return false;
                    topChar = (char)st.pop();
                    if (topChar != '[') {
                        return false;
                    }
                    break;

                case ')':
                    if (st.size() < 1) return false;
                    topChar = (char)st.pop();
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

        Solution s = new Solution();
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

