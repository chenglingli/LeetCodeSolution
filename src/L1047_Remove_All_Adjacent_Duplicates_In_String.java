import java.util.Stack;

public class L1047_Remove_All_Adjacent_Duplicates_In_String {

    public String removeDuplicates(String s) {

        if (s == null || s.trim().length() <= 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.empty()) {
                if (cur == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            } else {
                stack.push(cur);
            }
        }

        StringBuilder res = new StringBuilder();
        if (!stack.empty()) {
            for (char c : stack) {
                res.append(c);
            }
            return res.toString();
        }

        return "";
    }

    public String removeDuplicates2(String s) {
        if (s == null || s.trim().length() <= 1)
            return s;

        char[] origArray = s.toCharArray();
        char[] newArray = new char[s.length()];

        int end = -1;

        for (char c : origArray) {
            if (end == -1 || c != newArray[end]) {
                newArray[++end] = c;
            } else
                end--;
        }

        return new String(newArray, 0, end + 1);
    }

    public static void main(String[] args) {

        L1047_Remove_All_Adjacent_Duplicates_In_String s = new L1047_Remove_All_Adjacent_Duplicates_In_String();

        long sysDate1 = System.currentTimeMillis();

        //        int[] stones = {2, 7, 4, 1, 8, 1};
        String ss = "azxxzy";
        String res = s.removeDuplicates(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}