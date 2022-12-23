import java.util.Arrays;
import java.util.TreeSet;

public class L1337_The_K_Weakest_Rows_in_a_Matrix {

    // 非优先级队列方式
    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;
        int[] rowValueList = new int[m];

        for (int i = 0; i < m; i++) rowValueList[i] = countValue(mat[i]);

        // 寻找最小的k个数字的下标
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {

            int min = n + 1, index = -1;

            for (int j = 0; j < m; j++) {
                if (rowValueList[j] < min) {
                    min = rowValueList[j];
                    index = j;
                }
            }

            res[i] = index;
            rowValueList[index] = n + 1;
        }

        return res;
    }

    // 计算每行有多少个1
    private int countValue(int[] row) {

        if (row[0] == 0) {
            return 0;
        }

        int i = 0;
        int j = row.length - 1;

        while (i < j) {
            int mid = (i + j + 1) / 2;

            if (row[mid] == 1) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return i + 1;
    }

    // 优先级队列方式
    public int[] kWeakestRows2(int[][] mat, int k) {
        //0->soldier count, 1->index

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        for (int i = 0; i < mat.length; i++) {
            int count = 0;

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }

            set.add(new int[]{count, i});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = set.pollFirst()[1];
        }
        return result;
    }

    public int[] kWeakestRows3(int[][] mat, int k) {
        //0->soldier count, 1->index

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        for (int i = 0; i < mat.length; i++) {
            int count = countValue(mat[i]);
            set.add(new int[]{count, i});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = set.pollFirst()[1];
        }
        return result;
    }


    public static void main(String[] args) {

        L1337_The_K_Weakest_Rows_in_a_Matrix s = new L1337_The_K_Weakest_Rows_in_a_Matrix();
        long sysDate1 = System.currentTimeMillis();

        //        int[][] mat =
        //                {{1, 1, 0, 0, 0},
        //                        {1, 1, 1, 1, 0},
        //                        {1, 0, 0, 0, 0},
        //                        {1, 1, 0, 0, 0},
        //                        {1, 1, 1, 1, 1}};
        //        int k = 3;

        int[][] mat = {{1, 0}, {0, 0}, {1, 0}};
        int k = 2;

        int[] res = s.kWeakestRows(mat, k);

        System.out.println(Arrays.toString(res));

//        int[] row = {1, 0};
//        int x = s.countValue(row);
//        System.out.println();
//        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}