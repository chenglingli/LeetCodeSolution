public class L4078_Three_Fibonacci_Sum {

    /*
    You are given an integer n.

    The Fibonacci sequence starts with 0 and 1, and each subsequent number is the sum of the previous two numbers.
    Its first few terms are 0, 1, 1, 2, 3, 5, 8, 13, ....

    Return true if n can be expressed as the sum of three consecutive terms in the Fibonacci sequence, and false otherwise.



    Example 1:
    Input: n = 16

    Output: true

    Explanation:
    The three consecutive terms 3, 5, and 8 have a sum of 3 + 5 + 8 = 16.

    Example 2:
    Input: n = 8
    Output: false

    Explanation:
    Although 1 + 2 + 5 = 8, these terms are not consecutive in the Fibonacci sequence. No three consecutive terms have a sum of 8.

    Example 3:
    Input: n = 2
    Output: true
    Explanation:
    The first three terms have a sum of 0 + 1 + 1 = 2.

    Constraints:
    1 <= n <= 10^9
     */

    public boolean threeFibonacciSum(int n) {

        int a = 0;
        int b = 1;
        int c = 1;

        while (c < n) {
            if (a + b + c == n) {
                return true;
            }
            a = b;
            b = c;
            c = a + b;
        }

        return false;
    }

    /*
    
    思路：
    1. 如果n是奇数，则返回false
    2. 如果n是偶数，则判断n/2是否在斐波那契数列中
    3. 如果n/2在斐波那契数列中，则返回true
    4. 如果n/2不在斐波那契数列中，则返回false

    */
    public boolean threeFibonacciSum2(int n) {

        int a = 0;
        int b = 1;
        int c = a + b;

        if (n % 2 != 0)
            return false;

        while (c < 1000000000) {
            if (c == n / 2)
                return true;
            else {
                a = b;
                b = c;
                c = a + b;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        L4078_Three_Fibonacci_Sum s = new L4078_Three_Fibonacci_Sum();
        long sysDate1 = System.currentTimeMillis();

        int n = 16;

        boolean res = s.threeFibonacciSum(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}