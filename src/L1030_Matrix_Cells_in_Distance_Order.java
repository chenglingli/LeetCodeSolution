import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L1030_Matrix_Cells_in_Distance_Order {

    /*
    1 <= rows, cols <= 100
    0 <= rCenter < rows
    0 <= cCenter < cols

    两种思路：
    思路1，队列向外扩展，广度探索直到填满
    思路2，构造结构体和所有节点，排序法

     */
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int size = rows * cols;
        int[][] res = new int[size][2];
        int[][] visited = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int i = 0;

        res[i++] = new int[]{rCenter, cCenter};
        queue.offer(new int[]{rCenter, cCenter});
        visited[rCenter][cCenter] = 1;

        while (i < size) {
            int[] cur = queue.poll();

            int[] u = new int[]{cur[0], cur[1] + 1};
            i = saveIntoResult(u, visited, queue, res, i, rows, cols);

            int[] d = new int[]{cur[0], cur[1] - 1};
            i = saveIntoResult(d, visited, queue, res, i, rows, cols);

            int[] r = new int[]{cur[0] + 1, cur[1]};
            i = saveIntoResult(r, visited, queue, res, i, rows, cols);

            int[] l = new int[]{cur[0] - 1, cur[1]};
            i = saveIntoResult(l, visited, queue, res, i, rows, cols);
        }

        return res;
    }

    private int saveIntoResult(
            int[] p, int[][] visited, Queue<int[]> queue,
            int[][] res, int i, int rows, int cols) {
        if (inMatrix(p, rows, cols) && visited[p[0]][p[1]] == 0) {
            queue.offer(p);
            res[i++] = p;
            visited[p[0]][p[1]] = 1;
        }

        return i;
    }

    private boolean inMatrix(int[] p, int rows, int cols) {
        return p[0] >= 0 && p[0] < rows && p[1] >= 0 && p[1] < cols;
    }

    /*
        解法3
        确定距离，遍历
     */
    public int[][] allCellsDistOrder2(int rows, int cols, int rCenter, int cCenter) {

        int[][] res = new int[rows * cols][];
        res[0] = new int[]{rCenter, cCenter};            // Add start point rCenter,cCenter which has distance 0.
        int resIdx = 1;

        int lim = Math.max(rCenter, rows - rCenter - 1)
                + Math.max(cCenter, cols - cCenter - 1);
        // lim is highest distance value.

        for (int dist = 1; dist <= lim; dist++) {  // Process 'lim' diamond-shapes having distance 'dist'.

            int r = rCenter - dist;
            int c = cCenter;

            // Diamond side: Bottom Left
            for (int count = dist; count > 0; count--) {
                if (r >= 0 && c >= 0)
                    res[resIdx++] = new int[]{r, c};
                r++;
                c--;
            }

            // Diamond side: Bottom Right
            for (int count = dist; count > 0; count--) {
                if (r < rows && c >= 0)
                    res[resIdx++] = new int[]{r, c};
                r++;
                c++;
            }

            // Diamond side: Top Right
            for (int count = dist; count > 0; count--) {
                if (r < rows && c < cols)
                    res[resIdx++] = new int[]{r, c};
                r--;
                c++;
            }

            // Diamond side: Top Left
            for (int count = dist; count > 0; count--) {
                if (r >= 0 && c < cols)
                    res[resIdx++] = new int[]{r, c};
                r--;
                c--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        long sysDate1 = System.currentTimeMillis();
        L1030_Matrix_Cells_in_Distance_Order s = new L1030_Matrix_Cells_in_Distance_Order();

        int rows = 2;
        int cols = 3;
        int rCenter = 1;
        int cCenter = 2;
        int[][] res = s.allCellsDistOrder2(rows, cols, rCenter, cCenter);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}