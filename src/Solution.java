
public class Solution {

    public int mySqrt(int x) {
        double temp = x * 1.0;
        int ans = (int)Math.sqrt(temp);
        return ans;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        long sysDate1 = System.currentTimeMillis();
        int x = 2147483647;
        int res = s.mySqrt(x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}