public class L2390_Removing_Stars_From_a_String {

    /*
    You are given a string s, which contains stars *.

    In one operation, you can:

    Choose a star in s.
    Remove the closest non-star character to its left, as well as remove the star itself.
    Return the string after all stars have been removed.

    Note:
    The input will be generated such that the operation is always possible.
    It can be shown that the resulting string will always be unique.


    Example 1:
    Input: s = "leet**cod*e"
    Output: "lecoe"
    Explanation: Performing the removals from left to right:
    - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
    - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
    - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
    There are no more stars, so we return "lecoe".

    Example 2:
    Input: s = "erase*****"
    Output: ""
    Explanation: The entire string is removed, so we return an empty string.


    Constraints:
    1 <= s.length <= 10^5
    s consists of lowercase English letters and stars *.
    The operation above can be performed on s.
     */
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') sb.deleteCharAt(sb.length() - 1);
            else sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        L2390_Removing_Stars_From_a_String s =
                new L2390_Removing_Stars_From_a_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "leet**cod*e";
        String res = s.removeStars(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}