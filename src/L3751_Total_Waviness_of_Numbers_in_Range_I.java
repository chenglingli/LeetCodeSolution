public class L3751_Total_Waviness_of_Numbers_in_Range_I {

    /*

    You are given two integers num1 and num2 representing an inclusive range [num1, num2].

    The waviness of a number is defined as the total count of its peaks and valleys:

    A digit is a peak if it is strictly greater than both of its immediate neighbors.
    A digit is a valley if it is strictly less than both of its immediate neighbors.
    The first and last digits of a number cannot be peaks or valleys.
    Any number with fewer than 3 digits has a waviness of 0.
    Return the total sum of waviness for all numbers in the range [num1, num2].


    Example 1:

    Input: num1 = 120, num2 = 130

    Output: 3

    Explanation:

    In the range [120, 130]:
    120: middle digit 2 is a peak, waviness = 1.
    121: middle digit 2 is a peak, waviness = 1.
    130: middle digit 3 is a peak, waviness = 1.
    All other numbers in the range have a waviness of 0.
    Thus, total waviness is 1 + 1 + 1 = 3.

    Example 2:

    Input: num1 = 198, num2 = 202

    Output: 3

    Explanation:

    In the range [198, 202]:
    198: middle digit 9 is a peak, waviness = 1.
    201: middle digit 0 is a valley, waviness = 1.
    202: middle digit 0 is a valley, waviness = 1.
    All other numbers in the range have a waviness of 0.
    Thus, total waviness is 1 + 1 + 1 = 3.

    Example 3:

    Input: num1 = 4848, num2 = 4848

    Output: 2

    Explanation:

    Number 4848: the second digit 8 is a peak, and the third digit 4 is a valley, giving a waviness of 2.



    Constraints:

    1 <= num1 <= num2 <= 10^5

     */
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        int start = Math.max(num1, 100);

        for (int i = start; i <= num2; i++) {
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();

            for (int j = 1; j < chars.length - 1; j++) {
                if ((chars[j] > chars[j - 1]) && (chars[j] > chars[j + 1])) {
                    res++;
                } else if ((chars[j] < chars[j - 1]) && (chars[j] < chars[j + 1])) {
                    res++;
                }
            }
        }

        return res;
    }

    public int totalWaviness2(int num1, int num2) {
        int total = 0;

        for (int num = num1; num <= num2; num++) {
            total += waviness(num);
        }

        return total;
    }

    private int waviness(int num) {
        // Numbers less than 100 (1 or 2 digits) cannot have peaks or valleys
        if (num < 100) return 0;

        int count = 0;

        // Extract the rightmost digit first
        int right = num % 10;
        num /= 10;

        // Extract the middle digit
        int curr = num % 10;
        num /= 10;

        // Loop through the remaining digits
        while (num > 0) {
            int left = num % 10; // The next digit to the left

            // Check for peak or valley
            if ((curr > left && curr > right) || (curr < left && curr < right)) {
                count++;
            }

            // Shift our window to the left for the next iteration
            right = curr;
            curr = left;
            num /= 10;
        }

        return count;
    }


    public static void main(String[] args) {

        L3751_Total_Waviness_of_Numbers_in_Range_I s = new L3751_Total_Waviness_of_Numbers_in_Range_I();
        long sysDate1 = System.currentTimeMillis();

        int num1 = 120;
        int num2 = 130;
        int res = s.totalWaviness(num1, num2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}