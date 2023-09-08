public class L2180_Count_Integers_With_Even_Digit_Sum {

    /*
    Input: num = 30
    Output: 14
    Explanation:
    The 14 integers less than or equal to 30 whose digit sums are even are
    2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.

    1 <= num <= 1000

    一位数 2 4 6 8
    二位数 十位为基数，则个位为偶数；十位为偶数，则个位为基数
    三位数   百位为基数，
            百位为偶数

     */
    public int countEven(int num) {

        int ans = 0;

        for (int i = 1; i < num; i++) {
            if (isEven(i)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isEven(int x) {
        if (x == 1000) {
            return false;
        }
        return ((x % 10) + ((x / 10) % 10) + (x / 100)) % 2 == 0;
    }

    public int countEven2(int num) {

        int sum = 0;
        int n = num;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum % 2 == 0 ? num / 2 : (num - 1) / 2;
    }

    public static void main(String[] args) {

        L2180_Count_Integers_With_Even_Digit_Sum s =
                new L2180_Count_Integers_With_Even_Digit_Sum();
        long sysDate1 = System.currentTimeMillis();

        int num = 1000;
        int res = s.countEven2(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}