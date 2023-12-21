public class L2729_Check_if_The_Number_is_Fascinating {

    /*
    100 <= n <= 999
     */
    public boolean isFascinating(int n) {

        int[] count = new int[10];
        int temp = n;
        while (temp > 0) {
            if (count[temp % 10] == 1 || temp % 10 == 0) {
                return false;
            }
            count[temp % 10] = 1;
            temp /= 10;
        }

        temp = 2 * n;
        while (temp > 0) {
            if (count[temp % 10] == 1 || temp % 10 == 0) {
                return false;
            }
            count[temp % 10] = 1;
            temp /= 10;
        }

        temp = 3 * n;
        while (temp > 0) {
            if (count[temp % 10] == 1 || temp % 10 == 0) {
                return false;
            }
            count[temp % 10] = 1;
            temp /= 10;
        }

        return true;
    }

    public boolean isFascinating2(int n) {
        return n == 192 || n == 219 || n == 273 || n == 327;
    }

    public static void main(String[] args) {

        L2729_Check_if_The_Number_is_Fascinating s = new L2729_Check_if_The_Number_is_Fascinating();
        long sysDate1 = System.currentTimeMillis();

        int n = 100;
        boolean res = s.isFascinating(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}