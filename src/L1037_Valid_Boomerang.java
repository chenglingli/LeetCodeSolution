public class L1037_Valid_Boomerang {

    // 判断不在一条直线上 && 各不一样 
    public boolean isBoomerang(int[][] points) {

        if (isEqual(points[0], points[1])
                || isEqual(points[0], points[2])
                || isEqual(points[1], points[2])) {
            return false;
        }

        if (points[0][0] == points[1][0]
                || points[1][0] == points[2][0]
                || points[0][0] == points[2][0]) {
            return points[0][0] != points[1][0] || points[1][0] != points[2][0];
        }

        return (points[0][1] - points[1][1]) * 1.0 / (points[0][0] - points[1][0])
                != (points[2][1] - points[1][1]) * 1.0 / (points[2][0] - points[1][0]);
    }

    private boolean isEqual(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    public boolean isBoomerang2(int[][] points) {
        return points[0][0] * (points[1][1] - points[2][1])
                + points[1][0] * (points[2][1] - points[0][1])
                + points[2][0] * (points[0][1] - points[1][1])
                != 0;
    }

    public static void main(String[] args) {

        L1037_Valid_Boomerang s = new L1037_Valid_Boomerang();
        long sysDate1 = System.currentTimeMillis();

        //int[][] points = {{1, 1}, {2, 3}, {3, 2}};
        // int[][] points = {{1,1},{2,2},{3,3}};
        //        int[][] points = {{3,1},{3,2},{3,3}};
        int[][] points = {{0, 2}, {2, 1}, {1, 1}};

        boolean res = s.isBoomerang(points);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}