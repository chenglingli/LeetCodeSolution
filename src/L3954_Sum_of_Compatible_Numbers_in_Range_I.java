public class L3954_Sum_of_Compatible_Numbers_in_Range_I {

    /*

    You are given two integers n and k.

    A positive integer x is called compatible if it satisfies both of the following conditions:

    abs(n - x) <= k
    (n & x) == 0
    Return the sum of all compatible integers x.

    Note:

    Here, & denotes the bitwise AND operator.
    The absolute difference between integers i and j is defined as abs(i - j).


    Example 1:

    Input: n = 2, k = 3

    Output: 10

    Explanation:

    The compatible integers are:

    x = 1, since abs(2 - 1) = 1 and 2 & 1 = 0.
    x = 4, since abs(2 - 4) = 2 and 2 & 4 = 0.
    x = 5, since abs(2 - 5) = 3 and 2 & 5 = 0.
    Thus, the answer is 1 + 4 + 5 = 10.

    Example 2:

    Input: n = 5, k = 1

    Output: 0

    Explanation:

    There are no compatible integers in the range [4, 6]. Thus, the answer is 0.



    Constraints:

    1 <= n <= 100
    1 <= k <= 100

     */
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;
        int max = n + k;
        int  i = 1;
        while (i <= max) {
            if (Math.abs(n - i) <= k && (n & i) == 0) {
                sum += i;
            }
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {

        L3954_Sum_of_Compatible_Numbers_in_Range_I s = new L3954_Sum_of_Compatible_Numbers_in_Range_I();
        long sysDate1 = System.currentTimeMillis();

        int n = 2;
        int k = 3;
        int res = s.sumOfGoodIntegers(n, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}