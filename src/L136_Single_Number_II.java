/**
 * known that A XOR A = 0 and the XOR operator is commutative,
 * the solution will be very straightforward.
 */


public class L136_Single_Number_II {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int x : nums)
                sum += (x >> i) & 1;
            int residue = sum % 3;
            res = res | residue << i;
        }
        return res;
    }

    public static void main(String[] args) {

        L136_Single_Number_II s = new L136_Single_Number_II();

        long sysDate1 = System.currentTimeMillis();

        int[] l = {1, 1, 2, 1};

        int res = s.singleNumber(l);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}