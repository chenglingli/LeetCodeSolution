public class L3827_Count_Monobit_Integers {

    /*
    You are given an integer n.

    An integer is called Monobit if all bits in its binary representation are the same.

    Return the count of Monobit integers in the range [0, n] (inclusive).



    Example 1:

    Input: n = 1

    Output: 2

    Explanation:

    The integers in the range [0, 1] have binary representations "0" and "1".
    Each representation consists of identical bits. Thus, the answer is 2.

    Example 2:

    Input: n = 4

    Output: 3

    Explanation:

    The integers in the range [0, 4] include binaries "0", "1", "10", "11", and "100".
    Only 0, 1 and 3 satisfy the Monobit condition. Thus, the answer is 3.


    Constraints:

    0 <= n <= 1000

     */
    public int countMonobit(int n) {
        //二进制表达 1, 11, 111, 直到n
        // 2^x - 1

        int x = 0;

        while (Math.pow(2, x) - 1 <= n) {
            x++;
        }

        return x;
    }

    public int countMonobit2(int n) {
        int count = 1;
        long current = 1;
        while (current <= n) {
            count++;
            current = (current << 1) | 1;
        }

        return count;
    }

    public static void main(String[] args) {

        L3827_Count_Monobit_Integers s = new L3827_Count_Monobit_Integers();
        long sysDate1 = System.currentTimeMillis();

        int n = 4;
        int res = s.countMonobit(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}