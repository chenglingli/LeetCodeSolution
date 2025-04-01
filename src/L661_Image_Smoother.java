import java.util.Arrays;

public class L661_Image_Smoother {

    /*
    An image smoother is a filter of the size 3 x 3
        that can be applied to each cell of an image by rounding down the average of the cell
        and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother).
    If one or more of the surrounding cells of a cell is not present,
        we do not consider it in the average (i.e., the average of the four cells in the red smoother).


    Given an m x n integer matrix img representing the grayscale of an image,
        return the image after applying the smoother on each cell of it.


    Example 1:

    Input: img = [[1,1,1],[1,0,1],[1,1,1]]
    Output: [[0,0,0],[0,0,0],[0,0,0]]
    Explanation:
    For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
    For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
    For the point (1,1): floor(8/9) = floor(0.88888889) = 0

    Example 2:

    Input: img = [[100,200,100],[200,50,200],[100,200,100]]
    Output: [[137,141,137],[141,138,141],[137,141,137]]
    Explanation:
    For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
    For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
    For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138


    Constraints:

    m == img.length
    n == img[i].length
    1 <= m, n <= 200
    0 <= img[i][j] <= 255
     */


    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = getAvg(img, i, j);
            }
        }


        return res;
    }

    private int getAvg(int[][] img, int i, int j) {
        int m = img.length;
        int n = img[0].length;
        int sum = 0;
        int count = 0;

        for (int x = Math.max(0, i - 1); x <= Math.min(m - 1, i + 1); ++x) {
            for (int y = Math.max(0, j - 1); y <= Math.min(n - 1, j + 1); ++y) {
                sum += img[x][y];
                count++;
            }
        }

        return sum / count;
    }

    public static void main(String[] args) {

        L661_Image_Smoother s = new L661_Image_Smoother();
        long sysDate1 = System.currentTimeMillis();

        int[][] img = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] res = s.imageSmoother(img);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}