public class L2928_Distribute_Candies_Among_Children_I {

    /*

    You are given two positive integers n and limit.

    Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies.

    Example 1:
    Input: n = 5, limit = 2
    Output: 3
    Explanation: There are 3 ways to distribute 5 candies such that no child gets more than 2 candies:
        (1, 2, 2), (2, 1, 2) and (2, 2, 1).

    Example 2:
    Input: n = 3, limit = 3
    Output: 10
    Explanation: There are 10 ways to distribute 3 candies such that no child gets more than 3 candies:
        (0, 0, 3), (0, 1, 2), (0, 2, 1), (0, 3, 0), (1, 0, 2), (1, 1, 1), (1, 2, 0), (2, 0, 1), (2, 1, 0) and (3, 0, 0).


    Constraints:

    1 <= n <= 50
    1 <= limit <= 50
    */
    public int distributeCandies(int n, int limit) {

        int ans = 0;

        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                int k = n - i - j;
                if (k >= 0 && k <= limit) {
                    ans++;
                }
            }
        }

        return ans;
    }


    /*
     * 给定糖果总数 n 和每个小朋友最多能拿的糖果数 limit，计算可以分配给小朋友们的糖果组合数。

     */
    public int distributeCandies2(int n, int limit) {

        if (n > 3 * limit) {
            return 0;
        }

        long ans = comb2(n + 2);

        if (n > limit) {
            ans -= 3 * comb2(n - limit + 1);
        }

        if (n - 2 >= 2 * limit) {
            ans += 3 * comb2(n - 2 * limit);
        }

        return (int) ans;
    }

    private long comb2(int n) {
        return 1L * n * (n - 1) / 2;
    }

    public static void main(String[] args) {

        L2928_Distribute_Candies_Among_Children_I s = new L2928_Distribute_Candies_Among_Children_I();
        long sysDate1 = System.currentTimeMillis();

        int n = 3;
        int limit = 3;

        int res = s.distributeCandies(n, limit);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}