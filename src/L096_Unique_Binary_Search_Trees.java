public class L096_Unique_Binary_Search_Trees {

    /**
     * f(1) = 1
     * f(2) = 2
     * f(3) = 5
     * f(4) = 12
     * <p>
     * f(0) = 0
     * <p>
     * for (left = o -> i)
     * f(i) = f(left) * f(right) (right + left  = i - 1)
     */

    public int numTrees(int n) {

        int[] f = new int[20];
        f[1] = 1;
        f[0] = 1;

        for (int x = 2; x <= n; x++) {
            for (int left = 0; left < x; left++) {
                int right = x - 1 - left;
                f[x] += f[left] * f[right];
            }
        }

        return f[n];
    }

    public static void main(String[] args) {

        L096_Unique_Binary_Search_Trees s = new L096_Unique_Binary_Search_Trees();

        long sysDate1 = System.currentTimeMillis();

        int res = s.numTrees(4);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}