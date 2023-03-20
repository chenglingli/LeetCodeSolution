public class L1716_Calculate_Money_in_Leetcode_Bank {


    /*
    1 <= n <= 1000
     */
    public int totalMoney(int n) {
        int x = n / 7;
        int y = n % 7;
        int sum = 0;

        int cur = 28;
        for (int i = 0; i < x; i++) {
            sum += cur;
            cur += 7;
        }

        cur = 1 + x;
        for (int i = 0; i < y; i++) {
            sum += cur;
            cur ++;
        }

        return sum;
    }

    public static void main(String[] args) {

        L1716_Calculate_Money_in_Leetcode_Bank s = new L1716_Calculate_Money_in_Leetcode_Bank();
        long sysDate1 = System.currentTimeMillis();

        int accounts = 20;
        int res = s.totalMoney(accounts);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}