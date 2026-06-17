import java.util.Arrays;

public class L1828_Queries_on_Number_of_Points_Inside_a_Circle {

    /*
    You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane.
    Multiple points can have the same coordinates.

    You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.

    For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.

    Return an array answer, where answer[j] is the answer to the jth query.



    Example 1:


    Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
    Output: [3,2,2]
    Explanation: The points and circles are shown above.
    queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.

    Example 2:
    Input: points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
    Output: [2,3,2,4]
    Explanation: The points and circles are shown above.
    queries[0] is green, queries[1] is red, queries[2] is blue, and queries[3] is purple.


    Constraints:

    1 <= points.length <= 500
    points[i].length == 2
    0 <= x​​​​​​i, y​​​​​​i <= 500
    1 <= queries.length <= 500
    queries[j].length == 3
    0 <= xj, yj <= 500
    1 <= rj <= 500
    All coordinates are integers.


    Follow up: Could you find the answer for each query in better complexity than O(n)?
     */
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            res[i] = countPointsInCircle(points, queries[i]);
        }

        return res;
    }

    private int countPointsInCircle(int[][] points, int[] query) {
        int xj = query[0], yj = query[1], rj = query[2];
        int count = 0;

        for (int[] point : points) {
            if (isPointInsideCircle(point, xj, yj, rj)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPointInsideCircle(int[] point, int xj, int yj, int rj) {
        int dx = point[0] - xj;
        int dy = point[1] - yj;
        return dx * dx + dy * dy <= rj * rj;
    }

    public int[] countPoints2(int[][] points, int[][] queries) {
        int q = queries.length;
        int[] res = new int[q];

        for (int i = 0; i < q; i++) {
            int cx = queries[i][0];
            int cy = queries[i][1];
            int r = queries[i][2];
            int r2 = r * r;

            int count = 0;

            for (int[] p : points) {
                int dx = p[0] - cx;
                int dy = p[1] - cy;

                if (dx * dx + dy * dy <= r2) {
                    count++;
                }
            }

            res[i] = count;
        }

        return res;
    }

    public static void main(String[] args) {

        L1828_Queries_on_Number_of_Points_Inside_a_Circle s = new L1828_Queries_on_Number_of_Points_Inside_a_Circle();
        long sysDate1 = System.currentTimeMillis();

        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] res = s.countPoints(points, queries);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}