public class L3870_Count_Commas_in_Range {

    /*
    You are given an integer n.

    Return the total number of commas used when writing all integers from [1, n] (inclusive) in standard number formatting.

    In standard formatting:

    A comma is inserted after every three digits from the right.
    Numbers with fewer than 4 digits contain no commas.


    Example 1:

    Input: n = 1002

    Output: 3

    Explanation:

    The numbers "1,000", "1,001", and "1,002" each contain one comma, giving a total of 3.

    Example 2:

    Input: n = 998

    Output: 0

    Explanation:

    All numbers from 1 to 998 have fewer than four digits. Therefore, no commas are used.



    Constraints:

    1 <= n <= 10^5

    10^5 == 10,000

     */
    public int countCommas(int n) {
        // 题目需求是从1到n，总共多少个数字里面有逗号
        // 逗号的规则是：每隔3个数字插入一个逗号
        // 所以大于等于1000的每个数字就会有一个逗号
        // 又因为n的范围是1到10^5，所以只需要计算有多少个数字大于等于1000

        if (n < 1000) return 0;
        return n - 1000 + 1;
    }

    public static void main(String[] args) {

        L3870_Count_Commas_in_Range s = new L3870_Count_Commas_in_Range();
        long sysDate1 = System.currentTimeMillis();

        int n = 1002;

        int res = s.countCommas(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}