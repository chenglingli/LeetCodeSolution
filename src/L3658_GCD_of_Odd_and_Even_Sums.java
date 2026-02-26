import java.util.Arrays;

public class L3658_GCD_of_Odd_and_Even_Sums {

    /*

    You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:

    sumOdd: the sum of the smallest n positive odd numbers.

    sumEven: the sum of the smallest n positive even numbers.

    Return the GCD of sumOdd and sumEven.



    Example 1:

    Input: n = 4

    Output: 4

    Explanation:

    Sum of the first 4 odd numbers sumOdd = 1 + 3 + 5 + 7 = 16
    Sum of the first 4 even numbers sumEven = 2 + 4 + 6 + 8 = 20
    Hence, GCD(sumOdd, sumEven) = GCD(16, 20) = 4.

    Example 2:

    Input: n = 5

    Output: 5

    Explanation:

    Sum of the first 5 odd numbers sumOdd = 1 + 3 + 5 + 7 + 9 = 25
    Sum of the first 5 even numbers sumEven = 2 + 4 + 6 + 8 + 10 = 30
    Hence, GCD(sumOdd, sumEven) = GCD(25, 30) = 5.



    Constraints:

    1 <= n <= 1000
     */
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = (int)(Math.pow(n, 2));
        int sumEven = (1 + n) * n;
        return gcd(sumEven, sumOdd);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int gcdOfOddEvenSums2(int n) {
        return n;
    }

    public static void main(String[] args) {

        L3658_GCD_of_Odd_and_Even_Sums s = new L3658_GCD_of_Odd_and_Even_Sums();
        long sysDate1 = System.currentTimeMillis();

        int n = 4;

        int res = s.gcdOfOddEvenSums(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}