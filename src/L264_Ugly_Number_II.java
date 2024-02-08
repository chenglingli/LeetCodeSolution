public class L264_Ugly_Number_II {


    public int nthUglyNumber(int n) {

        if (n == 1)
            return 1; // base case

        int [] index = new int[6];
        int[] ugly = new int[n];
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(ugly[index[2]] * 2, Math.min(ugly[index[3]] * 3, ugly[index[5]] * 5));
            if (ugly[i] == ugly[index[2]] * 2) index[2]++;
            if (ugly[i] == ugly[index[3]] * 3) index[3]++;
            if (ugly[i] == ugly[index[5]] * 5) index[5]++;
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {

        L264_Ugly_Number_II s = new L264_Ugly_Number_II();
        long sysDate1 = System.currentTimeMillis();

        int res = s.nthUglyNumber(10);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}