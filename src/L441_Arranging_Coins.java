public class L441_Arranging_Coins {

    /**
     * You have a total of n coins that you want to form in a staircase shape,
     * where every k-th row must have exactly k coins.
     * <p>
     * Given n, find the total number of full staircase rows that can be formed.
     * <p>
     * n is a non-negative integer and fits within the range of a 32-bit signed integer.
     * <p>
     * Example 1:
     * <p>
     * n = 5
     * <p>
     * The coins can form the following rows:
     * ¤
     * ¤ ¤
     * ¤ ¤
     * <p>
     * Because the 3rd row is incomplete, we return 2.
     * Example 2:
     * <p>
     * n = 8
     * <p>
     * The coins can form the following rows:
     * ¤
     * ¤ ¤
     * ¤ ¤ ¤
     * ¤ ¤
     * <p>
     * Because the 4th row is incomplete, we return 3.
     */


    public int arrangeCoins3(int n) {
        int i = 1;
        while (n >= 0) {
            n = n - i;
            i++;
        }
        return i - 2;
    }

    public int arrangeCoins2(int n) {

        if (n == 1 || n == 0) {
            return n;
        }

        long low = 1, high = n;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (n == f(mid)) {
                return (int) mid;
            } else if (n > f(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) (low - 1);
    }

    public long f(long x) {
        return x * (x + 1) / 2;
    }


    public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }

    public static void main(String[] args) {

        L441_Arranging_Coins s = new L441_Arranging_Coins();

        long sysDate1 = System.currentTimeMillis();
        int res = s.arrangeCoins(1804289383);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}