public class L1374_Generate_a_String_With_Characters_That_Have_Odd_Counts {


    public String generateTheString(int n) {
        int x = 0;
        if (n % 2 == 0) {
            x = n - 1;
        } else {
            x = n;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append('a');
        }
        if (x != n) {
            sb.append('b');
        }

        return sb.toString();
    }

    public String generateTheString2(int n) {

        char[] res = new char[n];
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                res[i] = 'a';
            }

        } else {
            res[0] = 'b';
            for (int i = 1; i < n; i++) {
                res[i] = 'a';
            }

        }
        return new String(res);
    }

    public static void main(String[] args) {

        L1374_Generate_a_String_With_Characters_That_Have_Odd_Counts s = new L1374_Generate_a_String_With_Characters_That_Have_Odd_Counts();
        long sysDate1 = System.currentTimeMillis();

        int num = 4;
        // [4,0,1,1,3]

        // int[] nums = {7, 7, 7, 7};
        // [0,0,0,0]

        String res = s.generateTheString(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}