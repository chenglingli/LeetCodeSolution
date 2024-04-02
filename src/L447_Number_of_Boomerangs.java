import java.util.HashMap;
import java.util.Map;

public class L447_Number_of_Boomerangs {

    /*
    n == points.length
    1 <= n <= 500
    points[i].length == 2
    -10^4 <= xi, yi <= 10^4
    All the points are unique.

     */

    Map<Integer, Integer> map = new HashMap<>();

    /*
    时间复杂度 O(n^3)
    方法：暴力枚举
    TLE
     */
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int dis1 = calcDis(i, j, points);
                    int dis2 = calcDis(i, k, points);
                    if (dis1 == dis2) {
                        res += 2;
                    }

                    dis1 = calcDis(j, i, points);
                    dis2 = calcDis(j, k, points);
                    if (dis1 == dis2) {
                        res += 2;
                    }

                    dis1 = calcDis(k, i, points);
                    dis2 = calcDis(k, j, points);
                    if (dis1 == dis2) {
                        res += 2;
                    }
                }
            }
        }

        return res;
    }

    private int calcDis(int i, int j, int[][] points) {

        if (i > j) {
            return calcDis(j, i, points);
        }

        if (map.containsKey(i * 1000 + j)) {
            return map.get(i * 1000 + j);
        }

        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];

        int res = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        map.put(i * 1000 + j, res);
        return res;
    }


    /*
    Time complexity : O(n^2)
    方法：计算i和j之间的距离，然后存储在map中，key为距离，value为出现的次数
    如果某个距离出现了n次，那么就有n*(n-1)个回旋镖

     */
    public int numberOfBoomerangs2(int[][] arr) {
        int result = 0;

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                long dist = getDist(i, j, arr);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int v : map.values())
                result += v * (v - 1);
            map.clear();
        }

        return result;
    }

    public long getDist(int i, int j, int arr[][]) {
        long a1 = (long) arr[i][0];
        long a2 = (long) arr[j][0];
        long b1 = (long) arr[i][1];
        long b2 = (long) arr[j][1];
        return (a1 - a2) * (a1 - a2) + (b1 - b2) * (b1 - b2);
    }

    /*
    Time complexity : O(n^2)
    方法：
    计算i和j之间的距离，然后存储在map中，key为距离，value为出现的次数

     */
    public int numberOfBoomerangs3(int[][] points) {

        int result = 0;
        HashMap<Integer, Integer> distMap = new HashMap<Integer, Integer>();

        for (int[] i : points) {
            for (int[] j : points) {
                if (i == j) continue;
                int dist = (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
                int prevDist = distMap.getOrDefault(dist, 0);
                result += 2 * prevDist;
                distMap.put(dist, prevDist + 1);
            }
            distMap.clear();
        }

        return result;
    }

    public static void main(String[] args) {

        L447_Number_of_Boomerangs s = new L447_Number_of_Boomerangs();

        long sysDate1 = System.currentTimeMillis();

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};

        int res = s.numberOfBoomerangs(points);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}