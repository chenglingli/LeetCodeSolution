public class L942_DI_String_Match {

    public int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }

    public static void main(String[] args) {

        L942_DI_String_Match s = new L942_DI_String_Match();

        long sysDate1 = System.currentTimeMillis();

        String x = "IDID";

        int[] res = s.diStringMatch(x);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}