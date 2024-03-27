public class L319_Bulb_Switcher {

    /*
    0 <= n <= 10^9

    对于特定的某个灯泡i，如果他有偶数个因子，则最后是关闭的。
    只有平方数的因子是奇数个，所以只有平方数位置的灯泡最后是开的。譬如4，他有1,2,4三个因子，所以是开的。

    所以，我们问题换成，从1到n有多少个完全平方数。
    如果n是一个完全平方数，那么最后结果是sqrt(n)。
    如果n不是一个完全平方数，那么最后结果是sqrt(n)向下取整。

    当然还有个更简单办法：
     模拟，找规律
    画出10个灯泡，模拟一下就知道：
    f(10) = 3
    f(9) = 3
    f(8) = 2
    ……
    f(4) = 2
    f(3) = 1
    f(2) = 1
    f(1) = 1
     */
    public int bulbSwitch(int n) {
        return (int)(Math.sqrt(n));
    }

    public static void main(String[] args) {

        L319_Bulb_Switcher s = new L319_Bulb_Switcher();
        long sysDate1 = System.currentTimeMillis();

        int n = 10;
        int res = s.bulbSwitch(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}