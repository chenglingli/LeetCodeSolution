public class L1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers {


    /*

    A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
    For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.

    Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.


    Example 1:

    Input: n = "32"
    Output: 3
    Explanation: 10 + 11 + 11 = 32

    Example 2:
    Input: n = "82734"
    Output: 8

    Example 3:
    Input: n = "27346209830709182346"
    Output: 9

    Constraints:

    1 <= n.length <= 10^5
    n consists of only digits.
    n does not contain any leading zeros and represents a positive integer.

     */
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            max = Math.max(max, c - '0');
        }
        return max;
    }

    public static void main(String[] args) {

        L1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers s = new L1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers();
        long sysDate1 = System.currentTimeMillis();

        String n = "82734";
        int res = s.minPartitions(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}