public class L1275_Find_Winner_on_a_Tic_Tac_Toe_Game {

    /*

    Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

    Players take turns placing characters into empty squares ' '.
    The first player A always places 'X' characters, while the second player B always places 'O' characters.
    'X' and 'O' characters are always placed into empty squares, never on filled ones.
    The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
    The game also ends if all squares are non-empty.
    No more moves can be played if the game is over.
    Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that
        the ith move will be played on grid[rowi][coli].

    return the winner of the game if it exists (A or B).
    In case the game ends in a draw return "Draw".
    If there are still movements to play return "Pending".

    You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe),
        the grid is initially empty, and A will play first.



    Example 1:


    Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
    Output: "A"
    Explanation: A wins, they always play first.

    Example 2:
    Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
    Output: "B"
    Explanation: B wins.

    Example 3:
    Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
    Output: "Draw"
    Explanation: The game ends in a draw since there are no moves to make.


    Constraints:

    1 <= moves.length <= 9
    moves[i].length == 2
    0 <= rowi, coli <= 2
    There are no repeated elements on moves.
    moves follow the rules of tic tac toe.

     */
    public String tictactoe(int[][] moves) {

        // 整体思路：
        // 一共9个位置
        // 如果长度 == 9.且有人达成一条线，则给出赢家，否则是Draw
        // 如果长度 <9, 且有人达成一条线，则给出赢家，否则是Pending

        // 初始化棋盘，0表示空，1表示A, -1表示B
        int[][] grid = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                grid[moves[i][0]][moves[i][1]] = 1;
            } else {
                grid[moves[i][0]][moves[i][1]] = -1;
            }
        }

        // 判断是否达成一条线
        if (checkGrid(grid) == 1) {
            return "A";
        }
        else if (checkGrid(grid) == -1) {
            return "B";
        }
        else{
            if (moves.length < 9) {
                return "Pending";
            }
            else {
                return "Draw";
            }
        }
    }

    // 检查棋盘是否达成一条线，返回1表示A赢，-1表示B赢，0表示没有赢家
    private int checkGrid(int[][] grid) {
        // 检查行
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] != 0 && grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
                return grid[i][0];
            }
        }

        // 检查列
        for (int i = 0; i < grid.length; i++) {
            if (grid[0][i] != 0 && grid[0][i] == grid[1][i] && grid[0][i] == grid[2][i]) {
                return grid[0][i];
            }
        }

        // 检查对角线
        if (grid[0][0] != 0 && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) {
            return grid[0][0];
        }
        if (grid[0][2] != 0 && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]) {
            return grid[0][2];
        }

        return 0;
    }

    public static void main(String[] args) {

        L1275_Find_Winner_on_a_Tic_Tac_Toe_Game s = new L1275_Find_Winner_on_a_Tic_Tac_Toe_Game();
        long sysDate1 = System.currentTimeMillis();

        int[][] moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        String res = s.tictactoe(moves);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}