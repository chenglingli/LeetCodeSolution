import java.util.Arrays;

public class L1652_Defuse_the_Bomb {


    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] res = new int[code.length];
        if (k == 0) {
            return res;
        }

        int preSum = 0;
        if (k > 0) {
            for (int i = 1; i <= k; i++) preSum += code[i];

            for (int i = 0; i < n; i++) {
                res[i] = preSum;
                int sum = nextSumForward(code, i, k, preSum);
                preSum = sum;
            }
        } else {
            for (int i = n - 1; i >= (n + k); i--) preSum += code[i];

            for (int i = 0; i < n; i++) {
                res[i] = preSum;
                int sum = nextSumBackWord(code, i, k, preSum);
                preSum = sum;
            }
        }

        return res;
    }

    int nextSumForward(int[] code, int i, int k, int preSum) {
        return preSum + code[(i + k + 1) % code.length] - code[(i + 1) % code.length];
    }

    int nextSumBackWord(int[] code, int i, int k, int preSum) {
        return preSum + code[i] - code[(i + k + code.length) % code.length];
    }

    public static void main(String[] args) {

        L1652_Defuse_the_Bomb s = new L1652_Defuse_the_Bomb();
        long sysDate1 = System.currentTimeMillis();

        int[] code = {1, 2, 3, 4};
        int k = -2;
        int[] res = s.decrypt(code, k);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}