import java.util.Arrays;

public class L313_Super_Ugly_Number {

    public int nthSuperUglyNumber(int n, int[] primes) {

        long[] ugly = new long[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);

            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i])
                    idx[j]++;
                // System.out.println(Arrays.toString(idx));
            }
        }

        return (int) ugly[n - 1];
    }

    /*
    和264题同理
     */
    public int nthSuperUglyNumber2(int n, int[] primes) {

        long[] ugly = new long[n];
        int[] idx = new int[primes.length];
        long[] val = new long[primes.length];
        ugly[0] = 1;
        Arrays.fill(val, 1);

        long next = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = next;

            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i])
                    val[j] = ugly[idx[j]++] * primes[j];

                //find next ugly number
                if (next > val[j]) {
                    next = val[j];
                }
            }
        }

        return (int) ugly[n - 1];
    }

    public static void main(String[] args) {


        L313_Super_Ugly_Number s = new L313_Super_Ugly_Number();
        long sysDate1 = System.currentTimeMillis();

        int n = 12;
        int[] primes = {2, 7, 13, 19};
        int res = s.nthSuperUglyNumber2(n, primes);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}