import java.util.Stack;

public class L2375_Construct_Smallest_Number_From_DI_String {

    /*

    You are given a 0-indexed string pattern of length n consisting of
        the characters 'I' meaning increasing and 'D' meaning decreasing.

    A 0-indexed string num of length n + 1 is created using the following conditions:

    num consists of the digits '1' to '9', where each digit is used at most once.
    If pattern[i] == 'I', then num[i] < num[i + 1].
    If pattern[i] == 'D', then num[i] > num[i + 1].
    Return the lexicographically smallest possible string num that meets the conditions.



    Example 1:

    Input: pattern = "IIIDIDDD"
    Output: "123549876"
    Explanation:
    At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
    At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
    Some possible values of num are "245639871", "135749862", and "123849765".
    It can be proven that "123549876" is the smallest possible num that meets the conditions.
    Note that "123414321" is not possible because the digit '1' is used more than once.

    Example 2:

    Input: pattern = "DDD"
    Output: "4321"
    Explanation:
    Some possible values of num are "9876", "7321", and "8742".
    It can be proven that "4321" is the smallest possible num that meets the conditions.


    Constraints:

    1 <= pattern.length <= 8
    pattern consists of only the letters 'I' and 'D'.

     */
    public String smallestNumber(String pattern) {

        /*

        有n位就用到n+1个数字，比如n=2，则用到3个数字，分别是1,2,3。n=3，则用到4个数字，分别是1,2,3,4。
        Initialize Data Structures:
        Create a stack to store numbers.
        Use a StringBuilder for efficient string concatenation.

        Traverse from 1 to n+1:
        n is the length of the given pattern.
        The range is 1 to n+1 because each character in the pattern represents a relationship between two digits.

        Push the Current Number into Stack:
        At each step, push the current number into the stack.

        Check Conditions to Pop Numbers from Stack:
        If the current number reaches n+1, it means we are done processing all numbers.
        If the current pattern character is 'I' (Increasing), we should pop numbers to maintain order.

        Handle 'D' (Decreasing) Pattern:
        Keep adding numbers to the stack without popping.
        This ensures that numbers get reversed when popped later.

        Handle 'I' (Increasing) Pattern:
        When encountering an 'I', start popping from the stack and append the popped values to the result.
        This effectively reverses the sequence of numbers stored during a decreasing pattern.

        Finalize the Result:
        After the traversal, pop all remaining elements in the stack to complete the sequence.
        Convert the StringBuilder to a final string and return it.

        第一种解法，使用栈来存储数字，然后根据pattern的字符进行交换。
        步骤：
        1. 初始化一个栈，和一个StringBuilder。
        2. 遍历pattern，对于每个字符：
        2.1 如果当前数字是n+1，或者pattern的字符是'I'，则将栈中的所有元素弹出并添加到StringBuilder中。
        2.2 如果当前数字不是n+1，且pattern的字符是'D'，则将当前数字压入栈中。
        3. 将StringBuilder转换为字符串并返回。

        原理：
        栈的特性是后进先出，所以当我们遇到'I'时，需要将栈中的元素弹出并添加到StringBuilder中。
        当我们遇到'D'时，我们将当前数字压入栈中，这样在后续的'I'出现时，我们可以将栈中的元素弹出并添加到StringBuilder中。

        这种方法的时间复杂度是O(n)，空间复杂度也是O(n)。
         */

        int n = pattern.length();
        Stack<Integer> st = new Stack<Integer>();
        StringBuilder s = new StringBuilder("");

        for (int i = 1; i <= n + 1; i++) {
            st.push(i);

            if (i == n + 1 || pattern.charAt(i - 1) == 'I') {
                while (!st.isEmpty()) {
                    s.append(st.pop());
                }
            }
        }

        return s.toString();
    }

    /*
    第二种解法，直接用一个数组来存储数字，然后根据pattern的字符进行交换。

    这个算法步骤：
    1. 初始化一个长度为n+1的数组，并填充数字。
    2. 遍历pattern，对于每个'D'字符：
    2.1 从当前位置向前遍历，直到遇到'I'或者到达数组的开头。
    2.2 在这个范围内，将相邻的数字交换。
    3. 将数组转换为字符串并返回。

    这个算法原理：
    当我们遇到'D'时，我们需要将当前位置的数字和前一个数字交换。
    当我们遇到'I'时，我们不需要做任何事情。
    这种方法的好处是，我们可以避免使用栈来存储数字，从而减少空间复杂度。

    这种方法的时间复杂度是O(n)，空间复杂度也是O(n)。
     */
    public String smallestNumber2(String pattern) {

        int n = pattern.length();
        char[] ans = new char[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = ((i + 1) + "").charAt(0);
        }

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j >= 0 && pattern.charAt(j) == 'D') {
                swap(ans, j, j + 1);
                j--;
            }
        }

        return String.valueOf(ans);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        L2375_Construct_Smallest_Number_From_DI_String s =
                new L2375_Construct_Smallest_Number_From_DI_String();
        long sysDate1 = System.currentTimeMillis();

        String pattern = "IID";
        String res = s.smallestNumber2(pattern);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}