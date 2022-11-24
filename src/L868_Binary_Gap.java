public class L868_Binary_Gap {

    public int binaryGap(int n) {

        if (n == 0 || (n & n - 1) == 0) {
            return 0;
        }

        int tempN = n;
        StringBuilder binary = new StringBuilder();
        while (tempN > 0) {
            if (tempN % 2 == 0) {
                binary.append('0');
            } else {
                binary.append('1');
            }
            tempN = tempN / 2;
        }

        String binaryStr = binary.toString();
        int res = 0;
        int pre = -1;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                if (pre != -1 && i - pre > res) {
                    res = i - pre;
                }
                pre = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L868_Binary_Gap s = new L868_Binary_Gap();
        long sysDate1 = System.currentTimeMillis();

        int num = 9;
        //        int num = 5;
        int res = s.binaryGap(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}