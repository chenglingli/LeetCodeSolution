import java.util.HashMap;
import java.util.Map;

public class L397_Integer_Replacement {

    /*
    If n is even, replace n with n / 2.
    If n is odd, replace n with either n + 1 or n - 1.

    f(n) n 变为1的次数

    min{f(n-1),f(n+1)}

    if (n== 2^x)
        f(n) = x

    else
        f(n) = min{f(n-1), f(n+1)}

     */
    public int integerReplacement(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        return f(n, dp);
    }

    private int f(int x, Map<Integer, Integer> dp) {

        if (x == 2147483647) {
            return 32;
        }

        if (x < 0) {
            return 50; // > 32 is ok
        }
        if (x == 1) {
            return 0;
        }
        if (x == 2) {
            return 1;
        }

        // memorization
        if (dp.containsKey(x)) {
            return dp.get(x);
        }

        int mi = countMi(x);

        int tempRes = 0;
        if (mi != -1) {
            tempRes = mi;
        } else if (x % 2 == 0) {
            tempRes = f(x / 2, dp) + 1;
        } else {
            tempRes = Math.min(f(x - 1, dp), f(x + 1, dp)) + 1;
        }

        dp.put(x, tempRes);

        return tempRes;
    }

    private int countMi(int x) {
        long temp = x;
        int count = 0;
        while (temp % 2 == 0) {
            temp /= 2;
            count++;
        }
        if (temp != 1) {
            return -1;
        }
        return count;
    }


    public int integerReplacement2(int n) {
        int i = 0;
        if (n == 2147483647) {
            n = n - 1;
        }

        while (n != 1) {
            i++;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                if ((n + 1) % 4 == 0 && (n - 1) != 2) {
                    n = n + 1;
                } else {
                    n = n - 1;
                }
            }

        }

        return i;
    }

    public static void main(String[] args) {

        L397_Integer_Replacement s = new L397_Integer_Replacement();
        long sysDate1 = System.currentTimeMillis();

        int res = s.integerReplacement(8);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}