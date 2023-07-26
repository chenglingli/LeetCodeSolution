public class L1232_Check_If_It_Is_a_Straight_Line {

    /*
    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates contains no duplicate point.
     */
    public boolean checkStraightLine(int[][] coordinates) {

        if (coordinates.length == 2) {
            return true;
        }

        if (coordinates[0][0] == coordinates[1][0]) {
            int i = 2;
            while (i < coordinates.length) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
                i++;
            }
            return true;
        }

        double ratio = (coordinates[1][1] - coordinates[0][1]) * 1.0
                / (coordinates[1][0] - coordinates[0][0]);

        int i = 2;
        while (i < coordinates.length) {
            double cur = (coordinates[i][1] - coordinates[0][1]) * 1.0
                    / (coordinates[i][0] - coordinates[0][0]);
            if (Math.abs(cur - ratio) > 0.00001) {
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {

        L1232_Check_If_It_Is_a_Straight_Line s = new L1232_Check_If_It_Is_a_Straight_Line();
        long sysDate1 = System.currentTimeMillis();

//        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int[][] coordinates = {{0, 0}, {0, 1}, {0, -1}};
        boolean res = s.checkStraightLine(coordinates);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}