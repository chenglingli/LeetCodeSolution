import java.util.Arrays;

public class L2335_Minimum_Amount_of_Time_to_Fill_Cups {

    /*

    amount.length == 3
    0 <= amount[i] <= 100

    1 4 2 ->
       1 3 1
       0 2 1
       0 1 0
       0 0 0
     5 4 4 ->
        4 3 4
        3 3 3
        2 2 3
        2 1 2
        1 1 1
        0 0 1
        0 0 0

     */
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[1] == 0) {
            return amount[2];
        }

        amount[1]--;
        amount[2]--;
        return fillCups(amount) + 1;
    }

    public int fillCups2(int[] amount) {

        int total = 0;
        int max = 0;

        for (int i : amount) {
            total += i;
            max = Math.max(max, i);
        }

        return Math.max(max, (total + 1) / 2);
    }

    public static void main(String[] args) {

        L2335_Minimum_Amount_of_Time_to_Fill_Cups s =
                new L2335_Minimum_Amount_of_Time_to_Fill_Cups();
        long sysDate1 = System.currentTimeMillis();

        int[] amount = {5, 4, 4};
        int res = s.fillCups(amount);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}