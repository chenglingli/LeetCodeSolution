import java.util.ArrayList;
import java.util.List;

public class L1441_Build_an_Array_With_Stack_Operations {

    /*
    You are given an integer array target and an integer n.

    You have an empty stack with the two following operations:
    "Push": pushes an integer to the top of the stack.
    "Pop": removes the integer on the top of the stack.

    You also have a stream of the integers in the range [1, n].

    Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target.

    You should follow the following rules:
    If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
    If the stack is not empty, pop the integer at the top of the stack.
    If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
    Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.



    Example 1:
    Input: target = [1,3], n = 3
    Output: ["Push","Push","Pop","Push"]
    Explanation: Initially the stack s is empty. The last element is the top of the stack.
    Read 1 from the stream and push it to the stack. s = [1].
    Read 2 from the stream and push it to the stack. s = [1,2].
    Pop the integer on the top of the stack. s = [1].
    Read 3 from the stream and push it to the stack. s = [1,3].

    Example 2:
    Input: target = [1,2,3], n = 3
    Output: ["Push","Push","Push"]
    Explanation: Initially the stack s is empty. The last element is the top of the stack.
    Read 1 from the stream and push it to the stack. s = [1].
    Read 2 from the stream and push it to the stack. s = [1,2].
    Read 3 from the stream and push it to the stack. s = [1,2,3].

    Example 3:
    Input: target = [1,2], n = 4
    Output: ["Push","Push"]
    Explanation: Initially the stack s is empty. The last element is the top of the stack.
    Read 1 from the stream and push it to the stack. s = [1].
    Read 2 from the stream and push it to the stack. s = [1,2].
    Since the stack (from the bottom to the top) is equal to target, we stop the stack operations.
    The answers that read integer 3 from the stream are not accepted.

    Constraints:
    1 <= target.length <= 100
    1 <= n <= 100
    1 <= target[i] <= n
    target is strictly increasing.
     */
    public List<String> buildArray(int[] target, int n) {
        /*
        题意
        给定一个输入流，基于栈操作，实现目标数组的样子
        栈操作有两种：push 和 pop

        解法：
        对于目标数组的每个元素i, target[i]，记为b
        假设现在已经处理好了 target[i-1]，记为a

        那么 a 到 b之间的数组，都需要 push 和 pop
        然后 b 只需要push既可

         */

        List<String> res = new ArrayList<>();
        int i = 0;
        int cur = 1;
        while (i < target.length) {

            while (cur < target[i]) {
                res.add("Push");
                res.add("Pop");
                cur++;
            }

            res.add("Push");
            cur ++;

            i++;
        }

        return res;
    }

    public static void main(String[] args) {

        L1441_Build_an_Array_With_Stack_Operations s = new L1441_Build_an_Array_With_Stack_Operations();
        long sysDate1 = System.currentTimeMillis();

        int[] target = {1, 3};
        int n = 3;
        List<String> res = s.buildArray(target, n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}