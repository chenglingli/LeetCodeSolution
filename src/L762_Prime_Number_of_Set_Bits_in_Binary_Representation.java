public class L762_Prime_Number_of_Set_Bits_in_Binary_Representation {

    public int countPrimeSetBits(int left, int right) {

        int res = 0;

        for (int i = left; i <= right; i++) {
            int countOne = countSetBits2(i);
            if (isPrime2(countOne)) {
                res++;
            }
        }

        return res;
    }

    private int countOne(int x) {

        int count = 0;
        while (x > 0) {
            if (x % 2 != 0) {
                count++;
            }
            x /= 2;
        }

        return count;
    }

    private boolean isPrime(int x) {

        if (x == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }


    static int countSetBits2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    static boolean isPrime2(int n) {

        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        L762_Prime_Number_of_Set_Bits_in_Binary_Representation s = new L762_Prime_Number_of_Set_Bits_in_Binary_Representation();

        long sysDate1 = System.currentTimeMillis();

        int left = 990;
        int right = 1048;

        int res = s.countPrimeSetBits(left, right);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}