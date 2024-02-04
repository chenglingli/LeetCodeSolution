public class L1646_Get_Maximum_in_Generated_Array {

    /*
        0 <= n <= 100


    nums[0] = 0
    nums[1] = 1
    nums[2 * i] = nums[i] when 2 <= 2 * i <= n
    nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n

    0 1 2 3 4 5 6 7 8 9 10
    0 1 1 2 1 3 1 3 1 4 1

     */

    public int getMaximumGenerated(int n) {

        if (n == 0) {
            return 0;
        }

        int[] f = new int[101];
        f[0] = 0;
        f[1] = 1;
        int max = 1;

        for (int i = 2; i <= n; i++) {

            if (i % 2 == 0) {
                f[i] = f[i / 2];
            } else {
                f[i] = f[i / 2] + f[i / 2 + 1];
            }
            max = Math.max(max, f[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        L1646_Get_Maximum_in_Generated_Array s = new L1646_Get_Maximum_in_Generated_Array();
        long sysDate1 = System.currentTimeMillis();

        int res = s.getMaximumGenerated(11);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}