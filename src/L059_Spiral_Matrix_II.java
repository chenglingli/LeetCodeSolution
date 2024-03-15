import java.util.Arrays;

public class L059_Spiral_Matrix_II {

    public int[][] generateMatrix(int n) {

        int i = 0, j = 0, k = 1;
        int[][] res = new int[n][n];

        /*
          i ->
        j
        |
        V

        0,0 -> 0,4
            0,4 -> 1,3
        1,3 -> 4,3
            4,3 -> 3,2
        3,2 -> 3,-1
            3,-1 -> 2,0

         */

        while (k <= n * n) {

            while (j < n && res[i][j] == 0) {
                res[i][j++] = k++;
            }
            // 转向，纠正一下j
            j--;
            i++;

            while (i < n && res[i][j] == 0) {
                res[i++][j] = k++;
            }
            // 转向，纠正一下i
            i--;
            j--;

            while (j >= 0 && res[i][j] == 0) {
                res[i][j--] = k++;
            }
            // 转向，纠正一下j
            j++;
            i--;

            while (i >= 0 && res[i][j] == 0) {
                res[i--][j] = k++;
            }
            // 转向，纠正一下i
            i++;
            j++;
        }

        return res;
    }

    public static void main(String[] args) {

        L059_Spiral_Matrix_II s = new L059_Spiral_Matrix_II();

        long sysDate1 = System.currentTimeMillis();

        int n = 3;

        int[][] matrix = s.generateMatrix(n);
        System.out.println(Arrays.deepToString(matrix));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}