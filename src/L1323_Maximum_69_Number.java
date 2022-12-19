public class L1323_Maximum_69_Number {

    public int maximum69Number(int num) {

        int temp = num;
        int pow = 1000;
        int res = 0;

        while (pow > 0) {
            int cur = temp / pow;
            if (cur == 6) {
                res += 9 * pow;
                res += temp % pow;
                return res;
            } else if (cur == 9) {
                res += cur * pow;
            }

            temp -= cur * pow;
            pow /= 10;
        }

        return res;
    }

    public static void main(String[] args) {

        L1323_Maximum_69_Number s = new L1323_Maximum_69_Number();
        long sysDate1 = System.currentTimeMillis();

        int num = 99;

        int res = s.maximum69Number(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}