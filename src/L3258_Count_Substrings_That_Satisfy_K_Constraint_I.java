import java.util.ArrayList;
import java.util.List;

public class L3258_Count_Substrings_That_Satisfy_K_Constraint_I {

    /*

    You are given a binary string s and an integer k.

    A binary string satisfies the k-constraint if either of the following conditions holds:

    The number of 0's in the string is at most k.
    The number of 1's in the string is at most k.
    Return an integer denoting the number of substrings of s that satisfy the k-constraint.



    Example 1:

    Input: s = "10101", k = 1

    Output: 12

    Explanation:

    Every substring of s except the substrings "1010", "10101", and "0101" satisfies the k-constraint.

    Example 2:

    Input: s = "1010101", k = 2

    Output: 25

    Explanation:

    Every substring of s except the substrings with a length greater than 5 satisfies the k-constraint.

    Example 3:

    Input: s = "11111", k = 1

    Output: 15

    Explanation:

    All substrings of s satisfy the k-constraint.



    Constraints:

    1 <= s.length <= 50
    1 <= k <= s.length
    s[i] is either '0' or '1'.

     */
    public int countKConstraintSubstrings(String s, int k) {
        int count = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len + 1; j++) {
                //                System.out.println(i + " " + j);
                String sub = s.substring(i, j);
                //                System.out.println(sub);
                if (sub.chars().filter(ch -> ch == '0').count() <= k || sub.chars().filter(ch -> ch == '1').count() <= k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int countKConstraintSubstrings2(String s, int k) {

        int left = 0;
        int n = s.length();
        int ans = 0;

        int zero = 0;
        int one = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int d = c - '0';
            if (d == 0)
                zero++;
            else
                one++;

            while (zero > k && one > k) {

                char e = s.charAt(left++);
                int f = e - '0';

                if (f == 0)
                    zero--;
                else
                    one--;
            }

            ans += i - left + 1;
            System.out.println(ans);
        }

        return ans;
    }

    public static void main(String[] args) {

        L3258_Count_Substrings_That_Satisfy_K_Constraint_I s = new L3258_Count_Substrings_That_Satisfy_K_Constraint_I();
        long sysDate1 = System.currentTimeMillis();

        String ss = "1010101";
        int k = 2;

        int res = s.countKConstraintSubstrings2(ss, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}