public class L1582_Special_Positions_in_a_Binary_Matrix {


    public int numSpecial(int[][] mat) {

        int res = 0;
        int[][] visited = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                // 已经访问的无需访问
                if (visited[i][j] == 1) {
                    continue;
                }

                // 逐一判断
                if (mat[i][j] == 1) {

                    int existedOne = 0;

                    // 标记已访问
                    for (int x = 0; x < mat.length; x++) {
                        if (x != i) {
                            if (mat[x][j] == 1) {
                                existedOne = 1;
                            }
                        }
                        visited[x][j] = 1;
                    }

                    for (int x = 0; x < mat[0].length; x++) {
                        if (x != j) {
                            if (mat[i][x] == 1) {
                                existedOne = 1;
                            }
                        }
                        visited[i][x] = 1;
                    }

                    // check 是否满足
                    if (existedOne == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public static boolean isSpecial(int[][] mat, int row, int col) {
        for (int i = 0; i < mat[row].length; i++) {
            if (i == col) continue;
            if (mat[row][i] != 0) return false;
        }
        for (int i = 0; i < mat.length; i++) {
            if (i == row) continue;
            if (mat[i][col] != 0) return false;
        }
        return true;
    }

    public int numSpecial2(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    if (isSpecial(mat, i, j))
                        count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        L1582_Special_Positions_in_a_Binary_Matrix s =
                new L1582_Special_Positions_in_a_Binary_Matrix();
        long sysDate1 = System.currentTimeMillis();

        int[][] mat = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int res = s.numSpecial(mat);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}