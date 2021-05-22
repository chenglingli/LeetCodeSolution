public class L069_Sqrt_x {

    public int mySqrt(int x) {
        double temp = x * 1.0;
        int ans = (int) Math.sqrt(temp);
        return ans;
    }

    public static void main(String[] args) {

        L069_Sqrt_x s = new L069_Sqrt_x();

        long sysDate1 = System.currentTimeMillis();
        int x = 2147483647;
        int res = s.mySqrt(x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}