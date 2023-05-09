import java.math.BigInteger;

public class L1175_Prime_Arrangements {

    public int numPrimeArrangements(int n) {

        // 看 1-n 有多少个质数 x
        // ans = x! * (n-x)! % (10^9 + 7)
        // 5: 3! * 2! = 12
        // 100: (25! * 75!) % (10^9 + 7)

        int np = numOfPrimes(n);
        int nnp = n - np;

        BigInteger ansa = fact(np).multiply(fact(nnp));
        ansa = ansa.mod(BigInteger.valueOf(1000000007));

        return ansa.intValue();
    }

    private BigInteger fact(int n) {
        BigInteger ret = BigInteger.valueOf(1);
        while (n > 1) {
            ret = ret.multiply(BigInteger.valueOf(n));
            n--;
        }
        return ret;
    }

    private int numOfPrimes(int n) {

        int[] primes = new int[]{
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        int count = 0;
        for (int each : primes) {
            if (each > n) {
                break;
            }
            count++;
        }
        return count;
    }


    public int numPrimeArrangements2(int n) {
        final int kMod = 1_000_000_007;
        final int count = numOfPrimes(n);
        return (int) ((factorial(count, kMod) * factorial(n - count, kMod)) % kMod);
    }

    long factorial(int n, final long kMod) {
        long fact = 1;
        for (int i = 1; i <= n; ++i)
            fact = fact * i % kMod;
        return fact;
    }

    public static void main(String[] args) {

        L1175_Prime_Arrangements s = new L1175_Prime_Arrangements();
        long sysDate1 = System.currentTimeMillis();

        int n = 100;

        int res = s.numPrimeArrangements(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}