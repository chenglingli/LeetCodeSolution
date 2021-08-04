/**
 * known that A XOR A = 0 and the XOR operator is commutative,
 * the solution will be very straightforward.
 */


public class L136_Single_Number {

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++)
            result ^= nums[i];

        return result;
    }


    public static void main(String[] args) {

        L136_Single_Number s = new L136_Single_Number();

        long sysDate1 = System.currentTimeMillis();

        int[] l = {1, 1, 2};

        int res = s.singleNumber(l);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}