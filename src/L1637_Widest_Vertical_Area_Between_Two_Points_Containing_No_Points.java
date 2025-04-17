import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points {


    /*
        Given n points on a 2D plane where points[i] = [xi, yi],
            Return the widest vertical area between two points such that no points are inside the area.

        A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height).
            The widest vertical area is the one with the maximum width.

        Note that points on the edge of a vertical area are not considered included in the area.

        Example 1:
        Input: points = [[8,7],[9,9],[7,4],[9,7]]
        Output: 1
        Explanation: Both the red and the blue area are optimal.

        Example 2:
        Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
        Output: 3

        Constraints:

        n == points.length
        2 <= n <= 10^5
        points[i].length == 2
        0 <= xi, yi <= 10^9
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        
        int[] x = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int max = 0;
        for (int i = 1; i < x.length; i++) {
            max = Math.max(max, x[i] - x[i - 1]);
        }
        return max;
    }

    public static void main(String[] args) {

        L1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points s = new L1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points();
        long sysDate1 = System.currentTimeMillis();

        int[][] points =  new int[][]{
                {8, 7}, {9, 9}, {7, 4}, {9, 7}
        };
        int res = s.maxWidthOfVerticalArea(points);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}