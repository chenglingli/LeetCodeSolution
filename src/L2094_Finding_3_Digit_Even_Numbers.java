import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2094_Finding_3_Digit_Even_Numbers {

    /*


    The integer consists of the concatenation of
        three elements from digits in any arbitrary order.
    The integer does not have leading zeros.
    The integer is even.

    3 <= digits.length <= 100
    0 <= digits[i] <= 9

    Input: digits = [2,2,8,8,2]
    Output: [222,228,282,288,822,828,882]

    Input: digits = [2,1,3,0]
    Output: [102,120,130,132,210,230,302,310,312,320]

     */
    public int[] findEvenNumbers(int[] digits) {
        int[] map = new int[10]; // for freq of 0 to 9 (digits are fixed)

        for (int digit : digits) { //make a frequency map of digits
            map[digit]++;
        }

        List<Integer> arr = new ArrayList<>();

        for (int i = 100; i <= 999; i = i + 2) { //will always runs from 100 to 999
            int num = i;
            int[] freq = new int[10];
            while (num > 0) {  // will always run 3 times
                int rem = num % 10;
                freq[rem]++;
                num = num / 10;
            }

            boolean res = findans(freq, map);

            if (res)
                arr.add(i);
        }

        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }

        return ans;
    }

    private boolean findans(int[] currentNum, int[] database) {

        for (int i = 0; i < 10; i++) {  //it will always run for at max 10 times
            if (currentNum[i] > database[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        L2094_Finding_3_Digit_Even_Numbers s = new L2094_Finding_3_Digit_Even_Numbers();
        long sysDate1 = System.currentTimeMillis();

        int[] digits = {1, 2, 5, 2, 3};
        int[] res = s.findEvenNumbers(digits);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}