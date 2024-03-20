import java.util.HashMap;
import java.util.Map;

public class L149_Max_Points_on_a_Line {

    /*
    1 <= points.length <= 300
    points[i].length == 2
    -10^4 <= xi, yi <= 10^4
    All the points are unique.

     */
    public int maxPoints(int[][] points) {

        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, countPoints(i, j, points));
            }
        }

        return ans;
    }

    private int countPoints(int i, int j, int[][] points) {
        int[] p1 = points[i];
        int[] p2 = points[j];

        int res = 0;

        for (int k = 0; k < points.length; k++) {
            if (k == i || k == j) {
                res++;
                continue;
            }
            int[] p3 = points[k];
            if (isOnLine(p1, p2, p3)) {
                res++;
            }
        }

        return res;
    }

    /*
        判断p3是否在p1和p2连成的直线上
        两点式：(y3 - y1) / (y2 - y1) = (x3 - x1) / (x2 - x1)
    */
    private boolean isOnLine(int[] p1, int[] p2, int[] p3) {

        if ((p1[0] - p2[0]) * (p2[1] - p3[1]) == (p2[0] - p3[0]) * (p1[1] - p2[1])) {
            return true;
        }
        return false;
    }


    /*
    和方法1比，使用和hashmap
     */
    public int maxPoints2(int[][] points) {
        int len = points.length;
        if (len < 3)
            return len;

        int maxLine = 0;
        for (int i = 0; i < len; i++) {
            maxLine = Math.max(maxLine, getMaxLine(i, i + 1, points));
        }

        return maxLine;
    }

    /*
        以 point i 为起点，计算与其他点连成的直线上的点的个数

        使用Map<Double, int[]> lines记录斜率和与(x1, y1)连成直线的点的个数
        key: 斜率，value: 与(x1, y1)连成直线的点的个数
     */
    private int getMaxLine(int i, int j, int[][] points) {

        // key: 斜率，value: 与(x1, y1)连成直线的点的个数
        Map<Double, int[]> lines = new HashMap<>();
        int max = 2;
        int len = points.length;
        int x1 = points[i][0], y1 = points[i][1];

        while (j < len) {

            int x2 = points[j][0], y2 = points[j][1];
            double slope = 0.0;

            if (y2 == y1) {
                slope = 0.0;
            }
            else if (x2 == x1) {
                slope = Double.POSITIVE_INFINITY;
            }
            else {
                slope = (double) (y2 - y1) / (x2 - x1);
            }

            int[] line = lines.get(slope);
            if (line == null) {
                lines.put(slope, new int[]{2});
            } else {
                line[0]++;
                max = Math.max(max, line[0]);
            }

            j++;
        }

        return max;
    }


    public static void main(String[] args) {

        L149_Max_Points_on_a_Line s = new L149_Max_Points_on_a_Line();

        long sysDate1 = System.currentTimeMillis();

        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int res = s.maxPoints(points);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}