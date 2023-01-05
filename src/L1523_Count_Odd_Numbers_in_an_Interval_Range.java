public class L1523_Count_Odd_Numbers_in_an_Interval_Range {


    /*

    1 - 2   1
    1 - 3   2
    10 20   11,13,5,7,9 5


     */

    public int countOdds(int low, int high) {

        /*
        2~4  1
        2~6  2
        0~10 5
         */
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        }

        /*
        1~4  2
        1~6  3
        1~10 5

        0~3 2
        0~9 5
         */
        else if (low % 2 != 0 && high % 2 == 0
                || low % 2 == 0 && high % 2 != 0) {
            return (high - low + 1) / 2;
        }

        /*
        1~3 2
        1~9 5
         */
        else {
            return (high - low) / 2 + 1;
        }
    }

    public static void main(String[] args) {

        L1523_Count_Odd_Numbers_in_an_Interval_Range s =
                new L1523_Count_Odd_Numbers_in_an_Interval_Range();
        long sysDate1 = System.currentTimeMillis();

        int low = 4;
        int high = 9;
        int res = s.countOdds(low, high);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}