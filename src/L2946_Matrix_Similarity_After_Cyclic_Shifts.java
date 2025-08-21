public class L2946_Matrix_Similarity_After_Cyclic_Shifts {

    /*

    You are given an m x n integer matrix mat and an integer k. The matrix rows are 0-indexed.

    The following proccess happens k times:

    Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.


    Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.


    Return true if the final modified matrix after k steps is identical to the original matrix, and false otherwise.



    Example 1:

    Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4

    Output: false

    Explanation:

    In each step left shift is applied to rows 0 and 2 (even indices), and right shift to row 1 (odd index).



    Example 2:

    Input: mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2

    Output: true

    Explanation:



    Example 3:

    Input: mat = [[2,2],[2,2]], k = 3

    Output: true

    Explanation:

    As all the values are equal in the matrix, even after performing cyclic shifts the matrix will remain the same.



    Constraints:

    1 <= mat.length <= 25
    1 <= mat[i].length <= 25
    1 <= mat[i][j] <= 25
    1 <= k <= 50
    */
    public boolean areSimilar(int[][] mat, int k) {

        // 假设m行n列，k次循环
        // 对于每行，如果向右n次，肯定回到原点
        // 所以只需要考虑k%n次循环即可，设为x
        // 如果每行每隔x都是一样的值，则说明是相似的
        for (int[] ints : mat) {
            // 每行每隔x个元素都一样，则说明是相似的
            if (!isSimilar(ints, k)) {
                return false;
            }
        }

        return true;
    }

    boolean isSimilar(int[] arr, int x) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != arr[(i + x) % n]) {
                return false;
            }
        }

        return true;
    }

    public boolean areSimilar2(int[][] mat, int k) {
        for (int[] l : mat) {
            int n = l.length;
            for (int i = 0; i < n; ++i) {
                if (l[i] != l[(i + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        L2946_Matrix_Similarity_After_Cyclic_Shifts s = new L2946_Matrix_Similarity_After_Cyclic_Shifts();
        long sysDate1 = System.currentTimeMillis();

        int[][] mat = new int[][]{
                {1, 2, 1},
                {4, 5, 4},
                {7, 8, 7}
        };
        int k = 2;
        boolean res = s.areSimilar(mat, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}