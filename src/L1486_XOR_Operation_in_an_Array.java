public class L1486_XOR_Operation_in_an_Array {

    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            start = start + 2;
            res = res ^ start;
        }

        return res;
    }

    public static void main(String[] args) {

        L1486_XOR_Operation_in_an_Array s = new L1486_XOR_Operation_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int n = 4;
        int start = 3;
        int res = s.xorOperation(n, start);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}