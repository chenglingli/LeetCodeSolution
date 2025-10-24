import java.util.ArrayList;
import java.util.List;

public class L3248_Snake_in_Matrix {

    /*

    There is a snake in an n x n matrix grid and can move in four possible directions.
        Each cell in the grid is identified by the position: grid[i][j] = (i * n) + j.

    The snake starts at cell 0 and follows a sequence of commands.

    You are given an integer n representing the size of the grid and an array of strings commands
        where each command[i] is either "UP", "RIGHT", "DOWN", and "LEFT".
    It's guaranteed that the snake will remain within the grid boundaries throughout its movement.

    Return the position of the final cell where the snake ends up after executing commands.



    Example 1:

    Input: n = 2, commands = ["RIGHT","DOWN"]

    Output: 3

    Explanation:

    0	1
    2	3
    0	1
    2	3
    0	1
    2	3
    Example 2:

    Input: n = 3, commands = ["DOWN","RIGHT","UP"]

    Output: 1

    Explanation:

    0	1	2
    3	4	5
    6	7	8
    0	1	2
    3	4	5
    6	7	8
    0	1	2
    3	4	5
    6	7	8
    0	1	2
    3	4	5
    6	7	8


    Constraints:

    2 <= n <= 10
    1 <= commands.length <= 100
    commands consists only of "UP", "RIGHT", "DOWN", and "LEFT".
    The input is generated such the snake will not move outside of the boundaries.

     */
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (i * n) + j;
            }
        }

        int x = 0, y = 0;
        for (String command : commands) {
            if ("UP".equals(command)) {
                x--;
            } else if ("DOWN".equals(command)) {
                x++;
            } else if ("LEFT".equals(command)) {
                y--;
            } else if ("RIGHT".equals(command)) {
                y++;
            }
        }

        return grid[x][y];
    }

    public int finalPositionOfSnake2(int n, List<String> commands) {
        int counter = 0;

        for (String s : commands) {
            if (s.charAt(0) == 'R') {
                counter++;
            } else if (s.charAt(0) == 'L') {
                counter--;
            } else if (s.charAt(0) == 'U') {
                counter = counter - n;
            } else if (s.charAt(0) == 'D') {
                counter += n;
            }
        }

        return counter;
    }

    public static void main(String[] args) {

        L3248_Snake_in_Matrix s = new L3248_Snake_in_Matrix();
        long sysDate1 = System.currentTimeMillis();


        int n = 3;
        List<String> commands = new ArrayList<>();
        commands.add("DOWN");
        commands.add("RIGHT");
        commands.add("UP");

        int res = s.finalPositionOfSnake(n, commands);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}