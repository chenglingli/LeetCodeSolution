public class L3184_Count_Pairs_That_Form_a_Complete_Day_I {

    /*
    Given an integer array hours representing times in hours, return an integer denoting the number of pairs i, j
        where i < j and hours[i] + hours[j] forms a complete day.

    A complete day is defined as a time duration that is an exact multiple of 24 hours.

    For example, 1 day is 24 hours, 2 days is 48 hours, 3 days is 72 hours, and so on.



    Example 1:

    Input: hours = [12,12,30,24,24]

    Output: 2

    Explanation:

    The pairs of indices that form a complete day are (0, 1) and (3, 4).

    Example 2:

    Input: hours = [72,48,24,3]

    Output: 3

    Explanation:

    The pairs of indices that form a complete day are (0, 1), (0, 2), and (1, 2).



    Constraints:

    1 <= hours.length <= 100
    1 <= hours[i] <= 10^9
     */
    public int countCompleteDayPairs(int[] hours) {
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) ans++;
            }
        }

        return ans;
    }

    public int countCompleteDayPairs2(int[] hours) {
        int res = 0;
        int[] count = new int[24];

        for (int h : hours) {
            res += count[(24 - (h % 24)) % 24];
            count[h % 24]++;
        }

        return res;
    }

    public static void main(String[] args) {

        L3184_Count_Pairs_That_Form_a_Complete_Day_I s = new L3184_Count_Pairs_That_Form_a_Complete_Day_I();
        long sysDate1 = System.currentTimeMillis();

        int[] hours = {12, 12, 30, 24, 24};

        int res = s.countCompleteDayPairs(hours);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}