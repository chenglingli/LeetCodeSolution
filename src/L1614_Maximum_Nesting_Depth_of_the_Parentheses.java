import java.util.Stack;

public class L1614_Maximum_Nesting_Depth_of_the_Parentheses {


    /*

     */
    public int maxDepth(String s) {
        Stack st = new Stack();

        int i = 0;
        int ans = 0;
        while (i < s.length()) {
            char curChar = s.charAt(i);

            switch (curChar) {
                case '(':
                    st.push(curChar);
                    break;

                case ')':
                    if (st.size() > ans) {
                        ans = st.size();
                    }
                    st.pop();
                    break;
            }
            i++;
        }

        return ans;
    }

    public int maxDepth2(String s) {
        int left = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
                max = Math.max(max, left);
            }
            if (c == ')') {
                left--;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        L1614_Maximum_Nesting_Depth_of_the_Parentheses s = new L1614_Maximum_Nesting_Depth_of_the_Parentheses();
        long sysDate1 = System.currentTimeMillis();

        String input = "(1+(2*3)+((8)/4))+1";
        int res = s.maxDepth(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}