import java.util.Arrays;

public class L832_Flipping_an_Image {

    /*

    n == image.length
    n == image[i].length
    1 <= n <= 20
    images[i][j] is either 0 or 1.

     */
    public int[][] flipAndInvertImage(int[][] image) {

        int n = image.length;
        for (int i = 0; i < n; i++) {

            // flip the image horizontally
            for (int j = 0; j < n / 2; j++) {
                int temp = 1 - image[i][j];
                image[i][j] = 1 - image[i][n - j - 1];
                image[i][n - j - 1] = temp;
            }

            if ((n - 1) % 2 == 0) {
                image[i][(n - 1) / 2] = 1 - image[i][(n - 1) / 2];
            }

        }

        return image;
    }

    public static void main(String[] args) {

        L832_Flipping_an_Image s = new L832_Flipping_an_Image();
        long sysDate1 = System.currentTimeMillis();

        //        int[] rec2 = {7,8,13,15};
        //        int[] rec1 = {10,8,12,20};

        // int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] image = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};

        int[][] res = s.flipAndInvertImage(image);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}