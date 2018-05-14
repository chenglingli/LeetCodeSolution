
// Count the number of prime numbers less than a non-negative number, n.

public class CountPrimes {

    public int countPrimes(int n) {

        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {

        CountPrimes s = new CountPrimes();

        long sysDate1 = System.currentTimeMillis();

        int x = 10;

        int res = s.countPrimes(x);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}