public class L3950_Exactly_One_Consecutive_Set_Bits_Pair {

    /*

    You are given an integer n.

    Return true if its binary representation contains exactly one pair of consecutive set bits, and false otherwise.



    Example 1:

    Input: nums = 6

    Output: true

    Explanation:

    Binary representation of 6 is 110.
    There is exactly one pair of consecutive set bits ("11"). Thus, the answer is true.
    Example 2:

    Input: nums = 5

    Output: false

    Explanation:

    Binary representation of 5 is 101.
    There are no consecutive set bits. Thus, the answer is false.


    Constraints:

    0 <= n <= 10^5

     */
    public boolean consecutiveSetBits(int n) {
        return Integer.bitCount(n & (n >> 1)) == 1;
    }

    public static void main(String[] args) {

        L3950_Exactly_One_Consecutive_Set_Bits_Pair s = new L3950_Exactly_One_Consecutive_Set_Bits_Pair();
        long sysDate1 = System.currentTimeMillis();

//        int n = 6;
        int n = 5;
//        int n = 30;
//        int n = 45;
        boolean res = s.consecutiveSetBits(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}