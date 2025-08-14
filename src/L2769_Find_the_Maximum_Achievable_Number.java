public class L2769_Find_the_Maximum_Achievable_Number {

    /*

    Given two integers, num and t.
    A number x is achievable if it can become equal to num after applying the following operation at most t times:

    Increase or decrease x by 1, and simultaneously increase or decrease num by 1.
    Return the maximum possible value of x.


    Example 1:

    Input: num = 4, t = 1

    Output: 6

    Explanation:

    Apply the following operation once to make the maximum achievable number equal to num:

    Decrease the maximum achievable number by 1, and increase num by 1.
    Example 2:

    Input: num = 3, t = 2

    Output: 7

    Explanation:

    Apply the following operation twice to make the maximum achievable number equal to num:

    Decrease the maximum achievable number by 1, and increase num by 1.


    Constraints:

    1 <= num, t <= 50

    }

     */
    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }

    public static void main(String[] args) {

        L2769_Find_the_Maximum_Achievable_Number s = new L2769_Find_the_Maximum_Achievable_Number();
        long sysDate1 = System.currentTimeMillis();

        int num = 3;
        int t = 2;
        int res = s.theMaximumAchievableX(num, t);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}