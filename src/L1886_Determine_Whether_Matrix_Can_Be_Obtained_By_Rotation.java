public class L1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {

    /*

    Given two n x n binary matrices mat and target,
    return true if it is possible to make mat equal to target by rotating mat in 90-degree increments,
    or false otherwise.


    Example 1:
    Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
    Output: true
    Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.


    Example 2:
    Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
    Output: false
    Explanation: It is impossible to make mat equal to target by rotating mat.

    Example 3:
    Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
    Output: true
    Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.


    Constraints:
    n == mat.length == target.length
    n == mat[i].length == target[i].length
    1 <= n <= 10
    mat[i][j] and target[i][j] are either 0 or 1.

     */
    public boolean findRotation(int[][] mat, int[][] target) {
        // 方案：旋转3次，然后分别判断是否相等

        for (int i = 0; i <= 3; i++) {
            if (isEqual(mat, target)) {
                return true;
            }
            rotate90(mat);
        }
        return false;
    }

    private boolean isEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void rotate90(int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 交换元素
                int temp = mat[i][j];
                mat[i][j] = mat[n - 1 - j][i];
                mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                mat[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {

        L1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation s = new L1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation();
        long sysDate1 = System.currentTimeMillis();

        int[][] mat = new int[][]{{1, 1}, {0, 1}};
        int[][] target = new int[][]{{1, 1}, {1, 0}};

        boolean res = s.findRotation(mat, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}