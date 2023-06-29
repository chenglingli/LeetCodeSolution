public class L1893_Check_if_All_the_Integers_in_a_Range_Are_Covered {

    /*
    1 <= ranges.length <= 50
    1 <= starti <= endi <= 50
    1 <= left <= right <= 50
     */
    public boolean isCovered(int[][] ranges, int left, int right) {

        int[] record = new int[51];

        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                record[i] = 1;
            }
        }

        for (int i = left; i <= right; i++) {
            if (record[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isCovered2(int[][] ranges, int left, int right) {

        for (int l = left; l <= right; l++) {
            boolean checking = false;
            for (int[] range : ranges) {
                if (range[0] <= l && range[1] >= l) {
                    checking = true;
                    break;
                }
            }
            if (!checking)
                return false;
        }

        return true;

    }

    public static void main(String[] args) {

        L1893_Check_if_All_the_Integers_in_a_Range_Are_Covered s = new L1893_Check_if_All_the_Integers_in_a_Range_Are_Covered();
        long sysDate1 = System.currentTimeMillis();

        int[][] ranges = {{1, 1}, {3, 4}, {5, 6}};
        int left = 2;
        int right = 2;

        boolean res = s.isCovered(ranges, left, right);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}