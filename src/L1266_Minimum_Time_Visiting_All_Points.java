public class L1266_Minimum_Time_Visiting_All_Points {

    /*

    On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi].
    Return the minimum time in seconds to visit all the points in the order given by points.

    You can move according to these rules:

    In 1 second, you can either:
    move vertically by one unit,
    move horizontally by one unit, or
    move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
    You have to visit the points in the same order as they appear in the array.
    You are allowed to pass through points that appear later in the order, but these do not count as visits.


    Example 1:


    Input: points = [[1,1],[3,4],[-1,0]]
    Output: 7
    Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
    Time from [1,1] to [3,4] = 3 seconds
    Time from [3,4] to [-1,0] = 4 seconds
    Total time = 7 seconds



    Example 2:

    Input: points = [[3,2],[-2,2]]
    Output: 5


    Constraints:

    points.length == n
    1 <= n <= 100
    points[i].length == 2
    -1000 <= points[i][0], points[i][1] <= 1000

     */
    public int minTimeToVisitAllPoints(int[][] points) {

        int res = 0;
        for (int i = 1; i < points.length; i++) {
            res += minCostBetweenTwoPoints(
                    points[i - 1][0], points[i - 1][1], points[i][0], points[i][1]);
        }

        return res;
    }

    /*

    因为可以斜向移动，且成本 == 横向或竖向移动成本
    所以，两点间最短时间 = 横向或竖向移动距离较大的那个

     */
    private int minCostBetweenTwoPoints(int p1x, int p1y, int p2x, int p2y) {
        return Math.max(Math.abs(p2x - p1x), Math.abs(p2y - p1y));
    }


    public static void main(String[] args) {

        L1266_Minimum_Time_Visiting_All_Points s = new L1266_Minimum_Time_Visiting_All_Points();
        long sysDate1 = System.currentTimeMillis();

        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        int res = s.minTimeToVisitAllPoints(points);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}