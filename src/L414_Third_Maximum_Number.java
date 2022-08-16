public class L414_Third_Maximum_Number {

    public int thirdMax(int[] nums) {

        int a, b, c;
        a = Integer.MIN_VALUE;
        b = Integer.MIN_VALUE;
        c = Integer.MIN_VALUE;

        boolean changeTag = false;

        for (int num : nums) {

            if (num == Integer.MIN_VALUE) {
                changeTag = true;
                continue;
            }

            if (num > a) {
                c = b;
                b = a;

                a = num;

            }

            else if (num > b && num < a) {
                c = b;

                b = num;

            }

            else if (num > c && num < b) {
                c = num;
            }
        }


        if (b == Integer.MIN_VALUE) {
            return a;
        }

        if (c == Integer.MIN_VALUE && changeTag) {
            return c;
        }

        if (c > Integer.MIN_VALUE) {
            return c;
        }

        return a;
    }

    public static void main(String[] args) {

        L414_Third_Maximum_Number s = new L414_Third_Maximum_Number();
        long sysDate1 = System.currentTimeMillis();

 //        int[] ss = {2,2,3,1};
 //       int[] ss = {1,2};
 //       int[] ss = {3, 2,1};
 //        int[] ss = {3 ,-2147483648, 1, 2};
        int[] ss = {1 ,-2147483648, 1};

        int res = s.thirdMax(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}