import javafx.util.Pair;

import java.util.*;

public class L200_Number_of_Islands {


    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int M = grid.length, N = grid[0].length;

        int res = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == '1') {
                    ++res;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    // gird[x][y] = 1, delete it and its around.
    void dfs(char[][] grid, int x, int y) {
        int M = grid.length, N = grid[0].length;

        List<Integer> dirs1 = new ArrayList<>(Arrays.asList(1, 0, -1, 0));
        List<Integer> dirs2 = new ArrayList<>(Arrays.asList(0, 1, 0, -1));

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair head = q.poll();

            int a = (int)head.getKey();
            int b = (int)head.getValue();

            if (grid[a][b] != '1')
                continue;

            grid[a][b] = '0';

            for (int index = 0 ; index < 4; index ++) {
                int i = a + dirs1.get(index);
                int j = b + dirs2.get(index);

                if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] != '1') {
                    continue;
                }

                q.offer(new Pair( i, j ));
            }
        }
    }

    public static void main(String[] args) {

        L200_Number_of_Islands s = new L200_Number_of_Islands();

        long sysDate1 = System.currentTimeMillis();

        char [][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

//        char [][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };

        int res = s.numIslands(grid);

        System.out.println(res);
        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}