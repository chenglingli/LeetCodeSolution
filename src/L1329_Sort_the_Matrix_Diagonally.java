import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class L1329_Sort_the_Matrix_Diagonally {

    /*

    A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column
        and going in the bottom-right direction until reaching the matrix's end.
    For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

    Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.



    Example 1:
    Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
    Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]

    Example 2:
    Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
    Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]


    Constraints:
    m == mat.length
    n == mat[i].length
    1 <= m, n <= 100
    1 <= mat[i][j] <= 100

     */
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    sortDiagonal(mat, i, j);
                }
            }
        }

        return mat;
    }

    public void sortDiagonal(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;
        int[] diagonal = new int[Math.min(m - i, n - j)];
        for (int k = 0; k < diagonal.length; k++) {
            diagonal[k] = mat[i + k][j + k];
        }
        Arrays.sort(diagonal);
        for (int k = 0; k < diagonal.length; k++) {
            mat[i + k][j + k] = diagonal[k];
        }
    }

    // 解法2：同一条对角线 i - j 恒定，按 key 分组后排序写回
    public int[][] diagonalSort2(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(i - j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int k = idx.getOrDefault(key, 0);
                mat[i][j] = map.get(key).get(k);
                idx.put(key, k + 1);
            }
        }

        return mat;
    }

    // 解法3：值域 1..100，对角线用计数排序，总体 O(mn)
    public int[][] diagonalSort3(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            countingSortDiagonal(mat, i, 0);
        }
        for (int j = 1; j < n; j++) {
            countingSortDiagonal(mat, 0, j);
        }
        return mat;
    }

    private void countingSortDiagonal(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int[] count = new int[101];

        int i = r, j = c;
        while (i < m && j < n) {
            count[mat[i][j]]++;
            i++;
            j++;
        }

        i = r;
        j = c;
        for (int v = 1; v <= 100; v++) {
            while (count[v]-- > 0) {
                mat[i][j] = v;
                i++;
                j++;
            }
        }
    }

    // 解法4：每条对角线一个小根堆，扫描时入堆，再扫描时出堆写回
    public int[][] diagonalSort4(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(i - j, k -> new PriorityQueue<>()).offer(mat[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        return mat;
    }

    public static void main(String[] args) {

        L1329_Sort_the_Matrix_Diagonally s = new L1329_Sort_the_Matrix_Diagonally();
        long sysDate1 = System.currentTimeMillis();

        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};

        int[][] res = s.diagonalSort(mat);
        System.out.println(Arrays.deepToString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}