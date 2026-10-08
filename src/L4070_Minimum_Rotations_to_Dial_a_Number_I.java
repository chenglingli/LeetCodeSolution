public class L4070_Minimum_Rotations_to_Dial_a_Number_I {

    /*
    You are given a string s of length 10 consisting of digits.

    The dial contains the digits 0 through 9 in order and is circular, so 0 and 9 are adjacent. The pointer initially points to 0.

    To dial each digit of s in order, rotate the pointer until it points to that digit. Each rotation moves the pointer to an adjacent digit,
    and you may rotate in either direction.

    Dialing a digit that the pointer already points to requires no rotations.

    Return the minimum total number of rotations needed to dial every digit of s.



    Example 1:

    Input: s = "0192837465"

    Output: 25

    Explanation:

    Step	From	To	Rotations
    1	0	0	0
    2	0	1	1
    3	1	9	2
    4	9	2	3
    5	2	8	4
    6	8	3	5
    7	3	7	4
    8	7	4	3
    9	4	6	2
    10	6	5	1
    The total is 0 + 1 + 2 + 3 + 4 + 5 + 4 + 3 + 2 + 1 = 25, which is the minimum total number of rotations.

    Example 2:

    Input: s = "1200210200"

    Output: 12

    Explanation:

    Step	From	To	Rotations
    1	0	1	1
    2	1	2	1
    3	2	0	2
    4	0	0	0
    5	0	2	2
    6	2	1	1
    7	1	0	1
    8	0	2	2
    9	2	0	2
    10	0	0	0
    The total is 1 + 1 + 2 + 0 + 2 + 1 + 1 + 2 + 2 + 0 = 12, which is the minimum total number of rotations.



    Constraints:

    s.length == 10
    s consists only of digits '0' to '9'
     */
    public int minRotations(String s) {
        /*
        计算拨打字符串的数字，需要转动转盘多少位
        0-9十个数字是相邻摆放的，所以转动转盘，要么顺时针要么逆时针。

        转换问题：
        1，计算相邻数字之间的转动次数，其实就是计算相邻数字之间的距离。
        2，两个相邻数字，要么顺时针转到，要么逆时针转到

        譬如 1和3的距离，是 abs(3-1) 或者 abs(10-(3-1))，也就是 2 或者 8

         */

        int ans = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int next = s.charAt(i) - '0';
            ans += Math.min(Math.abs(cur - next), (10 - Math.abs(cur - next)));
            cur = s.charAt(i) - '0';
        }

        return ans;
    }

    public static void main(String[] args) {

        L4070_Minimum_Rotations_to_Dial_a_Number_I s = new L4070_Minimum_Rotations_to_Dial_a_Number_I();
        long sysDate1 = System.currentTimeMillis();

//        String ss = "0192837465";
        String ss = "1200210200" ;

        int res = s.minRotations(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}