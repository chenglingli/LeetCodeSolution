public class L2843_Count_Symmetric_Integers {

    /*

    You are given two positive integers low and high.

    An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x.
    Numbers with an odd number of digits are never symmetric.

    Return the number of symmetric integers in the range [low, high].



    Example 1:

    Input: low = 1, high = 100
    Output: 9
    Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
    Example 2:

    Input: low = 1200, high = 1230
    Output: 4
    Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.


    Constraints:

    1 <= low <= high <= 10^4

     */
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String str = String.valueOf(i);
            if (str.length() % 2 == 0) {
                int n = str.length();
                int sum1 = 0, sum2 = 0;
                for (int j = 0; j < n / 2; j++) {
                    sum1 += Character.getNumericValue(str.charAt(j));
                    sum2 += Character.getNumericValue(str.charAt(n - 1 - j));
                }
                if (sum1 == sum2) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countSymmetricIntegers2(int low, int high) {
        int res = 0;

        for (int i = low; i <= high; i++) {
            if (i < 100 && i % 11 == 0) {
                res++;
            } else if (1000 <= i && i < 10000) {
                int left = i / 1000 + (i % 1000) / 100;
                int right = (i % 100) / 10 + (i % 10);
                if (left == right) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2843_Count_Symmetric_Integers s = new L2843_Count_Symmetric_Integers();
        long sysDate1 = System.currentTimeMillis();

        int low = 1;
        int high = 100;

        int res = s.countSymmetricIntegers(low, high);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}