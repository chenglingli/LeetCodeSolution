import java.util.Arrays;

public class L1111_Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings {

    /*

    A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:

    It is the empty string, or
    It can be written as AB (A concatenated with B), where A and B are VPS's, or
    It can be written as (A), where A is a VPS.
    We can similarly define the nesting depth depth(S) of any VPS S as follows:

    depth("") = 0
    depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
    depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
    For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

    Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).
    The subsequences may not necessarily be contiguous.

    For example, for the sequence 123456789, one possible split is:

    A = {1, 3, 5, 7, 9},

    B = {2, 4, 6, 8}.

    This corresponds to the output [0, 1, 0, 1, 0, 1, 0, 1, 0]  where 0 indicates membership in A and 1 indicates membership in B.

    Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.

    Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.
    Note that even though multiple answers may exist, you may return any of them.



    Example 1:
    Input: seq = "(()())"
    Output: [0,1,1,1,1,0]

    Example 2:
    Input: seq = "()(())()"
    Output: [0,0,0,1,1,0,1,1]


    Constraints:
    1 <= seq.size <= 10000

     */
    public int[] maxDepthAfterSplit(String seq) {
        /*

        题意，将一个vps拆成2个vps seq，确保两个seq的最大深度最小，返回拆分结果

        思路：
        1. 遍历seq，用一个变量记录当前的深度
        2. 每次遇到'('，深度+1
        3. 每次遇到')'，深度-1
        4. 如果深度为偶数，则当前字符属于A
        5. 如果深度为奇数，则当前字符属于B
        6. 返回结果
         */

        int len = seq.length();
        int[] res = new int[len];

        int depth = 0;
        for (int i = 0; i < len; i++) {
            if (seq.charAt(i) == '(') {
                depth++;
                res[i] = depth % 2;
            } else if (seq.charAt(i) == ')') {
                depth--;
                res[i] = (depth + 1) % 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L1111_Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings s = new L1111_Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings();
        long sysDate1 = System.currentTimeMillis();

//        String seq = "()(())()";
        String seq = "(()())";
        int[] res = s.maxDepthAfterSplit(seq);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}