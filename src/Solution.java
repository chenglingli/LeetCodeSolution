
public class Solution {

    public int climbStairs(int n) {

        int f [] = new int[100];

        f[1] = 1;
        f[2] = 2;

        for(int i = 3 ; i <= n ; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        long sysDate1 = System.currentTimeMillis();
        int x = 12;
        int res = s.climbStairs(x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}