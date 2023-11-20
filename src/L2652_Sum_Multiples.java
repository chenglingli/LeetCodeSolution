public class L2652_Sum_Multiples {

    /*
        find the sum of all integers in the range [1, n] inclusive
            that are divisible by 3, 5, or 7.

     */
    public int sumOfMultiples(int n) {

        int sum = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public int sumOfMultiples2(int n) {
        int[] memo = new int[1001];

        if (memo[3] == 0) {
            int sum = 0;
            for (int i = 3; i < memo.length; ++i) {
                if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                    sum += i;
                memo[i] = sum;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {

        L2652_Sum_Multiples s = new L2652_Sum_Multiples();
        long sysDate1 = System.currentTimeMillis();

        int n = 15;
        int res = s.sumOfMultiples(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}