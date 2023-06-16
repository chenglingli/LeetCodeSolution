public class L1837_Sum_of_Digits_in_Base_K {

    /*
    1 <= n <= 100
    2 <= k <= 10

    34 = 3 * 10 + 4
    34/6 = 5

     */
    public int sumBase(int n, int k) {
        int x = n;
        int sum = 0;
        while (x > 0) {
            sum += x%k;
            x /= k;
        }
        return sum;
    }

    public static void main(String[] args) {

        L1837_Sum_of_Digits_in_Base_K s = new L1837_Sum_of_Digits_in_Base_K();
        long sysDate1 = System.currentTimeMillis();

        int n = 34;
        int k = 6;
        int res = s.sumBase(n, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}