public class L812_Largest_Triangle_Area {

    public double largestTriangleArea(int[][] points) {

        double ans = 0.0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    // double area = countArea(points[i], points[j], points[k]);
                    double area = countArea2(points, i, j, k);
                    ans = Math.max(ans, area);
                }
            }
        }

        return ans;
    }

    private double countArea(int[] p1, int[] p2, int[] p3) {
        double l1 = countL(p1, p2);
        double l2 = countL(p2, p3);
        double l3 = countL(p1, p3);
        if (l1 + l2 <= l3 || l2 + l3 <= l1 || l1 + l3 <= l2) {
            return 0.0;
        }

        double p = (l1 + l2 + l3) / 2;
        return Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));
    }

    private double countL(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    private double countArea2(int[][] points, int i, int j, int k) {
        double ax = points[i][0];
        double ay = points[i][1];
        double bx = points[j][0];
        double by = points[j][1];
        double cx = points[k][0];
        double cy = points[k][1];
        return Math.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2);
    }

    public double largestTriangleArea2(int[][] points) {
        double max = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double a = countArea2(points, i, j, k);
                    if (a > max) {
                        max = a;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        L812_Largest_Triangle_Area s = new L812_Largest_Triangle_Area();
        long sysDate1 = System.currentTimeMillis();

        int[][] points = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};

        double res = s.largestTriangleArea(points);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}