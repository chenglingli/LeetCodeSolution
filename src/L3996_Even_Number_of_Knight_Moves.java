public class L3996_Even_Number_of_Knight_Moves {

    /*
    You are given two integer arrays start and target,
    where each array is of the form [x, y] representing a cell on a standard 8 x 8 chessboard.

    Return true if a knight can move from start to target in an even number of moves. Otherwise, return false.

    Note: A valid knight move consists of moving two squares in one direction and one square perpendicular to it.
    The figure below illustrates all eight possible moves from a cell.


    Example 1:

    Input: start = [1,1], target = [2,2]

    Output: true

    Explanation:

    One possible sequence of moves is (1, 1) -> (3, 2) -> (2, 4) -> (4, 3) -> (2, 2).

    The knight reaches the target in 4 moves, which is even. Thus, the answer is true.

    Example 2:

    Input: start = [4,5], target = [6,6]

    Output: false

    Explanation:

    It is impossible to reach target = [6, 6] from start = [4, 5] in an even number of moves. Thus, the answer is false.



    Constraints:

    start.length == target.length == 2
    0 <= start[i], target[i] <= 7
     */

    private static final int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1},
        {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public boolean canReach(int[] start, int[] target) {
        return dfs(start, target, new boolean[8][8], 0);
    }

    private boolean dfs(int[] start, int[] target, boolean[][] visited, int step) {
        if (start[0] == target[0] && start[1] == target[1]) {
            if (step % 2 == 0) return true;
            else return false;
        }

        int x = start[0];
        int y = start[1];

        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visited[nx][ny]) {
                boolean res = dfs(new int[]{nx, ny}, target, visited, step + 1);
                if (res) return true;
            }
        }

        return false;
    }

    /*

    只要start和target是相同的颜色，就可以在偶数步内调到
    否则就是奇数步数

     */
    public boolean canReach2(int[] start, int[] target) {
        int startColor = (start[0] + start[1]) % 2;
        int targetColor = (target[0] + target[1]) % 2;
        return startColor == targetColor;
    }

    public static void main(String[] args) {

        L3996_Even_Number_of_Knight_Moves s = new L3996_Even_Number_of_Knight_Moves();
        long sysDate1 = System.currentTimeMillis();

        int[] start = {4, 5};
        int[] target = {6, 6};
        boolean res = s.canReach(start, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}