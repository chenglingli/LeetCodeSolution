public class L999_Available_Captures_for_Rook {


    /*

    You are given an 8 x 8 matrix representing a chessboard. There is exactly one white rook represented by 'R',
    some number of white bishops 'B', and some number of black pawns 'p'. Empty squares are represented by '.'.

    A rook can move any number of squares horizontally or vertically (up, down, left, right)
        until it reaches another piece or the edge of the board.
    A rook is attacking a pawn if it can move to the pawn's square in one move.

    Note: A rook cannot move through other pieces, such as bishops or pawns.
    This means a rook cannot attack a pawn if there is another piece blocking the path.

    Return the number of pawns the white rook is attacking.



    Example 1:


    Input: board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]

    Output: 3

    Explanation:

    In this example, the rook is attacking all the pawns.

    Example 2:


    Input: board = [[".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]

    Output: 0

    Explanation:

    The bishops are blocking the rook from attacking any of the pawns.

    Example 3:


    Input: board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]

    Output: 3

    Explanation:

    The rook is attacking the pawns at positions b5, d6, and f5.



    Constraints:

    board.length == 8
    board[i].length == 8
    board[i][j] is either 'R', '.', 'B', or 'p'
    There is exactly one cell with board[i][j] == 'R'

     */
    public int numRookCaptures(char[][] board) {

        // 先找到rock位置
        // 然后从该位置出发，上下左右移动，直到碰到边界或者碰到pawn
        // 碰到pawn，计数器+1
        // 碰到边界或者碰到bishop，停止移动
        // 返回计数器

        int count = 0;
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    i = board.length;
                    j = board[0].length;
                }
            }
        }

        // 从该位置出发，上下左右移动，直到碰到边界或者碰到pawn
        // 碰到pawn，计数器+1
        // 碰到边界或者碰到bishop，停止移动

        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 'B') break;
            if (board[i][y] == 'p') {
                count++;
                break;
            }
        }
        for (int i = x + 1; i < board.length; i++) {
            if (board[i][y] == 'B') break;
            if (board[i][y] == 'p') {
                count++;
                break;
            }
        }
        for (int j = y - 1; j >= 0; j--) {
            if (board[x][j] == 'B') break;
            if (board[x][j] == 'p') {
                count++;
                break;
            }
        }
        for (int j = y + 1; j < board[0].length; j++) {
            if (board[x][j] == 'B') break;
            if (board[x][j] == 'p') {
                count++;
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L999_Available_Captures_for_Rook s = new L999_Available_Captures_for_Rook();

        long sysDate1 = System.currentTimeMillis();

        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {
                }};

        int res = s.numRookCaptures(board);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}