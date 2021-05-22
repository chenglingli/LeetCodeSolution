import java.util.ArrayList;
import java.util.List;

public class L413_Arithmetic_Slices {

    /**
     * A sequence of number is called arithmetic if it consists of
     * at least three elements and if the difference between any
     * two consecutive elements is the same.
     * <p>
     * For example, these are arithmetic sequence:
     * <p>
     * 1, 3, 5, 7, 9
     * 7, 7, 7, 7
     * 3, -1, -5, -9
     * The following sequence is not arithmetic.
     * <p>
     * 1, 1, 2, 5, 7
     * <p>
     * A zero-indexed array A consisting of N numbers is given.
     * A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
     * <p>
     * A slice (P, Q) of array A is called arithmetic if the sequence:
     * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic.
     * In particular, this means that P + 1 < Q.
     * <p>
     * The function should return the number of arithmetic slices in the array A.
     * <p>
     * <p>
     * Example:
     * <p>
     * A = [1, 2, 3, 4]
     * <p>
     * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
     */

    public int numberOfArithmeticSlices(int[] A) {

        List<Integer> S = new ArrayList<>();
        List<Integer> E = new ArrayList<>();

        int s = 0, e = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] - A[i - 1] == A[i + 1] - A[i]) {
                e = i + 1;
            } else {
                if (e - s >= 2) {
                    S.add(s);
                    E.add(e);
                }
                s = i;
                e = 0;
            }
        }

        if (e - s >= 2) {
            S.add(s);
            E.add(e);
        }

        int ans = 0;
        for (int i = 0; i < S.size(); i++) {
            int len = E.get(i) - S.get(i) - 1;
            ans += (len * (len + 1)) / 2;
        }

        return ans;
    }

    int numberOfArithmeticSlices2(int[] A) {
        int n = A.length;
        int res = 0;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
                dp[i] = dp[i - 1] + 1;
            res += dp[i];
        }
        return res;
    }


    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        L413_Arithmetic_Slices s = new L413_Arithmetic_Slices();
        long sysDate1 = System.currentTimeMillis();

        int[] ss = {1, 2, 3, 4, 5, 9, 13};

        int res = s.numberOfArithmeticSlices(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}