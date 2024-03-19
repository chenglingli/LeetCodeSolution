import java.util.Arrays;

public class L452_Minimum_Number_of_Arrows_to_Burst_Balloons {


    /*
    基于右端点排序, 计算重叠区间个数

     */
    public int findMinArrowShots(int[][] points) {

        // 基于右端点排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int prevEnd = points[0][1];

        // 计算重叠区间个数
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {

        L452_Minimum_Number_of_Arrows_to_Burst_Balloons s = new L452_Minimum_Number_of_Arrows_to_Burst_Balloons();

        long sysDate1 = System.currentTimeMillis();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int res = s.findMinArrowShots(points);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}