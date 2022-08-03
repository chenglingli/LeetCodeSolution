public class L338_Counting_Bits {


    public int[] countBits(int n) {

        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = 1 + ans[i / 2];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        L338_Counting_Bits s = new L338_Counting_Bits();
        long sysDate1 = System.currentTimeMillis();

        int n = 5;
        int[] res = s.countBits(n);
        System.out.println(res[n]);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}