public class L878_Nth_Magical_Number {


    public int nthMagicalNumber(int N, int A, int B) {
        long lcm = A * B / gcd(A, B);
        long left = 2, right = (long) Math.pow(10, 14), M = (long) Math.pow(10, 9) + 7;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid / A + mid / B - mid / lcm < N) left = mid + 1;
            else right = mid;
        }

        return (int) (right % M);
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

        L878_Nth_Magical_Number s = new L878_Nth_Magical_Number();
        long sysDate1 = System.currentTimeMillis();

        int res = s.nthMagicalNumber(8, 10, 5);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}