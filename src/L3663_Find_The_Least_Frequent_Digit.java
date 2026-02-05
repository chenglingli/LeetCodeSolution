public class L3663_Find_The_Least_Frequent_Digit {

    /*

    Given an integer n, find the digit that occurs least frequently in its decimal representation. If multiple digits have the same frequency, choose the smallest digit.

    Return the chosen digit as an integer.

    The frequency of a digit x is the number of times it appears in the decimal representation of n.


    Example 1:

    Input: n = 1553322

    Output: 1

    Explanation:

    The least frequent digit in n is 1, which appears only once. All other digits appear twice.

    Example 2:

    Input: n = 723344511

    Output: 2

    Explanation:

    The least frequent digits in n are 7, 2, and 5; each appears only once.



    Constraints:

    1 <= n <= 2^31 - 1
     */
    public int getLeastFrequentDigit(int n) {
        int [] frequency = new int[10];

        int copy = n;
        while (copy > 0) {
            frequency[copy % 10]++;
            copy /= 10;
        }

        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (frequency[i]>= 1 && frequency[i] < min) {
                min = frequency[i];
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L3663_Find_The_Least_Frequent_Digit s = new L3663_Find_The_Least_Frequent_Digit();
        long sysDate1 = System.currentTimeMillis();

        int n = 10;

        int res = s.getLeastFrequentDigit(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}