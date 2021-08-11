// Reverse bits of a given 32 bits unsigned integer.

public class L191_Number_of_1_Bits {

    // you need treat n as an unsigned value
    public int hammingWeight(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1)
                res++;
        }
        return res;
    }


    public static void main(String[] args) {

        L191_Number_of_1_Bits s = new L191_Number_of_1_Bits();

        long sysDate1 = System.currentTimeMillis();

        int x = 3;

        int res = s.hammingWeight(x);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}