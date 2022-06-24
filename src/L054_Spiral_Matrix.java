import java.util.ArrayList;
import java.util.List;

public class L054_Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int h = matrix.length;
        int w = matrix[0].length;

        int direction = 1;
        int index = 0;
        int q = 0;

        while (index < h * w) {

            if (direction == 1) {
                for (int i = q; i < w - q; i++) {
                    res.add(matrix[q][i]);
                    index++;
                    direction = 2;
                }
            }

            if (direction == 2) {
                for (int i = q + 1; i < h - q; i++) {
                    res.add(matrix[i][w - q - 1]);
                    index++;
                    direction = 3;
                }
            }

            if (direction == 3) {
                for (int i = w - q - 2; i >= q; i--) {
                    res.add(matrix[h - q - 1][i]);
                    index++;
                    direction = 4;
                }
            }

            if (direction == 4) {
                for (int i = h - q - 2; i > q; i--) {
                    res.add(matrix[i][q]);
                    index++;
                    direction = 1;
                }
            }

            q++;

        }

        return res;
    }

    public static void main(String[] args) {

        L054_Spiral_Matrix s = new L054_Spiral_Matrix();

        long sysDate1 = System.currentTimeMillis();

        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> res = s.spiralOrder(matrix);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}