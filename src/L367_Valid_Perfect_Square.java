public class L367_Valid_Perfect_Square {

    /**
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     * <p>
     * Note: Do not use any built-in library function such as sqrt.
     * <p>
     * Example 1:
     * <p>
     * Input: 16
     * Output: true
     * Example 2:
     * <p>
     * Input: 14
     * Output: false
     */


    public boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }

        long low = 1;
        long high = num / 2 + 1;

        while (low < high) {
            long mid = (high - low) / 2 + low;
            long guess = mid * mid;
            if (guess == num) {
                return true;
            } else if (guess < num) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return false;
    }

    boolean isPerfectSquare2(int num) {
        long left = 0, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2, t = mid * mid;
            if (t == num) return true;
            if (t < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {

        L367_Valid_Perfect_Square s = new L367_Valid_Perfect_Square();

        long sysDate1 = System.currentTimeMillis();

        boolean res2 = s.isPerfectSquare(808201);
        System.out.println(res2 + " " + 808201);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}