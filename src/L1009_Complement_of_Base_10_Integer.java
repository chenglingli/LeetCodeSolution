public class L1009_Complement_of_Base_10_Integer {

    public int bitwiseComplement(int n) {

        if (n == 0) {
            return 1;
        }

        int[] arr = new int[32];
        int temp = n;
        int i = 0;

        while (temp > 0) {
            if (temp % 2 == 0) {
                arr[i] = 1;
            }

            i++;
            temp /= 2;
        }

        int res = 0;
        for (int j = 0; j < 32; j++) {
            if (arr[j] == 1) {
                res += Math.pow(2, j);
            }
        }

        return res;
    }


    public static void main(String[] args) {

        L1009_Complement_of_Base_10_Integer s = new L1009_Complement_of_Base_10_Integer();

        long sysDate1 = System.currentTimeMillis();

        int n = 2;
        int res = s.bitwiseComplement(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}