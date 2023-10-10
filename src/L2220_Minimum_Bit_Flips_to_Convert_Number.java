public class L2220_Minimum_Bit_Flips_to_Convert_Number {

    /*
    0 <= start, goal <= 109
     */
    public int minBitFlips(int start, int goal) {

        int ans = 0;

        while (start > 0 && goal > 0) {
            if (start % 2 != goal % 2) ans++;

            start /= 2;
            goal /= 2;
        }

        while (start > 0) {
            if (start % 2 != 0) ans++;
            start /= 2;
        }

        while (goal > 0) {
            if (goal % 2 != 0) ans++;
            goal /= 2;
        }

        return ans;
    }


    /*

    10 : 0001010
    82 : 1010010

     */

    public static void main(String[] args) {

        L2220_Minimum_Bit_Flips_to_Convert_Number s =
                new L2220_Minimum_Bit_Flips_to_Convert_Number();
        long sysDate1 = System.currentTimeMillis();

        int start = 10;
        int goal = 82;
        int res = s.minBitFlips(start, goal);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}