import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L316_Remove_Duplicate_Letters {

    /*
    1 <= s.length <= 10^4
    s consists of lowercase English letters.

    解决思路：
    1，使用栈存储字符
    2，使用 visited 数组标记是否访问过
    3，使用 lastOccurrence 记录字符最后一次出现的位置
    4，遍历字符串，如果栈不为空，且栈顶元素大于当前元素，且栈顶元素在后面还会出现，则出栈
    5，将当前元素入栈，标记为已访问
    6，最后将栈中元素转换为字符串

     */
    public String removeDuplicateLetters(String s) {

        Map<Character, Integer> lastOccurrence = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];

        int len = s.length();
        char[] sArray = s.toCharArray();

        // 最后一次出现的位置
        for (int i = 0; i < len; i++) {
            lastOccurrence.put(sArray[i], i);
        }

        for (int i = 0; i < len; i++) {

            char c = sArray[i];

            // 如果已经访问过，跳过
            if (!visited[c - 'a']) {

                // 如果栈不为空，且栈顶元素大于当前元素，且栈顶元素在后面还会出现
                // 则出栈, 标记为未访问
                while (!stack.isEmpty()
                        && stack.peek() > c
                        && lastOccurrence.get(stack.peek()) > i) {
                    char t = stack.pop();
                    visited[t - 'a'] = false;
                }

                stack.push(c);
                visited[c - 'a'] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character character : stack) {
            result.append(character);
        }

        return result.toString();
    }

    public static void main(String[] args) {


        L316_Remove_Duplicate_Letters s = new L316_Remove_Duplicate_Letters();
        long sysDate1 = System.currentTimeMillis();

        String ss = "cbacdcbc";
        String res = s.removeDuplicateLetters(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}