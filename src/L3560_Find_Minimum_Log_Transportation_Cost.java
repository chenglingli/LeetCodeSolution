public class L3560_Find_Minimum_Log_Transportation_Cost {

    /*
    You are given integers n, m, and k.

    There are two logs of lengths n and m units,
    which need to be transported in 3 trucks where each truck can carry one log with length at most k units.

    You may cut the logs into smaller pieces, where the cost of cutting a log of length x into logs of length len1 and len2 is cost = len1 * len2 such that len1 + len2 = x.

    Return the minimum total cost to distribute the logs onto the trucks. If the logs don't need to be cut, the total cost is 0.



    Example 1:

    Input: n = 6, m = 5, k = 5

    Output: 5

    Explanation:

    Cut the log with length 6 into logs with length 1 and 5, at a cost equal to 1 * 5 == 5. Now the three logs of length 1, 5, and 5 can fit in one truck each.

    Example 2:

    Input: n = 4, m = 4, k = 6

    Output: 0

    Explanation:

    The two logs can fit in the trucks already, hence we don't need to cut the logs.



    Constraints:

    2 <= k <= 10^5
    1 <= n, m <= 2 * k
    The input is generated such that it is always possible to transport the logs.
     */
    public long minCuttingCost(int n, int m, int k) {
        long ans = 0;
        if (n > k) {
            ans += (long)(n - k) * k;
        }

        if (m > k) {
            ans += (long)(m - k) * k;
        }

        return ans;
    }

    public static void main(String[] args) {

        L3560_Find_Minimum_Log_Transportation_Cost s = new L3560_Find_Minimum_Log_Transportation_Cost();
        long sysDate1 = System.currentTimeMillis();

        int n = 6;
        int m = 5;
        int k = 5;

        long res = s.minCuttingCost(n, m, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}