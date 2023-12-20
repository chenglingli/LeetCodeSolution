public class L2485_Find_the_Pivot_Integer {

    /*
        1 <= n <= 1000
     */
    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }

        int sum = (n + 1) * n / 2;
        int curSum = 0;
        for (int i = n; i >= n / 2; i--) {
            curSum += i;

            // 8 + 7 == 1~6 + 7
            if (curSum == (sum + i) - curSum) {
                return i;
            }
        }

        return -1;
    }

    /*
    1 + 2 + ... + 8 = 36
    如果求和是平方数，则有值，且确定

    假设存在i

    (1 + i) * i / 2 == (i + n) * (n-i+1) / 2
    i + i^2 == (n + i) * (n - i + 1)

     */
    public int pivotInteger2(int n) {
        int ans = (int) Math.sqrt(n * (n + 1) / 2);
        return ans * ans == n * (n + 1) / 2 ? ans : -1;
    }

    public static void main(String[] args) {

        L2485_Find_the_Pivot_Integer s = new L2485_Find_the_Pivot_Integer();
        long sysDate1 = System.currentTimeMillis();

        int n = 8;
        int res = s.pivotInteger(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}