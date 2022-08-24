public class L476_Number_Complement {


    public int findComplement(int num) {
        int[] arr = new int[32];
        int temp = num;
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

    public int findComplement2(int num) {
        int n = (int) (Math.log(num) / Math.log(2)) + 1;
        int bitmask = (1 << n) - 1;
        return num ^ bitmask;
    }

    public static void main(String[] args) {

        L476_Number_Complement s = new L476_Number_Complement();

        long sysDate1 = System.currentTimeMillis();

        int res = s.findComplement(5);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}