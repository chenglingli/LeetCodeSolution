import java.util.Arrays;

public class L1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers {

    public int[] getNoZeroIntegers(int n) {

        for (int i = 1; i <= n / 2; i++) {
            if (!containZero(i)) {
                int remain = n - i;
                if (!containZero(remain)) {
                    return new int[]{i, remain};
                }
            }
        }
        return new int[]{1, n - 1};
    }

    private boolean containZero(int x) {
        int copy = x;
        if (copy <= 9) {
            return false;
        } else {
            while (copy > 0) {
                int temp = copy % 10;
                if (temp == 0) {
                    return true;
                }
                copy /= 10;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        L1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers s = new L1317_Convert_Integer_to_the_Sum_of_Two_No_Zero_Integers();
        long sysDate1 = System.currentTimeMillis();

        int num = 11;

        int[] res = s.getNoZeroIntegers(num);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}