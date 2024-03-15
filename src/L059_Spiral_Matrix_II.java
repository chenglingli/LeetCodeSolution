import java.util.Arrays;

public class L059_Spiral_Matrix_II {


    /*

    基于n，生成n*n的旋转矩阵
    主要是模拟，用i和j控制坐标，到头时候就转向，需要注意的是，转向需要调整下一个过界的坐标
    一共是n*n个，所以k控制循环次数
    k从1开始，到n*n结束

     */
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