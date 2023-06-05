public class L1779_Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate {

    public int nearestValidPoint(int x, int y, int[][] points) {

        int minDis = 100001;
        int ans = -1;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int dis = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (dis < minDis) {
                    minDis = dis;
                    ans = i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L1779_Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate s = new L1779_Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate();
        long sysDate1 = System.currentTimeMillis();

        int x = 3;
        int y = 4;
        int[][] points = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        int res = s.nearestValidPoint(x, y, points);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}