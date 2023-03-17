public class L1550_Three_Consecutive_Odds {


    public boolean threeConsecutiveOdds(int[] arr) {

        if (arr.length < 3) {
            return false;
        }

        int i = 0;

        while (i < arr.length) {

            int j = 0;
            for (j = 0; j < 3; j++) {
                if (i + j >= arr.length) {
                    return false;
                }
                if (arr[i + j] % 2 == 0) {
                    j = 4;
                }
            }
            if (j == 3) {
                return true;
            }

            i++;
        }

        return false;
    }

    public static void main(String[] args) {

        L1550_Three_Consecutive_Odds s =
                new L1550_Three_Consecutive_Odds();
        long sysDate1 = System.currentTimeMillis();

        int[] arr = {1, 2, 34, 3, 4, 6, 21, 23, 11};
        boolean res = s.threeConsecutiveOdds(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}