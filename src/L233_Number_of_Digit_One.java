public class L233_Number_of_Digit_One {


    /*
    0 <= n <= 10^9

    暴力法：
        遍历每个数字，计算每个数字中1的个数
        时间复杂度：O(n * logn)
        空间复杂度：O(1)
     */
    public int countDigitOne2(int n) {
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            int tempX = f(i);
            ans += tempX;
        }

        return ans;
    }

    private int f(int x) {
        int ans = 0;

        while (x > 0) {
            if (x % 10 == 1) {
                ans++;
            }
            x /= 10;
        }

        return ans;
    }

    /*

    动态规划法：
        1. 从低位到高位，计算每个位上1的个数
        2. 例如：n = 824883294
            个位：n / 10 = 82488329, n % 10 = 4
            十位：n / 100 = 8248832, n % 100 = 94
            百位：n / 1000 = 824883, n % 1000 = 294
            ...


     */
    public int countDigitOne(int n) {
        int ans = 0;

        for (long m = 1; m <= n; m *= 10) {

            long a = n / m;
            long b = n % m;

            ans += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }

        return ans;
    }

    
    /*

    更为清晰的版本
    每一位考虑1出现的次数
    譬如考虑 第i位 时候

    prefix = n / (i * 10)
    digit = n / i % 10
    suffix = n % i

    12 0 34
        00 1 xx
        01 1 xx
        ……
        11 1 xx
            Total：12 * 100

    12 1 34
        00 1 xx
        01 1 xx
        ……
        11 1 xx
            Total：12 * 100
        12 1 00
        12 1 01
        ……
        12 1 34
            Total： 34 + 1

    12 2 34
        00 1 xx
        01 1 xx
        ……
        11 1 xx
        12 1 xx
            Total：13 * 100

     */
    public int countDigitOne3(int n) {

        int res = 0;

        for (long i = 1; i <= n; i *= 10) {

            int prefix = (int) (n / (i * 10));
            int digit = (int) ((n / i) % 10);
            int suffix = (int) (n % i);

            // 12345
            // i = 1, prefix = 1234, digit = 5, suffix = 0
            // i = 10, prefix = 123, digit = 4, suffix = 5
            // i = 100, prefix = 12, digit = 3, suffix = 45

            if (digit == 0) {
                /*
                例如 12 0 34
                    00 1 xx
                    01 1 xx
                    ……
                    11 1 xx
                        Total：12 * 100
                 */
                res += prefix * i;
            } else if (digit == 1) {
                /*
                例如 12 1 34
                    00 1 xx
                    01 1 xx
                    ……
                    11 1 xx
                        Total：12 * 100
                    12 1 00
                    12 1 01
                    ……
                    12 1 34
                        Total： 34 + 1
                 */
                res += prefix * i + suffix + 1;
            } else {
                /*
                例如 12 2 34
                    00 1 xx
                    01 1 xx
                    ……
                    11 1 xx
                    12 1 xx
                        Total：13 * 100
                 */
                res += (prefix + 1) * i;
            }
        }

        return res;
    }


    public static void main(String[] args) {

        L233_Number_of_Digit_One s = new L233_Number_of_Digit_One();
        long sysDate1 = System.currentTimeMillis();

        int n = 824883294;
        int x = s.countDigitOne3(n);
        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}