import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L733_Flood_Fill {

    public class ImageNode {
        int x;
        int y;

        ImageNode(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == null) {
                return false;
            }

            if (obj instanceof ImageNode) {
                ImageNode s = (ImageNode) obj;
                return s.x == x && s.y == y;
            }

            return false;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int target = image[sr][sc];
        if (target == color) {
            return image;
        }
        image[sr][sc] = color;

        Queue<ImageNode> queue = new LinkedList<>();
        queue.offer(new ImageNode(sr, sc));

        final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // 广度优先搜索
        while (!queue.isEmpty()) {

            ImageNode cur = queue.poll();

            for (int[] dir : directions) {
                int row = cur.x + dir[1];
                int col = cur.y + dir[0];

                if (isAddAble(row, col, image, target)) {
                    // target must != newColor,
                    // so if isAddAble(row, col, image, target) is false,
                    // means this point is visited.
                    image[row][col] = color;
                    queue.add(new ImageNode(row, col));
                }
            }
        }
        return image;
    }

    private boolean isAddAble(int row, int col, int[][] image, int target) {

        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return false;
        }

        return image[row][col] == target;
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;
        if (image[sr][sc] == color)
            return image;

        fillColor(image, sr, sc, image[sr][sc], color, m, n);

        return image;
    }

    public static void fillColor(
            int[][] image, int sr, int sc, int prevColor, int color, int m, int n) {

        // 越界
        if (sr >= m || sc >= n || sr < 0 || sc < 0)
            return;

        if (image[sr][sc] == prevColor) {
            image[sr][sc] = color;
            fillColor(image, sr + 1, sc, prevColor, color, m, n);
            fillColor(image, sr, sc + 1, prevColor, color, m, n);
            fillColor(image, sr - 1, sc, prevColor, color, m, n);
            fillColor(image, sr, sc - 1, prevColor, color, m, n);
        }
    }


    public static void main(String[] args) {

        L733_Flood_Fill s = new L733_Flood_Fill();

        long sysDate1 = System.currentTimeMillis();

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        //        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] res = s.floodFill(image, sr, sc, color);

        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}