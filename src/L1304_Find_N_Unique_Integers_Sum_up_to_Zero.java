import java.util.Arrays;

public class L1304_Find_N_Unique_Integers_Sum_up_to_Zero {

    public int[] sumZero(int n) {
        int x = n / 2;
        int[] res = new int[n];
        int count = 0;
        for (int i = x * (-1); i <= x; i++) {
            if (i == 0) {
                continue;
            }
            res[count++] = i;
        }

        if (n % 2 != 0) {
            res[n - 1] = 0;
        }
        return res;
    }

    public static void main(String[] args) {

        L1304_Find_N_Unique_Integers_Sum_up_to_Zero s = new L1304_Find_N_Unique_Integers_Sum_up_to_Zero();
        long sysDate1 = System.currentTimeMillis();

        int[] res = s.sumZero(5);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}