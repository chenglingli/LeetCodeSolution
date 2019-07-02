/**
 * f(n) = f(n-1) + f(n-2)
 *
 */

public class L070_Climbing_Stairs {

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

        L070_Climbing_Stairs s = new L070_Climbing_Stairs();

        long sysDate1 = System.currentTimeMillis();
        int x = 12;
        int res = s.climbStairs(x);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}