public class L4061_Minimum_Queen_Moves_to_Reach_Target {

    /*
    There is an 8 x 8 empty chessboard with 1-indexed rows and columns.

    You are given an array source = [sr, sc] representing the starting position of a queen,
    and an array target = [tr, tc] representing the target position.

    In one move, the queen travels one or more squares along a single row, column, or diagonal, staying within the board.

    Return the minimum number of moves for the queen to land exactly on target.


    Example 1:
    Input: source = [8,1], target = [1,8]
    Output: 1
    Explanation:
    A single diagonal move takes the queen straight from (8, 1) to (1, 8).

    Example 2:
    Input: source = [4,2], target = [1,3]
    Output: 2
    Explanation:
    The queen moves from (4, 2) to (4, 3), then from (4, 3) to (1, 3), reaching the target in 2 moves.

    Example 3:
    Input: source = [1,1], target = [1,1]
    Output: 0
    Explanation:
    The queen is already at the target position, so no moves are needed.

    Constraints:
    source == [sr, sc]
    target == [tr, tc]
    1 <= sr, sc, tr, tc <= 8
     */
    public int minQueenMoves(int[] source, int[] target) {
        // 皇后可以横向、纵向、斜向移动任意格子数，求最少步数到达目标位置
        // 答案要么是0步，要么是1步，要么是2步
        if (source[0] == target[0] && source[1] == target[1]) {
            return 0;
        } else if ((Math.abs(target[0] - source[0]) == Math.abs(target[1] - source[1]))) {
            // 斜向移动
            return 1;
        } else if (target[0] == source[0] || target[1] == source[1]){
            // 横向或纵向移动，但不是斜向移动
            return 1;
        }
        else {
            // 横向或纵向移动
            return 2;
        }
    }

    public static void main(String[] args) {

        L4061_Minimum_Queen_Moves_to_Reach_Target s = new L4061_Minimum_Queen_Moves_to_Reach_Target();
        long sysDate1 = System.currentTimeMillis();

        int[] source = {8, 1};
        int[] target = {1, 8};

        int res = s.minQueenMoves(source, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}