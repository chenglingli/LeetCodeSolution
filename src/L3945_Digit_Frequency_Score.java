import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3945_Digit_Frequency_Score {

    /*
    You are given an integer n.

    The score of n is defined as the sum of d * freq(d) over all distinct digits d,
    where freq(d) denotes the number of times the digit d appears in n.

    Return an integer denoting the score of n.



    Example 1:

    Input: n = 122

    Output: 5

    Explanation:

    The digit 1 appears 1 time, contributing 1 * 1 = 1.
    The digit 2 appears 2 times, contributing 2 * 2 = 4.
    Thus, the score of n is 1 + 4 = 5.
    Example 2:

    Input: n = 101

    Output: 2

    Explanation:

    The digit 0 appears 1 time, contributing 0 * 1 = 0.
    The digit 1 appears 2 times, contributing 1 * 2 = 2.
    Thus, the score of n is 2.


    Constraints:

    1 <= n <= 10^9

     */
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];
        int x = n;
        while (x > 0) {
            freq[x % 10]++;
            x /= 10;
        }

        int score = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > 0) {
                score += i * freq[i];
            }
        }

        return score;
    }

    public static void main(String[] args) {

        L3945_Digit_Frequency_Score s = new L3945_Digit_Frequency_Score();
        long sysDate1 = System.currentTimeMillis();

        int n = 122;

        int res = s.digitFrequencyScore(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}