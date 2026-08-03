import java.util.ArrayList;
import java.util.List;

public class L4006_Count_Valid_Prefixes {

    /*
    You are given a binary string s.

    A prefix of s is considered valid if its characters can be rearranged to form an alternating string.

    Return the number of valid prefixes of s.

    A string is considered alternating if no two adjacent characters are equal.



    Example 1:

    Input: s = "00101"

    Output: 3

    Explanation:

    The valid prefixes are:

    "0": It is already an alternating string.
    "001": It can be rearranged into "010", which is an alternating string.
    "00101": It can be rearranged into "01010", which is an alternating string.
    Thus, the answer is 3.

    Example 2:

    Input: s = "101"

    Output: 3

    Explanation:

    All prefixes of s = "101" are already alternating strings. Thus, the answer is 3.



    Constraints:

    1 <= s.length <= 100
    s consists only of '0' and '1'.
     */

    public int countValidPrefixes(String s) {
        int countOne = 0;
        int res = 0;

        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                countOne++;

            if (Math.abs(countOne - (i + 1 - countOne) ) <= 1)
                res++;
        }

        return res;
    }

    public static void main(String[] args) {

        L4006_Count_Valid_Prefixes s = new L4006_Count_Valid_Prefixes();
        long sysDate1 = System.currentTimeMillis();

        String ss = "00101";
        int res = s.countValidPrefixes(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}