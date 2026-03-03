public class L3798_Largest_Even_Number {

    /*
    You are given a string s consisting only of the characters '1' and '2'.

    You may delete any number of characters from s without changing the order of the remaining characters.

    Return the largest possible resultant string that represents an even integer. If there is no such string, return the empty string "".



    Example 1:

    Input: s = "1112"

    Output: "1112"

    Explanation:

    The string already represents the largest possible even number, so no deletions are needed.

    Example 2:

    Input: s = "221"

    Output: "22"

    Explanation:

    Deleting '1' results in the largest possible even number which is equal to 22.

    Example 3:

    Input: s = "1"

    Output: ""

    Explanation:

    There is no way to get an even number.



    Constraints:

    1 <= s.length <= 100
    s consists only of the characters '1' and '2'.

     */
    public String largestEven(String s) {
        // 找到最右边的 '2'
        int lastTwoIndex = s.lastIndexOf('2');

        // 如果没有 '2'，无法构成偶数，返回空字符串
        if (lastTwoIndex == -1) {
            return "";
        }

        // 返回从开头到最右边 '2' 的子串
        return s.substring(0, lastTwoIndex + 1);
    }

    public static void main(String[] args) {

        L3798_Largest_Even_Number s = new L3798_Largest_Even_Number();
        long sysDate1 = System.currentTimeMillis();

        String ss = "221";
        String res = s.largestEven(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}