import java.util.ArrayList;
import java.util.List;

public class L060_Permutation_Sequence {

    public String getPermutation(int n, int k) {

        if (n <= 0 || k <= 0) {
            return "";
        }

        String res = "";

        List<Integer> list = new ArrayList<Integer>();
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            list.add(i);
            fact *= i;
        }

        k--;

        /*
         *

            K(i) = K(i-1) / (n - i + 1)!
            a(i) = K(i) / (n - i)!

         */

        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = k / fact;
            res += list.get(index);
            list.remove(index);
            k %= fact;
        }

        return res;
    }

    public static void main(String[] args) {

        L060_Permutation_Sequence s = new L060_Permutation_Sequence();

        long sysDate1 = System.currentTimeMillis();
        String res = s.getPermutation(4, 2);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}