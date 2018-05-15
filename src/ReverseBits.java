
// Reverse bits of a given 32 bits unsigned integer.

public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }


    public static void main(String[] args) {

        ReverseBits s = new ReverseBits();

        long sysDate1 = System.currentTimeMillis();

        int x = 43261596;

        int res = s.reverseBits(x);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}